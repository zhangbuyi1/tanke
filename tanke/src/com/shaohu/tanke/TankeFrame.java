package com.shaohu.tanke;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class TankeFrame extends Frame {
    TanKe mainTanKe=new TanKe(200,200,30,30,Direction.DOWN);
    public TankeFrame(){

        // 设置窗口大小
        setSize(800,700);
        // 设置游戏 title
        setTitle("tanke");
        // 显示窗口
        setVisible(true);
        // 设置不能改变大小
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
        });
        // 添加一个监视器
        addKeyListener(mainTanKe);

    }

    @Override
    public void paint(Graphics g) {
        // 使用画笔 绘制一个坦克
        mainTanKe.paint(g);
        mainTanKe.mv();
    }


}
