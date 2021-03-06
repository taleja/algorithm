package array;

import org.junit.Assert;
import org.junit.Test;

public class CopyArrayTest {
	
	@Test
	public void test1(){
		
		int[] array = new int []{1, 3, 4, 5, 6, 7};
		int[] dest = new int []{-1, -1, -1, -1, -1, -1, -1};
		int[] actual = ArrayUtil.copyArray(array, 1, dest, 2, 3);
		Assert.assertArrayEquals(new int[]{-1, -1, 3, 4, 5, -1, -1}, actual);
	}
	
	@Test
	public void test2(){
		
		int[] array = new int []{1, 3, 4};
		int[] dest = new int []{-1, -1, -1, -1, -1, -1, -1};
		int[] actual = ArrayUtil.copyArray(array, 0, dest, 0, 3);
		Assert.assertArrayEquals(new int[]{1, 3, 4, -1, -1, -1, -1}, actual);
	}
	
	@Test
	public void test3(){
		
		int[] array = new int []{1, 3, 4, 5, 6, 7};
		int[] dest = new int []{-1, -1, -1, -1, -1, -1, -1};
		int[] actual = ArrayUtil.copyArray(array, 4, dest, 5, 2);
		Assert.assertArrayEquals(new int[]{-1, -1, -1, -1, -1, 6, 7}, actual);
	}
	
	@Test
	public void test4(){
		
		int[] array = new int []{1, 3, 4, 5, 6, 7};
		int[] dest = new int []{-1, -1, -1, -1, -1, -1, -1};
		int[] actual = ArrayUtil.copyArray(array, 0, dest, 0, 6);
		Assert.assertArrayEquals(new int[]{1, 3, 4, 5, 6, 7, -1}, actual);
	}

	@Test
	public void test5(){
		
		int[] array = new int []{0, 0, 2, 5, 9, 0, 0};
		int[] dest = new int []{-1, -1, -1, -1, -1, -1, -1};
		int[] actual = ArrayUtil.copyArray(array, 2, dest, 4, 3);
		Assert.assertArrayEquals(new int[]{-1, -1, -1, -1, 2, 5, 9}, actual);
	}
}
