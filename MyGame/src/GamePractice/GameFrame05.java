package GamePractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import GamePractice.GameFrame02.PaintThread;

public class GameFrame05  extends MyFrame{
	
	
	
	/**
	 * 这个地方是为了加载飞机的图片
	 */
	Image img =GameUtil.getImage("images/plane.jpg");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	
	
	
	private double x=100, y=100; //这个是飞机的初始位置
	private double degree=3.14/3 ;//这个是角度范围是【0-2pi】,要先给一个初始角度
	private double speed =10;
	/*private boolean left;    //这个是控制x轴的方向的移动的
	private boolean up;    //这个是控制Y轴方向的*/	
	
	@Override
	public void paint(Graphics g) {

	
		
		g.drawImage(img, (int )x,(int ) y,null );  //这个是在窗口上画一个图片 中间的x，y表示的是飞机每次变化的坐标
		g.drawImage(bg, 0, 0, null);
		
		x += speed*Math.cos(degree); //这个10 也是可以控制飞机的速度
		y += speed*Math.sin(degree);
		
		degree += 0.05;
	}
		
	public static void main(String[] args){
		
		GameFrame05 gf = new GameFrame05();
		gf.launchFrame();
		
	}
	

}
