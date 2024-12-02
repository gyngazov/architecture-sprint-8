
@Value("${statistics-server.url}")
private String serverUrl;

@Bean
public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
        .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<T> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<Object> serverResponse;
        try {
        serverResponse = rest.exchange(path, method, requestEntity, Object.class);
        } catch (HttpStatusCodeException e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsByteArray());
        }

        HttpMethod.POST
        response.getStatusCode()
