package entities;

public class Cliente {
    private String nome;
    private int numConta;
    private int saldo;
    private int tipoCliente;
    private int limite;

    private int[] registros = new int[10];

    public Cliente() {

    }

    public Cliente(String nome, int numConta, int saldo, int tipoCliente) {
        this.nome = nome;
        this.numConta = numConta;
        this.saldo = saldo;
        this.tipoCliente = tipoCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setSaldo(int saldo) {
        this.saldo += saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void atualizarLimite(int tipoConta, int saldo) {
        switch (tipoConta) {
            case 1:
                limite = 0;
                break;

            case 2:
                limite = saldo;
                break;

            case 3:
                limite = (int) (saldo + saldo * 0.50);
                if (limite < 0) {
                    limite = 0;
                }
                break;

            case 4:
                limite = (int) saldo * 2;
                if (limite < 0) {
                    limite = 0;
                }
                break;
        }
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getLimite() {
        return limite;
    }

    public void setRegistro(int valor) {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] == 0) {
                this.registros[i] = valor;
                return;
            }
        }
    }

    public int[] getRegistros() {
        return registros;
    }

    public void setRegistros(int[] novosRegistros) {
        this.registros = novosRegistros;
    }
}
