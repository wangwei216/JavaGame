package GamePractice;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	// 这个是工具类 最好吧构造器都私有化

	
	public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try{
			img =ImageIO.read(u);
		}catch (IOException e){
			e.printStackTrace();
		}
		return img;
	}
	
}
	