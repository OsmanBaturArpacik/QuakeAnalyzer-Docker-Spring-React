import logo from './resources/image/logo.svg';
import './App.css';

import Navbar from "./components/Navbar/Navbar";
import Test from "./Test";
import BasicMap from "./components/Map/BasicMap";
import React from "react";
// TODO:
// random lat,lon ile harita üzerinde deprem gösterme
function App() {
  let navComponent
  switch (window.location.pathname) {
    case "/Test":
      navComponent = <Test />
          break
  }
  return (
      <>
        <Navbar />
        <div className="container-map">
            <BasicMap />
        </div>
        <div className="container">{navComponent}</div>
        <div>
          <div className="App">
            <header className="App-header">
              <p>
                Selamlar herkese ben <a className="App-link" href="https://google.com.tr" target="_blank"
                                        rel={"noopener noreferrer"}>osman</a>
                <br/>
                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
                industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
                scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap
                into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the
                release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing
                software like Aldus PageMaker including versions of Lorem Ipsum.
              </p>
            </header>
          </div>
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
