package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;


@ManagedBean(name="fornecedorControlador")
@SessionScoped
public class FornecedorControlador {

	private List<Fornecedor> fornecedores;
	private FornecedorRepositorio fo;
	private PedidoRepositorio pr;
	private int pedidoCodigo;
	private Fornecedor fornecedor;
	private String chaveNome="";
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public FornecedorControlador() {
		fo = new FornecedorRepositorio();
		pr = new PedidoRepositorio();
		
	}
	

	public int getPedidoCodigo() {
		return pedidoCodigo;
	}

	public void setPedidoCodigo(int pedidoCodigo) {
		this.pedidoCodigo = pedidoCodigo;
	}

	public List<Fornecedor> getFornecedores() {
		fornecedores = fo.recuperarTodos();
		return fornecedores;
	}
	

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		fornecedor = new Fornecedor();
		return "funcionarioInclusao";
	}
	
	public String adicionar() {
	fornecedor.setPedidos(pr.recuperar(pedidoCodigo));
	fo.adicionar(fornecedor);
		return "funcionarioListagem";
	}
	
	public String editar(Fornecedor fornecedor) {
		this.fornecedor=fornecedor;
		pedidoCodigo = fornecedor.getPedidos().getId();
		return "funcionarioEdicao";
	}
	
	public String atualizar() {
		fornecedor.setPedidos(pr.recuperar(pedidoCodigo));
		fo.atualizar(fornecedor);
		return "funcionarioListagem";
	}
	
	public String excluir(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		pedidoCodigo = fornecedor.getPedidos().getId();
		return "fornecedorExclusao";
	}
	
	public String remover() {
		fo.remover(fornecedor);
		return "fornecedorListagem";
	}
}