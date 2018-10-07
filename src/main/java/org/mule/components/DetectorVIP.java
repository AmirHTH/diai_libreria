package org.mule.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.model.PedidoSimple;

public class DetectorVIP {
	
	
	public Object DecrementaElStock(PedidoSimple ps) {
		
		Properties vips = new Properties();
		String rootPath = "src/main/resources/vip.properties";

		//PedidoSimple ps = (PedidoSimple) src;
		
		try {
			vips.load(new FileInputStream(rootPath));
		} catch (IOException e) {
			e.printStackTrace();
		}	

		String key = ps.getNIF();	

		if (vips.containsKey(key)) {
			String value = vips.getProperty(key);
			int valueInt = Integer.parseInt(value);
			boolean result = (valueInt>2000);
			
			ps.setVip(result);
			
			System.out.println("+");
			System.out.println("+ El usuario "+key+" es tiene unca compra acumulada de "+value+ ". Su valor VIP es "+ps.isVip());
			System.out.println("+");
			
			if (result) {
				System.out.println("+");
				System.out.println("+ USUARIO VIP. Se debe enviar por su pedido por via UERGENTE ");
				System.out.println("+");
				System.out.println("+ PEDIDO VIP: " +ps.toString() );
				System.out.println("+");
			} else {
				System.out.println("+");
				System.out.println("+ Usuario NORMAL.  Pedido enviado por MENSAJERIA ORDINARIA");
				System.out.println("+");				
				System.out.println("+ Pedido Normal: " +ps.toString() );
				System.out.println("+");			
			}
		}
		
		

		return ps;
	}

}
