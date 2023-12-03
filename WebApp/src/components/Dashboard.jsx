import React, { useState, useEffect } from 'react';
import { Tab, Tabs } from '@mui/material';
import MapComponent from './MapComponent'
import TableComponent from './TableComponent';
import Chart from './ChartComponent'
import CrimeFeed from './CrimeFeed'
import Filter from './Filter'
import axios from 'axios';
import { environment } from '../../environment';
import { getFilteredDate, getDateDifferenceInDays, getDayOfTheWeek, getMonth } from '../utils/dateUtils'
import { truncateString } from '../utils/helper';

const api_url = environment.crimelensapi.url_dev;

const limit = 10;

export default function Dashboard() {

    const [selectedTab, setSelectedTab] = useState(0);

    const [crimeDateFilter, setCrimeDateFilter] = useState(getFilteredDate('LAST_10_YEARS'));

    const [selectedCrime, setSelectedCrime] = useState(null);

    /*
    DATA for pie chart component
    List of (classification, count)
    */
    const [crimeTypes, setCrimeTypes] = useState([]);
    
    useEffect(() => {
        let url = api_url + '/' + '?limit=' + limit + '&date=' + crimeDateFilter;
        console.log(url);

        axios.get(url)
            .then(response => {
                console.log(response.data);

                const uniqueCrimeTypes = response.data.reduce((acc, current) => {
                    acc[current.classification] = (acc[current.classification] || 0) + 1;
                    return acc;
                }, {});

                const typeData = Object.entries(uniqueCrimeTypes).map(([classification, count], index) => {
                    return { id: index, value: count, label: classification };
                });

                setCrimeTypes(typeData);
            })
            .catch(error => {
                console.log(error);
            });
    }, [crimeDateFilter])

    /*
    DATA for map component
    List of (lat, long)
    Should change based on selected crime classification
    */
    const [crimeLocations, setCrimeLocations] = useState([]);

    /*
    DATA for bar chart component
    List of (year, count)
    Should change based on selected crime classification
    */
    const [crimeCount, setCrimeCount] = useState([]);

    /*
    DATA for crime feed component
    List of crime objects
    crime : [{
        id: String,
        classification: String,
        description: String,
        crimeDate: String,
        street: String,
    }]
    */
    const [crimes, setCrimes] = useState([]);

    /* Selected crime type filter for (Map, Bar chart, Feed)  */
    const [selectedCrimeType, setSelectedCrimeType] = useState('');

    // main useEffect
    useEffect(() => {
        setSelectedCrime(null);

        let url = api_url + '/' + '?limit=' + limit + '&date=' + crimeDateFilter;

        if (selectedCrimeType) {
            url += '&classification=' + selectedCrimeType;
        }

        axios.get(url)
            .then(response => {
                console.log(response.data);

                const dateDiff = getDateDifferenceInDays(crimeDateFilter);

                let filterBy;
                if (dateDiff <= 7) {
                    filterBy = 'date';
                } else if (dateDiff <= 365) {
                    filterBy = 'month';
                } else {
                    filterBy = 'year';
                }

                const crimeCountData = response.data.reduce((acc, current) => {
                    
                    let y_axis;
                    const dateParts = current.crimeDate.split('-');
                    if (filterBy === 'date') {
                        y_axis = getDayOfTheWeek(current.crimeDate);
                    } else if (filterBy === 'month') {
                        y_axis = getMonth(parseInt(dateParts[1]) - 1);
                    } else {
                        y_axis = dateParts[0];
                    }

                    const index = acc.findIndex(item => item.y_axis === y_axis);
                    if (index !== -1) {
                        acc[index].crimes += 1;
                    } else {
                        acc.push({ y_axis, crimes: 1 });
                    }
                    return acc;
                }, []);

                const crimeLocationData = response.data.map(crime => ({
                    lat: crime.location.lat,
                    lng: crime.location.lon
                }));

                crimeCountData.sort((a, b) => a.year - b.year);

                const crimes = response.data.map(crime => ({
                    _id: crime.id,
                    classification: crime.classification,
                    description: crime.description,
                    crimeDate: crime.crimeDate,
                    location: crime.location
                }));

                setCrimeCount(crimeCountData);
                setCrimeLocations(crimeLocationData);
                setCrimes(crimes);
            })
            .catch(error => {
                console.log(error);
            });
    }, [selectedCrimeType, crimeDateFilter]);

    const handleTabChange = (event, newValue) => {
        setSelectedTab(newValue);
    };

    return (
        <div style={{ display: 'flex', justifyContent: 'space-between', margin: '20px' }}>
            <div style={{ display: 'flex', flexDirection: 'column', width: '60%' }}>
                <Tabs value={selectedTab} onChange={handleTabChange}>
                    <Tab sx={{color: '#fff'}} label="Analysis"/>
                    <Tab sx={{color: '#fff'}} label="View Records"/>
                </Tabs>
                {selectedTab === 0 && (
                <div>
                    <MapComponent crimeLocations={crimeLocations} selectedCrime={selectedCrime} />
                    <Chart crimeTypes={crimeTypes} crimeCount={crimeCount} />
                </div>)}
                {selectedTab === 1 && <TableComponent crimes={crimes}/>}
            </div>
            <div style={{ width: '20%' }}>
                <Filter crimeTypes={crimeTypes} setSelectedCrimeType={setSelectedCrimeType} setCrimeDateFilter={setCrimeDateFilter} />
            </div>
            <div style={{ width: '20%' }}>
                <CrimeFeed crimes={crimes} onCrimeSelect={setSelectedCrime} />
            </div>
        </div>
    );
}