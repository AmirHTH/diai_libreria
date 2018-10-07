package org.mule.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.model.PedidoSimple;

public class CheckStock {
	private Properties stock = new Properties();
	
	public CheckStock () {
		
// CARGA DE RELACION ENTRE PRODUCTOS Y ISBN
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("stock.properties").getPath();
		
		try {
			stock.load(new FileInputStream(rootPath));
		} catch (IOException e) {
			e.printStackTrace();
		}	
// FIN cArga PROPERTIES
	}
	
	public Object calculaFactura(PedidoSimple ps) 
	{
		String key = ps.getISBN();
		boolean disponible = false;
		if (stock.containsKey(key)) {
			if (Integer.parseInt(stock.getProperty(key)) >= Integer.parseInt(ps.getCantidad())) {
				disponible=true;
			}
		}
		ps.setStockDisponible(disponible);
		
		System.out.println(ps.toString());

		return ps;
	}

}
