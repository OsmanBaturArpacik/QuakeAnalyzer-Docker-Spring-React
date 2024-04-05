import React, { useRef, useEffect, useState } from 'react';
import * as maptilersdk from '@maptiler/sdk';
import "@maptiler/sdk/dist/maptiler-sdk.css";
import './map.css';
let map;
function MapBasic() {
    const mapContainer = useRef(null);
    // const map = useRef(null);
    const kartaca = { lng: 28.88987084209524, lat: 41.026163949733515 };
    const [zoom] = useState(7); //14 kartaca
    const [maxZoom] = useState(7);
    const [minZoom] = useState(7);
    maptilersdk.config.apiKey = 'MXLQcbMRvctNGBW5yfuf';

    useEffect(() => {
        if (map) return; // stops map from intializing more than once

        map = new maptilersdk.Map({
            container: mapContainer.current,
            style: maptilersdk.MapStyle.STREETS,
            center: [kartaca.lng, kartaca.lat],
            zoom: zoom,
            maxZoom: maxZoom,
            minZoom: minZoom
        });

    }, [kartaca.lng, kartaca.lat, zoom]);

    return (
        <div className="map-wrap">
            <div ref={mapContainer} className="map" />
        </div>
    );
}
export {MapBasic, map};