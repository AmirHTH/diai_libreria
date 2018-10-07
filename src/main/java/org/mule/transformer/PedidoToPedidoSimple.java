/**
 * 
 */
package org.mule.transformer;

import java.util.ArrayList;

import java.util.List;


import org.mule.api.transformer.TransformerException;

import org.mule.model.Pedido;
import org.mule.model.PedidoSimple;

/**
 * @author uo240753
 *
 */
public class PedidoToPedidoSimple extends AbstractTransformer {

	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractTransformer#doTransform(java.lang.Object, java.lang.String)
	 */
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		List<PedidoSimple> pedidos = new ArrayList<PedidoSimple>();
		Pedido pedidoFull= (Pedido) src;
		
		PedidoSimple ps;
		for (String key : pedidoFull.getProductos().keySet()) {
			ps = new PedidoSimple();
			ps.setFinancia(pedidoFull.isFinancia());
			ps.setNIF(pedidoFull.getNIF());
			ps.setNombreCompleto(pedidoFull.getNombreCompleto());
			ps.setISBN(key);
			ps.setCantidad( pedidoFull.getProductos().get(key));
			pedidos.add(ps);
		}
		
		
		
		return pedidos;
	}

}
