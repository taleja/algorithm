package mathematicalalgorithms;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(computeFactorial(6));
	}
	
	public static int computeFactorial(int value){
	    if(value == 0){
	    	return 1;
	    } else { 
	    	return value * computeFactorial(value - 1);	    
	    }
	}    
}
