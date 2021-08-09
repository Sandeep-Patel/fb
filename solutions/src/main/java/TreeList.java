import java.util.ArrayList;
import java.util.List;

public class TreeList {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> output = new ArrayList<>();
            treeTraversal(output, root);
            return output;
        }

        private void treeTraversal(List<Integer> output, TreeNode root) {
            if(root == null) {
                return;
            }

            output.add(root.val);
            treeTraversal(output, root.left);
            treeTraversal(output, root.right);

        }
    }
}
