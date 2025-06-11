import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { SITE_CONFIG } from '../config/site';
import { media } from '../styles/MediaQuery';
import { productService } from '../api/products';
import { Container, GridContainer, Section } from '../styles/common/Container';
import { Title } from '../styles/common/Typograghy';
import { Card, CardContent, CardTitle, CardImage } from '../styles/common/Card';
import { toast } from 'react-toastify';
import { ClipLoader } from 'react-spinners';

function Home() {
  const [popularProducts, setPopularProducts] = useState([]);
  const [newProducts, setNewProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const loadProducts = async () => {
      try {
        const products = await productService.getProducts();
        console.log(products);
        setNewProducts(products.filter((p) => p.isNew));
        setPopularProducts(products.filter((p) => p.isPopular));
      } catch (error) {
        console.error(error);
        const errorMessage = '상품을 불러오는데 실패했습니다.';
        setError(errorMessage);
        toast.error(errorMessage);
      } finally {
        setLoading(false);
      }
    };
    loadProducts();
  }, []);

  if (loading) {
    return (
      <LoadingContainer>
        <ThemeLoader size={50} aria-label="Loading Spinner" />
      </LoadingContainer>
    );
  }

  return (
    <Container>
      <Banner>
        <div>
          <BannerTitle>{SITE_CONFIG.name}</BannerTitle>
          <BannerSubTitle>{SITE_CONFIG.description}</BannerSubTitle>
        </div>
      </Banner>

      <Section>
        <Title>인기 상품</Title>
        <GridContainer>
          {popularProducts.map((product) => (
            <Card key={product.id}>
              <CardImage src={product.image} alt="" />
              <CardContent>
                <CardTitle>{product.name}</CardTitle>
                <span>{product.price}원</span>
              </CardContent>
            </Card>
          ))}
        </GridContainer>
      </Section>

      <Section>
        <Title>신상품</Title>
        <GridContainer>
          {newProducts.map((product) => (
            <Card key={product.id}>
              <CardImage src={product.image} alt="" />
              <CardContent>
                <CardTitle>{product.name}</CardTitle>
                <span>{product.price}원</span>
              </CardContent>
            </Card>
          ))}
        </GridContainer>
      </Section>
    </Container>
  );
}

const Banner = styled.div`
  background: linear-gradient(300deg, ${({ theme }) => theme.colors.primary}, ${({ theme }) => theme.colors.info});
  padding: ${({ theme }) => theme.spacing[16]} 0;
  color: ${({ theme }) => theme.colors.white};
`;

const BannerTitle = styled.h1`
  font-size: ${({ theme }) => theme.fontSizes.xl};
  font-weight: ${({ theme }) => theme.fontWeights.bold};
  margin-bottom: ${({ theme }) => theme.spacing[4]};

  ${media.md`
    font-size: ${({ theme }) => theme.fontSizes['4xl']}
  `}
`;

const BannerSubTitle = styled.p`
  font-size: ${({ theme }) => theme.fontSizes.base};

  ${media.md`
    font-size: ${({ theme }) => theme.fontSizes.xl}
  `}
`;

const LoadingContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  max-height: 100vh;
`;

const ThemeLoader = styled(ClipLoader)`
  color: ${({ theme }) => theme.colors.primary};
`;

export default Home;
