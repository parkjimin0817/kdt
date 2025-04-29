const serverData = [{
    id: 1,
    name: "박지민"
},{
    id: 2,
    name: "이인성"
},{
    id: 3,
    name: "김지원"
}]

//기존 콜백 방식
// function getUser(data, successCallback, errorCallback){
//     //일반 함수 내에서 비동기 작업 실행
//     setTimeout(() => {
//         //완료 후 callback을 통한 데이터 전달
//         const user = serverData.filter(u => u.id === data.id);
//         if(user.length>0) successCallback(user);
//         else errorCallback("user를 찾을 수 없습니다.")
//     }, 3000)
// } 

// getUser({id: 5}, (user) => {
//     console.log(user);
// }, (errorMsg) => {
//     console.log(errorMsg)
// })

function getUser(data){
    //Promise -> 비동기 작업을 실행해줄 객체
    return new Promise((resolve, reject) => {
        //resolve : 성공 시 실행해줄 함수
        //reject : 실패 시 실행해줄 함수

        //Promise 내에서 비동기 함수 실행
        setTimeout(() => {
            //완료 후 callback을 통한 데이터 전달
            const user = serverData.filter(u => u.id === data.id);
            if(user.length>0) resolve(user);
            else reject("user를 찾을 수 없습니다.");
        }, 3000)
    })
}

// getUser({id : 5})
//     .then(result => {
//         console.log("then 결과 : " , result)
//     })
//     .catch(reject => {
//         console.log("error 결과 :", reject)
//     })
//     .finally(() => {
//         console.log("finally 실행")
//     })

async function testAsync(){
    try {
        const result = await getUser({id: 3});
        console.log("then 결과 :", result);
    } catch(error) {
        console.log("catch 결과 : ", error);
    } finally{
        console.log("async/await 실행완료")
    }
}

testAsync();
