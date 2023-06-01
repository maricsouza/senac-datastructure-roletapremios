import java.util.Scanner;

public class Main {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        RoletaPremios roleta = new RoletaPremios();

        System.out.println("###      ROLETA DE PRÊMIOS      ###");
        
        int opcao = exibirMenu();

        while (opcao != -1) {

            if(opcao == 0) break;
            
            switch(opcao) {
                case 1:
                    System.out.println("Nome do prêmio que deseja adicionar:");
                    String nomePremio = sc.nextLine();
                    roleta.adicionar(nomePremio);
                    break;

                case 2:
                    System.out.println("Nome do prêmio que deseja remover:");
                    nomePremio = sc.nextLine();
                    roleta.remover(nomePremio);
                    break;

                case 3:
                    System.out.println("Nome do prêmio que deseja alterar:");
                    nomePremio = sc.nextLine();
                    System.out.println("Nome para o qual deseja alterar:");
                    String nomeAlterado = sc.nextLine();
                    roleta.alterar(nomePremio, nomeAlterado);
                    break;

                case 4:
                    roleta.verPremios();
                    System.out.printf("Total de prêmios: %d", roleta.totalPremios());
                    break;

                case 5:
                    System.out.println("Rodando roleta...");
                    String retornoRoleta = roleta.rodar();
                    System.out.printf("Seu prêmio é: %s", retornoRoleta);
                    break;
            }

            

            System.out.println();
            opcao = exibirMenu();
        }

        
    }

    public static int exibirMenu () {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("1. Adicionar prêmio\n2. Remover prêmio\n3. Alterar prêmio\n4. Ver total de prêmios\n5. Rodar a roleta e sortear um prêmio \n0. Sair");
        int escolha = sc.nextInt();

        if(escolha < 0 || escolha > 5) {
            escolha = -1;
        }

        return escolha;
    }
}



// project owner: Mariana Souza do Carmo