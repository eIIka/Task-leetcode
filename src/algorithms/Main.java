package algorithms;

import java.util.LinkedList;
import java.util.Stack;

enum Color {
  RED, BLACK
}

// Node Class
class Node<T extends Comparable<T>> {
  T data;
  Node<T> left;
  Node<T> right;
  Node<T> parent;
  Color color;

  // Constructor to create a new node
  Node(T data) {
    this.data = data;

    // New nodes are always red when inserted
    this.color = Color.RED;
    this.left = null;
    this.right = null;
    this.parent = null;
  }
}

class RedBlackTree<T extends Comparable<T>> {
  private Node<T> root;
  private final Node<T> TNULL; // Sentinel node for null references

  public RedBlackTree() {
    TNULL = new Node<>(null);
    TNULL.color = Color.BLACK;
    root = TNULL;
  }

  public void delete(T data) {
    Node<T> node = searchTree(data);
    if (node == TNULL) {
      System.out.println("Node not found in the tree.");
      return;
    }
    deleteNode(node);
    System.out.println("Deleted -> " + data);
    printTree();
  }

  private Node<T> searchTree(T data) {
    Node<T> current = root;
    while (current != TNULL && !current.data.equals(data)) {
      if (data.compareTo(current.data) < 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return current;
  }

  private void deleteNode(Node<T> z) {
    Node<T> x, y = z;
    Color originalColor = y.color;

    if (z.left == TNULL) {
      x = z.right;
      transplant(z, z.right);
    } else if (z.right == TNULL) {
      x = z.left;
      transplant(z, z.left);
    } else {
      y = minimum(z.right);
      originalColor = y.color;
      x = y.right;

      if (y.parent == z) {
        x.parent = y;
      } else {
        transplant(y, y.right);
        y.right = z.right;
        y.right.parent = y;
      }

      transplant(z, y);
      y.left = z.left;
      y.left.parent = y;
      y.color = z.color;
    }

    if (originalColor == Color.BLACK) {
      fixDelete(x);
    }
  }

  private void transplant(Node<T> u, Node<T> v) {
    if (u.parent == null) {
      root = v;
    } else if (u == u.parent.left) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    v.parent = u.parent;
  }

  private Node<T> minimum(Node<T> node) {
    while (node.left != TNULL) {
      node = node.left;
    }
    return node;
  }

  private void fixDelete(Node<T> x) {
    Node<T> sibling;
    while (x != root && x.color == Color.BLACK) {
      if (x == x.parent.left) {
        sibling = x.parent.right;

        if (sibling.color == Color.RED) {
          sibling.color = Color.BLACK;
          x.parent.color = Color.RED;
          leftRotate(x.parent);
          sibling = x.parent.right;
        }

        if (sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK) {
          sibling.color = Color.RED;
          x = x.parent;
        } else {
          if (sibling.right.color == Color.BLACK) {
            sibling.left.color = Color.BLACK;
            sibling.color = Color.RED;
            rightRotate(sibling);
            sibling = x.parent.right;
          }

          sibling.color = x.parent.color;
          x.parent.color = Color.BLACK;
          sibling.right.color = Color.BLACK;
          leftRotate(x.parent);
          x = root;
        }
      } else {
        sibling = x.parent.left;

        if (sibling.color == Color.RED) {
          sibling.color = Color.BLACK;
          x.parent.color = Color.RED;
          rightRotate(x.parent);
          sibling = x.parent.left;
        }

        if (sibling.left.color == Color.BLACK && sibling.right.color == Color.BLACK) {
          sibling.color = Color.RED;
          x = x.parent;
        } else {
          if (sibling.left.color == Color.BLACK) {
            sibling.right.color = Color.BLACK;
            sibling.color = Color.RED;
            leftRotate(sibling);
            sibling = x.parent.left;
          }

          sibling.color = x.parent.color;
          x.parent.color = Color.BLACK;
          sibling.left.color = Color.BLACK;
          rightRotate(x.parent);
          x = root;
        }
      }
    }
    x.color = Color.BLACK;
  }

  // Preorder traversal helper function
  private void preOrderHelper(Node<T> node) {
    if (node != TNULL) {
      System.out.print(node.data + " ");
      preOrderHelper(node.left);
      preOrderHelper(node.right);
    }
  }

  // Function to start preorder traversal
  public void preorder() {
    System.out.println("\nPreorder traversal:");
    preOrderHelper(this.root);
  }

  // Inorder traversal helper function
  private void inOrderHelper(Node<T> node) {
    if (node != TNULL) {
      inOrderHelper(node.left);
      System.out.print(node.data + " ");
      inOrderHelper(node.right);
    }
  }

  // Function to start inorder traversal
  public void inorder() {
    System.out.println("\n\nInorder traversal:");
    inOrderHelper(this.root);
  }

  // Postorder traversal helper function
  private void postOrderHelper(Node<T> node) {
    if (node != TNULL) {
      postOrderHelper(node.left);
      postOrderHelper(node.right);
      System.out.print(node.data + " ");
    }
  }

  // Function to start postorder traversal
  public void postorder() {
    System.out.println("\n\nPostorder traversal:");
    postOrderHelper(this.root);
  }

  // Function to perform left rotation
  private void leftRotate(Node<T> x) {
    Node<T> y = x.right;
    x.right = y.left;
    if (y.left != TNULL) {
      y.left.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }
    y.left = x;
    x.parent = y;
  }

  // Function to perform right rotation
  private void rightRotate(Node<T> x) {
    Node<T> y = x.left;
    x.left = y.right;
    if (y.right != TNULL) {
      y.right.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.right) {
      x.parent.right = y;
    } else {
      x.parent.left = y;
    }
    y.right = x;
    x.parent = y;
  }

  public void insert(T key) {
    Node<T> node = new Node<>(key);
    node.left = TNULL;
    node.right = TNULL;
    node.color = Color.RED;

    Node<T> y = null;
    Node<T> x = this.root;

    while (x != TNULL) {
      y = x;
      if (node.data.compareTo(x.data) < 0) {
        x = x.left;
      } else {
        x = x.right;
      }
    }

    node.parent = y;
    if (y == null) {
      root = node;
    } else if (node.data.compareTo(y.data) < 0) {
      y.left = node;
    } else {
      y.right = node;
    }

    if (node.parent == null) {
      node.color = Color.BLACK;
      printTree();
      return;
    }

    if (node.parent.parent == null) {
      printTree();
      return;
    }

    fixInsert(node);
    printTree();
  }

  private void fixInsert(Node<T> k) {
    Node<T> u;
    while (k.parent.color == Color.RED) {
      if (k.parent == k.parent.parent.right) {
        u = k.parent.parent.left;
        if (u.color == Color.RED) {
          u.color = Color.BLACK;
          k.parent.color = Color.BLACK;
          k.parent.parent.color = Color.RED;
          k = k.parent.parent;
        } else {
          if (k == k.parent.left) {
            k = k.parent;
            rightRotate(k);
          }
          k.parent.color = Color.BLACK;
          k.parent.parent.color = Color.RED;
          leftRotate(k.parent.parent);
        }
      } else {
        u = k.parent.parent.right;
        if (u.color == Color.RED) {
          u.color = Color.BLACK;
          k.parent.color = Color.BLACK;
          k.parent.parent.color = Color.RED;
          k = k.parent.parent;
        } else {
          if (k == k.parent.right) {
            k = k.parent;
            leftRotate(k);
          }
          k.parent.color = Color.BLACK;
          k.parent.parent.color = Color.RED;
          rightRotate(k.parent.parent);
        }
      }
      if (k == root) {
        break;
      }
    }
    root.color = Color.BLACK;
  }

  // DFS using stack (iterative approach)
  public void dfs() {
    if (root == TNULL) return;

    Stack<Node<T>> stack = new Stack<>();
    stack.push(root);

    System.out.println("\nDFS traversal (using stack, глибина):");
    while (!stack.isEmpty()) {
      Node<T> current = stack.pop();
      System.out.print(current.data + " ");

      // Додаємо правого нащадка першим, щоб лівий оброблявся першим
      if (current.right != TNULL) stack.push(current.right);
      if (current.left != TNULL) stack.push(current.left);
    }
    System.out.println();
  }

  // BFS using queue
  public void bfs() {
    if (root == TNULL) return;

    LinkedList<Node<T>> queue = new LinkedList<>();
    queue.add(root);

    System.out.println("\nBFS traversal (level order, ширина):");
    while (!queue.isEmpty()) {
      Node<T> current = queue.poll();
      System.out.print(current.data + " ");

      if (current.left != TNULL) queue.add(current.left);
      if (current.right != TNULL) queue.add(current.right);
    }
    System.out.println();
  }


  // Function to print the tree in the requested format
  public void printTree() {
    System.out.println("\nCurrent Tree:");
    printTreeHelper(this.root, "", true);
  }

  private void printTreeHelper(Node<T> node, String indent, boolean last) {
    if (node != TNULL) {
      System.out.print(indent);
      if (last) {
        System.out.print("R---- ");
        indent += "     ";
      } else {
        System.out.print("L---- ");
        indent += "|    ";
      }
      System.out.println(node.data + "(" + node.color + ")");
      printTreeHelper(node.left, indent, false);
      printTreeHelper(node.right, indent, true);
    }
  }
}

public class Main {
  public static void main(String[] args) {
    RedBlackTree<Integer> tree = new RedBlackTree<>();

    // Вставка вузлів
    tree.insert(47);
    tree.insert(50);
    tree.insert(61);
    tree.insert(41);
    tree.insert(53);
    tree.insert(12);
    tree.insert(68);
    tree.insert(63);
    tree.insert(3);


    // Виведення фінального дерева
    System.out.println("Final Tree:");
    tree.printTree();

    tree.inorder();
    tree.preorder();
    tree.postorder();

  }
}