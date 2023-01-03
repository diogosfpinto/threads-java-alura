package org.example.lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Principal {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Arraylist não é thread-safe, o que pode ocorrer falhas durante a execução, por exemplo, threads diferenteess
         * podem utilizar o mesmo índice.
         **/

        List<String> lista = new Vector<>();

        for (int i = 0; i  < 100; i++){
            Thread thread = new Thread(new TarefaAdicionaElemento(lista, i));
            thread.start();
        }

        Thread.sleep(200);

        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
}
