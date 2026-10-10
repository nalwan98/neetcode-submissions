
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return cloneGraph1(node, map);
    }

    public Node cloneGraph1(Node node, Map<Node, Node> map) {

        // FIX 1: Handle null input
        if (node == null) {
            return null;
        }

        // FIX 2: Stop if already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // FIX 3: Create clone and save immediately
        Node cur = new Node(node.val);
        map.put(node, cur);

        // FIX 4: Recursively clone neighbors
        for (Node i : node.neighbors) {
            cur.neighbors.add(cloneGraph1(i, map));
        }

        return cur;
    }
}
