package com.example.demo.pattern.facade;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;


// 좋은 코드, 좋은 설계 : 강한 응집도, 약한 결합도 (Strongly cohesion, Coupling )

@Slf4j
class OvenTimer {

    private Timer timer;
    private final Oven oven;
    private int second;


    public OvenTimer(Oven oven) {
        this.oven = oven;
    }

    @Test
    void start() {
        timer = new Timer();
        OvenTimerTask ovenTimerTask = new OvenTimerTask();
        timer.schedule(ovenTimerTask, 0, 1000);
        log.info("타이머 ON");
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    @Test
    void onTimerStopped() {
        oven.stop();
    }

    // 시간을 저장한뒤 오븐을 off 함. 재 시작시 저장된 second 로 시작.
    @Test
    void pause() {
        this.stop();
    }

    void reStart() throws Exception {
        if (second > 0) {
            this.start();
        } else {
            throw new Exception("Oven is not started.");
        }
    }

    @Test
    void stop() {
        timer.cancel();
        log.info("타이머 OFF");
    }

//    @Slf4j
//    static class OvenTimerTask extends TimerTask {
//
//        private int second;
//        private final OvenTimer ovenTimer;
//
//        public OvenTimerTask(OvenTimer ovenTimer) {
//            this.second = ovenTimer.getSecond();
//            this.ovenTimer = ovenTimer;
//        }
//
//        @Override
//        public void run() {
//            ovenTimer.setSecond(--second);
//            log.info("타이머 : " + second);
//            if (second <= 0) {
//                ovenTimer.onTimerStopped();
//            }
//        }
//    }

    /**
     * 내부클래스(inner)로 사용했을 때와, 정적클래스(static)로 사용하는 것의 차이.
     */
    private class OvenTimerTask extends TimerTask {

        private int second;
        private final OvenTimer ovenTimer;

        public OvenTimerTask() {
            this.ovenTimer = OvenTimer.this;
            this.second = ovenTimer.getSecond();
        }

        @Override
        public void run() {
            ovenTimer.setSecond(--second);
            log.info("타이머 : " + second);
            if (second <= 0) {
                ovenTimer.onTimerStopped();
            }
        }
    }
}

