package com.winby.demo.client;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelExceptionHandler {
    public static String blockHandle(BlockException ex) {
        return "扛不住了啊....block";
    }
    public static String fallBackHandle(BlockException ex) {
        return "扛不住了啊....fallBack";
    }
}
