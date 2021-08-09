import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TreeListLevelOrderTraversal {


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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        if(root == null) {
            return output;
        }

        subList.add(root.val);
        output.add(subList);

        output.addAll(getLR(root));


        return output;
    }

    public static Collection<? extends List<Integer>> getLR(TreeNode node) {
        List<Integer> subList = new ArrayList<>();
        if(node.left != null) {
            subList.add(node.left.val);
        }
        if(node.right != null) {
            subList.add(node.right.val);
        }

        return Collections.singleton(subList);
    }

}
