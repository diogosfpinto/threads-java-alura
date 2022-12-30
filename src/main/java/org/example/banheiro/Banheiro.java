package org.example.banheiro;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banheiro {

    Lock lock = new ReentrantLock();

    public void fazNumero1(){

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");


        /**
         * Usa Lock para executar o bloco sincronizadamente com possíveis outras threads. O bloco será executádo inteiramente
         * antes de iniciar a execução de outra thread para o mesmo bloco. */

        try {
            /**
             * Thread tenta executar durante o tempo estipulado. Se passado o tempo, bloco de código não é executado. */
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                System.out.println(nome + " entrando no banheiro");
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fazNumero2(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        try {
            if(lock.tryLock(20, TimeUnit.SECONDS)){
                System.out.println(nome + " entrando no banheiro");
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
