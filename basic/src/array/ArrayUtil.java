package array;

import java.util.HashSet;
import java.util.Map;

public class ArrayUtil {

	public static int[] subArray(int[] array, int fromIndex, int toIndex) {
		int[] rv = new int[(toIndex - fromIndex) + 1];

		for(int i = 0; i < rv.length; i++){
			rv[i] = array[fromIndex + i];			
		}		
		return rv;
	}

	public static int[] copyArray(int[] source, int sourceIndex, int[] destination, int destinationIndex, int count) {

		for(int i = sourceIndex; i < sourceIndex + count; i++){										
			destination[destinationIndex] = source[i];				
			destinationIndex++;
		}
		return destination;
	}
}
