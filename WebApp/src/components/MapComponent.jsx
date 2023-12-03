import React, { useRef, useEffect, useState } from "react";
import mapboxgl from "mapbox-gl";

import { environment } from "../../environment";

mapboxgl.accessToken = environment.mapbox.accessToken;

const MapComponent = ({ crimeLocations, selectedCrime }) => {
  const mapContainerRef = useRef(null);
  const map = useRef(null);

  const [lng, setLng] = useState(-73.9);
  const [lat, setLat] = useState(40.7);
  const [zoom, setZoom] = useState(10);

  useEffect(() => {
    if (crimeLocations.length > 0) {
      const firstLocation = crimeLocations[0];
      setLat(firstLocation.lat);
      setLng(firstLocation.lng);
    }
  }, [crimeLocations]);

  useEffect(() => {
    map.current = new mapboxgl.Map({
      container: mapContainerRef.current,
      // style: "mapbox://styles/mapbox/outdoors-v12",
      style: "mapbox://styles/mapbox/navigation-night-v1",
      center: [lng, lat],
      zoom: zoom,
    });

    // add navigation control (the +/- zoom buttons)
    map.current.addControl(new mapboxgl.NavigationControl(), "top-right");

    // map onload event
    map.current.on("load", () => {
      map.current.addSource("crimeLocations", {
        type: "geojson",
        data: {
          type: "FeatureCollection",
          features: crimeLocations.map((location) => ({
            type: "Feature",
            geometry: {
              type: "Point",
              coordinates: [location.lng, location.lat],
            },
          })),
        },
      });

      map.current.addLayer({
        id: "crimeLocations-glow",
        type: "circle",
        source: "crimeLocations",
        paint: {
          "circle-radius": 12,
          "circle-color": "#f00",
          "circle-blur": 1,
        },
      });

      map.current.addLayer({
        id: "crimeLocations",
        type: "circle",
        source: "crimeLocations",
        paint: {
          "circle-radius": 10,
          "circle-color": "#f00",
        },
      });
    });

    // clean up on unmount
    return () => map.current.remove();
  }, [crimeLocations, lat, lng, zoom]);

  useEffect(() => {
    if (selectedCrime && map.current) {
      map.current.flyTo({
        center: [selectedCrime.location.lon, selectedCrime.location.lat],
        zoom: 15,
        duraction: 500,
        essential: true,
      });
    }
  }, [selectedCrime]);

  return (
    <div>
      <div style={{
        width: "100%", height: "400px", border: '2px solid #c9c9c9',
        borderRadius: '6px',
        marginTop: '10px',
        marginRight: '15px',
        marginBottom: '10px'
      }} ref={mapContainerRef} />
    </div>
  );
};

export default MapComponent;
