import axios from "axios";
import DotGenerator from "../components/Map/DotGenerator";

const fetchDatas = async (url) => {
    try {
        const response = await fetch(url);
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};
let dataList;

const fetchData = async () => {
    try {
        const response = await fetch('http://localhost:8080/getList');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        handleData(data);
    } catch (error) {
        console.log("List is Empty")
        // console.error('There was a problem with the request:', error);
    }
};
const handleData = (data) => {
    dataList = data;
    // console.log(dataList);
};


const postData = async (url, body) => {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(body),
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error posting data:', error);
        throw error;
    }
};

export {fetchData, postData,dataList};