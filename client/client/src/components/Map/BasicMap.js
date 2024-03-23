import * as React from 'react';
import Map, {NavigationControl} from 'react-map-gl';
import maplibregl from 'maplibre-gl';
import 'maplibre-gl/dist/maplibre-gl.css';
import * as mapboxgl from 'mapbox-gl';
function BasicMap() {
    return (
        <Map mapLib={maplibregl}
             initialViewState={{
                 longitude: 16.62662018,
                 latitude: 49.2125578,
                 zoom: 14
             }}
             style={{width: "100%", height: " calc(100vh - 77px)"}}
             mapStyle="https://api.maptiler.com/maps/basic-v2/style.json?key=MXLQcbMRvctNGBW5yfuf"
        >
            <NavigationControl position="top-left" />
        </Map>
    );
}

export default BasicMap;