package imagehandle;

import imagehandle.RGBMatrix.RGBelement;

public class MatixConv1 implements MatrixConv{
	private RGBelement[][] m;
	@Override
	public void setMatrix(RGBelement[][] m) {
		// TODO Auto-generated method stub
		this.m=m;
	}
	public void conversion() {
		// TODO Auto-generated method stub
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[i].length;j++){
				m[i][j].red=m[i][j].red/10;
				m[i][j].green=m[i][j].green/10;
				m[i][j].blue=m[i][j].blue/10;
			}
		}
	}

}
