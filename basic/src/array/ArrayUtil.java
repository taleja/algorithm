package array;

public class ArrayUtil {

	public static int[] subArray(int[] array, int k, int j) {
		int[] rv = new int[(j - k) + 1];
		
		if(k == 0){
			for(int i = 0; i < array.length; i++){
				rv[i] = array[i];				
			}
		} else{
			for(int i = k; i < array.length; i++){				
				if(i <= j){ 
					rv[i-k] = array[i];					
				}
			}		
		}
		
		return rv;
	}
}
