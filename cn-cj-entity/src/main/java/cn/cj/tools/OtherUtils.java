package cn.cj.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 工具类
 * @author chenjie
 *
 */
public class OtherUtils {

	private static Logger logger = LoggerFactory.getLogger(OtherUtils.class);

	private static char RANDOMLIST[] = {
			'a','b','c','d','e','h',  
			'A','H','I','K','J','L',
			'B','G','P','O','N','M',
			'C','F','Q','R','S','T',
			'D','E','X','W','V','U',
			'f','g','i','l','o','1',
			'j','k','m','n','p','q',   
			'r','s','t','u','v','w',   
			'x','y','z','0','2','3',   
			'4','5','6','7','8','9',
			'Y','Z'
	};

	/**
	 * 获取自定义的随机数
	 * @param 几位随机数
	 * @return
	 */
	public static String getCustomRandom(int num){
		String targetRandom = "";
		for (int i = 0; i < num; i++) {
			targetRandom += RANDOMLIST[(int)(RANDOMLIST.length*Math.random())];
		}
		return targetRandom;
	}

	/**
	 * 生成验证码图片
	 * @param width
	 * @param height
	 * @param outputStream
	 * @param verifyCode
	 */
	public static void outputImg(int width, int height, ServletOutputStream outputStream, String verifyCode) {
		//创建img对象,设置宽高和颜色类型
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取图片上下文
		Graphics g = img.getGraphics();
		//设置图片的颜色
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		//画边框
		g.setColor(Color.white);
		g.drawRect(0, 0, width-2, height-2);  
		//让自定义随机数生成在图片上
		g.setColor(getRandColor(1,255));
		g.setFont(new Font("微软雅黑", Font.PLAIN,22));   
		String str = verifyCode.substring(0,1);
		//画str字符在自定义图片的8,17的位置
		g.drawString(str, 8, 22);
		str = verifyCode.substring(1, 2);   
		g.drawString(str, 20, 25);   
		str = verifyCode.substring(2, 3);   
		g.drawString(str, 35, 18);   
		str = verifyCode.substring(3, 4);   
		g.drawString(str, 45, 27); 
		//产生随机干扰点
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(width);   
			int y = random.nextInt(height);   
			g.drawOval(x, y, 1, 1);
		}
		//产生随机干扰线
		for (int i = 0; i < 3; i++) {
			//随机获取干扰线的起点和终点
			int xs = (int)(Math.random() * width);
			int ys = (int)(Math.random() * height);
			int xe = (int)(Math.random() * width);
			int ye = (int)(Math.random() * height);
			g.setColor(getRandColor(1, 255));
			g.drawLine(xs, ys, xe, ye);
		}
		//释放图片上下文
		g.dispose();
		try {
			//将图片转换为bute数组
			outputStream.write(getByteArray(img));
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			logger.debug("创建图片失败");
		}
	}

	/**
	 * 获取随机的颜色，r,g,b的取值在L到R之间
	 * @param L 左区间
	 * @param R 右区间
	 * @return 返回随机颜色值
	 */
	private static Color getRandColor(int L, int R){
		if(L > 255)
			L = 255;
		if(R > 255)
			R = 255;
		if(L < 0)
			L = 0;
		if(R < 0)
			R = 0;
		int interval = R - L; 
		int r = L + (int)(Math.random() * interval);
		int g = L + (int)(Math.random() * interval);
		int b = L + (int)(Math.random() * interval);
		return new Color(r, g, b);
	}

	/**
	 * 将图片转为byte数组
	 * @param image 图片
	 * @return 返回byte数组
	 * @throws IOException
	 */
	public static byte[] getByteArray(BufferedImage image) throws IOException{
		//ByteArrayOutputStream 不需要close
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		return baos.toByteArray();
	}



}
