import React, { Component } from 'react';
import mapboxgl from 'mapbox-gl';

mapboxgl.accessToken = 'pk.eyJ1IjoiYnJheDI1MDciLCJhIjoiY2xsYWY1enc3MWo4ZjNsbndnanZjaGdxciJ9.AbY1vj4s-fm7bNUERWBEGg';

class MapComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            lng: 5,
            lat: 34,
            zoom: 2
        };
    }

    componentDidMount() {
        const { lng, lat, zoom } = this.state;
        const map = new mapboxgl.Map({
            container: this.mapContainer,
            style: 'mapbox://styles/mapbox/dark-v10',
            center: [lng, lat],
            zoom: zoom
        });
        map.on('move', () => {
            const { lng, lat } = map.getCenter();
            this.setState({
                lng: lng.toFixed(4),
                lat: lat.toFixed(4),
                zoom: map.getZoom().toFixed(2)
            });
        });
    }

    render() {
        const { lng, lat, zoom } = this.state;
        return (
            <div>
                <div ref={el => this.mapContainer = el} style={{ width: '75%', height: '500px' }} />
                <div>Longitude: {lng} | Latitude: {lat} | Zoom: {zoom}</div>
            </div>
        )
    }
}

export default MapComponent;