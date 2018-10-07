/**
 * 
 */
package org.mule.transformer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.mule.api.transformer.TransformerException;

import org.mule.model.Pedido;
import org.mule.transformer.types.DataTypeFactory;

/**
 * @author UO240753
 *
 */
public class HttpToPedido extends AbstractTransformer {
	
	public HttpToPedido()
	{
		this.registerSourceType(DataTypeFactory.STRING);
		this.setReturnDataType(DataTypeFactory.create(Pedido.class));
	}

	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractTransformer#doTransform(java.lang.Object, java.lang.String)
	 */
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		Pedido pedido = new Pedido();
		String uri="";
		try {
			uri = URLDecoder.decode(((String) src), enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("URI recibida: "+uri);
		
		String uriLimpia = uri.substring(uri.indexOf("?")+1);
		
		System.out.println("URI limpiada: "+uriLimpia);
		
		Map<String, String> datos = new HashMap<String, String>(); 
		String[] params = uriLimpia.split("&");
		
		String[] info;
		for (String param : params) {
			info=param.split("=");
			datos.put(info[0], info[1]);
			System.out.println("datos indexados k,v: "+info[0]+", "+info[1]);
		}

		
		pedido.setNombreCompleto(datos.get("nombre"));
		pedido.setNIF(datos.get("cif"));
		pedido.setFinancia(Boolean.parseBoolean(datos.get("financia")));
		
		// CARGA DE RELACION ENTRE PRODUCTOS Y ISBN
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("relacionProductosISBN.properties").getPath();
		System.out.println(rootPath);

		Properties relacion = new Properties();
		try {
			relacion.load(new FileInputStream(rootPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// FIN cArga PROPERTIES
		
		
		Map<String, String> listaLibros = new HashMap<String, String>(); 
		for (int i = params.length-3; i>=(1); i--) 
	    {  
			String codProd="producto"+i;
			if (datos.containsKey(codProd)) {
				if (Integer.parseInt(datos.get(codProd))>0) {
					listaLibros.put(relacion.getProperty(codProd), datos.get(codProd));
					System.out.println("agregado pedido con producto, isbn, cuantia:" + codProd + ", "+relacion.getProperty(codProd)+", "+datos.get(codProd));
				}
			}
	    }
		
		pedido.setProductos(listaLibros);
		pedido.SOP_Pedidos();
		/*listaLibros.forEach((k,v) ->{
			pedido.addLibroCantidad(new ParLibroCantidad(k, v));
		});*/
		
		
		
		return pedido;
	}

}
