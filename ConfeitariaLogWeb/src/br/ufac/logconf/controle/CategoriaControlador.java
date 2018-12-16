package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;


@ManagedBean(name="categoriaControlador")
@SessionScoped
public class CategoriaControlador {

	private List<Categoria> categorias;
	private CategoriaRepositorio cr;
	private Categoria categoria;
	private String chaveNome="";
	
	public Categoria getCategoria() {
		return categoria;
	}

	public CategoriaControlador() {
		cr = new CategoriaRepositorio();
	//	mr = new MaterialRepositorio();
		
	}

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		categoria = new Categoria();
		return "categoriaInclusao";
	}
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String adicionar() {
	cr.adicionar(categoria);
		return "funcionarioListagem";
	}
	
	public String editar(Categoria categoria) {
		this.categoria = categoria;
		return "categoriaEdicao";
	}
	
	public String atualizar() {
		cr.atualizar(categoria);
		return "categoriaListagem";
	}
	
	public String excluir(Categoria categoria) {
		this.categoria = categoria;
		return "categoriaExclusao";
	}
	
	public String remover() {
		cr.remover(categoria);
		return "categoriaListagem";
	}
	
	
	
}