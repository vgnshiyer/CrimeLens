import React, { useRef, useEffect, useState } from 'react';
import mapboxgl from 'mapbox-gl';

import { environment } from '../../environment'

mapboxgl.accessToken = environment.mapbox.accessToken;

const MapComponent = ({crimeLocations}) => {
    const mapContainerRef = useRef(null);
    const map = useRef(null);

    const [lng, setLng] = useState(-73.9);
    const [lat, setLat] = useState(40.7);
    const [zoom, setZoom] = useState(10);

    useEffect(() => {
        // if (map.current) return; // initialize map only once
        map.current = new mapboxgl.Map({
            container: mapContainerRef.current,
            style: 'mapbox://styles/mapbox/outdoors-v12',
            center: [lng, lat],
            zoom: zoom
        });

        // add navigation control (the +/- zoom buttons)
        map.current.addControl(new mapboxgl.NavigationControl(), 'top-right');

        // map onload event 
        map.current.on('load', () => {
            map.current.addSource('crimeLocations', {
                type: 'geojson',
                data: {
                    type: 'FeatureCollection',
                    features: crimeLocations.map(location => ({
                        type: 'Feature',
                        geometry: {
                            type: 'Point',
                            coordinates: [location.lng, location.lat]
                        }
                    }))
                }
            });

            map.current.addLayer({
                id: 'crimeLocations-glow',
                type: 'circle',
                source: 'crimeLocations',
                paint: {
                    'circle-radius': 15,
                    'circle-color': '#f00',
                    'circle-blur': 1 // blur the edges
                }
            });
    
            map.current.addLayer({
                id: 'crimeLocations',
                type: 'circle',
                source: 'crimeLocations',
                paint: {
                    'circle-radius': 10,
                    'circle-color': '#f00'
                }
            });
        })

        // clean up on unmount
        return () => map.current.remove();
    }, [crimeLocations, lat, lng, zoom]);

    return (
        <div>
            <div style={{ width: "100%", height: "400px" }} ref={mapContainerRef} />
            <div className="sidebar">
                Longitude: {lng} | Latitude: {lat} | Zoom: {zoom}
            </div>
        </div>
    );
};

export default MapComponent;