import React, { useState, useEffect } from 'react';
import MapComponent from './MapComponent'
import Chart from './ChartComponent'
import CrimeFeed from './CrimeFeed'
import Filter from './Filter'
import axios from 'axios';
import { environment } from '../../environment';

const api_url = environment.crimelensapi.url_dev;

export default function Dashboard() {
    /*
    DATA for map component
    List of (lat, long)
    Should change based on selected crime classification
    */
    const [crimeLocations, setCrimeLocations] = useState([]);

    /*
    DATA for pie chart component
    List of (classification, count)
    */
    const [crimeTypes, setCrimeTypes] = useState([]);

    /*
    DATA for bar chart component
    List of (year, count)
    Should change based on selected crime classification
    */
    const [crimeCountByYear, setCrimeCountByYear] = useState([]);

    const [selectedCrimeType, setSelectedCrimeType] = useState('');

    useEffect(() => {
        console.log('selected crime type: ', selectedCrimeType);

        let url = api_url + '/' + '?limit=1000&fromYear=2015';

        if (selectedCrimeType) {
            url += '&classification=' + selectedCrimeType;
        }

        axios.get(url)
            .then(response => {
                const uniqueCrimeTypes = response.data.reduce((acc, current) => {
                    acc[current.classification] = (acc[current.classification] || 0) + 1;
                    return acc;
                }, {});

                const typeData = Object.entries(uniqueCrimeTypes).map(([classification, count], index) => {
                    return { id: index, value: count, label: classification };
                });

                const crimeCountData = response.data.reduce((acc, current) => {
                    const year = current.crimeDate.split('-')[0];
                    const index = acc.findIndex(item => item.year === year);
                    if (index !== -1) {
                        acc[index].crimes += 1;
                    } else {
                        acc.push({ year, crimes: 1 });
                    }
                    return acc;
                }, []);

                const crimeLocationData = response.data.map(crime => ({
                    lat: crime.location.lat,
                    lng: crime.location.lon
                }));

                crimeCountData.sort((a, b) => a.year - b.year);

                setCrimeTypes(typeData);
                setCrimeCountByYear(crimeCountData);
                setCrimeLocations(crimeLocationData);
            })
            .catch(error => {
                console.log(error);
            });
    }, [selectedCrimeType]);

    return (
        <div style={{ display: 'flex', justifyContent: 'space-between' }}>
            <div style={{ width: '20%' }}>
                <Filter crimeTypes={crimeTypes} setSelectedCrimeType={setSelectedCrimeType} />
            </div>
            <div style={{ display: 'flex', flexDirection: 'column', width: '60%' }}>
                <MapComponent crimeLocations={crimeLocations} />
                <Chart crimeTypes={crimeTypes} crimeCountByYear={crimeCountByYear} />
            </div>
            <div style={{ width: '20%' }}>
                <CrimeFeed />
            </div>
        </div>
    );
}
