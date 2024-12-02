package ru.smart.home.manage.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.smart.home.manage.dto.DeviceDto;

@Service
@RequiredArgsConstructor
public class HttpClient {
    @Value("${telemetry-server.url}")
    private String telemetryUrl;
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);
    private static final String DEV_PATH = "/devices/";

    /**
     * Слать json с данными нового прибора в сервис телеметрии.
     */
    public ResponseEntity<Object> post(int deviceId, DeviceDto body) {
        RestTemplate rest = new RestTemplateBuilder()
                .uriTemplateHandler(new DefaultUriBuilderFactory(telemetryUrl))
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DeviceDto> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<Object> serverResponse;
        try {
            serverResponse = rest.exchange(DEV_PATH + deviceId
                    , HttpMethod.POST
                    , requestEntity
                    , Object.class);
        } catch (HttpStatusCodeException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsByteArray());
        }
        return serverResponse;
    }
}
