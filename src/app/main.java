package app;

import dao.CategoriaDAO;
import dao.ClienteDAO;
import java.util.Scanner;
import model.Categoria;
import model.Cliente;
import dao.ContasPagarDAO;
import model.ContasPagar;
import dao.ContasReceberDAO;
import model.ContasReceber;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ContasPagarDAO contasPagarDAO = new ContasPagarDAO();
        ContasReceberDAO contasReceberDAO = new ContasReceberDAO();

        int opPrincipal;

        do {

            System.out.println("1 - Categoria");
            System.out.println("2 - Cliente");
            System.out.println("3 - Contas a Pagar");
            System.out.println("4 - Contas a Receber");
            System.out.println("0 - Sair");

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

                                categoriaDAO.listar().forEach(c
                                        -> System.out.println(
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

                                clienteDAO.listar().forEach(c
                                        -> System.out.println(
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

                case 3:

                    int opContas;

                    do {

                        System.out.println("\n=== MENU CONTAS A PAGAR ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opContas = sc.nextInt();
                        sc.nextLine();

                        switch (opContas) {

                            case 1:

                                contasPagarDAO.listar().forEach(cp
                                        -> System.out.println(
                                                "ID: " + cp.getId()
                                                + " | Valor: " + cp.getValor()
                                                + " | Data: " + cp.getData()
                                                + " | Status: " + cp.getStatus()
                                                + " | ID Fornecedor: " + cp.getId_fornecedor()
                                        )
                                );

                                break;

                            case 2:

                                ContasPagar novaConta = new ContasPagar();

                                System.out.print("Valor: ");
                                novaConta.setValor(sc.nextFloat());
                                sc.nextLine();

                                System.out.print("Data: ");
                                novaConta.setData(sc.nextLine());

                                System.out.print("Status: ");
                                novaConta.setStatus(sc.nextLine());

                                System.out.print("ID do fornecedor: ");
                                novaConta.setId_fornecedor(sc.nextInt());
                                sc.nextLine();

                                contasPagarDAO.inserir(novaConta);

                                System.out.println("Conta cadastrada!");
                                break;

                            case 3:

                                ContasPagar editarConta = new ContasPagar();

                                System.out.print("ID da conta: ");
                                editarConta.setId(sc.nextInt());
                                sc.nextLine();

                                System.out.print("Valor: ");
                                editarConta.setValor(sc.nextFloat());
                                sc.nextLine();

                                System.out.print("Data: ");
                                editarConta.setData(sc.nextLine());

                                System.out.print("Status: ");
                                editarConta.setStatus(sc.nextLine());

                                System.out.print("ID do fornecedor: ");
                                editarConta.setId_fornecedor(sc.nextInt());
                                sc.nextLine();

                                contasPagarDAO.atualizar(editarConta);

                                System.out.println("Conta atualizada!");
                                break;

                            case 4:

                                System.out.print("ID da conta: ");
                                int idConta = sc.nextInt();

                                contasPagarDAO.deletar(idConta);

                                System.out.println("Conta removida!");
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }

                    } while (opContas != 0);

                    break;

                case 4:

                    int opReceber;

                    do {

                        System.out.println("\n=== MENU CONTAS A RECEBER ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");

                        opReceber = sc.nextInt();
                        sc.nextLine();

                        switch (opReceber) {

                            case 1:

                                contasReceberDAO.listar().forEach(cr
                                        -> System.out.println(
                                                "ID: " + cr.getId()
                                                + " | Valor: " + cr.getValor()
                                                + " | Data Vencimento: " + cr.getData_vencimento()
                                                + " | Item Venda ID: " + cr.getId_item_venda()
                                        )
                                );

                                break;

                            case 2:

                                ContasReceber novaReceber = new ContasReceber();

                                System.out.print("Valor: ");
                                novaReceber.setValor(sc.nextFloat());
                                sc.nextLine();

                                System.out.print("Data de vencimento: ");
                                novaReceber.setData_vencimento(sc.nextLine());

                                System.out.print("ID Item Venda: ");
                                novaReceber.setId_item_venda(sc.nextInt());
                                sc.nextLine();

                                contasReceberDAO.inserir(novaReceber);

                                System.out.println("Conta cadastrada!");
                                break;

                            case 3:

                                ContasReceber editarReceber = new ContasReceber();

                                System.out.print("ID: ");
                                editarReceber.setId(sc.nextInt());
                                sc.nextLine();

                                System.out.print("Valor: ");
                                editarReceber.setValor(sc.nextFloat());
                                sc.nextLine();

                                System.out.print("Data de vencimento: ");
                                editarReceber.setData_vencimento(sc.nextLine());

                                System.out.print("ID Item Venda: ");
                                editarReceber.setId_item_venda(sc.nextInt());
                                sc.nextLine();

                                contasReceberDAO.atualizar(editarReceber);

                                System.out.println("Conta atualizada!");
                                break;

                            case 4:

                                System.out.print("ID da conta: ");
                                int idReceber = sc.nextInt();

                                contasReceberDAO.deletar(idReceber);

                                System.out.println("Conta removida!");
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }

                    } while (opReceber != 0);

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
