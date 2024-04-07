import React, { useRef, useEffect, useState } from 'react';
import "leaflet/dist/leaflet.css";

import L from "leaflet";

import './map.css';

import { MaptilerLayer } from "@maptiler/leaflet-maptilersdk";
import {fetchData} from "../../http/HttpRequest";
import "./L.Icon.Pulse.css";
import "./L.Icon.Pulse.js";
const MapBasic = () => {
    const mapContainer = useRef(null);
    const map = useRef(null);
    const center = { lng: 28.338414, lat: 40.507932 };
    const [zoom] = useState(8);

    // var pulsingIcon = L.icon.pulse({iconSize:[20,20],color:'red'});
    // var marker = L.marker([50,15],{icon: pulsingIcon}).addTo(map);

    const [markers, setMarkers] = useState([]);

    useEffect(() => {
        if (map.current) return;

        map.current = new L.Map(mapContainer.current, {
            center: L.latLng(center.lat, center.lng),
            zoom: zoom
        });

        const mtLayer = new MaptilerLayer({
            apiKey: "MXLQcbMRvctNGBW5yfuf",
        }).addTo(map.current);

    }, [center.lng, center.lat, zoom]);


    useEffect(() => {
        // Harita oluşturma ve diğer işlemler
        // const pulsingIcon = L.icon.pulse({iconSize:[20,20],color:'red'});
        // const marker = L.marker([38.8,28], {icon: pulsingIcon}).addTo(map.current);
    }, []);

    useEffect(() => {
        const fetchDataPeriodically = async () => {
            try {
                const newData = await fetchData();
                console.log("New data:", newData);
                setMarkers(newData);
            } catch (error) {
                console.error('There was a problem fetching new data:', error);
            } finally {
                setTimeout(fetchDataPeriodically, 4000); // 60 saniye (60000 milisaniye)
            }
        };

        fetchDataPeriodically();

        return () => clearTimeout(fetchDataPeriodically);
    }, []);


    useEffect(() => {
        if (!map.current || !markers || markers.length === 0) {
            map.current.eachLayer(layer => {
                if (layer instanceof L.Marker) {
                    map.current.removeLayer(layer);
                }
            });
            return;
        }
        else {
            // Önceki işaretçileri temizle
            map.current.eachLayer(layer => {
                if (layer instanceof L.Marker) {
                    map.current.removeLayer(layer);
                }
            });

            // Yeni işaretçileri ekle
            markers.forEach(marker => {
                const pulsingIcon = L.icon.pulse({ iconSize: [20*(marker.intensity)/2.3, 20*(marker.intensity)/2.3], color: 'red' });
                L.marker([marker.lon, marker.lat], { icon: pulsingIcon })
                    .addTo(map.current)
                    .bindPopup(`Latitude: ${marker.lat},<br> Longitude: ${marker.lon},<br> Intensity: ${marker.intensity},<br> Timestamp: ${new Date(marker.timestamp).toLocaleDateString()}`);
            });
        }
    }, [markers]);




















    return (
        <div className="map-wrap">
            <div ref={mapContainer} className="map"/>
        </div>
    )
}

export {MapBasic};