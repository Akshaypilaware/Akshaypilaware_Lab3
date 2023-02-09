class Node {
    int value;
    Node left;
    Node right;
  
    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  
  class BST {
    Node root;
  
    public BST() {
      this.root = null;
    }
  
    public void insert(int value) {
      if (root == null) {
        root = new Node(value);
        return;
      }
  
      Node current = root;
      while (true) {
        if (value < current.value) {
          if (current.left == null) {
            current.left = new Node(value);
            break;
          } else {
            current = current.left;
          }
        } else {
          if (current.right == null) {
            current.right = new Node(value);
            break;
          } else {
            current = current.right;
          }
        }
      }
    }
  
    public boolean findPairWithSum(int sum) {
      return findPairWithSum(root, sum);
    }
  
    private boolean findPairWithSum(Node node, int sum) {
      if (node == null) {
        return false;
      }
  
      int diff = sum - node.value;
  
      if (diff < 0) {
        return findPairWithSum(node.left, sum);
      }
  
      if (diff > 0) {
        return findPairWithSum(node.right, sum);
      }
  
      return true;
    }
  }
  
  public class BSTSum {
    public static void main(String[] args) {
      BST bst = new BST();
      bst.insert(40);
      bst.insert(20);
      bst.insert(60);
      bst.insert(10);
      bst.insert(30);
      bst.insert(50);
      bst.insert(70);
  
      int sum = 130;
      if (bst.findPairWithSum(sum)) {
        System.out.println("Pair is present with sum " + sum);
      } else {
        System.out.println("Pair is not present with sum " + sum);
      }
    }
  }
  
