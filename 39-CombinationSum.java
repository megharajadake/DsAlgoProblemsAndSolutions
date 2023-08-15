/**
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to the target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to the target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
**/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();  // Initialize a list to store the final combinations
        List<Integer> temp = new ArrayList<>();       // Initialize a temporary list to store the current combination being processed
        
        // Start the recursive helper function to find combinations
        helper(temp, 0, ans, candidates, target);
        
        return ans;  // Return the list of combinations
    }

    public void helper(List<Integer> temp, int i, List<List<Integer>> ans, int[] candidates, int target) {
        // Base case: If the target becomes zero, add the current combination to the answer list
        if (target == 0) {
            ans.add(new ArrayList(temp));
            return;
        }

        // Base case: If the target becomes negative, return as this combination is invalid
        if (target < 0)
            return;

        // Base case: If we have considered all candidates, return
        if (i == candidates.length)
            return;
        
        // Include the current candidate in the temporary combination
        temp.add(candidates[i]);
        // Recursively call the helper function with the same candidate (i) and reduced target (target - candidates[i])
        helper(temp, i, ans, candidates, target - candidates[i]);
        
        // Backtrack: Remove the last added candidate to explore other possibilities
        temp.remove(temp.size() - 1);
        // Move to the next candidate and call the helper function with the updated index (i+1)
        helper(temp, i + 1, ans, candidates, target);
    }
}
