package org.example.limittimegame;

import java.util.Timer;
import java.util.TimerTask;

public class LimitTimeGameSchedule {

    public static int count;
    public static void main(String[] args){

        count = 0;

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(count < 5){
                    System.out.println("Test");
                    count++;
                }else {
                    timer.cancel();
                }
            }
        };
        // 중간에 delay값을 준 이유는 실행하자마자 바로 시간초가 진행하기 때문에 delay를 지정해줌
        // period 값으로 일정 시간 텀으로 반복하라는 schedule 생성
        timer.schedule(timerTask, 5000, 2000);
    }
}
