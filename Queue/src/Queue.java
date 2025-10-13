/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 * @param <T>
 */
public class Queue<T> {
    private final LinearList<T> list;

    public Queue() {
        this.list = new LinearList<>();
    }

    // Enfileirar (adiciona no fim)
    public void enqueue(T data) {
        list.append(new Node<>(data));
    }

    // Desenfileirar (remove do início)
    public T dequeue() {
        Node<T> removed = list.remove();
        if (removed == null) return null;
        return removed.getData();
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Retorna o primeiro elemento (sem remover)
    public T peek() {
        Node<T> head = list.getHead();
        return (head != null) ? head.getData() : null;
    }

    // Exibe todos os elementos da fila (opcional, útil para depuração)
    public void printQueue() {
        Node<T> current = list.getHead();
        System.out.print("Fila: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
