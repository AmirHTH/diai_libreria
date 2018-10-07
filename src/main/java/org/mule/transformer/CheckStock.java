package org.mule.transformer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.api.transformer.TransformerException;
import org.mule.model.PedidoSimple;
import org.mule.transformer.AbstractTransformer;

public class CheckStock  extends AbstractTransformer {


	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		Properties stock = new Properties();
		PedidoSimple ps =  (PedidoSimple) src;
		// CARGA DE RELACION ENTRE PRODUCTOS Y ISBN
				String rootPath = Thread.currentThread().getContextClassLoader().getResource("stock.properties").getPath();
				
				try {
					stock.load(new FileInputStream(rootPath));
				} catch (IOException e) {
					e.printStackTrace();
				}	
		// FIN cArga PROPERTIES
				
				
				
		String key = ps.getISBN();
		boolean disponible = false;
		if (stock.containsKey(key)) {
			if (Integer.parseInt(stock.getProperty(key)) >= Integer.parseInt(ps.getCantidad())) {
				disponible=true;
			}
		}
		ps.setStock(disponible);
		
		System.out.println(ps.toString());

		return ps;
	}

}
