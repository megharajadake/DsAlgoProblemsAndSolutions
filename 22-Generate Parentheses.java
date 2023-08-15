/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
**/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();  // Initialize a list to store the generated balanced parentheses combinations
        String str = "";  // Initialize an empty string to build the current combination
        
        // Call the helper function to generate balanced parentheses combinations
        helper(str, 0, 0, n, ans);
        
        return ans;  // Return the list of generated combinations
    }

    public void helper(String str, int open, int close, int n, List<String> ans) {
        // Base case: If the length of the current combination is equal to 2*n, a balanced combination is formed
        if (str.length() == n * 2) {
            ans.add(str);  // Add the balanced combination to the answer list
            return;
        }

        // Recursive cases:

        // If the count of open parentheses is less than n, we can add an open parenthesis "("
        if (open < n)
            helper(str + "(", open + 1, close, n, ans);

        // If the count of close parentheses is less than the count of open parentheses,
        // we can add a close parenthesis ")"
        if (close < open)
            helper(str + ")", open, close + 1, n, ans);
    }
}
