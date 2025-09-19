import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Binary Tree");
        BinaryTree btree = new BinaryTree();
        
        for (int i=0; i < 15; i++)
        {
            System.out.print("-> ");
            btree.add(new Node(in.nextInt()));
            btree.show();
        }
                
        btree.show();

        System.out.print("Informe o valor: ");
        int searched = in.nextInt();

        String outSearched = btree.found(searched) ? " existe" : " não existe";
        System.out.println("Valor: " + searched + " " + outSearched);

        JFrame frame = new JFrame("Visualização da Árvore Binária");
        BinaryTreeCanvas canvas = new BinaryTreeCanvas(btree.getRoot());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(canvas);
        frame.setVisible(true);
    }
}
