import './App.css';

import Navbar from "./components/Navbar/Navbar";
import Scroll from "./components/Scroll/Scroll";
import React, {useEffect, useState} from "react";
import {MapBasic} from "./components/Map/MapBasic";
import DotGenerator from "./components/Map/DotGenerator";
import RequestTest from "./components/RequestTest";
import {fetchData} from "./http/HttpRequest";

function App() {

    const [data, setData] = useState(null);

    useEffect(() => {
        // İlk veri alımı
        fetchData().then((initialData) => {
            setData(initialData);
        });

        // Belirli aralıklarla yeni veri alımı
        const interval = setInterval(() => {
            fetchData().then((newData) => {
                setData(newData);
            });
        }, 3000); // 1 dakika (60000 milisaniye)

        // Component kaldırıldığında interval'i temizle
        return () => clearInterval(interval);
    }, []);


    const [coordinatesList, setCoordinatesList] = useState([]);

    const handleAddDot = () => {
        const newCoordinate = [Math.random() * 90, Math.random() * 90]; // Rastgele koordinatlar oluştur
        setCoordinatesList([...coordinatesList, newCoordinate]); // Yeni koordinatı ekleyerek durumu güncelle
    };
    const getRequestTestHandler = () => {
    }

    return (
        <>
            <Scroll/>
            <Navbar/>
            <div className="container-map">
                <MapBasic/>
            </div>
            {/*BACKEND SEND REQUEST*/}
            <div>
                <button onClick={getRequestTestHandler}>getRequestTest</button>
                <RequestTest/>
            </div>
            <div>
                <button onClick={handleAddDot}>Add Dot</button>
                <DotGenerator coordinatesList={coordinatesList}/>
            </div>

        </>
    );
}

export default App;
