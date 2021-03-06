package array;

import org.junit.Assert;
import org.junit.Test;

public class SubArrayTest {
	
	@Test
	public void test1(){		
		int[] array = {2, 0, 9, 55, 1};
		int[] actual = ArrayUtil.subArray(array, 1, 3);
		Assert.assertArrayEquals(new int[]{0, 9, 55}, actual);
	}
	
	@Test
	public void test2(){
		int[] array = {4, 6, 99, 0, 23, 444, 890, 21, 34}; 
		int[] actual = ArrayUtil.subArray(array, 1, 8);
		Assert.assertArrayEquals(new int[]{6, 99, 0, 23, 444, 890, 21, 34}, actual);
	}
	
	@Test
	public void test3(){
		int[] array = {4, 6}; 
		int[] actual = ArrayUtil.subArray(array, 0, 1);
		Assert.assertArrayEquals(new int[]{4, 6}, actual);
	}
	
	
	@Test
	public void test4(){
		int[] array = {4, 6, 99, 0, 23, 444, 890, 21, 34}; 
		int[] actual = ArrayUtil.subArray(array, 6, 8);
		Assert.assertArrayEquals(new int[]{890, 21, 34}, actual);
	}

	@Test
	public void test5(){
		int[] array = {4, 6, 3}; 
		int[] actual = ArrayUtil.subArray(array, 0, 1);
		Assert.assertArrayEquals(new int[]{4, 6}, actual);
	}
	
	@Test
	public void test6(){
		int[] array = {4, 6, 3}; 
		int[] actual = ArrayUtil.subArray(array, 0, 2);
		Assert.assertArrayEquals(new int[]{4, 6, 3}, actual);
	}
}
