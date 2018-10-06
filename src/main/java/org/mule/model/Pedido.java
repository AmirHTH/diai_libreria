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
	
	String NIF, nombreCompleto;
	boolean financia;
	Map<String, String> productos = new HashMap<String,String>();
	
	
	
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
