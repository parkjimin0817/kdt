import './App.css'
import Hello from './components/Hello'
import Heading from './components/Heading'
import VideoList from './components/VideoList'

const videoData = [{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/aWv3nD5gr7M/mqdefault_6s.webp?du=3000&sqp=CMmwh8AG&rs=AOn4CLA8vZoBraT3ifWBZ0c_jZEHkSWCPQ",
  title : "난 이걸로 먹고살래",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "8.3만",
  date : "2시간 전"
},{
  thumbnail : "https://i.ytimg.com/an_webp/juM_qadVY1E/mqdefault_6s.webp?du=3000&sqp=CLa4h8AG&rs=AOn4CLDfjDK86G1GfhXWx0R_1QDHYsGwDw",
  title : "길러준 은혜도 모르고...",
  logo : "https://yt3.googleusercontent.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s160-c-k-c0x00ffffff-no-rj",
  channelName: "빵빵이의 일상",
  views : "5.8만",
  date : "일주일 전"
}]

function App() {

  return (
    <>
      {/* <Heading type="h2"/>
      <Heading/>
      <Heading>
        무엇을 도와드릴까요?
      </Heading>
      <Hello/> */}
      <VideoList videos={videoData}/>
    </>
  )
}

export default App
