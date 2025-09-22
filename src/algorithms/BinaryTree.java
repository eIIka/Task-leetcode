package algorithms;

import java.util.LinkedList;

// NodeBinaryTree Class
class NodeBinaryTree {
  int key;
  NodeBinaryTree left, right;

  public NodeBinaryTree(int item) {
    key = item;
    left = right = null;
  }
}

// BinaryTree Class
public class BinaryTree {
  NodeBinaryTree root;

  public BinaryTree() {
    root = null;
  }

  // Method to delete a node with given key
  public void delete(int key) {
    root = deleteRec(root, key);
    System.out.println("Deleted " + key);
    printTree();
  }

  private NodeBinaryTree deleteRec(NodeBinaryTree root, int key) {
    if (root == null) return root;

    if (key < root.key) {
      root.left = deleteRec(root.left, key);
    } else if (key > root.key) {
      root.right = deleteRec(root.right, key);
    } else {
      // Node with one child or no child
      if (root.left == null) return root.right;
      if (root.right == null) return root.left;

      // Node with two children: Get the inorder successor (smallest in the right subtree)
      root.key = minValue(root.right);

      // Delete the inorder successor
      root.right = deleteRec(root.right, root.key);
    }

    return root;
  }

  private int minValue(NodeBinaryTree root) {
    int minValue = root.key;
    while (root.left != null) {
      root = root.left;
      minValue = root.key;
    }
    return minValue;
  }

  // Method to insert a new node with given key
  public void insert(int key) {
    root = insertRec(root, key);
  }

  // A recursive function to insert a new key in BST
  private NodeBinaryTree insertRec(NodeBinaryTree root, int key) {
    if (root == null) {
      root = new NodeBinaryTree(key);
      return root;
    }
    if (key < root.key)
      root.left = insertRec(root.left, key);
    else if (key > root.key)
      root.right = insertRec(root.right, key);
    return root;
  }

  // Inorder traversal (LNR)
  public void inorderTraversal() {
    LinkedList<Integer> result = new LinkedList<>();
    inorderRec(root, result);
    System.out.println("\nInorder traversal:");
    result.forEach(key -> System.out.print(key + " "));
    System.out.println("\n");
  }

  // Helper method for inorder traversal
  private void inorderRec(NodeBinaryTree node, LinkedList<Integer> result) {
    if (node != null) {
      inorderRec(node.left, result);
      result.add(node.key);  // Add the node's key to the result
      inorderRec(node.right, result);
    }
  }

  // Preorder traversal (NLR)
  public void preorderTraversal() {
    LinkedList<Integer> result = new LinkedList<>();
    preorderRec(root, result);
    System.out.println("\nPreorder traversal:");
    result.forEach(key -> System.out.print(key + " "));
    System.out.println("\n");
  }

  // Helper method for preorder traversal
  private void preorderRec(NodeBinaryTree node, LinkedList<Integer> result) {
    if (node != null) {
      result.add(node.key);  // Add the node's key to the result
      preorderRec(node.left, result);
      preorderRec(node.right, result);
    }
  }

  // Postorder traversal (LRN)
  public void postorderTraversal() {
    LinkedList<Integer> result = new LinkedList<>();
    postorderRec(root, result);
    System.out.println("\nPostorder traversal:");
    result.forEach(key -> System.out.print(key + " "));
    System.out.println("\n");
  }

  // Helper method for postorder traversal
  private void postorderRec(NodeBinaryTree node, LinkedList<Integer> result) {
    if (node != null) {
      postorderRec(node.left, result);
      postorderRec(node.right, result);
      result.add(node.key);  // Add the node's key to the result
    }
  }

  // DFS using stack (iterative approach)
  public void dfs() {
    if (root == null) return;

    LinkedList<NodeBinaryTree> stack = new LinkedList<>();
    stack.push(root);

    System.out.println("\nDFS traversal (using stack  глибина):");
    while (!stack.isEmpty()) {
      NodeBinaryTree current = stack.pop();
      System.out.print(current.key + " ");

      // Додаємо правого нащадка першим, щоб лівий оброблявся першим
      if (current.right != null) stack.push(current.right);
      if (current.left != null) stack.push(current.left);
    }
    System.out.println("\n");
  }

  // BFS using queue
  public void bfs() {
    if (root == null) return;

    LinkedList<NodeBinaryTree> queue = new LinkedList<>();
    queue.add(root);

    System.out.println("\nBFS traversal (level order  ширина):");
    while (!queue.isEmpty()) {
      NodeBinaryTree current = queue.poll();
      System.out.print(current.key + " ");

      if (current.left != null) queue.add(current.left);
      if (current.right != null) queue.add(current.right);
    }
    System.out.println("\n");
  }

  // Method to print the tree structure
  public void printTree() {
    System.out.println("Поточне дерево:");
    printTreeRec(root, "", true);
    System.out.println();
  }

  private void printTreeRec(NodeBinaryTree node, String indent, boolean last) {
    if (node != null) {
      System.out.print(indent);
      if (last) {
        System.out.print("R---- ");
        indent += "     ";
      } else {
        System.out.print("L---- ");
        indent += "|    ";
      }
      System.out.println(node.key);
      printTreeRec(node.left, indent, false);
      printTreeRec(node.right, indent, true);
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    tree.insert(47);
    tree.insert(50);
    tree.insert(61);
    tree.insert(41);
    tree.insert(53);
    tree.insert(12);
    tree.insert(68);
    tree.insert(63);
    tree.insert(3);

    tree.printTree();

    tree.inorderTraversal();
    tree.preorderTraversal();
    tree.postorderTraversal();



  }
}
