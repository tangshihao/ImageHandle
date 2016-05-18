package imagehandle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class test {
	public static void main(String[] args) throws IOException{
		File image=new File("C:\\Users\\唐世昊\\Desktop\\临时文件\\image_test\\test.jpg");
		BufferedImage bi=ImageIO.read(image);
		bi.getRGB(bi.getWidth()-1, bi.getHeight()-1);
		bi.getRGB(bi.getHeight()-1, bi.getWidth()-1);
	}
}
