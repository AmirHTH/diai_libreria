/**
 * 
 */
package org.mule.model;


import java.util.HashMap;

import java.util.Map;


/**
 * @author uo240753
 *
 */
public class Pedido {
	
	private String NIF, nombreCompleto;
	private boolean financia;
	private Map<String, String> productos = new HashMap<String,String>();
	//private List<ParLibroCantidad> listadoLibros  = new ArrayList<ParLibroCantidad>();
	
	/*
	
	public List<ParLibroCantidad> getListadoLibros() {
		return listadoLibros;
	}


	public void setListadoLibros(List<ParLibroCantidad> listadoLibros) {
		this.listadoLibros = listadoLibros;
	}
	
	public void addLibroCantidad(ParLibroCantidad objeto) {
		listadoLibros.add(objeto);
	}
	
*/

	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public boolean isFinancia() {
		return financia;
	}


	public void setFinancia(boolean financia) {
		this.financia = financia;
	}


	public Map<String, String> getProductos() {
		return productos;
	}


	public void setProductos(Map<String, String> productos) {
		this.productos = productos;
	}

	public void SOP_Pedidos() {  	
		productos.forEach((k,v) ->{System.out.println("cod : " + k + " valor : " + v);});
	}

	@Override
	public String toString() {
		return "Pedido [NIF=" + NIF + ", nombreCompleto=" + nombreCompleto + ", financia=" + financia + ", productos="
				+ productos + "]";
	}



}
