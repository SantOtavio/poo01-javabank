import java.util.ArrayList;

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

    public void deposito(){}

    public void transferencia(){}

}
