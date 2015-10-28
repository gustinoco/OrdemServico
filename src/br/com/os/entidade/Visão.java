/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.entidade;

/**
 *
 * @author Gustavo
 */
public class Visão<T> {

    T chave;
    String info;

    public Visão(T chave, String info) {
        this.chave = chave;
        this.info = info;
    }

  

    public T getChave() {
        return chave;
    }

    public void setChave(T chave) {
        this.chave = chave;

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info;
    }
}
