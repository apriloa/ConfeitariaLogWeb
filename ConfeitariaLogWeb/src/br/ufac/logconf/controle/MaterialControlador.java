package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;

@ManagedBean(name = "materialControlador")
@SessionScoped
public class MaterialControlador {

	private List<Material> materiais;
	private MaterialRepositorio mr;
	private CategoriaRepositorio cr;
	private Categoria categoria;
	private Material material;
	private int categoriaCodigo;
	private String chaveNome = "";

	public Material getmaterial() {
		return material;
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


	public MaterialControlador() {
		mr = new MaterialRepositorio();
		cr = new CategoriaRepositorio();

	}

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}
	
	public List<Material> getmateriais() {
		materiais = mr.recuperarTodos();
		return materiais;
	}
	public void setmateriais(List<Material> materiais) {
		this.materiais = materiais;
	}

	public String incluir() {
		material = new Material();
		return "materialInclusao";
	}

	
	public String adicionar() {
		material.setCategoria(cr.recuperar(categoriaCodigo));
		mr.adicionar(material);
		return "materialListagem";
	}

	public String editar(Material material) {
		this.material = material;
		categoriaCodigo = material.getCategoria().getId();
		return "materialEdicao";
	}

	public String atualizar() {
		material.setCategoria(cr.recuperar(categoriaCodigo));
		mr.atualizar(material);
		return "materialListagem";
	}

	public String excluir(Material material) {
		this.material = material;
		categoriaCodigo = material.getCategoria().getId();
		return "materialExclusao";
	}

	public String remover() {
		mr.remover(material);
		return "materialListagem";
	}

}