package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class OvenTurnTable {

    @Test
    void on() {
        log.info("턴테이블 ON");
    }

    @Test
    void off() {
        log.info("턴테이블 OFF");
    }

}
