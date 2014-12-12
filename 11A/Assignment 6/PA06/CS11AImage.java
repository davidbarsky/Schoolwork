import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class CS11AImage {

	public BufferedImage im = null; //don't modify this
	public int[] packedData = null; //don't modify this
	public int[][][] pixelData = null; //use this to modify the image
	public int height = 0; //read but do not set this
	public int width = 0; //read but do not set this

	//Constructor. This allows a program to initialize an instance of this class by using the 'new' keyword.
	public CS11AImage(BufferedImage image) {
		im = image;
		height = im.getHeight();
		width = im.getWidth();
		System.out.println(width);
		System.out.println(height);
		packedData = im.getRGB(0, 0, width, height, null, 0, width);
		unpackPixels();
	}

	public void flipHorizontal() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width/2; j++) { // Length
				int[][] temp = pixelData[width - i - 1];
				pixelData[width - i - 1] = pixelData[i];
        pixelData[i] = temp;
			}
		}

		System.out.println("Flipped Horizontally.");

	}

	public void flipVertical() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height/2; j++) { // Length
				int[][] temp = pixelData[width - i - 1];
				pixelData[width - i - 1] = pixelData[i];
        pixelData[i] = temp;
			}
		}

		System.out.println("Flipped Vertically.");

	}

	public void invert() {
		System.out.println("invert is not yet implemented");

		//Your code goes here.

		//System.out.println("Inverted.");

	}

	public void replaceColor(int[] oldColor, int[] newColor, int range) {
		System.out.println("replace is not yet implemented");

		//Your code goes here.

		//System.out.println("Replaced color");
	}


	//Writes the current data in pixelData to a .png image by first packing
	//the data into a 1D array of ints, then calling the write() method of
	//the ImageIO class.
	public boolean writeImage(File file) {
		//put pixelData into packedData
		packPixels();

		//Write new packed array back into BufferedImage
		//bi.setRGB(startX, startY, w, h, rgbArray, offset, scansize)
		im.setRGB(0, 0, width, height, packedData, 0, width);

		try{
			ImageIO.write(im, "png", file);
		} catch (IOException e) {
			System.out.println("Writing image failed.");
			return false;
		}
		return true;
	}


	//Uses bitwise operations to convert one integer into four channels,
	//each with a range from 0 to 255.
	public void unpackPixels() {
		System.out.println("Getting pixel values from packed data...");

		//This is a rows x columns array. That is, it is an array of rows.
		pixelData = new int[height][width][3];

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col ++) {
				pixelData[row][col][0] = (packedData[(row * width) + col] >> 16) & 0xff;
				pixelData[row][col][1] = (packedData[(row * width) + col] >> 8) & 0xff;
				pixelData[row][col][2] = (packedData[(row * width) + col]) & 0xff;
			}
		}
	}

	//Uses bitwise operations to convert four integer (ranging from 0 to 255)
	//into a single integer for use with the BufferedImage class.
	public void packPixels() {
		System.out.println("putting pixel values in packed format...");

		for (int row = 0; row < height; row ++) {
			for (int col = 0; col < width; col ++) {
				packedData[(row * width) + col] = ((255 & 0xFF) << 24) | //alpha
	            ((pixelData[row][col][0] & 0xFF) << 16) | //red
	            ((pixelData[row][col][1] & 0xFF) << 8)  | //green
	            ((pixelData[row][col][2] & 0xFF) << 0); //blue
			}
		}
	}
}
