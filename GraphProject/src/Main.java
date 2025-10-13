
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

        g.addVertex("Zé");
        g.addVertex("João");
        g.addVertex("Maria");
        g.addVertex("Carlos");
        g.addVertex("Ana");
        g.addVertex("Paula");
        
        g.addEdge("Zé", "João");
        g.addEdge("João", "Maria");
        g.addEdge("Maria", "Carlos");
        g.addEdge("Carlos", "Ana");
        g.addEdge("Ana", "Paula");
        g.addEdge("Paula", "João");
        g.addEdge("Ana", "João");
        g.addEdge("João", "Ana");
        
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        
        System.out.println("Lista de Adjacência:");
        g.printGraph();

        System.out.println();
        g.bfs("Zé");
    }
}

