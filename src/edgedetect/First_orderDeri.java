package edgedetect;

import imagehandle.MatrixConv;
import imagehandle.RGBMatrix;
import imagehandle.RGBMatrix.RGBelement;

public class First_orderDeri implements MatrixConv{
	private RGBelement[][] m;
	@Override
	public void setMatrix(RGBelement[][] m) {
		// TODO Auto-generated method stub
		this.m=m;
	}

	@Override
	public RGBelement[][] conversion() {
		// TODO Auto-generated method stub
		//使用一阶偏导检测边缘
		RGBelement[][] newM=new RGBelement[this.m.length][this.m[0].length];
		for(int i=0;i<newM.length;i++){
			for(int j=0;j<newM[i].length;j++){
				if(i==0|j==0|i==newM.length-1|j==newM[i].length-1){
					RGBelement e=new RGBMatrix().new RGBelement(0,0,0);
					newM[i][j]=e;
				}else{
					int derivalue=deriValue(i,j);
					RGBelement e=new RGBMatrix().new RGBelement(derivalue,derivalue,derivalue);
					newM[i][j]=e;
				}
			}
		}
		return newM;
	}
	private int deriValue(int i,int j){
		int G1R=(m[i+1][j-1].red+m[i+1][j].red+m[i+1][j+1].red)-(m[i-1][j-1].red+m[i-1][j].red+m[i-1][j+1].red);
		int G1G=(m[i+1][j-1].green+m[i+1][j].green+m[i+1][j+1].green)-(m[i-1][j-1].green+m[i-1][j].green+m[i-1][j+1].green);
		int G1B=(m[i+1][j-1].blue+m[i+1][j].blue+m[i+1][j+1].blue)-(m[i-1][j-1].blue+m[i-1][j].blue+m[i-1][j+1].blue);
		int G1=(int)Math.sqrt(Math.pow(G1R, 2)+Math.pow(G1G, 2)+Math.pow(G1B, 2));
		int G2R=(m[i-1][j+1].red+m[i][j+1].red+m[i+1][j+1].red)-(m[i-1][j-1].red+m[i][j-1].red+m[i+1][j-1].red);
		int G2G=(m[i-1][j+1].green+m[i][j+1].green+m[i+1][j+1].green)-(m[i-1][j-1].green+m[i][j-1].green+m[i+1][j-1].green);
		int G2B=(m[i-1][j+1].blue+m[i][j+1].blue+m[i+1][j+1].blue)-(m[i-1][j-1].blue+m[i][j-1].blue+m[i+1][j-1].blue);
		int G2=(int)Math.sqrt(Math.pow(G2R, 2)+Math.pow(G2G, 2)+Math.pow(G2B, 2));
		return G1+G2;
	}
}
