package GamePractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.text.html.MinimalHTMLWriter;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;

import GamePractice.GameFrame.PaintThread;




public class GameFrame02 extends Frame {
		
	/**
	 * 这个地方是为了加载飞机的图片
	 */
	Image img =GameUtil.getImage("images/plane.jpg");
	
	
	public void launchFrame(){  //定义一个加载窗口的方法
		setSize(700, 700); //这个是设置的窗口的大小
		setLocation(200, 200);
		setVisible(true);  //还要把窗口设置成为可见的
		
		new PaintThread().start(); //这个是启动线程
		
		addWindowListener(new WindowAdapter() { //这是一个内部类对窗口的监听对象，可以是窗口可以退出

			@Override
			public void windowClosing(WindowEvent e) {  //这个是对windowClosing进行重写
				System.exit(0);
			}  
			
		});
	}
	
	private double x=100, y=100; //这个是飞机的初始位置
	private double degree=3.14/3 ;//这个是角度范围是【0-2pi】,要先给一个初始角度
	private double speed =10;
	/*private boolean left;    //这个是控制x轴的方向的移动的
	private boolean up;    //这个是控制Y轴方向的*/	
	
	@Override
	public void paint(Graphics g) {

		Color c  = g.getColor();
		g.setColor(Color.red);
	
		g.getColor();
		
		g.drawImage(img, (int )x,(int ) y,null );  //这个是在窗口上画一个图片 中间的x，y表示的是飞机每次变化的坐标
		
		if(speed >0){
			speed -=0.03;
		}
		else{
			speed=0;
		}
		x += speed*Math.cos(degree); //这个10 也是可以控制飞机的速度
		y += speed*Math.sin(degree);
		
		if(y>700-60){	
			degree = -degree;
		}						//这两个可以合并一块条件用||就可以合并一块
		if(y<60){
			degree = -degree;
		}
		
		if(x<0){
			degree = Math.PI- degree;
		}
		if(x>700-60){
			degree = Math.PI -degree;
		}
	 /* if(left){
			x -=4;  //可以通过改变每次x和y的增加或者减少的值来调节 飞机飞行的 速度
		}
		else{
			x+=5;
		}
		if(x >700-60){	//这个30是指飞机自身的长度，现在先设置60
			left = true;
		}
		if(x<0){
			left = false;
		}
///////////////////////////////////////////////	
		if(up){
			y -=3;
		}
		else{
			y+=3;
		}
		if(y >700-60){	//这个30是指飞机自身的长度，现在先设置60
			up = true;
		}
		if(y<0){
			up= false;
		}
		*/
		
	}
	
	
	/**
	 * @author user
	 *这是一个线程类，而且还是一个内部类
	 */
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
	
	

	public static void main(String[] args){
		GameFrame02   gh = new GameFrame02();  // 创建一个游戏窗口的对象
		gh.launchFrame();
		
	}

}
