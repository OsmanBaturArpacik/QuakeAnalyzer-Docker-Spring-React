import React, { useEffect, useState } from 'react';
import {map} from "./MapBasic";
//TODO
// start index tut mapInstance.removeLayer(startindex) ile ilk ekleneni sil
function DotGenerator(props) {
    const { coordinatesList } = props;
    const [mapInstance, setMapInstance] = useState(null);
    const [mapLoaded, setMapLoaded] = useState(false);
    const [lastIndex, setLastIndex] = useState(-1);

    useEffect(() => {
        if (!mapInstance) {
            setMapInstance(map);
        }
    }, [mapInstance]);

    useEffect(() => {
        if (mapInstance && !mapLoaded) {
            mapInstance.on('load', () => {
                setMapLoaded(true);
            });
        }
    }, [mapInstance, mapLoaded]);

    useEffect(() => {
        const addDots = async () => {
            if (mapLoaded && coordinatesList && coordinatesList.length > 0) {
                const startIndex = lastIndex + 1;
                coordinatesList.slice(startIndex).forEach((coords, index) => {
                    const [x, y] = coords;
                    addPulsingDot(x, y, index + startIndex);
                });
                console.log('All dots added.');
            }
        };

        addDots();
    }, [mapLoaded, coordinatesList, lastIndex]);

    const addPulsingDot = (x, y, index) => {
        const size = 200;

        const pulsingDot = {
            width: size,
            height: size,
            data: new Uint8Array(size * size * 4),

            onAdd: function () {
                const canvas = document.createElement('canvas');
                canvas.width = this.width;
                canvas.height = this.height;
                this.context = canvas.getContext('2d');
            },

            render() {
                const duration = 1000;
                const t = (performance.now() % duration) / duration;

                const radius = (size / 2) * 0.3;
                const outerRadius = (size / 2) * 0.7 * t + radius;
                const context = this.context;

                context.clearRect(0, 0, this.width, this.height);
                context.beginPath();
                context.arc(this.width / 2, this.height / 2, outerRadius, 0, Math.PI * 2);
                context.fillStyle = `rgba(255, 200, 200,${1 - t})`;
                context.fill();

                context.beginPath();
                context.arc(this.width / 2, this.height / 2, radius, 0, Math.PI * 2);
                context.fillStyle = 'rgba(255, 100, 100, 1)';
                context.strokeStyle = 'white';
                context.lineWidth = 2 + 4 * (1 - t);
                context.fill();
                context.stroke();

                this.data = context.getImageData(0, 0, this.width, this.height).data;

                return true;
            }
        };

        mapInstance.addImage(`pulsing-dot-${index}`, pulsingDot, { pixelRatio: 2 });

        mapInstance.addSource(`point-${index}`, {
            type: 'geojson',
            data: {
                type: 'FeatureCollection',
                features: [
                    {
                        type: 'Feature',
                        geometry: {
                            type: 'Point',
                            coordinates: [x, y]
                        }
                    }
                ]
            }
        });

        mapInstance.addLayer({
            id: `point-${index}`,
            type: 'symbol',
            source: `point-${index}`,
            layout: {
                'icon-image': `pulsing-dot-${index}`
            }
        });
        setLastIndex(index);
    };

    return null;
}

export default DotGenerator;
