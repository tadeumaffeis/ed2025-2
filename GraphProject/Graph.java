
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 */
public class Graph<T> {
    private LinearList<Vertex<T>> vertices;

    public Graph() {
        this.vertices = new LinearList<>();
    }

    /*
     * Adiciona um novo vértice ao grafo
     */
    public void addVertex(T data) {
        if (getVertex(data) != null) {
            System.out.println("Vértice " + data + " já existe.");
            return;
        }
        vertices.append(new Node<>(new Vertex<>(data)));
    }

    /*
     * Adiciona uma aresta (ligação) entre dois vértices
     * O grafo é não direcionado, então adiciona nos dois sentidos.
     */
    public void addEdge(T from, T to) {
        Vertex<T> v1 = getVertex(from);
        Vertex<T> v2 = getVertex(to);

        if (v1 == null || v2 == null) {
            System.out.println("Um dos vértices não existe.");
            return;
        }

        // Adiciona a conexão nos dois lados (não direcionado)
        v1.getAdjacencyList().append(new Node<>(v2));
        v2.getAdjacencyList().append(new Node<>(v1));
    }

    /*
     * Busca um vértice pelo seu valor
     */
    public Vertex<T> getVertex(T data) {
        Node<Vertex<T>> current = vertices.getHead();
        while (current != null) {
            if (current.getData().getData().equals(data)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    /*
     * Imprime o grafo completo (lista de adjacência)
     */
    public void printGraph() {
        Node<Vertex<T>> current = vertices.getHead();

        while (current != null) {
            Vertex<T> vertex = current.getData();
            System.out.print(vertex + " -> ");
            Node<Vertex<T>> adjNode = vertex.getAdjacencyList().getHead();

            while (adjNode != null) {
                System.out.print(adjNode.getData() + " ");
                adjNode = adjNode.getNext();
            }

            System.out.println();
            current = current.getNext();
        }
    }

    /*
     * Exemplo de busca em largura (BFS)
     * para encontrar todos os vértices alcançáveis a partir de um vértice inicial.
     */
    public void bfs(T start) {
        Vertex<T> startVertex = getVertex(start);
        if (startVertex == null) {
            System.out.println("Vértice inicial não encontrado.");
            return;
        }

        Set<T> visitados = new HashSet<>();
        Queue<Vertex<T>> fila = new LinkedList<>();

        fila.add(startVertex);
        visitados.add(start);

        System.out.print("BFS a partir de " + start + ": ");

        while (!fila.isEmpty()) {
            Vertex<T> atual = fila.poll();
            System.out.print(atual.getData() + " ");

            Node<Vertex<T>> adj = atual.getAdjacencyList().getHead();
            while (adj != null) {
                Vertex<T> vizinho = adj.getData();
                if (!visitados.contains(vizinho.getData())) {
                    fila.add(vizinho);
                    visitados.add(vizinho.getData());
                }
                adj = adj.getNext();
            }
        }
        System.out.println();
    }
}
