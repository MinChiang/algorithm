import common.TreeNode;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-09 11:17
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcofOffer33 {

    public boolean verifyPostorder(int[] postorder) {
        // 二叉树后续遍历 左 | 右 | 根
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        return backtrack(root, postorder.length - 2, postorder, Integer.MIN_VALUE, root.val, root.val, Integer.MAX_VALUE);
    }

    public boolean backtrack(TreeNode treeNode, int index, int[] postorder, int leftBegin, int leftEnd, int rightBegin, int rightEnd) {
        if (index < 0) {
            return true;
        }
        // 先尝试放入右子树
        if (postorder[index] > rightBegin && postorder[index] < rightEnd) {
            treeNode.right = new TreeNode(postorder[index]);
            if (backtrack(treeNode.right, index - 1, postorder, treeNode.val, treeNode.right.val, treeNode.right.val, rightEnd)) {
                return true;
            }
            treeNode.right = null;
        }
        if (postorder[index] > leftBegin && postorder[index] < leftEnd) {
            treeNode.left = new TreeNode(postorder[index]);
            if (backtrack(treeNode.left, index - 1, postorder, leftBegin, treeNode.left.val, treeNode.left.val, treeNode.val)) {
                return true;
            }
            treeNode.left = null;
        }
        return false;
    }

    public static void main(String[] args) {
        ErChaSouSuoShuDeHouXuBianLiXuLieLcofOffer33 erChaSouSuoShuDeHouXuBianLiXuLieLcofOffer33 = new ErChaSouSuoShuDeHouXuBianLiXuLieLcofOffer33();
//        System.out.println(erChaSouSuoShuDeHouXuBianLiXuLieLcofOffer33.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(erChaSouSuoShuDeHouXuBianLiXuLieLcofOffer33.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

}
