/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

2 - "abc"
3 - "def"
4 - "ghi"
5 - "jkl"
6 - "mno"
7 - "pqrs"
8 - "tuv"
9 - "wxyz"

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
**/

class Solution {
    public List<String> letterCombinations(String digits) {
        // Create a HashMap to map digits to their corresponding character sets
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mon");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> ans = new ArrayList<>(); // List to store the final letter combinations
        StringBuilder str = new StringBuilder(); // StringBuilder to build combinations

        if (digits.length() == 0)
            return ans; // Return an empty list if the input string is empty

        helper(ans, map, digits, 0, str); // Call the helper function to generate letter combinations

        return ans; // Return the list of letter combinations
    }

    // Helper function to generate letter combinations using recursion
    public void helper(List<String> ans, HashMap<Integer, String> map, String digits, int idx, StringBuilder str) {
        // Base case: if we have processed all digits in the input string
        if (idx == digits.length()) {
            ans.add(str.toString()); // Add the current combination to the final list
            return;
        }

        int num = Integer.parseInt(String.valueOf(digits.charAt(idx))); // Convert the character digit to an integer
        String numStr = map.get(num); // Get the corresponding character set
        
        for (int i = 0; i < numStr.length(); i++) {
            str.append(numStr.charAt(i)); // Append the current character to the combination
            helper(ans, map, digits, idx + 1, str); // Recursively generate combinations for the next digit
            str.deleteCharAt(str.length() - 1); // Backtrack: Remove the last character from the combination
        }
    }
}
