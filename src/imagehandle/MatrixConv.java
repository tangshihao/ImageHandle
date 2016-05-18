package imagehandle;

import imagehandle.RGBMatrix.RGBelement;

public interface MatrixConv {
	public void setMatrix(RGBelement[][] m);
	public RGBelement[][] conversion();
}
