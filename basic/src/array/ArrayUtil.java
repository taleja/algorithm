package array;

public class ArrayUtil {

	public static int[] subArray(int[] array, int fromIndex, int toIndex) {
		int[] rv = new int[(toIndex - fromIndex) + 1];

		for(int i = 0; i < rv.length; i++){
			rv[i] = array[fromIndex + i];			
		}		
		return rv;
	}

	public static int[] copyArray(int[] source, int sourseIndex, int[] destination, int destinationIndex, int count) {
		
		for(int i = 0; i < destination.length; i++){			
			if(i >= destinationIndex && count != 0){								
				destination[i] = source[sourseIndex];				
				count--;
				sourseIndex++;
			 }
		}
		return destination;
	}
}
