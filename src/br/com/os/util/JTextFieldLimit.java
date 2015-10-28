/*
 * ------------Software Ordem de Serviço----------
 * Linguagem de Programação 2 - 1ºSem/2015
 * Profº Joinville - UFGD
 * Alunos: Felipe G. / Gustavo T. / Reinaldo
 */
package br.com.os.util;

import javax.swing.text.PlainDocument;

/**
 *
 * @author Gustavo
 */
public class JTextFieldLimit extends PlainDocument {

    private int limit;

        public JTextFieldLimit(int limit) {
            super();
        this.limit = limit;
    }

    public JTextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }
}

}
