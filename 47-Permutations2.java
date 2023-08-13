/**
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:[[1,1,2],[1,2,1],[2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
**/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store the final unique permutations
        helper(ans, 0, nums); // Call the helper function to generate unique permutations
        return ans; // Return the list of unique permutations
    }

    // Helper function to generate unique permutations using recursion and backtracking
    public void helper(List<List<Integer>> ans, int pos, int[] nums) {
        // Base case: if we have reached the last element in the array
        if (pos == nums.length-1) {
            List<Integer> temp = new ArrayList<>();
            // Convert the array into a List and add it to the final list of unique permutations
            for (int i=0; i<nums.length; i++)
                temp.add(nums[i]);
            ans.add(temp);
            return;
        }

        HashSet<Integer> set = new HashSet<>(); // Create a HashSet to keep track of used elements

        // Generate unique permutations by swapping elements starting from the current position
        for (int i=pos; i<nums.length; i++) {
            if (set.contains(nums[i]))
                continue; // Skip if the current element has been used before

            set.add(nums[i]); // Mark the current element as used

            swap(pos, i, nums); // Swap elements to create a new unique permutation
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
