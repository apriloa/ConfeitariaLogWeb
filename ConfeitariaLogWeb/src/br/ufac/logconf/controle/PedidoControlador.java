package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;


@ManagedBean(name="pedidoControlador")
@SessionScoped
public class PedidoControlador {

	private List<Pedido> pedidos;
	private PedidoRepositorio pr;
	//private ItemPedidoRepositorio ipr;
	private Pedido pedido;
	private int pedidoCodigo;
	private String chaveNome="";
	


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Pedido getPedido() {
		return pedido;
	}
	

	public int getPedidoCodigo() {
		return pedidoCodigo;
	}



	public void setPedidoCodigo(int pedidoCodigo) {
		this.pedidoCodigo = pedidoCodigo;
	}



	public PedidoControlador() {
		pr = new PedidoRepositorio();
		//mr = new MaterialRepositorio();
	}
	
	

	public List<Pedido> getItemPedidos() {
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
	pedido.setId(pr.recuperar(pedidoCodigo).getId());
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
}