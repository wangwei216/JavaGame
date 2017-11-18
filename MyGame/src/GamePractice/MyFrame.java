package GamePractice;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CompletionStage;

import GamePractice.GameFrame02.PaintThread;


public class MyFrame extends Frame {
	
	
	
	public void launchFrame(){  //定义一个加载窗口的方法
		setSize(Constant.GAME_HEIGHT, Constant.GAME_WIDTH); //这个是设置的窗口的大小
		setLocation(200, 200);
		setVisible(true);  //还要把窗口设置成为可见的
		
		new PaintThread().start(); //这个是启动线程
		
		addWindowListener(new WindowAdapter() { //这是一个内部类对窗口的监听对象，可以是窗口可以退出

			@Override
			public void windowClosing(WindowEvent e) {  //这个是对windowClosing进行重写
				System.exit(0);
			}  
			
		});
		
		addWindowListener(new WindowAdapter() { //这是一个内部类对窗口的监听对象，可以是窗口可以退出

			@Override
			public void windowClosing(WindowEvent e) {  //这个是对windowClosing进行重写
				System.exit(0);
			}  
			
		});

	}
	
	
	 class PaintThread extends Thread{
			public void run(){
				while (true){
					repaint();
					try {
						Thread.sleep(40); //1s 等于1000ms  也就是一秒可以重复画25次窗口
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
				}
			}
			
			
		}

}
	
	
	
