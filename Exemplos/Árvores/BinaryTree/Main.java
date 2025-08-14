import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Binary Tree");
        BinaryTree btree = new BinaryTree();
        
        for (int i=0; i < 7; i++)
        {
            System.out.print("-> ");
            btree.add(btree.getRoot(), new Node(in.nextInt()));
        }
                
        btree.show();
    }
}
