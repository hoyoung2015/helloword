package net.hoyoung.leetcode.two_sum;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * @author v_huyang01
 *
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {

		return nums;

	}

	public void quicksort(int[] nums, int low, int high) {
		if (nums == null || nums.length == 0 || low >= high)
			return;

		int pivot = nums[low];

		int left = low;

		int right = high;
		while (left < right) {
			while (left <= right && nums[left] < pivot) {
				left++;
			}
			while (left <= right && nums[right] >= pivot) {
				right--;
			}
			if(left < right){
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}
		quicksort(nums,low,right);
		quicksort(nums,right+1,high);
	}

	public static void main(String[] args) {
		int arr[] = new int[]{6, 1,2,3,4,5,6,9,7,6,8};
		new Solution().quicksort(arr, 0, 10);
		for(int val : arr){
			System.out.print(val+" ");
		}
		
	}
}