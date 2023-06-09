package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import entities.Clientes;

public class Funcoes {

    Clientes[] clientes = new Clientes[3];
    Clientes[] cliente = clientes;
    Scanner sc = new Scanner(System.in);

    public void showFuncoes(int opcao) {
        switch (opcao) {

            default:
                System.out.println("\nOpção Inválida!");
                System.out.println("\n--------------\n");
                break;

            case 0:
                System.out.println("Finalizado!");
                System.out.println("\n--------------\n");
                break;

            case 1:

                System.out.println("---- Cadastro Cliente ----\n");

                for (int i = 0; i < clientes.length; i++) {
                    System.out.print("Informe o nome do cliente: ");
                    String nome = sc.nextLine();

                    tiposContas();
                    System.out.print("Tipo de conta: ");
                    int tipoConta = sc.nextInt();
                    sc.nextLine();

                    while (tipoConta < 1 || tipoConta > 4) {
                        System.out.println("\nOpção inválida!");
                        System.out.print("Tipo de conta: ");
                        tipoConta = sc.nextInt();
                    }

                    Random random = new Random();
                    int codConta = random.nextInt(9999) + 1000;
                    System.out.println("Código da conta: " + codConta + "\n");

                    cliente[i] = new Clientes(nome, tipoConta, codConta);
                    System.out.println("--------------\n");
                }

                Arrays.sort(cliente, (c1, c2) -> c1.getCodConta() - c2.getCodConta());
                break;

            case 2:
                System.out.println("---- Movimentações ----\n");
                for (int i = 0; i < clientes.length; i++) {
                    System.out.println("Olá " + cliente[i].getNome());
                    System.out.println("Seu saldo atual é de R$ " + cliente[i].getSaldo());
                    System.out.println("Seu limite é de R$ " + cliente[i].getLimite());
                    System.out.println("\nSelecione uma opção abaixo\n");
                    System.out.println("01. Depósito");
                    System.out.println("02. Saque");
                    System.out.print("Opção: ");
                    int opc = sc.nextInt();
                    while (opc != 1 && opc != 2) {
                        System.out.println("Opção inválida!");
                        System.out.print("Opção: ");
                        opc = sc.nextInt();
                    }
                    System.out.println();

                    switch (opc) {
                        case 1:
                            System.out.println("---- Depósito ----\n");
                            System.out.println("Informe a quantidade que será depositada");
                            System.out.print("R$ ");
                            double deposito = sc.nextDouble();
                            cliente[i].setDeposito(deposito);
                            System.out.println("\nDepósito realizado com sucesso!");
                            System.out.println("Seu saldo atual é de R$ " + cliente[i].getSaldo());
                            System.out.println("\n---------------\n");
                            break;

                        case 2:
                            System.out.println("---- Saque ----\n");
                            System.out.println("Informe a quantidade que será sacada");
                            System.out.print("R$ ");
                            double saque = sc.nextDouble();
                            if (cliente[i].getSaldo() >= saque || cliente[i].getLimite() >= saque) {
                                cliente[i].setSaque(saque);
                                System.out.println("\nSaque realizado com sucesso!");
                                System.out.println("Seu saldo atual é de R$ " + cliente[i].getSaldo());
                                System.out.println("\n---------------\n");
                            } else {
                                System.out.println("\nNão há saldo/limite para saque!");
                                System.out.println("\n---------------\n");
                            }
                            break;
                    }
                }
                break;

            case 3:
                System.out.println("---- Atualização de contas ----\n");
                for (int i = 0; i < clientes.length; i++) {
                    switch (cliente[i].getTipoConta()) {
                        case 1:
                            cliente[i].setLimite(0);
                            break;

                        case 2:
                            cliente[i].setLimite(cliente[i].getSaldo());
                            break;

                        case 3:
                            cliente[i].setLimite(cliente[i].getSaldo() * 1.50);
                            break;

                        case 4:
                            cliente[i].setLimite(cliente[i].getSaldo() * 2);
                            break;
                    }

                }

                System.out.println("\nContas atualizadas com sucesso!\n");
                System.out.println("---------------\n");
                break;

            case 4:
                for (Clientes clientes : cliente) {
                    System.out.println("Nome: " + clientes.getNome());
                    System.out.println("Tipo de conta: " + clientes.getTipoConta());
                    System.out.println("Código da conta: " + clientes.getCodConta());
                    System.out.println("Saldo em conta: " + clientes.getSaldo());
                    System.out.println("Limite atual: " + clientes.getLimite());
                    System.out.println("\n--------------\n");
                }

                break;

            case 5:
                System.out.println("---- Gravação de dados ----\n");
                System.out.print("Informe o nome do arquivo: ");
                String nomeArquivo = sc.nextLine();
                sc.next();

                String arquivo = nomeArquivo + ".txt";
                try (BufferedWriter escrita = new BufferedWriter(new FileWriter(arquivo))) {
                    for (Clientes clientes : cliente) {
                        escrita.write("Nome: " + clientes.getNome() + "\n");
                        escrita.write("Tipo de conta: " + clientes.getTipoConta() + "\n");
                        escrita.write("Código da conta: " + clientes.getCodConta() + "\n");
                        escrita.write("Saldo em conta: " + clientes.getSaldo() + "\n");
                        escrita.write("Limite atual: " + clientes.getLimite() + "\n");
                        escrita.write("\n--------------\n");
                        escrita.newLine();
                    }
                    System.out.println("Dados gravados com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao gravar arquivos!");
                }
                break;
        }
    }

    private void tiposContas() {

        System.out.println("\n01. Física");
        System.out.println("02. Conjunta");
        System.out.println("03. Jurídica");
        System.out.println("04. Especial\n");
    }
}
