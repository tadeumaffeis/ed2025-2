import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

    public static void main(String[] args) {
        int v = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Binary Tree");
        BinaryTree btree = new BinaryTree();
        
        for (int i=0; i < 100; i++)
        {
            System.out.print("-> ");
            v = in.nextInt();
            if (v < 0)
            {
                break;
            }

            btree.add(new Node(v));
            btree.show();
        }
                
        btree.show();

        // System.out.print("Informe o valor: ");
        // int searched = in.nextInt();

        // String outSearched = btree.found(searched) ? " existe" : " não existe";
        // System.out.println("Valor: " + searched + " " + outSearched);

        btree.remove(10);
        btree.show();
        btree.remove(20);
        btree.show();

        // JFrame frame = new JFrame("Visualização da Árvore Binária 1");
        // BinaryTreeCanvas canvas = new BinaryTreeCanvas(btree.getRoot());
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(800, 600);
        // frame.add(canvas);
        // frame.setVisible(true);
    }
}
