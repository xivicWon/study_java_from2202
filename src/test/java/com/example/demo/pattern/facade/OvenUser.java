package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class OvenUser {

    public static void main(String[] args) throws InterruptedException {

//        OvenMagnetron ovenMagnetron = new OvenMagnetron();
////        OvenTurnTable turnTable = new OvenTurnTable();
//        OvenSlideTable ovenSlideTable = new OvenSlideTable();
//        OvenTimer ovenTimer = new OvenTimer();
//
//        ovenMagnetron.on();
//        ovenSlideTable.on();
//        ovenTimer.on(5);

        Oven oven = new Oven();
        oven.on();
        oven.setTime(10);
        oven.run();

        Thread.sleep(1900);
//        oven.pause();
        oven.off();
//        oven.run();

//        oven.pause();
//        Thread.sleep(2000);
//        oven.run();
//        Thread.sleep(8000);
//        oven.off();

//
//        ovenMagnetron.off();
//        ovenSlideTable.off();
//        ovenTimer.off();


    }

}
