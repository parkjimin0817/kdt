import React from 'react';
import styled from 'styled-components';
import { FaArrowLeft } from 'react-icons/fa';
import { FaEdit } from 'react-icons/fa';
import { MdDelete } from 'react-icons/md';

const IconButtons = () => {
  return (
    <Wrapper>
      <Title>
        <FaArrowLeft />
        아이콘 버튼
      </Title>

      <Button color="#20e72a">
        <FaEdit />
        수정
      </Button>

      <Button color="red">
        <MdDelete />
        삭제
      </Button>
    </Wrapper>
  );
};

export default IconButtons;

const Wrapper = styled.div`
  padding: 20px;
`;
const Title = styled.h2`
  font-size: 24px;
  display: flex;
  align-items: center;
  margin-bottom: 20px;
`;
const Button = styled.button`
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 10px 14px;
  background: ${({ color }) => color || ' #2d20e7'};
  color: white;
  font-size: 18px;
  border: none;
  border-radius: 8px;

  &:hover {
    opacity: 0.9;
  }
`;
