import React, { useRef, useEffect, useState } from 'react';
import mapboxgl from 'mapbox-gl';

import { environment } from '../../environment'

mapboxgl.accessToken = environment.mapbox.accessToken;

const MapComponent = () => {
    const mapContainerRef = useRef(null);
    const map = useRef(null);

    const [lng, setLng] = useState(111.93);
    const [lat, setLat] = useState(33.47);
    const [zoom, setZoom] = useState(10);

    useEffect(() => {
        // if (map.current) return; // initialize map only once
        map.current = new mapboxgl.Map({
            container: mapContainerRef.current,
            style: 'mapbox://styles/mapbox/outdoors-v12',
            center: [lng, lat],
            zoom: zoom
        });
        console.log(map.current);
        console.log(environment.mapbox.accessToken);

        // add navigation control (the +/- zoom buttons)
        map.current.addControl(new mapboxgl.NavigationControl(), 'top-right');

        // map onload event 
        map.current.on('load', () => {
            console.log("map loaded");
            map.current.resize();
        })

        // clean up on unmount
        return () => map.current.remove();
    }, [lat, lng, zoom]);

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