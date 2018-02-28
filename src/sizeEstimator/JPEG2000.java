package sizeEstimator;

/**
 * @author edvinmodigh
 * Subclass to Image
 */
public class JPEG2000 extends Image{
	
	/**
	 * Constructor for JPEG2000
	 * @param width is inputed width
	 * @param height is inputed height
	 * @throws Exception
	 */
	JPEG2000(int width, int height) throws Exception {
		if (width < 1) {
			throw new Exception("width must be positive integer");
		}
		if (height < 1) {
			throw new Exception("height must be positive integer");
		}
		this.setType("JPEG2000");
		this.setWidth(width);
		this.setHeight(height);
		this.setSize((int) ((width * height * 0.4 ) / Math.log(Math.log(width * height + 16.0))));
	}
}
