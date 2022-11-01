package br.com.unipar.ex01excecoes.model;

import br.com.unipar.ex01excecoes.exception.OperacaoInvalidaException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author andersonbosing
 */
public class Calculadora {

    private Double num1;
    private Double num2;
    private String operacao;

    private void somar() {
        System.out.println("Soma = " + (num1 + num2));
    }

    private void multiplicar() {
        System.out.println("Multiplicacao = " + (num1 * num2));
    }

    private void subtrair() {
        System.out.println("Subtracao = " + (num1 - num2));
    }

    public void dividir() {
        System.out.println("Divisao = " + (num1 / num2));
    }

    public void receberDados() {

        try {

            Scanner s = new Scanner(System.in);

            System.out.println("Informe o Primeiro Numero");
            num1 = s.nextDouble();

            System.out.println("Informe o Segundo Numero");
            num2 = s.nextDouble();

            System.out.println("Informe a Operação(soma, div, sub e multi)");
            operacao = s.next();

            validarDados();

        } catch (InputMismatchException e) {
            System.out.println("Dados de numeros informados incorretamente. Verifique!");
        } catch (OperacaoInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void validarDados() throws OperacaoInvalidaException, Exception {

        validarOperacoes();
        validarEntradas();

    }

    private void validarOperacoes() throws OperacaoInvalidaException {
        String[] operacoes = {"soma", "multi", "div", "sub"};

        boolean validarOperacoes = true;

        for (int i = 0; i < operacoes.length; i++) {
            if (operacao.toLowerCase().trim().equals(operacoes[i])) {
                validarOperacoes = false;
            }
        }

        if (validarOperacoes) {
            throw new OperacaoInvalidaException();
        }
    }

    private void validarEntradas() throws Exception {
        if ((operacao.toLowerCase().trim().equals("div")) && (num2 == 0)) {
            throw new Exception("Divisão por zero não permitida");
        }
    }

}
