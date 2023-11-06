package view;

import javax.swing.JOptionPane;

public class Menu {
	private int opcao;

	public int getOpcao() {
		return opcao;
	}

	public void showMenu() {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("MENU\n01. Cadastrar Contas\n02. Cadastrar Movimentação\n"
				+ "03. Atualizar Contas\n04. Consultar Cadastros\n05. Gravar Dados\n"
				+ "06. Ler Dados\n07. Ver Registros\n00. Finalizar"));
	}
}
