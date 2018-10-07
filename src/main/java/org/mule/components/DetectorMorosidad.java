package org.mule.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.model.PedidoSimple;

public class DetectorMorosidad {
	
	
	public Object DecrementaElStock(PedidoSimple ps) {
		
		Properties morosidad = new Properties();
		String rootPath = "src/main/resources/deudores.properties";

		//PedidoSimple ps = (PedidoSimple) src;
		
		try {
			morosidad.load(new FileInputStream(rootPath));
		} catch (IOException e) {
			e.printStackTrace();
		}	

		String key = ps.getNIF();	

		if (morosidad.containsKey(key)) {
			String value = morosidad.getProperty(key);
			int valueInt = Integer.parseInt(value);
			boolean result = (valueInt>2000);
			
			ps.setMoroso(result);
			
			System.out.println("+");
			System.out.println("+ La deuda de "+key+" es de "+value+ ". Su morosidad es "+ps.isMoroso());
			System.out.println("+");
		}

		return ps;
	}

}
