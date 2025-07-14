package com.kh.springai.controller;

import com.kh.springai.entity.Movie;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.image.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/ai")
@RestController
public class AiController {

    @Autowired
    private ChatModel chatModel;

    @Autowired
    private ImageModel imageModel;


    @GetMapping("/test")
    public Map<String, Object> testChatModel() {
        Map<String, Object> map = new HashMap<String, Object>();

        System.out.println("chatModel = " + chatModel.toString());

        //ChatClient를 생성
        ChatClient chatClient = ChatClient.builder(chatModel).build();

        String aiResponse = chatClient.prompt("공부 관련 명언을 세 개 알려줘").call().content();
        map.put("aiResponse", aiResponse);
        map.put("status", "success");

        return map;
    }

    //DALL-E 3기반 AI 이미지 생성
    @PostMapping("/generate-image")
    public Map<String, Object> generateImage(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            String prompt = request.get("prompt");
            if (prompt == null || prompt.trim().isEmpty()) {
                response.put("status", "error");
                response.put("error", "이미지 설명을 입력해주세요.");
                return response;
            }

            ImageOptions options = ImageOptionsBuilder.builder()
                    .model("dall-e-3")
                    .width(1024)
                    .height(1024)
                    .build();

            //이미지 생성
            ImagePrompt imagePrompt = new ImagePrompt(prompt, options);
            ImageResponse imageResponse = imageModel.call(imagePrompt);
            String imageUrl = imageResponse.getResult().getOutput().getUrl();

            response.put("status", "success");
            response.put("imageUrl", imageUrl);

        } catch (Exception e) {
            response.put("status", "error");
            response.put("error", e.getMessage());
        }

        return response;

    }

    /*
    promptTemplate이란?
    - LLM에게 전달할 프롬프트를 템플릿화해서 재사용 가능하게 만드는 기술
    - {변수명} 형태로 플레이스홀더를 사용하여 동적으로 내용을 바꿀 수 있다.
    ex) 안녕하세요! 제 이름은 {name}입니다. -> name 파라미터에 따라서 다양한 인사말을 생성
     */
    @PostMapping("/prompt-template")
    public Map<String, Object> promptTemplate(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            String name = request.get("name");
            if(name == null || name.trim().isEmpty()) {
                response.put("status", "error");
                response.put("error", "이름을 입력해주세요.");
                return response;
            }

            PromptTemplate promptTemplate = new PromptTemplate("안녕하세요 제 이름은 {name}입니다. 오늘 날씨에 대해서 알려주세요.");
            Prompt prompt = promptTemplate.create(Map.of("name", name));

            ChatClient chatClient = ChatClient.builder(chatModel).build();
            String result = chatClient.prompt(prompt)
                    .call()
                    .content();

            response.put("status", "success");
            response.put("result", result);
            response.put("type", "prompt-template");
        } catch (Exception e) {
            response.put("status", "error");
            response.put("error", e.getMessage());
        }
        return response;
    }

    //영화 리스트 생성
    @PostMapping("/chat-movie")
    public Map<String, Object> chatMovie(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            String directorName =  request.get("directorName");
            if(directorName == null || directorName.trim().isEmpty()) {
                response.put("status", "error");
                response.put("error", "감독 이름을 입력해주세요.");
                return response;
            }

            String template = """
                    Generate a list of movies directed by {directorName}.
                    If the director is unknown, return null.
                    Each movie object must contain the following.
                    -"title" (String) : The title of the movie.
                    -"year" (String) : release year.
                    한국 영화는 한글로 표기해줘.
                    format : {format} only.
                    """;


            //new ParameterizedTypeReference<List<Movie>>() {} -> 제네릭 타입 정보를 유지한 채로 json 응답을 List로 반환
            ChatClient chatClient = ChatClient.builder(chatModel).build();
            List<Movie> movieList = chatClient.prompt()
                    .user(userSpec -> userSpec.text(template)
                            .param("directorName", directorName)
                            .param("format", "json"))
                    .call()
                    .entity(new ParameterizedTypeReference<List<Movie>>() {});

            response.put("status", "success");
            response.put("result", movieList);
            response.put("type", "movie-list");
            response.put("directorName", directorName);

        } catch (Exception e) {
            response.put("status", "error");
            response.put("error", e.getMessage());
        }
        return response;
    }

}
