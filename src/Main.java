import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        principalMenu();
    }

    private static void principalMenu() {
        int choose;

        System.out.println("" +
                "++++MENU PRINCIPAL++++" +
                "\n1 - Gerência" +
                "\n2 - Usuário" +
                "\n3 - Encerrar Programa"
        );
        choose = sc.nextInt();

        switch (choose) {
            case 1:
                gerencyMenu();
                break;
            case 2:
                userMenu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("TU É MUITO BURRO CARA KKKKKKKKKKKKKKKKKKKKKKKK, É DE 1 A 3 ANIMAL. ");
                registerMenu();
                break;
        }
    }

    private static void userMenu() {
        System.out.println("+++++MENU DO USUÁRIO+++++" +
                "\n[1] - Entrar no javaBank" +
                "\n[2] - Encerrar aplicação");
        int choose = sc.nextInt();

        switch (choose) {
            case 1:
                javaBankLogin();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    private static void javaBankLogin() {
        System.out.println("+++++LOGIN+++++" +
                "\n[1] - Login na conta corrente" +
                "\n[2] - Login na conta de crédito" +
                "\n[3] - Login na conta poupança");
        int choose = sc.nextInt();

        switch (choose) {
            case 1:
                System.out.println("Insira o número da conta");
                String accountNumber = sc.next();
                verifyCheckingAccountNumber(accountNumber , choose);
                break;
            case 2:
                System.out.println("Insira o número da conta");
                accountNumber = sc.next();
                verifyCreditAccountNumber(accountNumber, choose);
                break;
            case 3:
                System.out.println("Insira o número da conta");
                accountNumber = sc.next();
                verifySavingsAccountNumber(accountNumber, choose);
        }
    }

    private static void verifySavingsAccountNumber(String accountNumber , int choose) {
        for (int i = 0; i < Poupanca.poupancas.size(); i++) {
            if (accountNumber.equals(Poupanca.poupancas.get(i).getNumero())) {
                userActionsMenu(accountNumber, choose);
            } else {
                System.out.println("NÚMERO DE CONTA INVÁLIDO!!");
                userMenu();
            }
        }
    }

    private static void verifyCreditAccountNumber(String accountNumber, int choose) {
        for (int i = 0; i < Credito.creditos.size(); i++) {
            if (accountNumber.equals(Credito.creditos.get(i).getNumero())) {
                userActionsMenu(accountNumber, choose);
            } else {
                System.out.println("NÚMERO DE CONTA INVÁLIDO!!");
                userMenu();
            }
        }
    }

    private static void verifyCheckingAccountNumber(String accountNumber, int choose) {
        for (int i = 0; i < Corrente.correntes.size(); i++) {
            if (accountNumber.equals(Corrente.correntes.get(i).getNumero())) {
                userActionsMenu(accountNumber, choose);
            } else {
                System.out.println("NÚMERO DE CONTA INVÁLIDO!!");
                userMenu();
            }
        }
    }

    private static void userActionsMenu(String accountNumber, int choose) {
        System.out.println("+++++CONTA Nº " + accountNumber + "++++++" +
                "\n[1] - Listar saldo" +
                "\n[2] - Realizar transferência" +
                "\n[3] - Realizar saque" +
                "\n[4] - Realizar deposito");
        int chooseAction = sc.nextInt();

        switch (chooseAction){
            case 1:
                balanceList(accountNumber , choose);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    private static void balanceList(String accountNumber , int choose) {
        if (choose == 1){
            
        }
    }

    private static void gerencyMenu() {

        System.out.println("++++MENU GERENCIA++++" +
                "\n1 - Cadastrar conta" +
                "\n2 - Bloquear conta" +
                "\n3 - Listar Contas" +
                "\n4 - Voltar");
        int choose = sc.nextInt();

        switch (choose) {
            case 1:
                registerMenu();
                break;
            case 2:
                blockAccountMenu();
                break;
            case 3:
                listAccountMenu();
                break;
            case 4:
                principalMenu();
                break;
        }
    }

    private static void registerMenu() {

        System.out.println("++++MENU CADASTRO++++" +
                "\n1 - Corrente" +
                "\n2 - Crédito" +
                "\n3 - Poupança" +
                "\n4 - Voltar");

        int choose = sc.nextInt();

        if (choose > 0 && choose < 4) {
            register(choose);
        } else if (choose == 4) {
            gerencyMenu();
        } else {
            System.out.println("TU É MUITO BURRO CARA KKKKKKKKKKKKKKKKKKKKKKKK, É DE 1 A 4 ANIMAL. ");
            registerMenu();
        }
    }

    private static void register(int choose) {

        double saldo;
        String numero;
        String titular, senha;
        String status;


        System.out.println("Número da conta: ");
        numero = sc.next();
        System.out.println("Titular:");
        titular = sc.next();
        System.out.println("Senha: ");
        senha = sc.next();
        status = "Regular";
        saldo = 0.0;

        switch (choose) {
            case 1:
                System.out.println("Limite:");
                double limite = sc.nextDouble();
                Corrente correnteTemp = new Corrente(saldo, titular, senha, status, numero, limite);
                Corrente.correntes.add(correnteTemp);
                System.out.println("Cadastro realizado com sucesso!");
                registerMenu();
                break;

            case 2:
                System.out.println("Limite:");
                limite = sc.nextDouble();
                System.out.println("Data da fatura:");
                String dataFatura = sc.next();
                Credito creditoTemp = new Credito(saldo, titular, senha, status, numero, limite, dataFatura);
                Credito.creditos.add(creditoTemp);
                System.out.println("Cadastro realizado com sucesso!");
                registerMenu();
                break;
            case 3:
                System.out.println("Rendimento:");
                double rendimento = sc.nextDouble();
                Poupanca poupancaTemp = new Poupanca(saldo, titular, senha, status, numero, rendimento);
                Poupanca.poupancas.add(poupancaTemp);
                System.out.println("Cadastro realizado com sucesso!");
                registerMenu();
                break;
        }
    }

    private static void blockAccountMenu() {
        System.out.println("++++MENU BLOQUEIO++++" +
                "\n1 - Corrente" +
                "\n2 - Crédito" +
                "\n3 - Poupança" +
                "\n4 - Voltar");

        int choose = sc.nextInt();

        System.out.println("Informe o número da conta a ser bloqueada:");
        int conta = sc.nextInt();

        if (choose > 0 && choose < 4) {
            cancelar(conta, choose);
        } else if (choose == 4) {
            gerencyMenu();
        } else {
            System.out.println("TU É MUITO BURRO CARA KKKKKKKKKKKKKKKKKKKKKKKK, É DE 1 A 4 ANIMAL. ");
            blockAccountMenu();
        }
    }

    private static void cancelar(int conta, int choose) {
        switch (choose) {
            case 1:
                System.out.println("Conta cancelada com sucesso!");
                Corrente.correntes.get(conta).setStatus("Cancelada");
                blockAccountMenu();
                break;
            case 2:
                System.out.println("Conta cancelada com sucesso!");
                Credito.creditos.get(conta).setStatus("Cancelada");
                blockAccountMenu();
                break;
            case 3:
                System.out.println("Conta cancelada com sucesso!");
                Poupanca.poupancas.get(conta).setStatus("Cancelada");
                blockAccountMenu();
                break;
        }
    }

    private static void listAccountMenu() {
        System.out.println("++++MENU LISTAR++++" +
                "\n1 - Corrente" +
                "\n2 - Crédito" +
                "\n3 - Poupança" +
                "\n4 - Voltar");

        int choose = sc.nextInt();

        if (choose > 0 && choose < 4) {
            listar(choose);
        } else if (choose == 4) {
            gerencyMenu();
        } else {
            System.out.println("TU É MUITO BURRO CARA KKKKKKKKKKKKKKKKKKKKKKKK, É DE 1 A 4 ANIMAL. ");
            listAccountMenu();
        }
    }

    private static void listar(int choose) {
        switch (choose) {
            case 1:
                for (int i = 0; i < Corrente.correntes.size(); i++) {
                    String saida = Corrente.correntes.get(i).toString();
                    System.out.println(saida);
                    if (i + 1 != Corrente.correntes.size()) {
                        System.out.println("-----------------------------");
                    }
                }
                System.out.println("Deseja listar mais alguma conta? [1] - Sim [2] - Não");
                choose = sc.nextInt();
                if (choose == 1) {
                    listAccountMenu();
                } else {
                    gerencyMenu();
                }
                break;
            case 2:
                for (int i = 0; i < Credito.creditos.size(); i++) {
                    String saida = Credito.creditos.get(i).toString();
                    System.out.println(saida);
                    if (i + 1 != Credito.creditos.size()) {
                        System.out.println("-----------------------------");
                    }
                }
                System.out.println("Deseja listar mais alguma conta? [1] - Sim [2] - Não");
                choose = sc.nextInt();
                if (choose == 1) {
                    listAccountMenu();
                } else {
                    gerencyMenu();
                }
                break;
            case 3:
                for (int i = 0; i < Poupanca.poupancas.size(); i++) {
                    String saida = Poupanca.poupancas.get(i).toString();
                    System.out.println(saida);
                    if (i + 1 != Poupanca.poupancas.size()) {
                        System.out.println("-----------------------------");
                    }
                }
                System.out.println("Deseja listar mais alguma conta? [1] - Sim [2] - Não");
                choose = sc.nextInt();
                if (choose == 1) {
                    listAccountMenu();
                } else {
                    gerencyMenu();
                }
                break;
        }
    }
}
