
public class Node {
    private Node leftNode;
    private Node rightNode;
    private int info;

    public Node() {
    }

    public Node(int info) {
        this.info = info;
        this.leftNode = this.rightNode = null;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
    
    
    
}
