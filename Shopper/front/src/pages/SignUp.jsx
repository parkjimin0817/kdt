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
import { useSignUpForm } from '../hooks/useSignUpForm';

const SignUp = () => {
  const { register, handleSubmit, errors, isSubmitting, watch } = useSignUpForm();
  return (
    <AuthContainer>
      <Title>회원가입</Title>
      <Form onSubmit={handleSubmit}>
        <InputGroup>
          <Label htmlFor="username">사용자이름</Label>
          <Input
            id="username"
            type="text"
            placeholder="사용자 이름을 입력하세요."
            {...register('username')}
            $error={errors.username}
          />
          {errors.username && <ErrorMessage>{errors.username.message}</ErrorMessage>}
        </InputGroup>
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
        <InputGroup>
          <Label htmlFor="email">비밀번호 확인</Label>
          <Input
            id="confirmPassword"
            type="password"
            placeholder="비밀번호를 다시 입력하세요."
            {...register('confirmPassword')}
            error={errors.confirmPassword}
          />
          {errors.confirmPassword && <ErrorMessage>{errors.confirmPassword.message}</ErrorMessage>}
        </InputGroup>

        <Button type="submit" disabled={isSubmitting}>
          {isSubmitting ? '처리중...' : '가입하기'}
        </Button>
      </Form>
      <AuthLink to="/login">이미 계정이 있으신가요? 로그인하기</AuthLink>
    </AuthContainer>
  );
};

export default SignUp;
