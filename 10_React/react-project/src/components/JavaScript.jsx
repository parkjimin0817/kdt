import React from 'react'

const imgurl = "https://i.namu.wiki/i/ZbNPpk4fG_ZEd7jf7aiYyRhqbXqocxfeSWhxwvBP9YeBn09fLGXbCQBaSGBN7QuZ-0En6Tu25OlUwGL79KqYYEC_9yw42m3IZmFH9LpJ2HiSN6UMmRz8YrJuMy4Lgf5bAdlyA3SoIe1mn1SESCXSsw.webp"
const text = "Hello, JSX"
const num = 10;

const loginUser = {
    name : "박지민",
    id : "jimin001",
    age : 38,
}

function getImg(){
    return <img src={imgurl} alt="빵빵이" width={100}/>
}

const numbers = [1,2,3,4]
const userList = [{
    name : "박지민",
    id : "jimin001",
    age : 38,
},{
    name : "박지지",
    id : "jimin002",
    age : 40,
},{
    name : "박지성",
    id : "jimin003",
    age : 88,
}]

const JavaScript = () => {
  return (
    <div>
        <h2>변수 넣는 방법</h2>
        <ul>
            <li>{text}</li>
            <li>{text + " Test"}</li>
        </ul>
        <h2>숫자 및 계산식 사용</h2>
        <ul>
            <li>{num}</li>
            <li>{num + 20}</li>
        </ul>
        <h2>Boolean 값</h2>
        <ul>
            <li>{true}</li>
            <li>{false}</li>
            <li>{undefined}</li>
            <li>{null}</li>
        </ul>

        <h2>Object, Array 값</h2>
        <ul>
            {
                Object.keys(loginUser).map((key) =>
                <li key={key}> {/*반복되는 요소안에는 무조건 key라는 속성이 필요함*/}
                    {key} : {loginUser[key]}
                </li>
            )}
            <li>{numbers}</li> {/*배열 그대로 출력 (문자열로 자동 변환)*/}
           {[<li key={1}>111</li>,<li key={2}>222</li>,<li key={3}>333</li> ]}
        </ul>

        <h2>태그 속성에 값 넣기</h2>
        <ul>
            <li>
                <img src={imgurl} alt="빵빵이" width={100}/>
            </li>
        </ul>

        <h2>조건부 렌더링</h2>
        <ul>
            <li>{num > 10 ? "10보다 큼" : "10보다 작음"}</li>
            <li>{num != 10 && "조건이 true일 때 보임"}</li>
            <li>{num != 10 || "조건이 true일 때 보임"}</li>

            <h3>삼항 연산자</h3>
            <li>{1 + 1 === 2 ? "참입니다" : "거짓입니다"}</li>
            
            <h3>AND 연산자</h3>
            <li>{1+1 === 2 && "AND 연산자 1"}</li>
            <li>{1+1 !== 2 && "AND 연산자 2"}</li>
            <li>{userList.length !== 0 && "user목록"}</li>

            <h3>OR 연산자</h3>
            <li>{1+1 !== 2 || "OR 연산자 1"}</li>
            <li>{1+1 === 2 || "OR 연산자 2"}</li>
        </ul>

        <h2>함수호출로 태그가 올 수 있음</h2>
        <ul>
            <li>{getImg()}</li>
        </ul>

        <h2>배열을 이용한 동적 리스트</h2>
        <ul>
            {userList.map((user) => <li key={user.id}>이름 : {user.name}, id: {user.id}, 나이: {user.age}</li> )}
        </ul> {/*동적으로 ui생성 시 react가 변경 항목만을 식별하기 위해 key 속성이 필요함*/}
        
        
    </div>
  )
}

export default JavaScript