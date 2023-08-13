/**
Given an integer array nums that may contain duplicates, return all possible subsets(the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 1:
Input: nums = [0]
Output: [[],[0]]
**/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the input array to handle duplicates
        
        List<List<Integer>> ans = new ArrayList<>(); // List to store the final subsets
        List<Integer> temp = new ArrayList<>();      // Temporary list to build subsets
        
        helper(temp, 0, ans, nums, Integer.MIN_VALUE); // Call the helper function to generate subsets
        
        return ans; // Return the list of subsets
    }

    // Helper function to generate subsets using recursion and backtracking
    public void helper(List<Integer> temp, int i, List<List<Integer>> ans, int[] nums, int prevIgnored) {
        // Base case: if we have considered all elements of the nums array
        if (i == nums.length) {
            ans.add(new ArrayList(temp)); // Add the current subset to the final list of subsets
            return;
        }

        // Check if the current element is different from the previous ignored element
        if (nums[i] != prevIgnored) {
            temp.add(nums[i]); // Include the current element in the subset
            helper(temp, i+1, ans, nums, Integer.MIN_VALUE); // Recursively generate subsets with the current element
            
            temp.remove(temp.size()-1); // Backtrack: Exclude the current element from the subset
        }

        // Generate subsets without the current element by ignoring it
        helper(temp, i+1, ans, nums, nums[i]);
    }
}
