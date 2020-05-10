package com.winby.demo.client;

public class DemoHystrix implements DemoClient {

    @Override
    public String get() {
        return "fallback";
    }
}
