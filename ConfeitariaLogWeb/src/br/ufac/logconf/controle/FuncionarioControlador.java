package br.ufac.logconf.controle;


import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.Funcionario;
import br.ufac.logconf.entidades.Pedido;
import br.ufac.logconf.repositorios.FuncionarioRepositorio;
import br.ufac.logconf.repositorios.PedidoRepositorio;


@ManagedBean(name="funcionarioControlador")
@SessionScoped
public class FuncionarioControlador {

	private List<Funcionario> funcionarios;
	private FuncionarioRepositorio fr;
	private PedidoRepositorio pr;
	private Funcionario funcionario;
	private String chaveNome="";
	private Pedido pedido;
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}


	public FuncionarioControlador() {
		fr = new FuncionarioRepositorio();
		pr = new PedidoRepositorio();
	}

	public List<Funcionario> getFuncionarios() {
		funcionarios = fr.recuperarTodosPorNome();
		return funcionarios;
	}
	

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		funcionario = new Funcionario();
		return "funcionarioInclusao";
	}
	
	public String adicionarPedido() {
		pr.adicionar(pedido);
		return "pedidolistagem";
	}
	
	public String adicionar() {
	fr.adicionar(funcionario);
		return "funcionarioListagem";
	}
	
	public String editar(Funcionario funcionario) {
		this.funcionario = funcionario;
		return "funcionarioEdicao";
	}
	
	public String atualizar() {
		fr.atualizar(funcionario);
		return "funcionarioListagem";
	}
	
	public String excluir(Funcionario funcionario) {
		this.funcionario = funcionario;
		return "funcionarioExclusao";
	}
	
	public String remover() {
		fr.remover(funcionario);
		return "funcionarioListagem";
	}
}