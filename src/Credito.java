
import java.util.ArrayList;
import java.util.Scanner;

public class Credito extends Conta {

    static ArrayList<Credito> creditos = new ArrayList<Credito>();


    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(String dataFatura) {
        this.dataFatura = dataFatura;
    }

    public Credito(double saldo, String titular, String senha, String status, String numero, double limite, String dataFatura) {
        super(saldo, titular, senha, status, numero);
        this.limite = limite;
        this.dataFatura = dataFatura;
    }

    public Credito() {
        super();
    }


    @Override
    public String toString() {
        return super.toString() + "\nLimite: " + limite + "\nData da Fatura: " + dataFatura;
    }

    double limite;
    String dataFatura;

    public static void paymentAction(String accountNumber, int choose) {
        Scanner sc = new Scanner(System.in);
        System.out.println("+++++MENU PAGAMENTOS+++++" +
                "\nInsira o valor do pagamento");
        double paymentValue = sc.nextDouble();
        System.out.println("\nSCANNEANDO CÓDIGO DE BARRAS, BIP BIP BIP BIP");

        paymentMethod(paymentValue, choose, accountNumber);
    }

    public static void paymentMethod(double paymentValue, int choose, String accountNumber) {
        Scanner sc = new Scanner(System.in);
        if (choose == 1) {
            Corrente.correntes.get(Integer.parseInt(accountNumber)).setSaldo(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo() - paymentValue);
            System.out.println("Pagamento realizado no valor de: R$" + paymentValue);
            Main.userActionsMenu(accountNumber , choose);
        } else if (choose == 2) {
            Credito.creditos.get(Integer.parseInt(accountNumber)).setSaldo(Credito.creditos.get(Integer.parseInt(accountNumber)).getSaldo() - paymentValue);
            System.out.println("Pagamento realizado no valor de: R$" + paymentValue);
            Main.userActionsMenu(accountNumber , choose);
        } else if (choose == 3) {
            System.out.println("ISTO NÃO É DISPONIVEL PARA CONTAS POUPANÇA");
            Main.userActionsMenu(accountNumber , choose);
        }
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
            Main.userActionsMenu(accountNumber , choose);
        }
    }

}
