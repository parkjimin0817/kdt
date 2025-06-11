import { AuthContainer, Button, Title } from '../styles/Authstyles';
import useUserStore from '../store/userStore';

const Profile = () => {
  const { user, isAuthenticated } = useUserStore();
  return (
    <AuthContainer>
      <Title>나의 정보</Title>
      <div>이름 : {user?.username}님</div>
      <div>이메일 : {user?.email}</div>
      <div>등급 : {user?.role}</div>
      <Button>수정하기</Button>
      <Button>탈퇴하기</Button>
    </AuthContainer>
  );
};

export default Profile;
