class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, 2, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void helper(int n, int cur, List<Integer> temp, List<List<Integer>> result) {
        for (int i = cur; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                temp.add(i);
                List<Integer> copy = new ArrayList<>(temp);
                copy.add(n / i);
                result.add(copy);
                helper(n / i, i, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
}