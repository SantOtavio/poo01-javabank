
import java.util.ArrayList;

public class Corrente extends Conta {

    static ArrayList<Corrente> correntes = new ArrayList<Corrente>();


    double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public Corrente(double saldo, String titular, String senha, String status, String numero, double limite) {
        super(saldo, titular, senha, status, numero);
        this.limite = limite;
    }

    public Corrente() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + "Limite: " + limite;
    }

    public Corrente(double limite) {
        this.limite = limite;
    }

    public void pagamento() {
    }

    public void transferencia() {
    }

    public void deposito() {
    }


}
