public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeLinkNode cur = queue.poll();
            if (cur.left != null) {
                cur.left.next = cur.right;
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                queue.offer(cur.right);
            }
        }
    }
}