/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */
class Solution {
    public boolean exist_1(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;
        boolean result = false;
        boolean used[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = recursion(board, word, 0, i, j, used);

                    if (result)
                        return true;
                }
            }
        }
        return result;
    }

    public boolean recursion(char[][] board, String word, int index, int hang, int lie, boolean[][] used) {
        if (hang < 0 || hang >= board.length || lie < 0 || lie >= board[0].length)
            return false;
        if (used[hang][lie])
            return false;
        if (board[hang][lie] != word.charAt(index))
            return false;

        if (index == word.length() - 1)
            return true;

        used[hang][lie] = true;

        boolean result = recursion(board, word, index + 1, hang + 1, lie, used)
                || recursion(board, word, index + 1, hang, lie + 1, used)
                || recursion(board, word, index + 1, hang - 1, lie, used)
                || recursion(board, word, index + 1, hang, lie - 1, used);
        if (!result) {
            used[hang][lie] = false;
            return false;
        }

        return true;
    }

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
            || exist(board, y, x-1, word, i+1)
            || exist(board, y+1, x, word, i+1)
            || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
}
