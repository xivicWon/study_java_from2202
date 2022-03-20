package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class OvenMagnetron {

    @Test
    void on() {
        log.info("마이크로파 ON");
    }

    @Test
    void off() {
        log.info("마이크로파 OFF");
    }


}
