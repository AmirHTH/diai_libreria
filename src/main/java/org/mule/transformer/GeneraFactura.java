package org.mule.transformer;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.mule.api.transformer.TransformerException;

import org.mule.model.PedidoSimple;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;



public class GeneraFactura  extends AbstractTransformer {

	public GeneraFactura()
	{
		this.registerSourceType(DataTypeFactory.create(Collection.class));
		this.setReturnDataType(DataTypeFactory.STRING);
	}
	


	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		
		Collection<PedidoSimple> listadops = (Collection<PedidoSimple>) src;
		String factura="";
		for (PedidoSimple ps : listadops) {
		
		
		System.out.println("GENERANDO FACTURA...");
		//PedidoSimple ps =  (PedidoSimple) src;
		Random r = new Random();
		int min = 1000000;
		int max = 10000000;
		int preciomin  = 10;
		int preciomax = 150;


		
		factura += "\n Factura Num.: "+ r.nextInt(max-min) + max; 
		factura += "\n Empresa: Amazin Books (3463464R) Registro madrid 42,51,1";		
		factura += "\n Para: "+ps.getNombreCompleto() +" ("+ps.getNIF()+")";		
		factura += "\n PEDIDO: ";
		factura += "\n\t ISBN: "+ps.getISBN() + "\t Cantidad: "+ps.getCantidad();
		factura += "\n Total: "+ r.nextInt(preciomax-preciomin) + preciomax;
		System.out.println("FACTURA: "+factura);
		}
		return factura;
	}

}
