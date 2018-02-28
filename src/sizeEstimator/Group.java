package sizeEstimator;
import java.util.List;


/**
 * @author edvinmodigh
 * Contains a list of images and a total group size in bytes
 * Group size is calculated on creation
 */
public class Group {
	Integer size;
	List<Image> list;
	
	/**
	 * Constructor for Group
	 * @param list is list of images that will be put in this group
	 */
	Group(List<Image> list) {
		this.size = 0;
		this.list = list;
		
		//Calculate total storage size of images in group
		for (int i = 0; i < list.size(); i++) {
			this.size = this.size + list.get(i).getSize();
		}
		
		// Calculate group size with given formula
		this.size = (int) (this.size / Math.log(this.list.size()+3));
	}
}
