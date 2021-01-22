package com.shaohu.tanke;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankeFrame tankeFrame = new TankeFrame();
        while (true){
            Thread.sleep(50);
            tankeFrame.repaint();
        }
    }
}
