/**
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
**/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store the final subsets
        List<Integer> temp = new ArrayList<>();      // Temporary list to build subsets
        
        helper(temp, 0, ans, nums); // Call the helper function to generate subsets
        
        return ans; // Return the list of subsets
    }

    // Helper function to generate subsets using recursion and backtracking
    public void helper(List<Integer> temp, int i, List<List<Integer>> ans, int[] nums) {
        // Base case: if we have considered all elements of the nums array
        if (i == nums.length) {
            ans.add(new ArrayList(temp)); // Add the current subset to the final list of subsets
            return;
        }

        // Include the current element (nums[i]) in the subset
        temp.add(nums[i]);
        helper(temp, i+1, ans, nums); // Recursively generate subsets with the current element

        // Backtrack: Exclude the current element from the subset
        temp.remove(temp.size()-1);
        helper(temp, i+1, ans, nums); // Recursively generate subsets without the current element
    }
}
