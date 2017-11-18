package GamePractice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.RenderingHints;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.PaintEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.util.PrimitiveIterator;

import javax.swing.WindowConstants;
import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;


public class GameFrame extends Frame {
		
	/**
	 * 这个地方是为了加载飞机的图片
	 */
	Image img =GameUtil.getImage("images/plane.jpg");
	
	
	public void launchFrame(){  //定义一个加载窗口的方法
		setSize(500, 500);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() { //这是一个内部类对窗口的监听对象，可以是窗口可以退出

			@Override
			public void windowClosing(WindowEvent e) {  //这个是对windowClosing进行重写
				System.exit(0);
			}  
			
		});
	}
	
	private double x, y;
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 250);
		g.drawRect(100, 100, 200, 200);
		
		Font f = new Font("宋体", Font.BOLD, 30);
		g.setFont(f);
		
		Color c  = g.getColor();
		g.setColor(Color.red);
		g.drawString("这是我的游戏窗口", 100, 200);
		g.getColor();
		
		g.drawImage(img, (int )x,(int ) y,null);  //这个是在窗口上画一个图片 中间的x，y表示的是飞机每次变化的坐标
	
		x+=3;
		y+=2;
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
		GameFrame   gh = new GameFrame();  // 创建一个游戏窗口的对象
		gh.launchFrame();
		
	}
}
