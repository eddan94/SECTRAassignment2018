package sizeEstimator;

/**
 * @author edvinmodigh
 * Class Image is superclass to JPEG, JPEG2000 and Uncompressed
 */
public class Image {
		private String type;
		private Integer width;
		private Integer height;
		private Integer size;
		private Boolean inGroup = false;
		
		/**
		 * Adds pyramid sizes to the full image size
		 * Minimum size is set to 128
		 * Function is called from JPEG and Uncompressed
		 */
		protected void pyramid() {
			int smallest;
			// Find the smallest of width/height
			if (this.getWidth() < this.getHeight()) {
				smallest = this.getWidth();
			} else {
				smallest = this.getHeight();
			}
			// Add 1/4 of the last level size iteratively until limit is reached.
			// I can use 1/4 instead of doing the full calculation as the formula for 
			// calculating size is linear for both JPEG and Uncompressed.
			int levelSize = this.getSize();
			while (smallest >= 128*2) {
				smallest = smallest/2;
				levelSize = levelSize/4;
				this.setSize(this.getSize() + levelSize);
			}
		}

		// Below are getter and setters for the parameters in Image
		
		/**
		 * @return true if image is in a group
		 */
		public Boolean getInGroup() {
			return inGroup;
		}


		/**
		 * @param bol is boolean value that sets inGroup
		 */
		public void setInGroup(Boolean bol) {
			this.inGroup = bol;
		}


		/**
		 * @return calculated size of the image
		 */
		public Integer getSize() {
			return size;
		}


		/**
		 * @param size sets image size
		 */
		public void setSize(Integer size) {
			this.size = size;
		}


		/**
		 * @return type of image
		 * JPEG, JPEG2000 or Uncompressed
		 */
		public String getType() {
			return type;
		}


		/**
		 * @param type sets type of image
		 */
		public void setType(String type) {
			this.type = type;
		}


		/**
		 * @return width of image in pixels
		 */
		public Integer getWidth() {
			return width;
		}


		/**
		 * @param width sets width of image in pixels
		 */
		public void setWidth(Integer width) {
			this.width = width;
		}


		/**
		 * @return height of image in pixels
		 */
		public Integer getHeight() {
			return height;
		}

		
		/**
		 * @param height sets height of image in pixels
		 */
		public void setHeight(Integer height) {
			this.height = height;
		}
}

