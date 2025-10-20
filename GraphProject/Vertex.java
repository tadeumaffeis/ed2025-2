/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 */
public class Vertex<T> {
    private final T data;
    private final LinearList<Vertex<T>> adjacencyList;

    public Vertex(T data) {
        this.data = data;
        this.adjacencyList = new LinearList<>();
    }

    public T getData() {
        return data;
    }

    public LinearList<Vertex<T>> getAdjacencyList() {
        return adjacencyList;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

