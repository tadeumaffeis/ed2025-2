
import java.io.UnsupportedEncodingException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Graph<String> g = new Graph<>();
        GraphAdjacencyMatrix<String> matrix = new GraphAdjacencyMatrix<>(6);

        g.addVertex("Zé");
        matrix.addVertex("Zé");
        g.addVertex("João");
        matrix.addVertex("João");
        g.addVertex("Maria");
        matrix.addVertex("Maria");
        g.addVertex("Carlos");
        matrix.addVertex("Carlos");
        g.addVertex("Ana");
        matrix.addVertex("Ana");
        g.addVertex("Paula");
        matrix.addVertex("Paula");
        
        g.addEdge("Zé", "João");
        g.addEdge("João", "Maria");
        g.addEdge("Maria", "Carlos");
        g.addEdge("Carlos", "Ana");
        g.addEdge("Ana", "Paula");
        g.addEdge("Paula", "João");
        g.addEdge("Ana", "João");
        g.addEdge("João", "Ana");
        
        matrix.setVertex("Zé", "João");
        matrix.setVertex("João", "Maria");
        matrix.setVertex("Maria", "Carlos");
        matrix.setVertex("Carlos", "Ana");
        matrix.setVertex("Ana", "Paula");
        matrix.setVertex("Paula", "João");
        matrix.setVertex("Ana", "João");
        matrix.setVertex("João", "Ana");
        
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        
        System.out.println("Lista de Adjacência:");
        g.printGraph();
        
        System.out.println("Matriz de Adjacência");
        matrix.printMatrix();
        matrix.printVertex();

        System.out.println();
        g.bfs("Zé");
    }
}

