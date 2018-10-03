package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.idealista.PropertySearch;


public class IdealistaResource {
	private static final Logger log = Logger.getLogger(IdealistaResource.class.getName());
	
	 private ClientResource getClientResource(String uri, String pAccessToken)
	    {
	        ClientResource lClientResource = new ClientResource(uri);
	        ChallengeResponse lChallengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        lChallengeResponse.setRawValue(pAccessToken);
	        lClientResource.setChallengeResponse(lChallengeResponse);
	        return lClientResource;
	    }
	
	
	public PropertySearch getAnuncios(Map<String,String> requisitos, String token) throws UnsupportedEncodingException {
		
		PropertySearch anuncios = null;
		// Hemos decidido no incluir paginación para los resultados de Idealista. Si el usuario
		// especifica bien su búsqueda, es raro que salgan más de 50 resultados. Por lo tanto,
		// el parámetro numPage siempre valdrá 1 en todas las peticiones.
		String uri = "https://api.idealista.com/3.5/es/search?locale=es&maxItems=50&numPage=1&order=price&sort=asc&";
		
		for (String clave : requisitos.keySet()) {
			uri += URLEncoder.encode(clave, "UTF-8");
			uri+= "=";
			uri += URLEncoder.encode(requisitos.get(clave),"UTF-8");
			uri += "&";
		}
		
		uri = uri.substring(0, uri.length() - 1);

	

		ClientResource cr = this.getClientResource(uri, token);
		

		try {
			StringRepresentation repr = new StringRepresentation("", MediaType.MULTIPART_FORM_DATA);
		    anuncios = cr.post(null, PropertySearch.class);
				} catch (ResourceException re) {
				System.err.println("Error " +cr.getResponse().getStatus());
				}
		
		
		
		
	
	return anuncios;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
