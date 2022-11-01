package br.com.unipar.ex01excecoes.exception;

/**
 *
 * @author andersonbosing
 */
public class OperacaoInvalidaException extends Exception {

    public OperacaoInvalidaException() {
        
        super("Operação informada invalida. Informe soma, div, sub e multi");
        
    }
    
}
