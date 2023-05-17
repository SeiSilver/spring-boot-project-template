package com.spring.template.silver.app.entrypoint.controller;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class TestController {

  private final WebClient webClientService1;
  private final WebClient webClientService2;

  public TestController(WebClient.Builder webClientBuilder) {

    HttpClient httpClient = HttpClient.create()
        .tcpConfiguration(
            client -> client
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000000)
                .doOnConnected(conn -> conn
                    .addHandlerLast(
                        new ReadTimeoutHandler(1000, TimeUnit.SECONDS))
                    .addHandlerLast(
                        new WriteTimeoutHandler(1000, TimeUnit.SECONDS))));
    ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

    this.webClientService1 = webClientBuilder
        .clientConnector(connector)
        .baseUrl("http://localhost:8090")
        .build();

    this.webClientService2 = webClientBuilder
        .clientConnector(connector)
        .baseUrl("http://localhost:8099")
        .build();
  }

  @GetMapping("/call/service1")
  public Map<String, String> test1() {
    return webClientService1.get()
        .uri("/api/call/service2")
        .retrieve()
        .bodyToMono(Map.class)
        .block();
  }

  @GetMapping("/call/service2")
  public Map<String, String> test2() {
    return webClientService2.get()
        .uri("/api/randomData")
        .retrieve()
        .bodyToMono(Map.class)
        .block();
  }

  @GetMapping("/randomData")
  public Map<String, String> randomStuff() {
    Map<String, String> data = new HashMap<>();
    data.put("message", "random Data");
    return data;
  }

}
