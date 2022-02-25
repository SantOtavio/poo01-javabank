import java.util.ArrayList;
import java.util.Scanner;

public class Poupanca extends Conta {

    static ArrayList<Poupanca> poupancas = new ArrayList<Poupanca>();


    double rendimento;

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public Poupanca(double saldo, String titular, String senha, String status, String numero, double rendimento) {
        super(saldo, titular, senha, status, numero);
        this.rendimento = rendimento;
    }

    public Poupanca() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + "\nRendimento: " + rendimento;
    }

    public Poupanca(double rendimento) {
        this.rendimento = rendimento;
    }

    public static void withdrawAction(String accountNumber, int choose) {
        Scanner sc = new Scanner(System.in);
        System.out.println("+++++MENU SAQUE+++++" +
                "\nInsira o valor do saque: ");
        double withdrawValue = sc.nextDouble();

        withdrawMethod(withdrawValue, choose, accountNumber);
    }

    public static void withdrawMethod(double withdrawValue, int choose, String accountNumber) {
        Scanner sc = new Scanner(System.in);
        if (choose == 1) {
            Corrente.correntes.get(Integer.parseInt(accountNumber)).setSaldo(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo() - withdrawValue);
            System.out.println("Saque realizado no valor de: R$" + withdrawValue);
        } else if (choose == 2) {
            Credito.creditos.get(Integer.parseInt(accountNumber)).setLimite(Credito.creditos.get(Integer.parseInt(accountNumber)).getLimite() - withdrawValue);
            System.out.println("Saque realizado no valor de: R$" + withdrawValue);
        } else if (choose == 3) {
            System.out.println("ISTO NÃO É DISPONIVEL PARA CONTAS POUPANÇA");
        }
        Main.userActionsMenu(accountNumber , choose);
    }

    public static void depositAction(String accountNumber, int choose) {
        Scanner sc = new Scanner(System.in);
        System.out.println("+++++MENU DEPOSITO+++++" +
                "\nInsira o valor para deposito: ");
        double depositValue = sc.nextDouble();
        depositMethod(accountNumber, choose, depositValue);
    }

    public static void depositMethod(String accountNumber, int choose, double depositValue) {
        Scanner sc = new Scanner(System.in);
        if (choose == 1) {
            Corrente.correntes.get(Integer.parseInt(accountNumber)).setSaldo(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo() + depositValue);
            System.out.println("Deposito realizado no valor de: R$" + depositValue);
        } else if (choose == 2) {
            System.out.println("ISSO NÃO É DISPONÍVEL PARA CONTAS DE CRÊDITO");
        } else if (choose == 3) {
            Poupanca.poupancas.get(Integer.parseInt(accountNumber)).setSaldo(Poupanca.poupancas.get(Integer.parseInt(accountNumber)).getSaldo() + depositValue);
            System.out.println("Deposito realizado no valor de: R$" + depositValue);
        }
        Main.userActionsMenu(accountNumber , choose);
    }
}
