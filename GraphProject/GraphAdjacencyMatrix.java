
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 */
public class GraphAdjacencyMatrix<T> {

    private boolean matrix[][];
    private ArrayList<T> vertex;
    
    public GraphAdjacencyMatrix(int dimension) {
        matrix = new boolean[dimension][dimension];
        vertex = new ArrayList<>();
    }
    
    public void addVertex(T v)
    {
        vertex.add(v);
    }
    
    private int getFromTo(String fromTo) {
        AtomicInteger index = new AtomicInteger(-1);    // valor padrão se não for encontrado
        AtomicInteger current = new AtomicInteger(0);   // contador de posição

        vertex.forEach(v -> {
            if (v.equals(fromTo)) {
                index.set(current.get());
            }
            current.incrementAndGet();
        });

        return index.get();
    }
    
    public void setVertex(String from, String to)
    {
        
        matrix[getFromTo(from)][getFromTo(to)] = true;
    }
    
    public void printMatrix()
    {
        for (boolean[] row : matrix)
        {
            for (boolean cell : row)
            {
                int cellValue = cell ? 1 : 0;
                System.out.print("\t" + cellValue);
            }
            System.out.println();
        }
    }
   
    public void printVertex() {
        AtomicInteger x = new AtomicInteger(0);
        vertex.forEach(new Consumer<T>() {
            @Override
            public void accept(T v) {
                System.out.print(x.get());
                System.out.print(" ");
                System.out.println(v);
                x.incrementAndGet();
            }
        });
    }
}
