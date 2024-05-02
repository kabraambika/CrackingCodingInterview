//The function visits each node in the tree exactly once,
// so the time complexity is O(N), where N is the total number of nodes in the tree.

//The space complexity is determined by the maximum depth of the recursion stack.
// In the worst case, when the tree is skewed and resembles a linked list,
// the space complexity would be O(H), where H is the height of the tree.
// However, in a balanced tree, the space complexity would be O(log N).
public class SalesPath {
    static class Node {
      int cost;
      Node[] children;
      Node parent;

      Node(int cost) {
        this.cost = cost;
        children = null;
        parent = null;
      }
    }

    int getCheapestCost(Node rootNode) {
      //We first check if the rootNode is null.
      // If it is, we return 0 since there is no cost associated with an empty tree.
      if (rootNode == null) {
        return 0;
      }

      //If the rootNode has no children (i.e., children is null or has a length of 0),
      // we return its cost since it represents the end of a Sales Path.
      if (rootNode.children == null || rootNode.children.length == 0) {
        return rootNode.cost;
      }

      //If the rootNode has children, we initialize a variable minCost to Integer.MAX_VALUE.
      // This variable will keep track of the minimal cost among all the children.
      int minCost = Integer.MAX_VALUE;

      //We iterate over each child of the rootNode using a for-each loop and recursively call the getCheapestCost method on each child.
      // This will give us the minimal cost for each subtree rooted at the child nodes.
      for (Node child : rootNode.children) {
        //We update the minCost variable by taking the minimum value between the current minCost
        // and the cost of each child subtree using Math.min().
        int childCost = getCheapestCost(child);
        minCost = Math.min(minCost, childCost);
      }

      //Finally, we return the sum of the rootNode's cost
      // and the minimal cost among its children.
      return rootNode.cost + minCost;
  }

  public static void main(String[] args) {
    // Create the tree nodes
    Node root = new Node(0);
    Node node1 = new Node(5);
    Node node2 = new Node(3);
    Node node3 = new Node(6);
    root.children = new Node[]{node1, node2, node3}; //0 -> 5,3,6
    node1.parent = root;
    node2.parent = root;
    node3.parent = root;

    Node node4 = new Node(4);
    node1.children = new Node[]{node4}; // 5-> 4
    node4.parent = node1;

    Node node5 = new Node(2);
    Node node6 = new Node(0);

    node2.children = new Node[]{node5, node6}; //3 -> 2, 0
    node5.parent = node2;
    node6.parent = node2;

    Node node7 = new Node(1);
    Node node8 = new Node(5);

    node3.children = new Node[]{node7, node8}; //6 -> 1,5
    node7.parent = node3;
    node8.parent = node3;

    Node node9 = new Node(1);
    node5.children = new Node[]{node9}; // 2->1
    node9.parent = node5;

    Node node10 = new Node(1);
    node9.children = new Node[]{node10}; //1->1
    node10.parent = node9;

    Node node11 = new Node(10);
    node6.children = new Node[]{node11}; //0 -> 10
    node11.parent = node6;

    // Create an instance of the SalesPath class
    SalesPath salesPath = new SalesPath();

    // Call the getCheapestCost method and print the result
    int minCost = salesPath.getCheapestCost(root);
    System.out.println("Minimum Sales Path Cost: " + minCost);
  }
}


