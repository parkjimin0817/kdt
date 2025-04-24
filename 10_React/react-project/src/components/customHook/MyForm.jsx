import React, { useState } from 'react'
import UseInput from './UseInput';

const MyForm = () => {
    const name = UseInput('');
    const email = UseInput('');


    const handleSubmit = (e) => {
        e.preventDefault();
        alert(`이름 : ${name.value}, 이메일 : ${email.value}`);
    }

  return (
    <form onSubmit={handleSubmit}>
        <input placeholder='이름...' {...name}/>
        <input placeholder='이메일...' {...email}/>
        <button type='submit'>제출</button>
    </form>
  )
}

export default MyForm