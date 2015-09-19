package array;

public class ArrayUtil {

	public static int[] subArray(int[] array, int fromIndex, int toIndex) {
		int[] rv = new int[(toIndex - fromIndex) + 1];

		for(int i = 0; i < rv.length; i++){
			rv[i] = array[fromIndex + i];			
		}		
		return rv;
	}
}
