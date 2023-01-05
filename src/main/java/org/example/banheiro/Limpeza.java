package org.example.banheiro;

public class Limpeza implements Runnable {

    private Banheiro banheiro;

    public Limpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.limpa();
    }
}
