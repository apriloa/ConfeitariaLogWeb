package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;

@ManagedBean(name = "materialControlador")
@SessionScoped
public class MaterialControlador {

	private List<Material> materials;
	private MaterialRepositorio mr;
	private Material material;
	private String chaveNome = "";

	public Material getmaterial() {
		return material;
	}

	public MaterialControlador() {
		mr = new MaterialRepositorio();

	}

	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		material = new Material();
		return "materialInclusao";
	}

	public List<Material> getmaterials() {
		return materials;
	}

	public void setmaterials(List<Material> materials) {
		this.materials = materials;
	}

	public String adicionar() {
		mr.adicionar(material);
		return "funcionarioListagem";
	}

	public String editar(Material material) {
		this.material = material;
		return "materialEdicao";
	}

	public String atualizar() {
		mr.atualizar(material);
		return "materialListagem";
	}

	public String excluir(Material material) {
		this.material = material;
		return "materialExclusao";
	}

	public String remover() {
		mr.remover(material);
		return "materialListagem";
	}

}