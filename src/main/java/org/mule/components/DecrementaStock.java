package org.mule.components;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.model.PedidoSimple;

public class DecrementaStock {
	
	
	public Object DecrementaElStock(PedidoSimple ps) {
		
		Properties stock = new Properties();
		//PedidoSimple ps =  (PedidoSimple) src;
		// CARGA DE RELACION ENTRE PRODUCTOS Y ISBN
		//String rootPath = Thread.currentThread().getContextClassLoader().getResource("stock.properties").getPath();
		String rootPath = "src/main/resources/stock.properties";
		//FileInputStream in = new FileInputStream("src/main/resources/stock.properties");
		
		try {
			stock.load(new FileInputStream(rootPath));
		} catch (IOException e) {
			e.printStackTrace();
		}	

		String key = ps.getISBN();
		

		if (stock.containsKey(key)) {
			String value = stock.getProperty(key);
			int valueInt = Integer.parseInt(value);
			int cuantiaPedida = Integer.parseInt(ps.getCantidad());
			System.out.println("+");
			System.out.println("+ En stock se disponen de "+value+ " copias del libro "+key);
			if (valueInt >= cuantiaPedida) {
				
				stock.replace(key, Integer.toString(valueInt-cuantiaPedida));
				System.out.println("+ En stock quedan "+stock.getProperty(key)+ " copias del libro "+key);
				System.out.println("+");
			}
		}
		
		try {
			stock.store(new FileOutputStream(rootPath), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ps;
	}

}
