import logo from './resources/image/logo.svg';
import './App.css';

import Navbar from "./components/Navbar/Navbar";
import Scroll from "./components/Scroll";
import React, {useState} from "react";
import MapBasic from "./components/Map/MapBasic";
import DotGenerator from "./components/Map/DotGenerator";

function App() {
    const [coordinatesList, setCoordinatesList] = useState([]);

    const handleAddDot = () => {
        const newCoordinate = [Math.random() * 90, Math.random() * 90]; // Rastgele koordinatlar oluştur
        setCoordinatesList([...coordinatesList, newCoordinate]); // Yeni koordinatı ekleyerek durumu güncelle
    };

    return (
        <>
            <div>
                <button onClick={handleAddDot}>Add Dot</button>
                <DotGenerator coordinatesList={coordinatesList}/>
            </div>
            <Scroll/>
            <Navbar/>
            <div className="container-map">
                <MapBasic/>
            </div>
            <div>
                <div className="App">
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo"/>
                        <p>
                            Edit <code>src/App.js</code> and save to reload.
                        </p>
                        <a
                            className="App-link"
                            href="https://reactjs.org"
                            target="_blank"
                            rel="noopener noreferrer"
                        >
                            Learn React
                        </a>
                    </header>
                </div>
            </div>
        </>
    );
}

export default App;
