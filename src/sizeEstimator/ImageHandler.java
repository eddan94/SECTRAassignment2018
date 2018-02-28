package sizeEstimator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author edvinmodigh
 * ImageHandler handles lists of images and groups
 * Also contains functions for making images of inputs
 * and grouping them
 */
public class ImageHandler {
	List<Image> imageList;
	List<Group> groupList;
	
	/**
	 * Constructor for ImageHandler
	 * Creates a list of Images and a list of groups
	 * both initially empty.
	 */
	ImageHandler(){
		imageList = new ArrayList<Image>();
		groupList = new ArrayList<Group>();
	}
	
	/**
	 * Checks validity of input and creates image of correct type
	 * @param st is input from console
	 * @throws Exception
	 */
	public void distribute(String[] st) throws Exception {
		
		String type = st[0];
		int width = 0;
		int height = 0;
		
		// Check if input width and height is integer
		try {
			width = Integer.parseInt(st[1]);
			height = Integer.parseInt(st[2]);
		} catch (NumberFormatException e){
			throw new Exception("Width or height not integer value");
		}
		
		// Sorts input into correct subclass
		if (type.matches("J") || type.matches("JPG")) {
			imageList.add(new JPEG(width, height));
		}
		
		else if (type.matches("JP2") || type.matches("JPEG2000")) {
			imageList.add(new JPEG2000(width, height));
		}
		
		else if (type.matches("BMP")) {
			imageList.add(new Uncompressed(width, height));
		}
		// If input matches no subclass, throw exception
		else {
			throw new Exception("Invalid type: " + type);
		}
		
	}
	
	/**
	 * @return total size, with groups and pyramids taken in consideration 
	 * 
	 */
	public int getSize() {
		int size = 0;
		
		// Add all images sizes not in a group to size
		for (Image image : imageList) {
			// If image is in a group, don't add its size
			if (image.getInGroup()) {
				continue;
			}
			size = size + image.getSize();
		}
		
		// add groups calculated sizes to size
		for (Group group : groupList) {
			size = size + group.size;
		}
		
		return size;
	}

	/**
	 * Groups inputed group indexes into a group
	 * Group size is calculated in group class upon creation of group
	 * @param part input from console
	 * @throws Exception
	 */
	public void group(String[] part) throws Exception {
		// Split line into objects, first one (index [0]) will be "G"
		
		List<Image> tempList = new ArrayList<Image>();
		
		// Iterate over inputed indices.
		// catch exceptions for invalid inputs
		for (int i = 1; i <= part.length-1; i++) {
			int p = 0;
			try {
				// Convert object to Integer
				p = Integer.parseInt(part[i])-1;
			} catch (NumberFormatException e) {
				throw new Exception(part[i] + " is not an integer");
			}
			
			// If p outbounds the list of images
			if (imageList.size() <= p ) {
				throw new Exception("No image on index " + (p+1) );
			}
			
			// If image p already exists in a group
			if (imageList.get(p).getInGroup()) {
				throw new Exception("Image " + (p+1) + " is already in a group");
			}
			
			// Put image in temporary list and set group-boolean to true
			tempList.add(imageList.get(p));
			imageList.get(p).setInGroup(true);
		}
		
		// Add grouped images from tempList to a new group 
		// and put the group in groupList
		groupList.add(new Group(tempList));
	}
}
