import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);
    public static int tamanho = 2;
    public static VetPessoa vet = new VetPessoa(tamanho);

    // public static Pessoa vetor[] = new Pessoa[10];
    public static void main(String[] args) throws Exception {

        char opcao;

        System.out.println("---Bem vindo a agenda de aniversario KnowHow---");
        do {
            System.out.println("\n1 - Inserir.\n"
                    + "2 - Remover.\n"
                    + "3 - Pesquisar por nome.\n"
                    + "4 - Pesquisar por dia e mes.\n"
                    + "5 - Pesquisar por mes.\n"
                    + "6 - Sair\n");
            opcao = (input.next().charAt(0));
            switch (opcao) {
                case '1':
                    CadastrarPessoa();
                    break;
                case '2':
                    Remover();
                    break;
                case '3':
                    pesquisarPorNome();
                    break;
                case '4':
                    pesquisarDiaeMes();
                    break;
                case '5':
                    pesquisarMes();
                    break;
                case '6':
                    System.out.println("Ate a proxima.");
                    break;
                default:
                    System.out.println("Opcao invalida, por favor digite uma opcao valida.");
                    break;
            }
        } while (opcao != '6');

    }

    public static void CadastrarPessoa() {

        System.out.println("Digite o nome da pessoa: ");
        String nome = input.next();
        System.out.println("Digite seu telefone: ");
        String telefone = input.next();
        System.out.println("Digite seu email: ");
        String email = input.next();

        System.out.println("Digite o dia que nasceu: ");
        int dia = input.nextInt();
        System.out.println("Digite o mes que nasceu: ");
        int mes = input.nextInt();
        System.out.println("Digite o ano que nasceu: ");
        int ano = input.nextInt();

        Data DataDeAniversario = new Data(dia, mes, ano);
        Pessoa pessoa1 = new Pessoa(nome, telefone, email, DataDeAniversario);

        boolean verdade = vet.insere(pessoa1);
        if (verdade == true) {
            System.out.println("Insercao foi bem sucedida.");
        } else {
            System.out.println("Insercao NAO foi bem sucedida.");
        }

    }

    public static void Remover() {
        String nome1;
        System.out.println("Digite o nome da pessoa que deseja remover: ");
        nome1 = input.next();
        boolean decisao = vet.remove(nome1);

        if (decisao == true) {
            System.out.println("Foi removido com sucesso.");
        } else {
            System.out
                    .println("Nao foi possivel remover pois o nome da pessoa pode nao estar no nosso banco de dados.");
        }

    }

    // pesquisa o nome e indica se o mesmo tem na agenda.
    public static void pesquisarPorNome() {

        String nomezera;
        System.out.println("Digite o nome que deseja ser pesquisado: ");
        nomezera = input.next();
        int indicepessoa = vet.pesquisa(nomezera);

        if (indicepessoa >= 0) {
            System.out.println(vet.getPessoa(indicepessoa));
        } else {
            System.out.println("Nome Inexistente");
        }

    }

    public static void pesquisarDiaeMes() {

        int diazero, meszero;
        System.out.println("Digite o dia do aniversariante: ");
        diazero = input.nextInt();
        System.out.println("Digite o mes do aniversariante: ");
        meszero = input.nextInt();

        VetPessoa pessoas = vet.pesquisaDiaMes(diazero, meszero);

        if (vet.pesquisaDiaMes(diazero, meszero) == null) {
            System.out.println("Nenhum aniversariante.");

        } else {
            for (int i = 0; i < pessoas.getQuant(); i++) {
                System.out.println(pessoas.getPessoa(i).getNome());
            }

        }

    }

    public static void pesquisarMes() {
        int mesmes;
        System.out.println("Digite o mes para identificarmos o aniversariante: ");
        mesmes = input.nextInt();

        VetPessoa pessoas = vet.pesquisaMes(mesmes);

        while (mesmes < 1 || mesmes >= 12) {
            System.out.println("Mes invalido, digite corretamente: ");
            mesmes = input.nextInt();
        }
        if (vet.pesquisaMes(mesmes) != null) {
            for (int i = 0; i < pessoas.getQuant(); i++) {
                System.out.println(pessoas.getPessoa(i).getNome());
            }
        } else {
            System.out.println("Nenhum aniversariante!");
        }

    }
}
