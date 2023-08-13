/**
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
**/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store the final combinations
        List<Integer> temp = new ArrayList<>(); // Temporary list to build combinations

        helper(temp, 1, ans, k, n); // Call the helper function to generate combinations

        return ans; // Return the list of combinations
    }

    // Helper function to generate combinations using recursion and backtracking
    public void helper(List<Integer> temp, int i, List<List<Integer>> ans, int k, int n) {
        // Base case: if the temporary combination size is equal to k
        if (temp.size() == k) {
            ans.add(new ArrayList(temp)); // Add the current combination to the final list of combinations
            return;
        }

        // If we have exceeded the range of numbers from 1 to n
        if (i > n) {
            return;
        }

        temp.add(i); // Include the current number in the combination
        helper(temp, i+1, ans, k, n); // Recursively generate combinations with the next number

        temp.remove(temp.size()-1); // Backtrack: Exclude the current number from the combination
        helper(temp, i+1, ans, k, n); // Recursively generate combinations without the current number
    }
}
