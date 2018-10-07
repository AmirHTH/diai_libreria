package org.mule.transformer;


import java.util.Random;

import org.mule.api.transformer.TransformerException;
import org.mule.model.PedidoSimple;
import org.mule.transformer.AbstractTransformer;

public class GeneraCartaFinanciacion  extends AbstractTransformer {


	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		System.out.println("GENERANDO CARTA DE FINANCIACION...");
		PedidoSimple ps =  (PedidoSimple) src;
		Random r = new Random();
		int min = 1000000;
		int max = 10000000;

		String financia="\n";
		
		financia += "FINANCIACION Num.: "+ r.nextInt(max-min) + max; 
		financia += "\n Empresa: Amazin Books (3463464R) Registro madrid 42,51,1";		
		financia += "\n Para: "+ps.getNombreCompleto() +" ("+ps.getNIF()+")";		
		financia += "\n PEDIDO: ";
		financia += "\n\t ISBN: "+ps.getISBN() + "\t Cantidad: "+ps.getCantidad();
		financia += "\n Se ha aceptado su solicitud de financiación. \\n";
		System.out.println(financia);
		return financia;
	}

}
