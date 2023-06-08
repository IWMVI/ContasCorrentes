package view;

import java.util.Scanner;

import controller.Funcoes;

public class Principal {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Funcoes funcoes = new Funcoes();
        Scanner sc = new Scanner(System.in);

        do {
            menu.showMenu(sc);
            funcoes.showFuncoes(menu.getOpcao());
        } while (menu.getOpcao() != 0);
    }
}
