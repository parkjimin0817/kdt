import React, { useState } from 'react'
import { Container, Loading, Error, PostCard, Title, Content, ButtonContainer, LoadingOverlay } from './styled/PostList.styled'
import { Button } from './styled/common'
import usePostStore from '../store/postStore'
import { useEffect } from 'react'

const PostList = () => {
    const { posts, error, loading, getPosts, deletePost } = usePostStore();
    const [ deletePostId, setDeletePostId ] = useState();

    useEffect(() => {
        getPosts();
    }, [getPosts])

    if (loading && posts.length === 0) return <Loading>로딩중...</Loading>
    if (error) return <Error>에러 발생 : {error}</Error>

    const handleDelete = async (id) => {
        setDeletePostId(id);
        await deletePost(id);
        setDeletePostId(null);
    }

    return (
        <Container>
            {posts.map((post) => (
                <PostCard key={post.id}>
                    <Title>{post.title}</Title>
                    <Content>{post.body}</Content>
                    <ButtonContainer>
                        <Button>수정</Button>
                        <Button
                            disabled={loading}
                            onClick={() => handleDelete(post.id)}
                        >
                            {deletePostId === post.id ? "삭제중..." : "삭제"}
                        </Button>
                    </ButtonContainer>
                    {deletePostId === post.id && (
                        <LoadingOverlay>
                            <div>삭제중...</div>
                        </LoadingOverlay>
                    )}
                </PostCard>
            ))}
        </Container>
    )
}

export default PostList