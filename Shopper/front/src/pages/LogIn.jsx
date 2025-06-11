import React from 'react';
import {
  AuthContainer,
  Form,
  InputGroup,
  Label,
  Title,
  Input,
  AuthLink,
  Button,
  ErrorMessage,
} from '../styles/Authstyles';
import { useLogInForm } from '../hooks/useLogInForm';

const LogIn = () => {
  const { register, handleSubmit, errors, onSubmit, isLoading } = useLogInForm();
  return (
    <AuthContainer>
      <Title>로그인</Title>
      <Form onSubmit={handleSubmit(onSubmit)}>
        <InputGroup>
          <Label htmlFor="email">이메일</Label>
          <Input
            id="email"
            type="email"
            placeholder="이메일 입력하세요."
            {...register('email')}
            $error={errors.email}
          />
          {errors.email && <ErrorMessage>{errors.email.message}</ErrorMessage>}
        </InputGroup>
        <InputGroup>
          <Label htmlFor="email">비밀번호</Label>
          <Input
            id="password"
            type="password"
            placeholder="비밀번호를 입력하세요."
            {...register('password')}
            $error={errors.password}
          />
          {errors.password && <ErrorMessage>{errors.password.message}</ErrorMessage>}
        </InputGroup>

        <Button type="submit" disabled={isLoading}>
          {isLoading ? '로그인중...' : '로그인'}
        </Button>
        <AuthLink to="/signup">계정이 없으신가요? 회원가입하기</AuthLink>
      </Form>
    </AuthContainer>
  );
};

export default LogIn;
