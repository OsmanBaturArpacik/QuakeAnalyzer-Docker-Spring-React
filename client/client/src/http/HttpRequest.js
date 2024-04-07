const fetchData = async () => {
    try {
        const response = await fetch('http://localhost:8080/getList');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('There was a problem with the request:', error);
        return null;
    }
};


// const postData = async (url, body) => {
//     try {
//         const response = await fetch(url, {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json',
//             },
//             body: JSON.stringify(body),
//         });
//         const data = await response.json();
//         return data;
//     } catch (error) {
//         console.error('Error posting data:', error);
//         throw error;
//     }
// };

export {fetchData};