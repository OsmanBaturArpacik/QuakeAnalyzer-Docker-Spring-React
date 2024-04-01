import './App.css';

import Navbar from "./components/Navbar/Navbar";
import Scroll from "./components/Scroll/Scroll";
import React, {useState} from "react";
import {MapBasic} from "./components/Map/MapBasic";
import DotGenerator from "./components/Map/DotGenerator";
import RequestTest from "./components/RequestTest";

function App() {
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
