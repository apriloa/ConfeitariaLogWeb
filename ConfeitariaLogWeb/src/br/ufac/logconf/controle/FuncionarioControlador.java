package br.ufac.logconf.controle;

import java.io.Serializable;
import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.Funcionario;
import br.ufac.logconf.repositorios.FuncionarioRepositorio;


@ManagedBean(name="funcionarioControlador")
@SessionScoped
public class FuncionarioControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Funcionario> funcionarios;
	private FuncionarioRepositorio fr;
	private Funcionario funcionario;
	private String chaveNome="";
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioControlador() {
		fr = new FuncionarioRepositorio();
	//	pr = new PedidoRepositorio();
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