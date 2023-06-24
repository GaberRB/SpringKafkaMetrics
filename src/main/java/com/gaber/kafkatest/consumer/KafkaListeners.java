package com.gaber.kafkatest.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
@Slf4j
public class KafkaListeners {

    private final HttpClient httpClient;

    public KafkaListeners() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @KafkaListener(
            topics = "topico_java",
            groupId = "groupId"
    )
    public void listerner(List<String> dados){
        if (dados.size() > 0){
            Executor executor = Executors.newFixedThreadPool(10);
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            StopWatch processWatch = StopWatch.createStarted();
            for(var dado : dados){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
                    log.info(String.valueOf(dado));
                    sendPostRequest("http://localhost:8080/api/kafka/" + dado);
                }, executor);
                futures.add(future);
            }

            futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

            processWatch.stop();;

            log.info("fim do consumo das mensagens : {} ", processWatch);
        }

    }
    private void sendPostRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("Response code: {}", response.statusCode());
        } catch (IOException | InterruptedException e) {
            log.error("Failed to send POST request: {}", e.getMessage());
        }
    }

}
