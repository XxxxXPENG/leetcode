package tu;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visitedMap = new HashMap<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(node);
        visitedMap.put(node, new Node(node.val, new ArrayList<>()));
        while (!deque.isEmpty()) {
            Node removeNode = deque.remove();
            for (Node neighbor : removeNode.neighbors) {
                if (!visitedMap.containsKey(neighbor)) {
                    visitedMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    deque.add(neighbor);
                }
                visitedMap.get(removeNode).neighbors.add(visitedMap.get(neighbor));
            }
        }
        return visitedMap.get(node);
    }
}



class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}