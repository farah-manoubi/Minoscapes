package com.example.minoscape;

public class EThread implements Runnable {

    public EThread() {}

    public static boolean stop = false;
    public static int seconde = 0, minute;

    public void run() {
        try {
            while(!stop) {
                Thread.sleep(1000);
                seconde+=1;
                if(seconde>60) {
                    minute+=1;
                    seconde = 0;
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
