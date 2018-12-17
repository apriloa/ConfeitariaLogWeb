package br.ufac.logconf.controle;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.logconf.entidades.*;
import br.ufac.logconf.repositorios.*;


@ManagedBean(name="itemPedidoControlador")
@SessionScoped
public class ItemPedidoControlador {

	private List<ItemPedido> itemPedidos;
	private List<Material> itensSelect;
	private MaterialRepositorio mr;
	private ItemPedidoRepositorio ipr;
	private Material material;
	private ItemPedido itemPedido;
	private int quantidadeMaterial;
	private int materialCodigo;
	private String chaveNome="";
	
	


	public int getQuantidadeMaterial() {
		return quantidadeMaterial;
	}




	public void setQuantidadeMaterial(int quantidadeMaterial) {
		this.quantidadeMaterial = quantidadeMaterial;
	}




	public ItemPedido getItemPedido() {
		return itemPedido;
	}
	
	
	

	public Material getMaterial() {
		return material;
	}




	public int getMaterialCodigo() {
		return materialCodigo;
	}



	public void setMaterialCodigo(int materialCodigo) {
		this.materialCodigo = materialCodigo;
	}



	public ItemPedidoControlador() {
		ipr = new ItemPedidoRepositorio();
		mr = new MaterialRepositorio();
	}
	
	

	public List<ItemPedido> getItemPedidos() {
		itemPedidos = ipr.recuperarTodos();
		return itemPedidos;
	}


	public String getChaveNome() {
		return chaveNome;
	}

	public void setChaveNome(String chaveNome) {
		this.chaveNome = chaveNome;
	}

	public String incluir() {
		itemPedido= new ItemPedido();
		return "itemPedidoInclusao";
	}
	
	public String adicionar() {
	itemPedido.setMaterial(mr.recuperar(materialCodigo));
	ipr.adicionar(itemPedido);
		return "itemPedidoListagem";
	}
	
	public String editar(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
		materialCodigo = itemPedido.getMaterial().getId();
		return "itemPedidoEdicao";
	}
	
	public String atualizar() {
		itemPedido.setMaterial(mr.recuperar(materialCodigo));
		ipr.atualizar(itemPedido);
		return "itemPedidoListagem";
	}
	
	public String excluir(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
		materialCodigo = itemPedido.getMaterial().getId();
		return "funcionarioExclusao";
	}
	
	public String remover() {
		ipr.remover(itemPedido);
		return "itemPedidoListagem";
	}


	public List<Material> getItensSelect() {
		return itensSelect;
	}


	public void setItensSelect(List<Material> itensSelect) {
		this.itensSelect = itensSelect;
	}
}