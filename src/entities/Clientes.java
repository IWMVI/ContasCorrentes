package entities;

public class Clientes {

    private String nome;
    private int tipoConta;
    private double saldo;
    private double limite;
    private int codConta;

    public Clientes() {

    }

    public Clientes(String nome, int tipoConta, int codConta) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.codConta = codConta;
        saldo = 0;
        limite = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getCodConta() {
        return codConta;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    public void setDeposito(double deposito) {
        saldo += deposito;
    }

    public void setSaque(double saque) {
        saldo -= saque;
    }

}
