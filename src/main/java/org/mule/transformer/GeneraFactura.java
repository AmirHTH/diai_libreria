package org.mule.transformer;


import java.util.Random;

import org.mule.api.transformer.TransformerException;
import org.mule.model.PedidoSimple;
import org.mule.transformer.AbstractTransformer;

public class GeneraFactura  extends AbstractTransformer {


	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		System.out.println("GENERANDO FACTURA...");
		PedidoSimple ps =  (PedidoSimple) src;
		Random r = new Random();
		int min = 1000000;
		int max = 10000000;
		int preciomin  = 10;
		int preciomax = 150;

		String factura="\n";
		
		factura += "\n Factura Num.: "+ r.nextInt(max-min) + max; 
		factura += "\n Empresa: Amazin Books (3463464R) Registro madrid 42,51,1";		
		factura += "\n Para: "+ps.getNombreCompleto() +" ("+ps.getNIF()+")";		
		factura += "\n PEDIDO: ";
		factura += "\n\t ISBN: "+ps.getISBN() + "\t Cantidad: "+ps.getCantidad();
		factura += "\n Total: "+ r.nextInt(preciomax-preciomin) + preciomax;
		System.out.println(factura);
		return factura;
	}

}
