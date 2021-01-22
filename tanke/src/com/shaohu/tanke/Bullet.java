package com.shaohu.tanke;/**
 * Created by zhangshaohu on 2021/1/22.
 */

import java.awt.*;

/**
 * @author: zhangshaohu
 * @date: 2021/1/22
 * @description: 子弹类
 */
public class Bullet {

    /**
     * 是否出界
     */
    boolean live = true;
    /**
     * 子弹坐标x
     */
    private int x;
    /**
     * 子弹坐标y
     */
    private int y;
    /**
     * 宽
     */
    private int width;
    /**
     * 高
     */
    private int height;
    /**
     * 子弹速度
     */
    private int speed;
    /**
     * 子弹方向
     */
    private Direction direction;

    /**
     * 子弹构造器
     */
    public Bullet(int x, int y, int speed, Direction direction, int width, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.width = width;
        this.height = height;
    }


    /**
     * 绘制
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, width, height);
        g.setColor(c);
        // 子弹一旦发出 就按照一个方向飞就好了
        mv();
    }

    private void mv() {
        switch (direction) {
            case DOWN:
                y += speed;
                break;
            case UP:
                y -= speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
        // 如果当前子弹超出界限 那么就死了
        if (x <= 0 || y < 0 || x > TankeFrame.width || y > TankeFrame.height) {
            live = false;
        }
    }

}