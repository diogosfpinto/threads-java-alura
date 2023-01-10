package org.example.deadlocks;

public class Main {

    public static void main(String[] args) {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        /**
         * ordem dos syncronized dentro de cada runnable causa o travamento das threads
         * */

        new Thread(new TafefaAcessaBanco(pool, tx)).start();
        new Thread((new TarefaAcessaBancoProcedimento(pool, tx))).start();

    }
}
