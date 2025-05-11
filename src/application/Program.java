    package application;

    import entities.Produto;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;
    import java.util.Scanner;

    public class Program {
        public static void main(String[] args) {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            List<Produto> list = new ArrayList<>();

            int opcao;

            System.out.println("------ SISTEMA DE PRODUTOS ------");

            do {
                System.out.println();

                System.out.println("MENU");
                System.out.println("1 - Cadastrar Produto");
                System.out.println("2 - Atualizar Produto");
                System.out.println("3 - Remover Produto");
                System.out.println("4 - Listar Produtos");
                System.out.println("5 - Sair");

                System.out.println();

                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();

                System.out.println();

                switch (opcao){
                    case 1:
                        System.out.println("--- CADASTRO DE PRODUTO ---");

                        System.out.print("ID: ");
                        int id = sc.nextInt();

                        while (temId(list, id)){
                            System.out.print("ID Existente! Tente Novamente: ");
                            id = sc.nextInt();
                        }

                        System.out.print("Nome: ");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();

                        while (preco <= 0){
                            System.out.println("Preço Inválido! Tente Novamente!");
                            System.out.print("Preço: ");
                            preco = sc.nextDouble();
                        }

                        Produto produto = new Produto(id, nome, preco);

                        list.add(produto);

                        System.out.println();
                        System.out.println("* PRODUTO CADASTRADO COM SUCESSO *");
                    break;

                    case 2:
                        System.out.println("--- ATUALIZAR PRODUTO ---");

                        System.out.print("ID do produto: ");
                        int idBuscaProdutoAtualizar = sc.nextInt();

                        Produto pAtualizar = list.stream().filter(x -> x.getId() == idBuscaProdutoAtualizar).findFirst().orElse(null);

                        System.out.println();

                        if (pAtualizar != null){
                            System.out.println(pAtualizar);
                            System.out.println();

                            System.out.print("Deseja atualizar o nome desse produto? (s/n) ");
                            char respNome = ' ';

                            while (respNome != 's' && respNome != 'n'){
                                respNome = sc.next().charAt(0);
                                sc.nextLine();

                                if (respNome != 's' && respNome != 'n'){
                                    System.out.println("Resposta Inválida! Digite 's' para sim ou 'n' para não!");
                                    System.out.print("Tente Novamente: ");
                                }
                            }

                            if (respNome == 's'){
                                System.out.print("Informe o novo nome do produto: ");
                                String novoNome = sc.nextLine();

                                pAtualizar.setNome(novoNome);

                                System.out.println();
                                System.out.println("* NOME ATUALIZADO *");

                            }

                            System.out.println();
                            System.out.print("Deseja atualizar o preço desse produto? (s/n) ");
                            char respPreco = ' ';

                            while (respPreco != 's' && respPreco != 'n'){
                                respPreco = sc.next().charAt(0);
                                sc.nextLine();
                                if (respPreco != 's' && respPreco != 'n' ){
                                    System.out.println("Resposta Inválida! Digite 's' para sim ou 'n' para não!");
                                    System.out.print("Tente Novamente: ");
                                }
                            }


                            if (respPreco == 's'){
                                System.out.print("Informe o novo preço do produto: ");
                                double novoPreco = sc.nextDouble();

                                while (novoPreco <= 0){
                                    System.out.println("Preço Inválido! Tente Novamente!");
                                    System.out.print("Preço: ");
                                    novoPreco = sc.nextDouble();
                                }


                                pAtualizar.setPreco(novoPreco);

                                System.out.println();
                                System.out.println("* PREÇO ATUALIZADO *");
                            }
                        } else {
                            System.out.println("Erro: ID não existente!");
                        }
                    break;

                    case 3:
                        System.out.println("--- REMOÇÃO DE PRODUTO ---");

                        System.out.print("Informe o ID do produto que quer remover: ");
                        int idBuscaProdutoRemover = sc.nextInt();

                        System.out.println();

                        Produto pRemover = list.stream().filter(x -> x.getId() == idBuscaProdutoRemover).findFirst().orElse(null);


                        if (pRemover != null){
                            System.out.println(pRemover);
                            System.out.println();
                            System.out.print("Deseja remover esse produto? (s/n) ");
                            char respRemover = ' ';

                            while (respRemover != 's' && respRemover != 'n'){
                                respRemover = sc.next().charAt(0);
                                if (respRemover != 's' && respRemover != 'n' ){
                                    System.out.println("Resposta Inválida! Digite 's' para sim ou 'n' para não!");
                                    System.out.print("Tente Novamente: ");
                                }
                            }

                            if (respRemover == 's'){
                                list.remove(pRemover);
                                System.out.println();
                                System.out.println("* PRODUTO REMOVIDO COM SUCESSO *");
                            }
                        } else {
                            System.out.println("Erro: ID não existente!");
                        }
                    break;

                    case 4:
                        System.out.println("--- LISTA DE PRODUTOS ---");
                        System.out.println();

                        if (list.isEmpty()){
                            System.out.println("Nenhum Produto Cadastrado!");
                        }else {
                            for (Produto pListar : list) {
                                System.out.println(pListar);
                            }
                        }
                    break;

                    case 5:
                        System.out.println("Encerrando Sistema de Produtos....");
                    break;

                    default:
                        System.out.println("Opção Inválida! Tente Novamente!");
                }
            }while (opcao != 5);

        }
        public static Boolean temId(List<Produto> list, int id){
            Produto produto = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
            return produto != null;
        }
    }
