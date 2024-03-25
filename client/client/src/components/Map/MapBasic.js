import React, { Component } from 'react';
import maplibregl from 'maplibre-gl';

let mapInstance;

class MapBasic extends Component {


    componentDidMount() {
        const mapContainer = document.getElementById('map')

        const initialViewState = {
            longitude: 28.8895977631662,
            latitude: 41.01959529376145,
            zoom: 2
        };

        mapInstance = new maplibregl.Map({
            container: mapContainer,
            style: 'https://api.maptiler.com/maps/streets-v2/style.json?key=MXLQcbMRvctNGBW5yfuf',
            center: [initialViewState.longitude, initialViewState.latitude],
            zoom: initialViewState.zoom
        });
    }

    componentWillUnmount() {
        if (mapInstance) {
            mapInstance.remove();
        }
    }

    getMapInstance() {
        return mapInstance;
    }

    render() {
        return (
            <div id="map" style={{ width: "100%", height: " calc(100vh - 77px)" }} />
        );
    }
}

export default MapBasic;
