import java.util.Scanner;

public class Conta {
    Scanner sc = new Scanner(System.in);

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
        System.out.println(this.getSaldo());
    }

    public static void balanceList(String accountNumber, int choose) {
        if (choose == 1) {
            System.out.println(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo());
        } else if (choose == 2) {
            System.out.println(Credito.creditos.get(Integer.parseInt(accountNumber)).getSaldo());
        } else if (choose == 3) {
            System.out.println(Poupanca.poupancas.get(Integer.parseInt(accountNumber)).getSaldo());
        }
        Main.userActionsMenu(accountNumber , choose);
    }

    public static void transferAction(String accountNumber, int choose) {
        Scanner sc = new Scanner(System.in);
        System.out.println("+++++MENU TRANSFERÊNCIA+++++");
        System.out.println("Insira o número da conta que deseja transferir dinheiro: ");
        String accountToTransfer = sc.next();
        System.out.println("Insira a quantia de dinheiro desejada para a transferência: ");
        double moneyToTransfer = sc.nextDouble();

        tranferMoney(accountToTransfer, moneyToTransfer, choose, accountNumber);
    }

    public static void tranferMoney(String accountToTransfer, double moneyToTransfer, int choose, String accountNumber) {
        if (choose == 1) {
            Corrente.correntes.get(Integer.parseInt(accountToTransfer)).setSaldo(moneyToTransfer);
            System.out.println("Transferência realizada no valor de: R$" + moneyToTransfer);
        } else if (choose == 2) {
            Credito.creditos.get(Integer.parseInt(accountToTransfer)).setSaldo(moneyToTransfer);
            System.out.println("Transferência realizada no valor de: R$" + moneyToTransfer);
        } else if (choose == 3) {
            Poupanca.poupancas.get(Integer.parseInt(accountToTransfer)).setSaldo(moneyToTransfer);
            System.out.println("Transferência realizada no valor de: R$" + moneyToTransfer);
        }
        Main.userActionsMenu(accountNumber , choose);
    }
}
