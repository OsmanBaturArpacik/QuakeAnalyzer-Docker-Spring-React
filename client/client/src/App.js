import './App.css';

import Navbar from "./components/Navbar/Navbar";
import Scroll from "./components/Scroll/Scroll";
import {MapBasic} from "./components/Map/MapBasic";

function App() {

    return (
        <>
            <Scroll/>
            <Navbar/>
            <div className="container-map">
                <MapBasic/>
            </div>
        </>
    );
}

export default App;
