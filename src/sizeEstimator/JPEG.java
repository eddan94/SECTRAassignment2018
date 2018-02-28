package sizeEstimator;

/**
 * @author edvinmodigh
 * Subclass to Image
 */
public class JPEG extends Image{
	
	/**
	 * Constructor for JPEG
	 * @param width is inputed width
	 * @param height is inputed height
	 * @throws Exception
	 */
	JPEG(int width, int height) throws Exception {
		if (width < 1) {
			throw new Exception("width must be positive integer");
		}
		if (height < 1) {
			throw new Exception("height must be positive integer");
		}
		this.setType("JPEG");
		this.setWidth(width);
		this.setHeight(height);
		this.setSize((int) (this.getWidth() * this.getHeight() * 0.2));
		
		// Pyramid function calculates the pyramid sizes and adds them to this image´s total size
		pyramid();

	}
}
	
	
