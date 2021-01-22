package com.shaohu.tanke;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TanKe extends KeyAdapter {
    /**
     * 上下左右键是否按下
     */
    private boolean up, dwon, left, right;
    /**
     * 坦克出现坐标
     */
    private int x, y;
    /**
     * 坦克大小
     */
    private int width, height;
    /**
     * 坦克移动速度
     */
    private static final int speed = 20;
    /**
     * 坦克移动方向
     */
    private Direction dir = Direction.DOWN;
    /**
     * 坦克是否移动
     */
    private boolean isMV=false;

    /**
     * 坦克构造器
     *
     * @param x      出现的x坐标
     * @param y      出现的y坐标
     * @param width  坦克的宽
     * @param height 坦克的高
     * @param dir    坦克移动方向
     */
    public TanKe(int x, int y, int width, int height, Direction dir) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dir = dir;

    }

    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    /**
     * 坦克移动方法
     */
    public void setDir() {
        if (up||dwon||right||left){
            isMV=true;
            if (up) dir = Direction.UP;
            if (dwon) dir = Direction.DOWN;
            if (left) dir = Direction.LEFT;
            if (right) dir = Direction.RIGHT;
        }else {
            isMV=false;
        }

    }


    /**
     * 按下键的时候触发
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                dwon = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
        setDir();
    }

    /**
     * 结束按键触发
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                dwon = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
        setDir();

    }
    public  void mv(){
        if (!isMV) return;
        switch (dir){
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            case LEFT:
                x-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;

        }
    }
}
