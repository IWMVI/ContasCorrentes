package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import entities.Cliente;
import view.Menu;

public class Funcoes {

	Cliente[] cliente = new Cliente[5];
	Random random = new Random();
	Menu menu = new Menu();

	public void showFuncoes(int opcao) {
		switch (opcao) {

		case 0:
			JOptionPane.showMessageDialog(null, "Finalizado!");
			break;

		case 1:
			for (int i = 0; i < cliente.length; i++) {
				String nome = JOptionPane.showInputDialog("Informe o nome do cliente");
				int tipoConta = Integer.parseInt(JOptionPane.showInputDialog(
						"Informe o tipo de conta\n01. Física\n02. Conjunta\n03. Jurídica\n04. Especial"));
				int numConta = random.nextInt(9999) + 1000;
				int saldoConta = 0;
				while (tipoConta < 1 || tipoConta > 4) {
					tipoConta = Integer.parseInt(JOptionPane.showInputDialog(
							"Informe uma opção válida\n01. Física\n02. Conjunta\n03. Jurídica\n04. Especial"));
				}
				cliente[i] = new Cliente(nome, numConta, saldoConta, tipoConta);

			}
			break;

		case 2:
			for (int i = 0; i < cliente.length; i++) {
				int tipoMov = Integer.parseInt(JOptionPane.showInputDialog(
						cliente[i].getNome() + ", informe o tipo de movimentação\n01. Depósito\n02. Saque"));
				switch (tipoMov) {
				case 1:
					int deposito = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do depósito"));
					cliente[i].setSaldo(deposito);
					cliente[i].setRegistro(deposito);
					break;

				case 2:
					int saque = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor de saque"));
					if (cliente[i].getSaldo() < saque && cliente[i].getLimite() + cliente[i].getSaldo() < saque) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente");
						i--;
					} else {
						cliente[i].setSaldo(-saque);
						cliente[i].setRegistro(saque);
					}
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
					i--;
					break;
				}
			}
			break;

		case 3:
			for (Cliente atual : cliente) {
				atual.atualizarLimite(atual.getTipoCliente(), atual.getSaldo());
			}
			break;

		case 4:
			for (int i = 0; i < cliente.length; i++) {
				System.out.println(cliente[i].getNome());
				System.out.println(cliente[i].getTipoCliente());
				System.out.println(cliente[i].getNumConta());
				System.out.println(cliente[i].getSaldo());
				System.out.println(cliente[i].getLimite());
				System.out.println("\n");
			}
			break;

		case 5:
			String nomeArq = JOptionPane.showInputDialog("Informe o nome do arquivo a ser salvo");
			try {
				BufferedWriter escrita = new BufferedWriter(new FileWriter(nomeArq + ".txt"));
				for (int i = 0; i < cliente.length; i++) {
					escrita.write(cliente[i].getNome() + "\n");
					escrita.write(cliente[i].getNumConta() + "\n");
					escrita.write(cliente[i].getTipoCliente() + "\n");
					escrita.write(cliente[i].getSaldo() + "\n");
					escrita.write(cliente[i].getLimite() + "\n");

					escrita.newLine();
				}

				escrita.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao gravar dados no arquivo " + nomeArq);
			}
			break;

		case 6:
			nomeArq = JOptionPane.showInputDialog("Informe o arquivo a ser lido");
			try {
				Cliente[] c = new Cliente[5];
				BufferedReader leitura = new BufferedReader(new FileReader(nomeArq + ".txt"));
				for (int i = 0; i < c.length; i++) {
					c[i] = new Cliente();
					c[i].setNome(leitura.readLine());
					c[i].setNumConta(Integer.parseInt(leitura.readLine()));
					c[i].setTipoCliente(Integer.parseInt(leitura.readLine()));
					c[i].setSaldo(Integer.parseInt(leitura.readLine()));
					c[i].setLimite(Integer.parseInt(leitura.readLine()));
					leitura.readLine();
				}
				leitura.close();

				cliente = c;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao ler arquivo " + nomeArq);
			}
			break;

		case 7:
			for (Cliente atual : cliente) {
				int[] registros = atual.getRegistros();
				System.out.println("Registros para " + atual.getNome() + ":");
				for (int valor : registros) {
					System.out.println(valor);
				}
				System.out.println();
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			break;
		}
	}
}
