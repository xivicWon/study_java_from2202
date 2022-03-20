package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Oven {
    private final OvenMagnetron ovenMagnetron;
    private final OvenSlideTable ovenSlideTable;
    //    private final OvenTurnTable ovenTurnTable;
    private final OvenTimer ovenTimer;
    private OvenDisplay ovenDisplay;
    private OvenStatus status;

    public Oven() {
        this.ovenMagnetron = new OvenMagnetron();
        this.ovenSlideTable = new OvenSlideTable();
        this.ovenTimer = new OvenTimer(this);
//        this.ovenTurnTable = new OvenTurnTable();
        this.status = OvenStatus.OFF;
        this.ovenDisplay = new OvenDisplay();
    }

    public void on() {
        this.status = OvenStatus.ON;
        this.showStatusToDisplay();
    }

    public void setTime(int timer) {
        this.ovenTimer.setSecond(timer);
    }

    public void run() {
        ovenMagnetron.on();
        ovenSlideTable.on();
        if (this.status == OvenStatus.PAUSE) {
            try {
                ovenTimer.reStart();
            } catch (Exception e) {
                log.info(e.getMessage());
                this.stop();
            }
        } else {
            ovenTimer.start();
            this.status = OvenStatus.WORK;
            this.showStatusToDisplay();
        }
    }

    public void pause() {
        ovenTimer.pause();
        ovenSlideTable.off();
        ovenMagnetron.off();
        this.status = OvenStatus.PAUSE;
        this.showStatusToDisplay();
    }

    public void stop() {
        ovenTimer.stop();
        ovenSlideTable.off();
        ovenMagnetron.off();
        this.status = OvenStatus.STAY;
        this.showStatusToDisplay();
    }

    public void off() {
        if (this.status.equals(OvenStatus.WORK)) {
            this.stop();
        }
        this.status = OvenStatus.OFF;
        this.showStatusToDisplay();
    }

    private void showStatusToDisplay() {
        ovenDisplay.draw("Oven Status : " + status);
    }
}
