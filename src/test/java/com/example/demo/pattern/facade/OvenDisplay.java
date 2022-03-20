package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OvenDisplay {

    public void draw(String message) {
        log.info(message);
    }
}
