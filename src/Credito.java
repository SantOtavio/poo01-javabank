
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

    public Credito(double saldo, String titular, String senha, String status, String numero, double limite , String dataFatura) {
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


    public void pagamento(){
        Scanner sc = new Scanner(System.in);

        double valorPagamento;

        System.out.println("Insira o valor do pagamento: ");
        valorPagamento = sc.nextDouble();

        this.setSaldo(this.getSaldo() - valorPagamento);
    }

}
