package sizeEstimator;

/**
 * @author edvinmodigh
 * Subclass to Image
 */
public class Uncompressed extends Image{
	
	/**
	 * Constructor for Uncompressed
	 * @param width is inputed width
	 * @param height is inputed height
	 * @throws Exception
	 */
	Uncompressed(int width, int height) throws Exception {
		if (width < 1) {
			throw new Exception("width must be positive integer");
		}
		if (height < 1) {
			throw new Exception("height must be positive integer");
		}
		this.setType("Uncompressed");
		this.setWidth(width);
		this.setHeight(height);
		this.setSize(width * height);
		
		// Pyramid function calculates the pyramid sizes and adds them to this image´s total size
		pyramid();
	}

}
