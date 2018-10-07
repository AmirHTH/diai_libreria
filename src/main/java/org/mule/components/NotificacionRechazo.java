/**
 * 
 */
package org.mule.components;

import org.mule.model.PedidoSimple;

/**
 * @author UO240753
 *
 */
public class NotificacionRechazo {

	public NotificacionRechazo() {
		
	}
	
	public Object notificacion(PedidoSimple ps) {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("+");
		System.out.println("+ Sr/Sra "+ps.getNombreCompleto());
		System.out.println("+ Su pedido se ha rechazado por falta de stock de "+ps.getISBN());
		System.out.println("+");
		System.out.println("-----------------------------------------------------------------------------");
		return ps;
	}

}
