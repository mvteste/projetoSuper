package app;

import controller.CategoriaController;
import controller.ClienteController;
import controller.ContasPagarController;
import controller.ContasReceberController;
import controller.ContratoTrabController;
import controller.EstoqueController;
import controller.FornecedorController;
import controller.FuncionarioController;
import controller.ItemVendaController;
import controller.PagamentoController;
import controller.ProdutoController;
import controller.TipoFuncionarioController;
import controller.VendaController;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CategoriaController       categoriaController     = new CategoriaController();
        ClienteController         clienteController       = new ClienteController();
        ContasPagarController     contasPagarController   = new ContasPagarController();
        ContasReceberController   contasReceberController = new ContasReceberController();
        ContratoTrabController    contratoController      = new ContratoTrabController();
        EstoqueController         estoqueController       = new EstoqueController();
        FornecedorController      fornecedorController    = new FornecedorController();
        FuncionarioController     funcionarioController   = new FuncionarioController();
        ItemVendaController       itemVendaController     = new ItemVendaController();
        PagamentoController       pagamentoController     = new PagamentoController();
        ProdutoController         produtoController       = new ProdutoController();
        TipoFuncionarioController tipoFuncController      = new TipoFuncionarioController();
        VendaController           vendaController         = new VendaController();

        int opPrincipal;

        do {

            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1  - Categoria");
            System.out.println("2  - Cliente");
            System.out.println("3  - Contas a Pagar");
            System.out.println("4  - Contas a Receber");
            System.out.println("5  - Contrato de Trabalho");
            System.out.println("6  - Estoque");
            System.out.println("7  - Fornecedor");
            System.out.println("8  - Funcionário");
            System.out.println("9  - Item de Venda");
            System.out.println("10 - Pagamento");
            System.out.println("11 - Produto");
            System.out.println("12 - Tipo de Funcionário");
            System.out.println("13 - Venda");
            System.out.println("0  - Sair");
            System.out.print("Opção: ");

            opPrincipal = Integer.parseInt(sc.nextLine());

            switch (opPrincipal) {

                // ===================== CATEGORIA =====================
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
                        opCategoria = Integer.parseInt(sc.nextLine());

                        switch (opCategoria) {
                            case 1:
                                categoriaController.obterCategorias().forEach(c ->
                                    System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome())
                                );
                                break;
                            case 2:
                                System.out.print("Nome: ");
                                categoriaController.salvarCategoria(sc.nextLine());
                                System.out.println("Categoria cadastrada!");
                                break;
                            case 3:
                                System.out.print("ID: ");           int idCatAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Novo nome: ");    String novoNomeCat = sc.nextLine();
                                categoriaController.atualizarCategoria(idCatAtual, novoNomeCat);
                                System.out.println("Categoria atualizada!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                categoriaController.excluirCategoria(Integer.parseInt(sc.nextLine()));
                                System.out.println("Categoria removida!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opCategoria != 0);
                    break;

                // ===================== CLIENTE =====================
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
                        opCliente = Integer.parseInt(sc.nextLine());

                        switch (opCliente) {
                            case 1:
                                clienteController.obterClientes().forEach(c ->
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
                                System.out.print("Nome: ");      String nomeCliente = sc.nextLine();
                                System.out.print("CPF: ");       String cpfCliente = sc.nextLine();
                                System.out.print("Email: ");     String emailCliente = sc.nextLine();
                                System.out.print("Telefone: ");  String telCliente = sc.nextLine();
                                System.out.print("CEP: ");       String cepCliente = sc.nextLine();
                                System.out.print("Cidade: ");    String cidadeCliente = sc.nextLine();
                                clienteController.salvarCliente(nomeCliente, cpfCliente, emailCliente,
                                        telCliente, cepCliente, cidadeCliente);
                                System.out.println("Cliente cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");        int idCliAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Nome: ");      String nomeCliEdit = sc.nextLine();
                                System.out.print("Cidade: ");    String cidadeCliEdit = sc.nextLine();
                                System.out.print("CEP: ");       String cepCliEdit = sc.nextLine();
                                System.out.print("Telefone: ");  String telCliEdit = sc.nextLine();
                                System.out.print("CPF: ");       String cpfCliEdit = sc.nextLine();
                                System.out.print("Email: ");     String emailCliEdit = sc.nextLine();
                                clienteController.atualizarCliente(idCliAtual, nomeCliEdit, cidadeCliEdit,
                                        cepCliEdit, telCliEdit, cpfCliEdit, emailCliEdit);
                                System.out.println("Cliente atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                clienteController.excluirCliente(Integer.parseInt(sc.nextLine()));
                                System.out.println("Cliente removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opCliente != 0);
                    break;

                // ===================== CONTAS A PAGAR =====================
                case 3:
                    int opContasPagar;
                    do {
                        System.out.println("\n=== MENU CONTAS A PAGAR ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opContasPagar = Integer.parseInt(sc.nextLine());

                        switch (opContasPagar) {
                            case 1:
                                contasPagarController.obterContas().forEach(cp ->
                                    System.out.println(
                                        "ID: " + cp.getId()
                                        + " | Valor: " + cp.getValor()
                                        + " | Data: " + cp.getData()
                                        + " | Status: " + cp.getStatus()
                                        + " | ID Fornecedor: " + cp.getId_fornecedor()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Valor: ");          float valorCP = Float.parseFloat(sc.nextLine());
                                System.out.print("Data: ");           String dataCP = sc.nextLine();
                                System.out.print("ID Fornecedor: ");  int fornCP = Integer.parseInt(sc.nextLine());
                                System.out.print("Status: ");         String statusCP = sc.nextLine();
                                contasPagarController.salvarContas(valorCP, dataCP, fornCP, statusCP);
                                System.out.println("Conta cadastrada!");
                                break;
                            case 3:
                                System.out.print("ID: ");             int idCPAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Valor: ");          float valorCPEdit = Float.parseFloat(sc.nextLine());
                                System.out.print("Data: ");           String dataCPEdit = sc.nextLine();
                                System.out.print("ID Fornecedor: ");  int fornCPEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("Status: ");         String statusCPEdit = sc.nextLine();
                                contasPagarController.atualizarContas(idCPAtual, valorCPEdit, dataCPEdit,
                                        fornCPEdit, statusCPEdit);
                                System.out.println("Conta atualizada!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                contasPagarController.excluirContas(Integer.parseInt(sc.nextLine()));
                                System.out.println("Conta removida!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opContasPagar != 0);
                    break;

                // ===================== CONTAS A RECEBER =====================
                case 4:
                    int opContasReceber;
                    do {
                        System.out.println("\n=== MENU CONTAS A RECEBER ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opContasReceber = Integer.parseInt(sc.nextLine());

                        switch (opContasReceber) {
                            case 1:
                                contasReceberController.obterContas().forEach(cr ->
                                    System.out.println(
                                        "ID: " + cr.getId()
                                        + " | Valor: " + cr.getValor()
                                        + " | Data Vencimento: " + cr.getData_vencimento()
                                        + " | ID Item Venda: " + cr.getId_item_venda()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Valor: ");            float valorCR = Float.parseFloat(sc.nextLine());
                                System.out.print("Data Vencimento: ");  String dataCR = sc.nextLine();
                                System.out.print("ID Item Venda: ");    int itemCR = Integer.parseInt(sc.nextLine());
                                contasReceberController.salvarContas(valorCR, dataCR, itemCR);
                                System.out.println("Conta cadastrada!");
                                break;
                            case 3:
                                System.out.print("ID: ");               int idCRAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Valor: ");            float valorCREdit = Float.parseFloat(sc.nextLine());
                                System.out.print("Data Vencimento: ");  String dataCREdit = sc.nextLine();
                                System.out.print("ID Item Venda: ");    int itemCREdit = Integer.parseInt(sc.nextLine());
                                contasReceberController.atualizarContas(idCRAtual, valorCREdit, dataCREdit, itemCREdit);
                                System.out.println("Conta atualizada!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                contasReceberController.excluirConta(Integer.parseInt(sc.nextLine()));
                                System.out.println("Conta removida!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opContasReceber != 0);
                    break;

                // ===================== CONTRATO DE TRABALHO =====================
                case 5:
                    int opContrato;
                    do {
                        System.out.println("\n=== MENU CONTRATO DE TRABALHO ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opContrato = Integer.parseInt(sc.nextLine());

                        switch (opContrato) {
                            case 1:
                                contratoController.obterContratos().forEach(ct ->
                                    System.out.println(
                                        "ID: " + ct.getId()
                                        + " | Cargo: " + ct.getCargo()
                                        + " | Salário: " + ct.getSalario()
                                        + " | Início: " + ct.getData_inicio()
                                        + " | Fim: " + ct.getData_fim()
                                        + " | Tipo: " + ct.getTipo_contrato()
                                        + " | ID Funcionário: " + ct.getId_funcionario()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Cargo: ");          String cargoCT = sc.nextLine();
                                System.out.print("Salário: ");        float salarioCT = Float.parseFloat(sc.nextLine());
                                System.out.print("Data Início: ");    String inicioCT = sc.nextLine();
                                System.out.print("Data Fim: ");       String fimCT = sc.nextLine();
                                System.out.print("Tipo Contrato: ");  String tipoCT = sc.nextLine();
                                System.out.print("ID Funcionário: "); int funcCT = Integer.parseInt(sc.nextLine());
                                contratoController.salvarContrato(cargoCT, salarioCT, inicioCT, fimCT, tipoCT, funcCT);
                                System.out.println("Contrato cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");             int idCTAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Cargo: ");          String cargoCTEdit = sc.nextLine();
                                System.out.print("Salário: ");        float salarioCTEdit = Float.parseFloat(sc.nextLine());
                                System.out.print("Data Início: ");    String inicioCTEdit = sc.nextLine();
                                System.out.print("Data Fim: ");       String fimCTEdit = sc.nextLine();
                                System.out.print("Tipo Contrato: ");  String tipoCTEdit = sc.nextLine();
                                System.out.print("ID Funcionário: "); int funcCTEdit = Integer.parseInt(sc.nextLine());
                                contratoController.atualizarContrato(idCTAtual, cargoCTEdit, salarioCTEdit,
                                        inicioCTEdit, fimCTEdit, tipoCTEdit, funcCTEdit);
                                System.out.println("Contrato atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                contratoController.excluirContrato(Integer.parseInt(sc.nextLine()));
                                System.out.println("Contrato removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opContrato != 0);
                    break;

                // ===================== ESTOQUE =====================
                case 6:
                    int opEstoque;
                    do {
                        System.out.println("\n=== MENU ESTOQUE ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opEstoque = Integer.parseInt(sc.nextLine());

                        switch (opEstoque) {
                            case 1:
                                estoqueController.obterEstoques().forEach(e ->
                                    System.out.println(
                                        "ID: " + e.getId()
                                        + " | Quantidade: " + e.getQuantidade()
                                        + " | ID Produto: " + e.getProduto_id()
                                        + " | Validade: " + e.getData_validade()
                                        + " | Lote: " + e.getLote()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Quantidade: ");    int qtdEST = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Produto: ");    int prodEST = Integer.parseInt(sc.nextLine());
                                System.out.print("Data Validade: "); String valEST = sc.nextLine();
                                System.out.print("Lote: ");          String loteEST = sc.nextLine();
                                estoqueController.salvarEstoque(qtdEST, prodEST, valEST, loteEST);
                                System.out.println("Estoque cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");            int idESTAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Quantidade: ");    int qtdESTEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Produto: ");    int prodESTEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("Data Validade: "); String valESTEdit = sc.nextLine();
                                System.out.print("Lote: ");          String loteESTEdit = sc.nextLine();
                                estoqueController.atualizarEstoque(idESTAtual, qtdESTEdit, prodESTEdit,
                                        valESTEdit, loteESTEdit);
                                System.out.println("Estoque atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                estoqueController.excluirEstoque(Integer.parseInt(sc.nextLine()));
                                System.out.println("Estoque removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opEstoque != 0);
                    break;

                // ===================== FORNECEDOR =====================
                case 7:
                    int opFornecedor;
                    do {
                        System.out.println("\n=== MENU FORNECEDOR ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opFornecedor = Integer.parseInt(sc.nextLine());

                        switch (opFornecedor) {
                            case 1:
                                fornecedorController.obterFornecedores().forEach(f ->
                                    System.out.println(
                                        "ID: " + f.getId()
                                        + " | Nome: " + f.getNome()
                                        + " | CNPJ: " + f.getCnpj()
                                        + " | Telefone: " + f.getTelefone()
                                        + " | Email: " + f.getEmail()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Nome: ");      String nomeForn = sc.nextLine();
                                System.out.print("CNPJ: ");      String cnpjForn = sc.nextLine();
                                System.out.print("Email: ");     String emailForn = sc.nextLine();
                                System.out.print("Telefone: ");  String telForn = sc.nextLine();
                                fornecedorController.salvarFornecedor(nomeForn, cnpjForn, emailForn, telForn);
                                System.out.println("Fornecedor cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");        int idFornAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Nome: ");      String nomeFornEdit = sc.nextLine();
                                System.out.print("CNPJ: ");      String cnpjFornEdit = sc.nextLine();
                                System.out.print("Email: ");     String emailFornEdit = sc.nextLine();
                                System.out.print("Telefone: ");  String telFornEdit = sc.nextLine();
                                fornecedorController.atualizarFornecedor(idFornAtual, nomeFornEdit,
                                        cnpjFornEdit, emailFornEdit, telFornEdit);
                                System.out.println("Fornecedor atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                fornecedorController.excluirFornecedor(Integer.parseInt(sc.nextLine()));
                                System.out.println("Fornecedor removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opFornecedor != 0);
                    break;

                // ===================== FUNCIONÁRIO =====================
                case 8:
                    int opFuncionario;
                    do {
                        System.out.println("\n=== MENU FUNCIONÁRIO ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opFuncionario = Integer.parseInt(sc.nextLine());

                        switch (opFuncionario) {
                            case 1:
                                funcionarioController.obterFuncionarios().forEach(f ->
                                    System.out.println(
                                        "ID: " + f.getId()
                                        + " | Nome: " + f.getNome()
                                        + " | Nascimento: " + f.getData_nascimento()
                                        + " | Telefone: " + f.getTelefone()
                                        + " | ID Tipo: " + f.getId_tipoFuncionario()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Nome: ");            String nomeFunc = sc.nextLine();
                                System.out.print("Data Nascimento: "); String nascFunc = sc.nextLine();
                                System.out.print("Telefone: ");        String telFunc = sc.nextLine();
                                System.out.print("ID Tipo Func: ");    int tipoFunc = Integer.parseInt(sc.nextLine());
                                funcionarioController.salvarFuncionario(nomeFunc, nascFunc, telFunc, tipoFunc);
                                System.out.println("Funcionário cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");              int idFuncAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Nome: ");            String nomeFuncEdit = sc.nextLine();
                                System.out.print("Data Nascimento: "); String nascFuncEdit = sc.nextLine();
                                System.out.print("Telefone: ");        String telFuncEdit = sc.nextLine();
                                System.out.print("ID Tipo Func: ");    int tipoFuncEdit = Integer.parseInt(sc.nextLine());
                                funcionarioController.atualizarFuncionario(idFuncAtual, nomeFuncEdit,
                                        nascFuncEdit, telFuncEdit, tipoFuncEdit);
                                System.out.println("Funcionário atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                funcionarioController.excluirFuncionario(Integer.parseInt(sc.nextLine()));
                                System.out.println("Funcionário removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opFuncionario != 0);
                    break;

                // ===================== ITEM DE VENDA =====================
                case 9:
                    int opItemVenda;
                    do {
                        System.out.println("\n=== MENU ITEM DE VENDA ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opItemVenda = Integer.parseInt(sc.nextLine());

                        switch (opItemVenda) {
                            case 1:
                                itemVendaController.obterItens().forEach(iv ->
                                    System.out.println(
                                        "ID: " + iv.getId()
                                        + " | ID Produto: " + iv.getId_produto()
                                        + " | Quantidade: " + iv.getQuantidade()
                                        + " | ID Venda: " + iv.getId_venda()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("ID Produto: ");   int prodIV = Integer.parseInt(sc.nextLine());
                                System.out.print("Quantidade: ");   int qtdIV = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Venda: ");     int vendaIV = Integer.parseInt(sc.nextLine());
                                itemVendaController.salvarItem(prodIV, qtdIV, vendaIV);
                                System.out.println("Item cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");           int idIVAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Produto: ");   int prodIVEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("Quantidade: ");   int qtdIVEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Venda: ");     int vendaIVEdit = Integer.parseInt(sc.nextLine());
                                itemVendaController.atualizarItem(idIVAtual, prodIVEdit, qtdIVEdit, vendaIVEdit);
                                System.out.println("Item atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                itemVendaController.excluirItem(Integer.parseInt(sc.nextLine()));
                                System.out.println("Item removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opItemVenda != 0);
                    break;

                // ===================== PAGAMENTO =====================
                case 10:
                    int opPagamento;
                    do {
                        System.out.println("\n=== MENU PAGAMENTO ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opPagamento = Integer.parseInt(sc.nextLine());

                        switch (opPagamento) {
                            case 1:
                                pagamentoController.obterPagamentos().forEach(p ->
                                    System.out.println(
                                        "ID: " + p.getId()
                                        + " | Forma: " + p.getForma_pagamento()
                                        + " | Valor: " + p.getValor()
                                        + " | Data: " + p.getData_pagamento()
                                        + " | ID Venda: " + p.getId_venda()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Forma Pagamento: "); String formaPag = sc.nextLine();
                                System.out.print("Valor: ");           float valorPag = Float.parseFloat(sc.nextLine());
                                System.out.print("Data Pagamento: ");  String dataPag = sc.nextLine();
                                System.out.print("ID Venda: ");        int vendaPag = Integer.parseInt(sc.nextLine());
                                pagamentoController.salvarPagamento(formaPag, valorPag, dataPag, vendaPag);
                                System.out.println("Pagamento cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");              int idPagAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Forma Pagamento: "); String formaPagEdit = sc.nextLine();
                                System.out.print("Valor: ");           float valorPagEdit = Float.parseFloat(sc.nextLine());
                                System.out.print("Data Pagamento: ");  String dataPagEdit = sc.nextLine();
                                System.out.print("ID Venda: ");        int vendaPagEdit = Integer.parseInt(sc.nextLine());
                                pagamentoController.atualizarPagamento(idPagAtual, formaPagEdit, valorPagEdit,
                                        dataPagEdit, vendaPagEdit);
                                System.out.println("Pagamento atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                pagamentoController.excluirPagamento(Integer.parseInt(sc.nextLine()));
                                System.out.println("Pagamento removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opPagamento != 0);
                    break;

                // ===================== PRODUTO =====================
                case 11:
                    int opProduto;
                    do {
                        System.out.println("\n=== MENU PRODUTO ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opProduto = Integer.parseInt(sc.nextLine());

                        switch (opProduto) {
                            case 1:
                                produtoController.obterProdutos().forEach(p ->
                                    System.out.println(
                                        "ID: " + p.getId()
                                        + " | Nome: " + p.getNome()
                                        + " | Preço: " + p.getPreco()
                                        + " | Marca: " + p.getMarca()
                                        + " | Cód.Barras: " + p.getCodigo_barras()
                                        + " | Descrição: " + p.getDescricao()
                                        + " | ID Categoria: " + p.getId_categoria()
                                        + " | ID Fornecedor: " + p.getId_fornecedor()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("Nome: ");          String nomeProd = sc.nextLine();
                                System.out.print("Preço: ");         float precoProd = Float.parseFloat(sc.nextLine());
                                System.out.print("ID Categoria: ");  int catProd = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Fornecedor: "); int fornProd = Integer.parseInt(sc.nextLine());
                                System.out.print("Marca: ");         String marcaProd = sc.nextLine();
                                System.out.print("Cód. Barras: ");   int codProd = Integer.parseInt(sc.nextLine());
                                System.out.print("Descrição: ");     String descProd = sc.nextLine();
                                produtoController.salvarProduto(nomeProd, precoProd, catProd, fornProd,
                                        marcaProd, codProd, descProd);
                                System.out.println("Produto cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");            int idProdAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Nome: ");          String nomeProdEdit = sc.nextLine();
                                System.out.print("Preço: ");         float precoProdEdit = Float.parseFloat(sc.nextLine());
                                System.out.print("ID Categoria: ");  int catProdEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Fornecedor: "); int fornProdEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("Marca: ");         String marcaProdEdit = sc.nextLine();
                                System.out.print("Cód. Barras: ");   int codProdEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("Descrição: ");     String descProdEdit = sc.nextLine();
                                produtoController.atualizarProduto(idProdAtual, nomeProdEdit, precoProdEdit,
                                        catProdEdit, fornProdEdit, marcaProdEdit, codProdEdit, descProdEdit);
                                System.out.println("Produto atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                produtoController.excluirProduto(Integer.parseInt(sc.nextLine()));
                                System.out.println("Produto removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opProduto != 0);
                    break;

                // ===================== TIPO DE FUNCIONÁRIO =====================
                case 12:
                    int opTipoFunc;
                    do {
                        System.out.println("\n=== MENU TIPO DE FUNCIONÁRIO ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opTipoFunc = Integer.parseInt(sc.nextLine());

                        switch (opTipoFunc) {
                            case 1:
                                tipoFuncController.obterTiposFuncionario().forEach(tp ->
                                    System.out.println("ID: " + tp.getId() + " | Descrição: " + tp.getDesc())
                                );
                                break;
                            case 2:
                                System.out.print("Descrição: ");
                                tipoFuncController.salvarTipoFuncionario(sc.nextLine());
                                System.out.println("Tipo cadastrado!");
                                break;
                            case 3:
                                System.out.print("ID: ");        int idTFAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("Descrição: "); String descTFEdit = sc.nextLine();
                                tipoFuncController.atualizarTipoFuncionario(idTFAtual, descTFEdit);
                                System.out.println("Tipo atualizado!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                tipoFuncController.excluirTipoFuncionario(Integer.parseInt(sc.nextLine()));
                                System.out.println("Tipo removido!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opTipoFunc != 0);
                    break;

                // ===================== VENDA =====================
                case 13:
                    int opVenda;
                    do {
                        System.out.println("\n=== MENU VENDA ===");
                        System.out.println("1 - Listar");
                        System.out.println("2 - Inserir");
                        System.out.println("3 - Atualizar");
                        System.out.println("4 - Deletar");
                        System.out.println("0 - Voltar");
                        System.out.print("Opção: ");
                        opVenda = Integer.parseInt(sc.nextLine());

                        switch (opVenda) {
                            case 1:
                                vendaController.obterVendas().forEach(v ->
                                    System.out.println(
                                        "ID: " + v.getId()
                                        + " | ID Cliente: " + v.getId_cliente()
                                        + " | Data: " + v.getData_venda()
                                        + " | Total: " + v.getValorTotal()
                                        + " | ID Funcionário: " + v.getId_funcionario()
                                        + " | Status: " + v.getStatus()
                                    )
                                );
                                break;
                            case 2:
                                System.out.print("ID Cliente: ");      int cliVenda = Integer.parseInt(sc.nextLine());
                                System.out.print("Data Venda: ");      String dataVenda = sc.nextLine();
                                System.out.print("Valor Total: ");     float totalVenda = Float.parseFloat(sc.nextLine());
                                System.out.print("ID Funcionário: ");  int funcVenda = Integer.parseInt(sc.nextLine());
                                System.out.print("Status: ");          String statusVenda = sc.nextLine();
                                vendaController.salvarVenda(cliVenda, dataVenda, totalVenda, funcVenda, statusVenda);
                                System.out.println("Venda cadastrada!");
                                break;
                            case 3:
                                System.out.print("ID: ");              int idVendaAtual = Integer.parseInt(sc.nextLine());
                                System.out.print("ID Cliente: ");      int cliVendaEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("Data Venda: ");      String dataVendaEdit = sc.nextLine();
                                System.out.print("Valor Total: ");     float totalVendaEdit = Float.parseFloat(sc.nextLine());
                                System.out.print("ID Funcionário: ");  int funcVendaEdit = Integer.parseInt(sc.nextLine());
                                System.out.print("Status: ");          String statusVendaEdit = sc.nextLine();
                                vendaController.atualizarVenda(idVendaAtual, cliVendaEdit, dataVendaEdit,
                                        totalVendaEdit, funcVendaEdit, statusVendaEdit);
                                System.out.println("Venda atualizada!");
                                break;
                            case 4:
                                System.out.print("ID: ");
                                vendaController.excluirVenda(Integer.parseInt(sc.nextLine()));
                                System.out.println("Venda removida!");
                                break;
                            case 0: break;
                            default: System.out.println("Opção inválida!");
                        }
                    } while (opVenda != 0);
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