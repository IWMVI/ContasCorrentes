package view;

import java.io.IOException;

import model.Funcoes;

public class Principal {
	public static void main(String[] args) throws IOException {

		Menu m = new Menu();
		Funcoes f = new Funcoes();

		do {
			m.showMenu();
			f.showFuncoes(m.getOpcao());
		} while (m.getOpcao() != 0);
	}
}
