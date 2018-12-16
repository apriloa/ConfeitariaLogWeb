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
	private CategoriaRepositorio cr;
	private Categoria categoria;
	private int categoriaCodigo;
	private Fornecedor fornecedor;
	private String chaveNome="";
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	

	public int getCategoriaCodigo() {
		return categoriaCodigo;
	}


	public void setCategoriaCodigo(int categoriaCodigo) {
		this.categoriaCodigo = categoriaCodigo;
	}


	public FornecedorControlador() {
		fo = new FornecedorRepositorio();
		cr = new CategoriaRepositorio();
		
		
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
		return "fornecedorInclusao";
	}
	
	public String adicionar() {
	fornecedor.setCategorias(cr.recuperar(categoriaCodigo));
	fo.adicionar(fornecedor);
		return "fornecedorListagem";
	}
	
	public String editar(Fornecedor fornecedor) {
		this.fornecedor=fornecedor;
		categoriaCodigo = fornecedor.getCategorias().getId();
		return "fornecedorEdicao";
	}
	
	public String atualizar() {
		fornecedor.setCategorias(cr.recuperar(categoriaCodigo));
		fo.atualizar(fornecedor);
		return "fornecedorListagem";
	}
	
	public String excluir(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		categoriaCodigo = fornecedor.getCategorias().getId();
		return "fornecedorExclusao";
	}
	
	public String remover() {
		fo.remover(fornecedor);
		return "fornecedorListagem";
	}
}