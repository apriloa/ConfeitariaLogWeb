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
	private List<ItemPedido> itensSelect;
	private PedidoRepositorio pr;
	private FornecedorRepositorio fr;
	private FuncionarioRepositorio fur;
	private Funcionario funcionario;
	private Fornecedor fornecedor;
	private Pedido pedido;
	private ItemPedido item;
	private int pedidoCodigo;
	private int fornecedorCodigo;
	private int funcionarioCodigo;
	private String chaveNome = "";

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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

	public PedidoControlador() {
		pr = new PedidoRepositorio();
		fr = new FornecedorRepositorio();
		fur = new FuncionarioRepositorio();
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
		pedido.setItemspedidos(itensSelect);
		//funcionario.setId(fur.recuperar(funcionarioCodigo).getId());
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

	public List<ItemPedido> getItensSelect() {
		return itensSelect;
	}

	public void setItensSelect(List<ItemPedido> itensSelect) {
		this.itensSelect = itensSelect;
	}

	public ItemPedido getItem() {
		return item;
	}
	
	
	
}