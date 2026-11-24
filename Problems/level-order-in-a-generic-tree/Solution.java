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
    public void levelOrder(Node root) {
        if(root==null) return;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){                                    
            Node node = que.poll();
            System.out.print(node.data+" ");
            for(Node child : node.children){
                que.offer(child);
            }                                    
        }
        System.out.print(".");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String[] arr = scn.nextLine().split(" ");
        Node root = construct(arr);

        Solution sol = new Solution();
        sol.levelOrder(root);
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
