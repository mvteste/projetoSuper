package app;

import dao.CategoriaDAO;
import dao.ClienteDAO;
import java.util.Scanner;
import model.Categoria;
import model.Cliente;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        int opPrincipal;

        do {

            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Categoria");
            System.out.println("2 - Cliente");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opPrincipal) {

                case 1:

                    int opCategoria;

                    do {

                        System.out.println("\n=== MENU CATEGORIA ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opCategoria = sc.nextInt();
                        sc.nextLine();

                        switch (opCategoria) {

                            case 1:

                                categoriaDAO.listar().forEach(c ->
                                        System.out.println(
                                                "ID: " + c.getId()
                                                + " | Nome: " + c.getNome()
                                        )
                                );

                                break;

                            case 2:

                                Categoria nova = new Categoria();

                                System.out.print("Nome da categoria: ");
                                nova.setNome(sc.nextLine());

                                categoriaDAO.inserir(nova);

                                System.out.println("Categoria cadastrada!");
                                break;

                            case 3:

                                Categoria editar = new Categoria();

                                System.out.print("ID: ");
                                editar.setId(sc.nextInt());
                                sc.nextLine();

                                System.out.print("Novo nome: ");
                                editar.setNome(sc.nextLine());

                                categoriaDAO.atualizar(editar);

                                System.out.println("Categoria atualizada!");
                                break;

                            case 4:

                                System.out.print("ID da categoria: ");
                                int id = sc.nextInt();

                                categoriaDAO.deletar(id);

                                System.out.println("Categoria removida!");
                                break;
                        }

                    } while (opCategoria != 0);

                    break;

                case 2:

                    int opCliente;

                    do {

                        System.out.println("\n=== MENU CLIENTE ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opCliente = sc.nextInt();
                        sc.nextLine();

                        switch (opCliente) {

                            case 1:

                                clienteDAO.listar().forEach(c ->
                                        System.out.println(
                                                "ID: " + c.getId()
                                                + " | Nome: " + c.getNome()
                                                + " | Cidade: " + c.getCidade()
                                                + " | CEP: " + c.getCep()
                                                + " | CPF: " + c.getCpf()
                                                + " | Telefone: " + c.getTelefone()
                                                + " | Email: " + c.getEmail()
                                        )
                                );

                                break;

                            case 2:

                                Cliente novo = new Cliente();

                                System.out.print("Nome: ");
                                novo.setNome(sc.nextLine());

                                System.out.print("Cidade: ");
                                novo.setCidade(sc.nextLine());

                                System.out.print("CEP: ");
                                novo.setCep(sc.nextLine());

                                System.out.print("CPF: ");
                                novo.setCpf(sc.nextLine());

                                System.out.print("Telefone: ");
                                novo.setTelefone(sc.nextLine());

                                System.out.print("Email: ");
                                novo.setEmail(sc.nextLine());

                                clienteDAO.inserir(novo);

                                System.out.println("Cliente cadastrado!");
                                break;

                            case 3:

                                Cliente editar = new Cliente();

                                System.out.print("ID: ");
                                editar.setId(sc.nextInt());
                                sc.nextLine();

                                System.out.print("Nome: ");
                                editar.setNome(sc.nextLine());

                                System.out.print("Cidade: ");
                                editar.setCidade(sc.nextLine());

                                System.out.print("CEP: ");
                                editar.setCep(sc.nextLine());

                                System.out.print("CPF: ");
                                editar.setCpf(sc.nextLine());

                                System.out.print("Telefone: ");
                                editar.setTelefone(sc.nextLine());

                                System.out.print("Email: ");
                                editar.setEmail(sc.nextLine());

                                clienteDAO.atualizar(editar);

                                System.out.println("Cliente atualizado!");
                                break;

                            case 4:

                                System.out.print("ID do cliente: ");
                                int id = sc.nextInt();

                                clienteDAO.deletar(id);

                                System.out.println("Cliente removido!");
                                break;
                        }

                    } while (opCliente != 0);

                    break;

                case 0:

                    System.out.println("Programa encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opPrincipal != 0);

        sc.close();
    }
}