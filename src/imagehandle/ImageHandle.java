package imagehandle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import edgedetect.First_orderDeri;

public class ImageHandle {
	private File image;
	private File newImage;
	private RGBMatrix rgbm;
	public void setImagePath(String inputPath,String outputPath){
		image=new File(inputPath);
		newImage=new File(outputPath);
	}
	public void imageTrans() throws IOException{
		BufferedImage input=ImageIO.read(image);
		System.out.println(input);
		RGBMatrix matrix=new RGBMatrix();
		matrix.setMc(new First_orderDeri());
		matrix.setImage(input);
		System.out.println(matrix.getImage());
		ImageIO.write(matrix.getImage(), "jpg",newImage);
	}
	public static void main(String[] args) throws IOException{
		ImageHandle ih=new ImageHandle();
		ih.setImagePath("C:\\Users\\唐世昊\\Desktop\\临时文件\\image_test\\4.jpg", "C:\\Users\\唐世昊\\Desktop\\临时文件\\image_test\\result31.jpg");
		ih.imageTrans();
	}
}
