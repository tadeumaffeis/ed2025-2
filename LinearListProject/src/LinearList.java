/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 */
public class LinearList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinearList() {
        this.head = this.tail = null;
    }

    /*
     * Inserir no início da lista
     */
    public void insert(Node<T> node) {
        if (isEmpty()) {
            this.head = this.tail = node;
            return;
        }

        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
    }

    /*
     * Inserir no final da lista
     */
    public void append(Node<T> node) {
        if (isEmpty()) {
            this.head = this.tail = node;
            return;
        }

        this.tail.setNext(node);
        node.setPrev(this.tail);
        this.tail = node;
    }

    /*
     * Inserir em uma posição específica (posição 0 = início)
     */
    public void insertAt(int position, Node<T> node) {
        if (position <= 0 || isEmpty()) {
            insert(node);
            return;
        }

        Node<T> aux = this.head;
        int index = 0;

        // Percorre até a posição anterior ou até o fim
        while (aux.getNext() != null && index < position - 1) {
            aux = aux.getNext();
            index++;
        }

        // Se chegou ao final, insere no fim
        if (aux.getNext() == null) {
            append(node);
            return;
        }

        Node<T> proximo = aux.getNext();
        aux.setNext(node);
        node.setPrev(aux);
        node.setNext(proximo);
        proximo.setPrev(node);
    }

    /*
     * Remover o primeiro nó
     */
    public Node<T> remove() {
        if (isEmpty()) return null;

        Node<T> aux = this.head;

        // Se só tem um elemento
        if (aux.getNext() == null) {
            this.head = this.tail = null;
            return aux;
        }

        this.head = aux.getNext();
        this.head.setPrev(null);
        aux.setNext(null);

        return aux;
    }

    /*
     * Remover o último nó
     */
    public Node<T> pop() {
        if (isEmpty()) return null;

        Node<T> aux = this.tail;

        // Se só tem um elemento
        if (aux.getPrev() == null) {
            this.head = this.tail = null;
            return aux;
        }

        this.tail = aux.getPrev();
        this.tail.setNext(null);
        aux.setPrev(null);

        return aux;
    }

    /*
     * Remover um nó em uma posição específica
     */
    public Node<T> removeAt(int position) {
        if (isEmpty()) return null;
        if (position <= 0) return remove();

        Node<T> aux = this.head;
        int index = 0;

        // Avança até o nó da posição
        while (aux != null && index < position) {
            aux = aux.getNext();
            index++;
        }

        // Se a posição é maior que o tamanho, remove o último
        if (aux == null) return pop();

        // Se for o último nó
        if (aux.getNext() == null) return pop();

        // Se for um nó do meio
        Node<T> anterior = aux.getPrev();
        Node<T> proximo = aux.getNext();
        anterior.setNext(proximo);
        proximo.setPrev(anterior);

        aux.setNext(null);
        aux.setPrev(null);

        return aux;
    }

    /*
     * Verifica se a lista está vazia
     */
    public boolean isEmpty() {
        return (this.head == null && this.tail == null);
    }

    public Node<T> getHead() {
        return this.head;
    }

    /*
     * Exibe a lista do início ao fim
     */
    public void printList() {
        Node<T> aux = this.head;
        System.out.print("Lista: ");
        while (aux != null) {
            System.out.print(aux.getData() + " ");
            aux = aux.getNext();
        }
        System.out.println();
    }
}

