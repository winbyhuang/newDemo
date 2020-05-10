package com.winby.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-provider")
public interface DemoClient {
    @GetMapping("/config/get")
    String get();
}
