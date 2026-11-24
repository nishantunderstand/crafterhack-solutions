import java.io.*;
import java.util.*;

class Node {
    int data;
    ArrayList<Node> children;

    Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

class Solution {
    public void traversals(Node root) {
        System.out.println("Node Pre "+root.data); // Euler Pre-Area

        for(Node child : root.children){
            System.out.println("Edge Pre "+root.data+"--"+child.data); // Edge Pre-Area
            traversals(child);
            System.out.println("Edge Post "+root.data+"--"+child.data); // Edge Post-Area
        }
        System.out.println("Node Post "+root.data); // Euler Post-Area
    }
}






























































































public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String[] arr = scn.nextLine().split(" ");
        Node root = construct(arr);

        Solution sol = new Solution();
        sol.traversals(root);
        
    }

    public static Node construct(String[] arr) {
        Node root = null;
        Stack<Node> stk = new Stack<>();

        for (String s : arr) {
            int val = Integer.parseInt(s);
            if (val != -1) {
                Node child = new Node(val);
                if (stk.isEmpty()) {
                    root = child;
                } else {
                    Node parent = stk.peek();
                    parent.children.add(child);
                }
                stk.push(child);
            } else {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            }
        }
        return root;
    }
}
