package view;

import java.util.Scanner;

public class Menu {

    private int opcao;

    public int getOpcao() {
        return opcao;
    }

    public int showMenu(Scanner sc) {
        System.out.println("\n---- MENU ---\n");
        System.out.println("01. Cadastrar Cliente");
        System.out.println("02. Movimentações");
        System.out.println("03. Atualizar Contas");
        System.out.println("04. Verificar Dados");
        System.out.println("05. Gravar Dados");
        System.out.println("00. Finalizar");
        System.out.print("Opção: ");
        this.opcao = sc.nextInt();
        System.out.println("\n--------------\n");
        return opcao;
    }
}
