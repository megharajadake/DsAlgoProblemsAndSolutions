/**
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
**/


class Solution {
    public boolean exist(char[][] board, String word) {
        // Iterate through each cell in the board
        for (int rowCnt = 0; rowCnt < board.length; rowCnt++) {
            for (int colCnt = 0; colCnt < board[0].length; colCnt++) {
                // Start the helper function from the current cell
                if (helper(rowCnt, colCnt, board, word, 0)) {
                    return true; // If the word is found, return true
                }
            }
        }
        return false; // If word is not found in any cell, return false
    }

    public boolean helper(int rowCnt, int colCnt, char[][] board, String word, int charCnt) {
        // Base case: If all characters of the word have been matched, return true
        if (charCnt == word.length()) {
            return true;
        }

        // Bounds checking: Check if the current cell is within the board's bounds
        if (rowCnt < 0 || rowCnt >= board.length || colCnt < 0 || colCnt >= board[0].length) {
            return false;
        }

        // Check if the current cell's character matches the corresponding character in the word
        if (board[rowCnt][colCnt] != word.charAt(charCnt)) {
            return false;
        }

        // Store the current cell value, and mark it as visited by changing to ' '
        char temp = board[rowCnt][colCnt];
        board[rowCnt][colCnt] = ' ';

        // Recursively search for the remaining characters of the word in adjacent cells
        boolean found =
            helper(rowCnt + 1, colCnt, board, word, charCnt + 1) ||
            helper(rowCnt - 1, colCnt, board, word, charCnt + 1) ||
            helper(rowCnt, colCnt + 1, board, word, charCnt + 1) ||
            helper(rowCnt, colCnt - 1, board, word, charCnt + 1);

        // Restore the original cell value
        board[rowCnt][colCnt] = temp;

        return found; // Return whether the word was found in adjacent cells
    }
}
