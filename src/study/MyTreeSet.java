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

    // 중위 순회 -> tree 형태의 노드들이 어떻게 연결되었는지 그림을 그려보면 재귀호출이 무한 루프에 빠지지 않는다는 것을 알 수 있다.
    private void inOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, sb);
        // 왼쪽부터 값넣기 -> 그림을 그려보면 root를 기준으로 오른쪽으로 갈 때 각각의 TreeNode의 left는 null인 것을 알 수 있다.
        sb.append(node.element).append(" ");
        inOrderTraversal(node.right, sb);
        // 오른쪽으로 넘어가기 -> 그림을 그려보면 root를 기준으로 왼쪽으로 가는 각각의 TreeNode의 right는 null인 것을 알 수 있다.
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

