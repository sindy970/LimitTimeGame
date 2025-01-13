package org.example.limittimegame;

import java.util.Random;
import java.util.Scanner;

public class LimitTimeGame {
    //class value
    static int correct = 0; // 정답갯수
    static int wrong = 0; // 틀린 갯수
    static int proNum = 0; // 문제 갯수

    public static void main(String[] args) {
        GuguTimer timer = new GuguTimer();
        timer.start();
    }

    private static class GuguTimer extends Thread {
        @Override
        public void run() {
            GameGugu game = new GameGugu();

            System.out.println("구구단 게임 시작! 제한시간 60초!");
            game.start();
            for(int i=60; i>0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("게임 종료!");
            System.out.println("총 문제 갯수: " + LimitTimeGame.proNum);
            System.out.println("맞춘 갯수: " + LimitTimeGame.correct);
            System.out.println("틀린 갯수: " + LimitTimeGame.wrong);
            System.exit(0); //THread 종료.

            game.interrupt();
        }
    } //class - timer


    private static class GameGugu extends Thread {
        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);

            System.out.println("시작!");
            while (true) {
                Random random = new Random();
                int fir = random.nextInt(100);
                int sec = random.nextInt(10);
                int result = fir * sec;

                System.out.println((LimitTimeGame.proNum+1)+ "번" + "--->" + fir + " X " + sec + " 정답은?");
                int inRes = sc.nextInt();

                if(inRes == result) {
                    System.out.println("정답입니다!");
                    LimitTimeGame.correct ++; // 정답 갯수
                }else {
                    System.out.println("틀렸습니다! 정답은: " + result);
                    LimitTimeGame.wrong ++; // 틀린 갯수
                }

                LimitTimeGame.proNum++; // 문제 갯수

                if(isInterrupted()) {
                    System.exit(0);
                }
            }//while
        }
    }// class - game
}
