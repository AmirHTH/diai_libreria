/**
 * 
 */
package org.mule.model;


/**
 * @author uo240753
 *
 */
public class PedidoSimple {
	
	private boolean stock;
	private String cantidad, ISBN;
	private String NIF, nombreCompleto;
	private boolean financia, moroso, vip;
	
	
	
	public boolean isVip() {
		return vip;
	}


	public void setVip(boolean vip) {
		this.vip = vip;
	}


	public boolean isMoroso() {
		return moroso;
	}


	public void setMoroso(boolean moroso) {
		this.moroso = moroso;
	}

	public boolean isStock() {
		return stock;
	}


	public void setStock(boolean stock) {
		this.stock = stock;
	}


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
		return "PedidoSimple [stock=" + stock + ", cantidad=" + cantidad + ", ISBN=" + ISBN + ", NIF=" + NIF
				+ ", nombreCompleto=" + nombreCompleto + ", financia=" + financia + ", moroso=" + moroso + ", vip="
				+ vip + "]";
	}




}
