package study;

import com.sun.source.tree.Tree;

import java.util.Objects;

public class MyTreeSet {

        private TreeNode root;
        private int size;

    public TreeNode getRoot() {
        return root;
    }

    public MyTreeSet() {
        root = null;
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString();
    }

    private void inOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, sb); // 재귀함수로 제일 왼쪽으로 이동
        sb.append(node.element).append(" "); // 왼쪽부터 값넣기
        inOrderTraversal(node.right, sb); // 오른쪽으로 넘어가기
    }

    public void add(int element) {
        root = add(root, element); // 새로 update 될 때마다 renewal
    }

    public int getSize() {
        return size;
    }

    private TreeNode add(TreeNode node, int element) { // node params는 root 이다.
        if (node == null) {
            size++;
            return new TreeNode(element); // 해당 TreeNode가 비어있을 때 까지
        }
        if (element < node.element) {
            node.left = add(node.left, element); // 재귀함수 이용 -> left가 null이 나올 때 까지
        } else if (element > node.element) {
            node.right = add(node.right, element); // 재귀함수 이용 -> right가 null이 나올 때까지
        }
        return node; // 중복되는 것은 추가되는 기능 없이 그대로 반환 됨
    }
}


class TreeNode{
    TreeNode left;
    int element;
    TreeNode right;

    public TreeNode(int element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}

