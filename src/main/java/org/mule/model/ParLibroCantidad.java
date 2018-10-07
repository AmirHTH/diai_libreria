package org.mule.model;

public class ParLibroCantidad {
	private String isbn;
	private String cantidad;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public ParLibroCantidad(String isbn, String cantidad) {
		super();
		this.isbn = isbn;
		this.cantidad = cantidad;
	}
	
	


}
