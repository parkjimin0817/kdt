import axios from "axios";

// 1. GET 요청 (데이터 조회)
// axios.get("https://jsonplaceholder.typicode.com/posts/1")
//   .then(response => {
//     console.log(response.data);
//   })
//   .catch(error => {
//     console.error(error);
//   });

async function getPost() {
    try {
        const response = await axios.get("https://jsonplaceholder.typicode.com/posts/1");
        console.log("받은 데이터:", response.data);
    } catch (Error) {
        console.error("에러 발생:", Error)
    }
}

// getPost();

async function addPost() {
    //axios.post(요청할 url, 전달할 데이터)
    const response = await axios.post("https://jsonplaceholder.typicode.com/posts/1", {
        title: 'foo',
        body: 'bar',
        userId: 1,
    });
    console.log("받은 데이터:", response.data)
}

addPost();