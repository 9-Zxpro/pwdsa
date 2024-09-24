package leetcode;

import java.util.*;

public class Solution {
    List<Integer> resp = new ArrayList<>();
    int pivot = 0;

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        pivot = len / 3;
        quickSort(nums, 0, nums.length - 1);
        return resp;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (end - start < pivot) {
            return;
        }
        int left = start;
        int right = end;
        int i = start + 1;
        while (right >= i) {
            if (nums[left] > nums[i]) {
                swap(nums, left, i);
                i++;
                left++;
            } else if (nums[left] < nums[i]) {
                if (nums[i] > nums[right]) {
                    swap(nums, i, right);
                }
                right--;
            } else {
                i++;
            }
        }
        if (right - left >= pivot) {
            resp.get(nums[right]);
        }
        quickSort(nums, start, left - 1);
        quickSort(nums, right + 1, end);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int first(int[] a, int t) {
        int beg = 0, end = a.length-1, mid;
        int si=-1;
        while(beg < end) {
            mid = beg+(end-beg)/2;
            if(a[mid] == t) {
                si = mid;
            }
            else {
                end = mid-1;
            }
        }
        return si;
    }

    

    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        q.add(8);
        int[] val = {7, 5, 2};
        int right = (int) 10e9;
        Arrays.sort(val);
//        for (int v : val) {
//            System.out.print(v + " ");
//        }
//            int x = -2345777;
//            int ans = 0;
//         for(int place = 1; x/place != 0; place *= 10) {
//                 ans += (x/place)%10;
//        System.out.print(ans +" ");
//                 ans *= 10;
//
//         }
        System.out.print(right);
    }
}

