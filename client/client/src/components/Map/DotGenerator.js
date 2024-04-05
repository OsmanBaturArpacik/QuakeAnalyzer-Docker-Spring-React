import React, { useEffect, useState } from 'react';
import { map } from "./MapBasic";
import { dataList } from "../../http/HttpRequest";

function DotGenerator() {
    const [list, setList] = useState(null);
    const [mapLoaded, setMapLoaded] = useState(false);
    const [lastIndex, setLastIndex] = useState(-1);
    const [dotsAdded, setDotsAdded] = useState(false);

    useEffect(() => {
        if (!dataList) {
            return;
        }
        setList(dataList);
        setDotsAdded(false);
        // console.log("Object list:" + dataList)
        // console.log("Data List:", JSON.stringify(dataList));
    }, [dataList]); // list degisince calisir

    useEffect(() => {
        const addDots = () => {
            removeAllDots();
            if (mapLoaded && list && list.length > 0 && !dotsAdded) {
                setLastIndex(lastIndex+1);
                list.forEach((obj, index) => {
                    addPulsingDot( obj.lat, obj.lon, (lastIndex + index) );
                    console.log("NEW ADD: lat:" + obj.lat + "lon:" + obj.lon + "intensity:" + obj.intensity + "timestamp:" + obj.timestamp )
                });
                console.log("All dots added.");
                setDotsAdded(true);
                setLastIndex(lastIndex+list.length);
            }
        };

        addDots();
    }, [mapLoaded, list, dotsAdded, lastIndex]);

    useEffect(() => {
        const onMapLoad = () => {
            setMapLoaded(true);
        };

        map.on('load', onMapLoad);

        return () => {
            map.off('load', onMapLoad);
        };
    }, [dotsAdded, map, mapLoaded]);

    const removeAllDots = () => {
        if(dotsAdded || lastIndex == -1) {
            return;
        }
        for (let i = 0; i <= list.length; i++) {
            map.removeLayer(`point-${i}`);
            map.removeSource(`point-${i}`);
            map.removeSource(`pulsing-dot-${i}`);
        }
        setDotsAdded(false);
        setLastIndex(-1);
        console.log("All dots removed.");
    };

    const addPulsingDot = (x, y, index) => {
        map.addImage(`pulsing-dot-${index}`, pulsingDot, { pixelRatio: 2 });

        map.addSource(`point-${index}`, {
            'type': 'geojson',
            'data': {
                'type': 'FeatureCollection',
                'features': [
                    {
                        'type': 'Feature',
                        'geometry': {
                            'type': 'Point',
                            'coordinates': [x, y]
                        }
                    }
                ]
            }
        });
        map.addLayer({
            'id': `point-${index}`,
            'type': 'symbol',
            'source': `point-${index}`,
            'layout': {
                'icon-image': `pulsing-dot-${index}`
            }
        });
    };

    var size = 200;
    var pulsingDot = {
        width: size,
        height: size,
        data: new Uint8Array(size * size * 4),
        onAdd: function () {
            var canvas = document.createElement('canvas');
            canvas.width = this.width;
            canvas.height = this.height;
            this.context = canvas.getContext('2d');
        },
        render: function () {
            var duration = 1000;
            var t = (performance.now() % duration) / duration;
            var radius = (size / 2) * 0.3;
            var outerRadius = (size / 2) * 0.7 * t + radius;
            var context = this.context;
            context.clearRect(0, 0, this.width, this.height);
            context.beginPath();
            context.arc(
                this.width / 2,
                this.height / 2,
                outerRadius,
                0,
                Math.PI * 2
            );
            context.fillStyle = 'rgba(255, 200, 200,' + (1 - t) + ')';
            context.fill();
            context.beginPath();
            context.arc(
                this.width / 2,
                this.height / 2,
                radius,
                0,
                Math.PI * 2
            );
            context.fillStyle = 'rgba(255, 100, 100, 1)';
            context.strokeStyle = 'white';
            context.lineWidth = 2 + 4 * (1 - t);
            context.fill();
            context.stroke();
            this.data = context.getImageData(
                0,
                0,
                this.width,
                this.height
            ).data;
            map.triggerRepaint();
            return true;
        }
    };

    return null;
}

export default DotGenerator;
