package imagehandle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

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
		RGBMatrix matrix=new RGBMatrix();
		matrix.setMc(new MatixConv1());
		matrix.setImage(input);
		ImageIO.write(matrix.getImage(), "jpg",newImage);
	}
	public static void main(String[] args) throws IOException{
		ImageHandle ih=new ImageHandle();
		ih.setImagePath("C:\\Users\\Ã∆ ¿Íª\\Desktop\\test.jpg", "C:\\Users\\Ã∆ ¿Íª\\Desktop\\result.jpg");
		ih.imageTrans();
	}
}
