/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.gov.sp.fatec.binarytree;

import java.util.Scanner;

/**
 *
 * @author amaffeis
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Binary Tree");
        BinaryTree btree = new BinaryTree();
        int vet[] = new int[7];
        
        for (int i=0; i < 7; i++)
        {
            System.out.print("-> ");
            vet[i] = in.nextInt();
        }
        
        for (int i=0; i < vet.length; i++)
        {
            btree.add(btree.getRoot(), new Node(vet[i]));
        }
        
        btree.show();
    }
}
