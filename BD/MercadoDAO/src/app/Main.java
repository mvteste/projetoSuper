package app;

import dao.ClientesDAO;
import dao.Conexao;
import dao.FornecedorDAO;
import dao.FuncionariosDAO;
import dao.Cargo_FuncionarioDAO;
import dao.ContratosDAO;
import dao.Pedido_CompraDAO;
import dao.CaixaDAO; 
import dao.Contas_PagarDAO; 
import java.sql.Connection;
import java.util.Scanner;
import model.Clientes;
import model.Fornecedor;
import model.Funcionarios;
import model.Cargo_Funcionario;
import model.Contratos;
import model.Pedido_Compra;
import model.Caixa; 
import model.Contas_Pagar; 

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ClientesDAO clienteDAO = new ClientesDAO();
        FuncionariosDAO funcionarioDAO = new FuncionariosDAO();
        Cargo_FuncionarioDAO cargoDAO = new Cargo_FuncionarioDAO();
        ContratosDAO contratoDAO = new ContratosDAO();
        Pedido_CompraDAO pedidoCompraDAO = new Pedido_CompraDAO();
        CaixaDAO caixaDAO = new CaixaDAO(); 
        Contas_PagarDAO contasPagarDAO = new Contas_PagarDAO(); 

        int op;

        do {

            System.out.println("\n===== SISTEMA =====");
            System.out.println("1 - Testar conexão");
            System.out.println("2 - Menu Fornecedor");
            System.out.println("3 - Menu Cliente");
            System.out.println("4 - Menu Funcionário");
            System.out.println("5 - Menu Cargo");
            System.out.println("6 - Menu Contratos");
            System.out.println("7 - Menu Pedido de Compra");
            System.out.println("8 - Menu Caixa"); 
            System.out.println("9 - Menu Contas a Pagar"); 
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    try {
                        Connection conn = Conexao.conectar();

                        if (conn != null) {
                            System.out.println("Conectado com sucesso!");
                            conn.close();
                        }

                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    menuFornecedor(sc, fornecedorDAO);
                    break;

                case 3:
                    menuCliente(sc, clienteDAO);
                    break;

                case 4:
                    menuFuncionario(sc, funcionarioDAO);
                    break;

                case 5:
                    menuCargo(sc, cargoDAO);
                    break;

                case 6:
                    menuContratos(sc, contratoDAO);
                    break;

                case 7:
                    menuPedidoCompra(sc, pedidoCompraDAO);
                    break;

                case 8:
                    menuCaixa(sc, caixaDAO); 
                    break;

                case 9:
                    menuContasPagar(sc, contasPagarDAO); 
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (op != 0);

        sc.close();
    }

    public static void menuFornecedor(Scanner sc, FornecedorDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU FORNECEDOR ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Editar");
            System.out.println("3 - Listar");
            System.out.println("4 - Desativar");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Fornecedor f = new Fornecedor();

                    System.out.print("Nome: ");
                    f.setNome(sc.nextLine());

                    System.out.print("CNPJ: ");
                    f.setCnpj(sc.nextLine());

                    System.out.print("Email: ");
                    f.setEmail(sc.nextLine());

                    System.out.print("Endereço: ");
                    f.setEndereco(sc.nextLine());

                    dao.inserir(f);
                    break;

                case 2:
                    f = new Fornecedor();

                    System.out.print("ID: ");
                    f.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    f.setNome(sc.nextLine());

                    System.out.print("Novo CNPJ: ");
                    f.setCnpj(sc.nextLine());

                    System.out.print("Novo email: ");
                    f.setEmail(sc.nextLine());

                    System.out.print("Novo endereço: ");
                    f.setEndereco(sc.nextLine());

                    dao.editar(f);
                    break;

                case 3:
                    dao.listar().forEach(fornecedor ->
                        System.out.println(
                            fornecedor.getId() + " - " +
                            fornecedor.getNome() + " - " +
                            fornecedor.getCnpj() + " - " +
                            fornecedor.getEmail() + " - " +
                            fornecedor.getEndereco() + " - " +
                            fornecedor.getStatus()
                        )
                    );
                    break;

                case 4:
                    f = new Fornecedor();

                    System.out.print("ID do fornecedor: ");
                    f.setId(sc.nextInt());

                    dao.desativar(f);
                    break;
            }

        } while (op != 0);
    }

    public static void menuCliente(Scanner sc, ClientesDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Editar");
            System.out.println("3 - Listar");
            System.out.println("4 - Desativar");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Clientes c = new Clientes();

                    System.out.print("Nome: ");
                    c.setNome(sc.nextLine());

                    System.out.print("Data de nascimento: ");
                    c.setData_nascimento(sc.nextLine());

                    System.out.print("CPF: ");
                    c.setCpf(sc.nextLine());

                    System.out.print("Telefone: ");
                    c.setTelefone(sc.nextLine());

                    dao.inserir(c);
                    break;

                case 2:
                    c = new Clientes();

                    System.out.print("ID: ");
                    c.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    c.setNome(sc.nextLine());

                    System.out.print("Nova data de nascimento: ");
                    c.setData_nascimento(sc.nextLine());

                    System.out.print("Novo CPF: ");
                    c.setCpf(sc.nextLine());

                    System.out.print("Novo telefone: ");
                    c.setTelefone(sc.nextLine());

                    dao.editar(c);
                    break;

                case 3:
                    dao.listar().forEach(cliente ->
                        System.out.println(
                            cliente.getId() + " - " +
                            cliente.getNome() + " - " +
                            cliente.getData_nascimento() + " - " +
                            cliente.getCpf() + " - " +
                            cliente.getTelefone() + " - " +
                            cliente.getStatus()
                        )
                    );
                    break;

                case 4:
                    c = new Clientes();

                    System.out.print("ID do cliente: ");
                    c.setId(sc.nextInt());

                    dao.desativar(c);
                    break;
            }

        } while (op != 0);
    }

    public static void menuFuncionario(Scanner sc, FuncionariosDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU FUNCIONÁRIO ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Editar");
            System.out.println("3 - Listar");
            System.out.println("4 - Desativar");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Funcionarios func = new Funcionarios();

                    System.out.print("Nome: ");
                    func.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    func.setCpf(sc.nextLine());

                    System.out.print("Telefone: ");
                    func.setTelefone(sc.nextLine());

                    System.out.print("Email: ");
                    func.setEmail(sc.nextLine());

                    System.out.print("Endereço: ");
                    func.setEndereco(sc.nextLine());

                    System.out.print("Data de Admissão: ");
                    func.setData_admissao(sc.nextLine());

                    System.out.print("Data de Nascimento: ");
                    func.setData_nascimento(sc.nextLine());
                    
                    System.out.print("ID do Cargo do Funcionário: ");
                    Cargo_Funcionario cargoIns = new Cargo_Funcionario();
                    cargoIns.setId(sc.nextInt());
                    func.setCargo_funcionario(cargoIns);

                    dao.inserir(func);
                    break;

                case 2:
                    func = new Funcionarios();

                    System.out.print("ID do Funcionário: ");
                    func.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    func.setNome(sc.nextLine());

                    System.out.print("Novo CPF: ");
                    func.setCpf(sc.nextLine());

                    System.out.print("Novo telefone: ");
                    func.setTelefone(sc.nextLine());

                    System.out.print("Novo email: ");
                    func.setEmail(sc.nextLine());

                    System.out.print("Novo endereço: ");
                    func.setEndereco(sc.nextLine());

                    System.out.print("Nova data de admissão: ");
                    func.setData_admissao(sc.nextLine());

                    System.out.print("Nova data de nascimento: ");
                    func.setData_nascimento(sc.nextLine());
                    
                    System.out.print("Novo ID do Cargo: ");
                    Cargo_Funcionario cargoEdit = new Cargo_Funcionario();
                    cargoEdit.setId(sc.nextInt());
                    func.setCargo_funcionario(cargoEdit);

                    dao.editar(func);
                    break;

                case 3:
                    dao.listar().forEach(funcionario ->
                        System.out.println(
                            funcionario.getId() + " - " +
                            funcionario.getNome() + " - " +
                            funcionario.getCpf() + " - " +
                            funcionario.getTelefone() + " - " +
                            funcionario.getEmail() + " - " +
                            funcionario.getEndereco() + " - " +
                            funcionario.getData_admissao() + " - " +
                            funcionario.getData_nascimento() + " - " +
                            "Cargo: " + (funcionario.getCargo_funcionario() != null ? funcionario.getCargo_funcionario().getNome() : "Sem Cargo") + " - " +
                            funcionario.getStatus()
                        )
                    );
                    break;

                case 4:
                    func = new Funcionarios();

                    System.out.print("ID do funcionário a desativar: ");
                    func.setId(sc.nextInt());

                    dao.desativar(func);
                    break;
            }

        } while (op != 0);
    }

    public static void menuCargo(Scanner sc, Cargo_FuncionarioDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU CARGO ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Editar");
            System.out.println("3 - Listar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Cargo_Funcionario cargo = new Cargo_Funcionario();

                    System.out.print("Nome do Cargo: ");
                    cargo.setNome(sc.nextLine());

                    System.out.print("Descrição: ");
                    cargo.setDescricao(sc.nextLine());

                    dao.inserir(cargo);
                    break;

                case 2:
                    cargo = new Cargo_Funcionario();

                    System.out.print("ID do Cargo: ");
                    cargo.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo Nome: ");
                    cargo.setNome(sc.nextLine());

                    System.out.print("Nova Descrição: ");
                    cargo.setDescricao(sc.nextLine());

                    dao.editar(cargo);
                    break;

                case 3:
                    dao.listar().forEach(c -> 
                        System.out.println(
                            c.getId() + " - " + 
                            c.getNome() + " - " + 
                            c.getDescricao()
                        )
                    );
                    break;

                case 4:
                    cargo = new Cargo_Funcionario();

                    System.out.print("ID do Cargo a deletar: ");
                    cargo.setId(sc.nextInt());

                    dao.deletar(cargo);
                    break;
            }

        } while (op != 0);
    }

    public static void menuContratos(Scanner sc, ContratosDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU CONTRATOS ===");
            System.out.println("1 - Registrar Contrato");
            System.out.println("2 - Editar Contrato");
            System.out.println("3 - Listar Contratos");
            System.out.println("4 - Remover Contrato");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Cargo_Funcionario cg = new Cargo_Funcionario();
                    Funcionarios fn = new Funcionarios();

                    System.out.print("ID do Cargo: ");
                    cg.setId(sc.nextInt());

                    System.out.print("ID do Funcionário: ");
                    fn.setId(sc.nextInt());

                    System.out.print("Salário (ex: 2500,50): ");
                    double salario = sc.nextDouble();
                    sc.nextLine(); 

                    System.out.print("Data de Início (AAAA-MM-DD): ");
                    String inicio = sc.nextLine();

                    System.out.print("Data de Fim (AAAA-MM-DD ou deixe em branco): ");
                    String fim = sc.nextLine();

                    Contratos novoContrato = new Contratos(cg, fn, salario, inicio, fim);
                    dao.inserir(novoContrato);
                    break;

                case 2:
                    cg = new Cargo_Funcionario();
                    fn = new Funcionarios();

                    System.out.println("-- Identificadores do Contrato a ser Alterado --");
                    System.out.print("ID do Cargo Atual: ");
                    cg.setId(sc.nextInt());

                    System.out.print("ID do Funcionário Current: ");
                    fn.setId(sc.nextInt());

                    System.out.print("Novo Salário: ");
                    double novoSalario = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nova Data de Início (AAAA-MM-DD): ");
                    String novoInicio = sc.nextLine();

                    System.out.print("Nova Data de Fim (AAAA-MM-DD): ");
                    String novoFim = sc.nextLine();

                    Contratos contratoEditado = new Contratos(cg, fn, novoSalario, novoInicio, novoFim);
                    dao.editar(contratoEditado);
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE CONTRATOS ATIVOS ---");
                    dao.listar().forEach(con -> 
                        System.out.println(
                            "Cargo: (" + con.getCargo_funcionario().getId() + ") " + con.getCargo_funcionario().getNome() + " | " +
                            "Func.: (" + con.getFuncionario().getId() + ") " + con.getFuncionario().getNome() + " | " +
                            "Salário: R$ " + con.getSalario() + " | " +
                            "Vigência: " + con.getData_inicio() + " até " + (con.getData_fim() == null || con.getData_fim().isEmpty() ? "Atual" : con.getData_fim())
                        )
                    );
                    break;

                case 4:
                    cg = new Cargo_Funcionario();
                    fn = new Funcionarios();

                    System.out.println("-- Identificadores para Remoção --");
                    System.out.print("ID do Cargo do Contrato: ");
                    cg.setId(sc.nextInt());

                    System.out.print("ID do Funcionário do Contrato: ");
                    fn.setId(sc.nextInt());

                    Contratos contratoDeletar = new Contratos(cg, fn, 0, "", "");
                    dao.deletar(contratoDeletar);
                    break;
            }

        } while (op != 0);
    }

    public static void menuPedidoCompra(Scanner sc, Pedido_CompraDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU PEDIDO DE COMPRA ===");
            System.out.println("1 - Registrar Pedido");
            System.out.println("2 - Editar Pedido");
            System.out.println("3 - Listar Pedidos");
            System.out.println("4 - Remover Pedido");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Pedido_Compra p = new Pedido_Compra();
                    Fornecedor f = new Fornecedor();

                    System.out.print("Quantidade de Itens: ");
                    p.setQuantidade(sc.nextInt());

                    System.out.print("Valor Total (ex: 1500,75): ");
                    p.setTotal(sc.nextDouble());

                    System.out.print("ID do Fornecedor: ");
                    f.setId(sc.nextInt());
                    p.setFornecedor(f);

                    dao.inserir(p);
                    break;

                case 2:
                    p = new Pedido_Compra();
                    f = new Fornecedor();

                    System.out.print("ID do Pedido a ser editado: ");
                    p.setId(sc.nextInt());

                    System.out.print("Nova Quantidade de Itens: ");
                    p.setQuantidade(sc.nextInt());

                    System.out.print("Novo Valor Total: ");
                    p.setTotal(sc.nextDouble());

                    System.out.print("Novo ID do Fornecedor: ");
                    f.setId(sc.nextInt());
                    p.setFornecedor(f);

                    dao.editar(p);
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE PEDIDOS DE COMPRA ---");
                    dao.listar().forEach(pedido -> 
                        System.out.println(
                            "ID Pedido: " + pedido.getId() + " | " + 
                            "Qtd: " + pedido.getQuantidade() + " | " + 
                            "Total: R$ " + pedido.getTotal() + " | " + 
                            "Fornecedor: (" + pedido.getFornecedor().getId() + ") " + pedido.getFornecedor().getNome()
                        )
                    );
                    break;

                case 4:
                    p = new Pedido_Compra();

                    System.out.print("ID do Pedido a ser removido: ");
                    p.setId(sc.nextInt());

                    dao.deletar(p);
                    break;
            }

        } while (op != 0);
    }

    public static void menuCaixa(Scanner sc, CaixaDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU CAIXA ===");
            System.out.println("1 - Inserir Caixa");
            System.out.println("2 - Editar Caixa");
            System.out.println("3 - Listar Caixas");
            System.out.println("4 - Deletar Caixa");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Caixa cx = new Caixa();

                    System.out.print("Nome do Caixa (ex: Caixa Principal): ");
                    cx.setNome(sc.nextLine());

                    System.out.print("Valor Inicial: ");
                    cx.setValor(sc.nextDouble());
                    sc.nextLine();

                    dao.inserir(cx);
                    break;

                case 2:
                    cx = new Caixa();

                    System.out.print("ID do Caixa a ser editado: ");
                    cx.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo Nome do Caixa: ");
                    cx.setNome(sc.nextLine());

                    System.out.print("Novo Valor: ");
                    cx.setValor(sc.nextDouble());
                    sc.nextLine();

                    dao.editar(cx);
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE CAIXAS ---");
                    dao.listar().forEach(caixa -> 
                        System.out.println(
                            "ID Caixa: " + caixa.getId() + " | " + 
                            "Nome: " + caixa.getNome() + " | " + 
                            "Valor: R$ " + caixa.getValor()
                        )
                    );
                    break;

                case 4:
                    cx = new Caixa();

                    System.out.print("ID do Caixa a ser removido: ");
                    cx.setId(sc.nextInt());
                    sc.nextLine();

                    dao.deletar(cx);
                    break;
            }

        } while (op != 0);
    }

   public static void menuContasPagar(Scanner sc, Contas_PagarDAO dao) {

        int op;

        do {
            System.out.println("\n=== MENU CONTAS A PAGAR ===");
            System.out.println("1 - Registrar Conta a Pagar");
            System.out.println("2 - Editar Conta a Pagar");
            System.out.println("3 - Listar Contas a Pagar");
            System.out.println("4 - Remover Conta a Pagar");
            System.out.println("5 - Pagar Conta (Baixa no Caixa)"); // Adicionado aqui
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Contas_Pagar cp = new Contas_Pagar();
                    Caixa cx = new Caixa();
                    Pedido_Compra pc = new Pedido_Compra();

                    System.out.print("Nome da Conta (Descrição): ");
                    cp.setNome(sc.nextLine());

                    System.out.print("Valor da Conta (ex: 350,90): ");
                    cp.setValor(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Data de Vencimento (AAAA-MM-DD): ");
                    cp.setData_vencimento(sc.nextLine());

                    System.out.print("ID do Caixa Vinculado: ");
                    cx.setId(sc.nextInt());
                    cp.setCaixa(cx);

                    System.out.print("ID do Pedido de Compra (Digite 0 se não houver): ");
                    int idPedido = sc.nextInt();

                    if (idPedido > 0) {
                        pc.setId(idPedido);
                        cp.setPedido_compra(pc);
                    } else {
                        cp.setPedido_compra(null);
                    }

                    dao.inserir(cp);
                    break;

                case 2:
                    cp = new Contas_Pagar();
                    cx = new Caixa();
                    pc = new Pedido_Compra();

                    System.out.print("ID da Conta a ser editada: ");
                    cp.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Novo Nome da Conta: ");
                    cp.setNome(sc.nextLine());

                    System.out.print("Novo Valor: ");
                    cp.setValor(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Nova Data de Vencimento (AAAA-MM-DD): ");
                    cp.setData_vencimento(sc.nextLine());

                    System.out.print("Novo ID do Caixa Vinculado: ");
                    cx.setId(sc.nextInt());
                    cp.setCaixa(cx);

                    System.out.print("Novo ID do Pedido de Compra (Digite 0 se não houver): ");
                    int idPedidoEdit = sc.nextInt();

                    if (idPedidoEdit > 0) {
                        pc.setId(idPedidoEdit);
                        cp.setPedido_compra(pc);
                    } else {
                        cp.setPedido_compra(null);
                    }

                    dao.editar(cp);
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE CONTAS A PAGAR ---");
                    dao.listar().forEach(conta -> {
                        String infoPedido = (conta.getPedido_compra() != null) 
                                ? " | Pedido Compra ID: " + conta.getPedido_compra().getId() 
                                : " | Pedido Compra: Nenhum";
                        
                        String statusTexto = (conta.getStatus() == 2) ? "PAGA" : "PENDENTE";
                        
                        System.out.println(
                            "ID: " + conta.getId() + " | " +
                            "Descrição: " + conta.getNome() + " | " +
                            "Valor: R$ " + conta.getValor() + " | " +
                            "Vencimento: " + conta.getData_vencimento() + " | " +
                            "Status: " + statusTexto + " | " +
                            "Caixa: " + conta.getCaixa().getNome() +
                            infoPedido
                        );
                    });
                    break;

                case 4:
                    cp = new Contas_Pagar();

                    System.out.print("ID da Conta a ser removida: ");
                    cp.setId(sc.nextInt());
                    
                    dao.deletar(cp);
                    break;

                case 5: // Nova lógica adicionada para executar o método
                    System.out.print("Digite o ID da conta que deseja pagar: ");
                    int idContaPagar = sc.nextInt();
                    sc.nextLine();

                    dao.pagarConta(idContaPagar);
                    break;
            }

        } while (op != 0);
    }
}