

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        if (n == 0 || k == 0 || n < k)
            return result;
        List<Integer> temp = new ArrayList<>();
        recursion(result, temp, 1, n, k);
        return result;
    }

    public void recursion(List<List<Integer>> result, List<Integer> temp, int index, int n, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList(temp));
            return;
        }
        for (int i = index; i <= (n - (k - temp.size()) + 1); i++) {
            temp.add(i);
            recursion(result, temp, i + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}
