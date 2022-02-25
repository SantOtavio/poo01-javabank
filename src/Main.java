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
                verifyCheckingAccountNumber(accountNumber, choose);
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

    private static void verifySavingsAccountNumber(String accountNumber, int choose) {
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
                "\n[3] - Realizar pagamento" +
                "\n[4] - Realizar saque" +
                "\n[5] - Realizar deposito");
        int chooseAction = sc.nextInt();

        switch (chooseAction) {
            case 1:
                balanceList(accountNumber, choose);
                break;
            case 2:
                transferAction(accountNumber, choose);
                break;
            case 3:
                paymentAction(accountNumber, choose);
                break;
            case 4:
                withdrawAction(accountNumber, choose);
                break;
            case 5:
                depositAction(accountNumber, choose);
                break;
        }
    }

    private static void depositAction(String accountNumber, int choose) {
        System.out.println("+++++MENU DEPOSITO+++++" +
                "\nInsira o valor para deposito: ");
        double depositValue = sc.nextDouble();
        depositMethod(accountNumber, choose, depositValue);
    }

    private static void depositMethod(String accountNumber, int choose, double depositValue) {
        if (choose == 1) {
            Corrente.correntes.get(Integer.parseInt(accountNumber)).setSaldo(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo() + depositValue);
            System.out.println("Deposito realizado no valor de: R$" + depositValue);
            userMenu();
        } else if (choose == 2) {
            System.out.println("ISSO NÃO É DISPONÍVEL PARA CONTAS DE CRÊDITO");
        } else if (choose == 3) {
            Poupanca.poupancas.get(Integer.parseInt(accountNumber)).setSaldo(Poupanca.poupancas.get(Integer.parseInt(accountNumber)).getSaldo() + depositValue);
            System.out.println("Deposito realizado no valor de: R$" + depositValue);
        }
    }

    private static void withdrawAction(String accountNumber, int choose) {
        System.out.println("+++++MENU SAQUE+++++" +
                "\nInsira o valor do saque: ");
        double withdrawValue = sc.nextDouble();

        withdrawMethod(withdrawValue, choose, accountNumber);
    }

    private static void withdrawMethod(double withdrawValue, int choose, String accountNumber) {
        if (choose == 1) {
            Corrente.correntes.get(Integer.parseInt(accountNumber)).setSaldo(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo() - withdrawValue);
            System.out.println("Saque realizado no valor de: R$" + withdrawValue);
        } else if (choose == 2) {
            Credito.creditos.get(Integer.parseInt(accountNumber)).setLimite(Credito.creditos.get(Integer.parseInt(accountNumber)).getLimite() - withdrawValue);
            System.out.println("Saque realizado no valor de: R$" + withdrawValue);
        } else if (choose == 3) {
            System.out.println("ISTO NÃO É DISPONIVEL PARA CONTAS POUPANÇA");
            //paymentAction();
        }
    }

    private static void paymentAction(String accountNumber, int choose) {
        System.out.println("+++++MENU PAGAMENTOS+++++" +
                "\nInsira o valor do pagamento");
        double paymentValue = sc.nextDouble();
        System.out.println("\nSCANNEANDO CÓDIGO DE BARRAS, BIP BIP BIP BIP");

        paymentMethod(paymentValue, choose, accountNumber);
    }

    private static void paymentMethod(double paymentValue, int choose, String accountNumber) {
        if (choose == 1) {
            Corrente.correntes.get(Integer.parseInt(accountNumber)).setSaldo(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo() - paymentValue);
            System.out.println("Pagamento realizado no valor de: R$" + paymentValue);
        } else if (choose == 2) {
            Credito.creditos.get(Integer.parseInt(accountNumber)).setSaldo(Credito.creditos.get(Integer.parseInt(accountNumber)).getSaldo() - paymentValue);
            System.out.println("Pagamento realizado no valor de: R$" + paymentValue);
        } else if (choose == 3) {
            System.out.println("ISTO NÃO É DISPONIVEL PARA CONTAS POUPANÇA");
            //paymentAction();
        }
    }

    private static void transferAction(String accountNumber, int choose) {
        System.out.println("+++++MENU TRANSFERÊNCIA+++++");
        System.out.println("Insira o número da conta que deseja transferir dinheiro: ");
        String accountToTransfer = sc.next();
        System.out.println("Insira a quantia de dinheiro desejada para a transferência: ");
        double moneyToTransfer = sc.nextDouble();

        tranferMoney(accountToTransfer, moneyToTransfer, choose, accountNumber);
    }

    private static void tranferMoney(String accountToTransfer, double moneyToTransfer, int choose, String accountNumber) {
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
    }

    private static void balanceList(String accountNumber, int choose) {
        if (choose == 1) {
            System.out.println(Corrente.correntes.get(Integer.parseInt(accountNumber)).getSaldo());
        } else if (choose == 2) {
            System.out.println(Credito.creditos.get(Integer.parseInt(accountNumber)).getSaldo());
        } else if (choose == 3) {
            System.out.println(Poupanca.poupancas.get(Integer.parseInt(accountNumber)).getSaldo());
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
