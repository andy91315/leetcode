public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < height.length; i++) {
            if (matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestRectangleArea(height);
        for (int i = 1; i < matrix.length; i++) {
            resetheight(height, matrix, i);
            result = Math.max(result, largestRectangleArea(height));
        }
        return result;
    }
    
    public void resetheight(int[] height, char[][] matrix, int row) {
        for (int i = 0; i < height.length; i++) {
            if (matrix[row][i] == '1') {
                height[i]++;
            } else {
                height[i] = 0;
            }
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        while (i <= heights.length) {
            int h = (i == heights.length) ? 0 : heights[i];
           
            while(!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
            i++;
        }
        return max;
    }
}