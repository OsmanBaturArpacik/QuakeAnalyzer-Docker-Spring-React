import React from 'react';
import axios from "axios";

class RequestTest extends React.Component {
    handleClick = () => {
        const formData = new FormData();
        formData.append('x', 'x value');
        formData.append('y', 'y value');
        axios.post('http://localhost:8080/analyzData', formData)
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.error('There was a problem with the request:', error);
            });
    };

    render() {
        return (
            <div>
                <button onClick={this.handleClick}>Send Request</button>
            </div>
        );
    }
}

export default RequestTest;
//
// import React, { Component } from 'react';
// import axios from 'axios';
//
// export default class RequestTest extends Component {
//     componentDidMount() {
//         const requestData = {
//             x: 'x value',
//             y: 'y value'
//         };
//
//         axios.post('http://localhost:8080/analyzData', requestData)
//             .then(response => {
//                 console.log(response.data);
//             })
//             .catch(error => {
//                 console.error('There was a problem with the request:', error);
//             });
//     }
//
//     render() {
//         return (
//             <></>
//         );
//     }
// }