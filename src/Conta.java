import java.util.Scanner;

public class Conta {

//    public String getPessoa() {
//        return pessoa;
//    }

//    public void setPessoa(String pessoa) {
//        this.pessoa = pessoa;
//    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    double saldo;

//    String pessoa;
    String titular;
    String senha;
    String status;
    String numero;

    @Override
    public String toString() {
        return "Dados da conta: " + "\n" +
                "Titular: " + titular + "\n" +
                "Número: " + numero + "\n" +
                "Senha: " + senha + "\n" +
                "Status: " + status + "\n" +
                "Saldo: " + saldo + "\n";
    }


    public Conta(double saldo, String titular, String senha, String status, String numero) {
        this.saldo = saldo;
        this.titular = titular;
        this.senha = senha;
        this.status = status;
        this.numero = numero;
    }

    public Conta() {
        super();
    }

    public void saque() {
        Scanner sc = new Scanner(System.in);

        double saqueValor;

        System.out.println("Insira o valor do saque: ");
        saqueValor = sc.nextDouble();

        this.setSaldo(this.getSaldo() - saqueValor);
    }

    public void saldo() {
        Scanner sc = new Scanner(System.in);

        System.out.println(this.getSaldo());
    }
}
