package com.winby.demo.client;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private DemoClient demoClient;

    @GetMapping("feignGet")
    @SentinelResource(value="feign",entryType = EntryType.OUT,
//            fallback="fallBackHandle",fallbackClass= SentinelExceptionHandler.class,
            blockHandler="blockHandle",blockHandlerClass= SentinelExceptionHandler.class)
    public String feignGet() throws InterruptedException {
        System.out.println(demoClient.get());
        throw new RuntimeException("发生异常");
//        return demoClient.get();
    }
}
