package imagehandle;

import java.awt.image.BufferedImage;

public class RGBMatrix {
	BufferedImage bi;
	private RGBelement[][] m;
	private MatrixConv mc;
	public void setMc(MatrixConv mc){
		this.mc=mc;
	}
	public class RGBelement{
		public RGBelement(int r,int g,int b){
			this.red=r;
			this.green=g;
			this.blue=b;
		}
		public int red;
		public int green;
		public int blue;
	}
	public BufferedImage getImage(){
		return bi;
	}
	private int[] getRGB(int i,int j){
		int RGB=bi.getRGB(i, j);
		int R=(RGB&0xff0000)>>16;  
        int G=(RGB&0xff00)>>8;  
        int B=(RGB&0xff);
        int[] RGBresult=new int[3];
        RGBresult[0]=R;
        RGBresult[1]=G;
        RGBresult[2]=B;
        return RGBresult;
	}
	private void setRGB(int i,int j){
		int RGB=(bi.getRGB(i, j)&0xff000000)|((m[i][j].red&0xff)<<16)|((m[i][j].green&0xff)<<8)|(m[i][j].blue&0xff);
		bi.setRGB(i, j, RGB);
	}
	public void setImage(BufferedImage bi){
		this.bi=bi;
		m=new RGBelement[bi.getHeight()][bi.getWidth()];
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				int[] RGB=getRGB(i,j);
				RGBelement ele=new RGBelement(RGB[0],RGB[1],RGB[2]);
				m[i][j]=ele;
			}
		}
		//对矩阵m执行变换操作
		mc.setMatrix(m);
		mc.conversion();
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				setRGB(i,j);
			}
		}
	}
	public int getHeight(){
		return m.length;
	}
	public int getWidth(){
		return m[0].length;
	}
}
