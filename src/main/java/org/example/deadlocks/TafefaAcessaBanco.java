package org.example.deadlocks;

public class TafefaAcessaBanco implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;
    public TafefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (pool) {

            System.out.println("Peguei a chave do pool");
            pool.getConnection();

            synchronized (tx) {

                System.out.println("Peguei a chave da tx");
                tx.begin();

            }
        }
    }
}
