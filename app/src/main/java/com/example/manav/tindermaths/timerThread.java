package com.example.manav.tindermaths;

import android.content.Intent;

public class timerThread extends QuizUI implements Runnable {

    public void run(){
        int countdown = 1000;
        while(countdown>0) {
            try {
                System.out.println("HEY" + countdown);
                Thread.sleep(1000);
                countdown--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Intent i = new Intent(this, EndGame.class);
        System.out.println("bfdbfgbg");
        i.putExtra("score", endGame());
        startActivity(i);
    }
}

