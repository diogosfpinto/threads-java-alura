package org.example.banheiro;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {

    Lock lock = new ReentrantLock();
    private boolean ehSujo = true;

    public void fazNumero1(){

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");


        /**
         * Usa Lock para executar o bloco sincronizadamente com possíveis outras threads. O bloco será executádo inteiramente
         * antes de iniciar a execução de outra thread para o mesmo bloco. */

        /**
         * Thread tenta executar durante o tempo estipulado. Se passado o tempo, bloco de código não é executado. */
        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            /*alterando estado da thread*/
            if(ehSujo){
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa rápida");

            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");
            lock.unlock();
        }
    }

    public void fazNumero2(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            if(ehSujo){
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");

            try {
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");
            lock.unlock();
        }
    }

    /**
     * Com wait, a thread do objeto entra em estado de espera, saindo do bloco de execução.
     * */
    private void esperaLaFora(String name) {
        try {
            System.out.println(name + " eca! Vou esperar limpar!");
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
