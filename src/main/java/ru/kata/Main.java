package ru.kata;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://94.198.50.185:7081/api/users";

        ResponseEntity<String> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                null,
                String.class);

        String cookie = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", cookie);

        // POST
        User newUser = new User(3L, "James", "Brown", (byte) 35);
        HttpEntity<User> postRequest = new HttpEntity<User>(newUser, headers);
        String part1 = restTemplate.postForObject(baseUrl, postRequest, String.class);

        // PUT
        User updateUser = new User(3L, "Thomas", "Shelby", (byte) 35);
        HttpEntity<User> putRequest = new HttpEntity<User>(updateUser, headers);
        String part2 = restTemplate.exchange(
                baseUrl,
                HttpMethod.PUT,
                putRequest,
                String.class).getBody();

        // DELETE
        HttpEntity<String> deleteRequest = new HttpEntity<String>(headers);
        String part3 = restTemplate.exchange(
                baseUrl + "/3",
                HttpMethod.DELETE,
                deleteRequest,
                String.class).getBody();

        System.out.println(part1 + part2 + part3);
    }
}
