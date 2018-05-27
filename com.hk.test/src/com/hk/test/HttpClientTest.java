package com.hk.test;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * HttpClient 增强
 * @author : kally
 * @date : 2018/5/27 09 54
 */
public class HttpClientTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).GET().build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
        System.out.println(response.statusCode());
        System.out.println(response.version().name());
        System.out.println(response.body());
    }
}
