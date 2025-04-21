import React, { useState } from 'react'

//이름과 성별을 입력받을 수 있도록 만들고
//submit 버튼 클릭 시 이름 : ~~~ 성별: ~~~ 출력해라 (alert)

const SignUp = () => {
    const[name, setName] = useState("");
    const[gender, setGender] = useState("man");

    const handleChangeName = (ev) => {
        setName(ev.target.value);
    }
    const hadleChangeGender = (ev) => {
        setGender(ev.target.value);
    }
    const handleSubmit = (ev) => {
        alert(`이름 : ${name}, 성별 : ${gender}`);
        ev.preventDefault(); //a태그나 submit태그 같은 고유 동작을 중단하기 위한 이벤트 방지 
        //ev.stopPropagation(); 부모 엘리먼트에게 이벤트가 전파되는 것을 막을 수 있다
    }

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="">
                이름 : 
                <input type="text" value={name} onChange={handleChangeName}/>
            </label>
            <br/><br/>
            <label>
                성별
                <select value={gender} onChange={hadleChangeGender}>
                    <option value="man">남자</option>
                    <option value="woman">여자</option>
                </select>
            </label>
            <br/><br/>
            <button type="submit">제출</button>
        </form>
    )
}

export default SignUp