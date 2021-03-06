package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;

@ManagedBean(name = "pedidoControlador")
@SessionScoped
public class PedidoControlador {

	private List<Pedido> pedidos;
	private List<Material> materiais;
	
	private PedidoRepositorio pr;
	private FornecedorRepositorio fr;
	private FuncionarioRepositorio fur;
	private ItemPedidoRepositorio ipr;
	
	private Funcionario funcionario;
	private Fornecedor fornecedor;
	private Pedido pedido;
	private ItemPedido item;
	
	private int pedidoCodigo;
	private int fornecedorCodigo;
	private int funcionarioCodigo;
	private int itemCodigo;
	
	public int getMaterialCodigo() {
		return itemCodigo;
	}

	private int quantidade;

	private String chaveNome = "";
	
	
	
	public int getQuantidade() {
		return quantidade;
	}


	public PedidoControlador() {
		pr = new PedidoRepositorio();
		fr = new FornecedorRepositorio();
		fur = new FuncionarioRepositorio();
		ipr = new ItemPedidoRepositorio();
	}


	public Pedido getPedido() {
		return pedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public ItemPedido getItem() {
		return item;
	}

	public int getPedidoCodigo() {
		return pedidoCodigo;
	}

	public void setPedidoCodigo(int pedidoCodigo) {
		this.pedidoCodigo = pedidoCodigo;
	}

	public int getFornecedorCodigo() {
		return fornecedorCodigo;
	}

	public void setFornecedorCodigo(int fornecedorCodigo) {
		this.fornecedorCodigo = fornecedorCodigo;
	}

	public int getFuncionarioCodigo() {
		return funcionarioCodigo;
	}

	public void setFuncionarioCodigo(int funcionarioCodigo) {
		this.funcionarioCodigo = funcionarioCodigo;
	}

	public List<Pedido> getPedidos() {
		pedidos = pr.recuperarTodos();
		return pedidos;
	}

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		pedido = new Pedido();
		return "pedidoInclusao";
	}

	public String adicionar() {
		//fornecedor.setId(pr.recuperar(fornecedorCodigo).getId());
		pedido.setFornecedores(fr.recuperarTodosPorID(fornecedorCodigo));
		pedido.setFuncionario(fur.recuperar(funcionarioCodigo));
		pedido.setItemspedidos(ipr.recuperarTodosPorID(itemCodigo));
		pedido.setDataEntrada(pr.recuperar(pedidoCodigo).getDataEntrada());
		pedido.setDataEntrada(pr.recuperar(pedidoCodigo).getDataSaida());
		funcionario.setId(fur.recuperar(funcionarioCodigo).getId());
		pr.adicionar(pedido);
		return "pedidoListagem";
	}

	public String editar(Pedido pedido) {
		this.pedido = pedido;
		pedidoCodigo = pedido.getId();
		return "pedidoEdicao";
	}

	public String atualizar() {
		pedido.setId(pr.recuperar(pedidoCodigo).getId());
		pr.atualizar(pedido);
		return "itemPedidoListagem";
	}

	public String excluir(Pedido pedido) {
		this.pedido = pedido;
		pedidoCodigo = pedido.getId();
		return "pedidoExclusao";
	}

	public String remover() {
		pr.remover(pedido);
		return "pedidoListagem";
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
/*
	public List<ItemPedido> getItensSelect() {
		return itensSelect;
	}

	public void setItensSelect(List<ItemPedido> itensSelect) {
		this.itensSelect = itensSelect;
	}
*/

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}