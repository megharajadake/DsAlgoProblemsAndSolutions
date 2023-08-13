/**
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
**/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store the final permutations
        helper(ans, 0, nums); // Call the helper function to generate permutations
        return ans; // Return the list of permutations
    }

    // Helper function to generate permutations using recursion and backtracking
    public void helper(List<List<Integer>> ans, int pos, int[] nums) {
        // Base case: if we have reached the last element in the array
        if (pos == nums.length-1) {
            List<Integer> temp = new ArrayList<>();
            // Convert the array into a List and add it to the final list of permutations
            for (int i=0; i<nums.length; i++)
                temp.add(nums[i]);
            ans.add(temp);
            return;
        }

        // Generate permutations by swapping elements starting from the current position
        for (int i=pos; i<nums.length; i++) {
            swap(pos, i, nums); // Swap elements to create a new permutation
            helper(ans, pos+1, nums); // Recursively generate permutations with the next position
            swap(pos, i, nums); // Backtrack by swapping elements back to the original order
        }
    }

    // Function to swap two elements in an array
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
