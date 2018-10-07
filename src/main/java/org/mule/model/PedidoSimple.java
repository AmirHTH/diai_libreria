/**
 * 
 */
package org.mule.model;


/**
 * @author uo240753
 *
 */
public class PedidoSimple {
	
	private String NIF, nombreCompleto;
	private boolean financia, stock=false;
	
	public boolean isInStock() {
		return stock;
	}


	public void setStockDisponible(boolean stock) {
		this.stock = stock;
	}


	private String cantidad, ISBN;
	
	

	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


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


	@Override
	public String toString() {
		return "PedidoSimple [NIF=" + NIF + ", nombreCompleto=" + nombreCompleto + ", financia=" + financia
				+ ", cantidad=" + cantidad + ", ISBN=" + ISBN + " Disponible="+ stock +"]";
	}



}
