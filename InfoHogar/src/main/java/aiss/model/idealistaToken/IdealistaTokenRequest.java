package aiss.model.idealistaToken;





import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;




public class IdealistaTokenRequest {
	
	private static final String IDEALISTA_API_KEY_Y_SECRET_CODIFICADOS_BASE64 = "Y3BnOWM2YW4yenowenB1bnU4MjVoNTRzNDlseTAwMHc6cmpFbGF6RXlLN2hO";
    
	
	 private ClientResource getClientResource(String uri, String pAccessToken)
	    {
	        ClientResource lClientResource = new ClientResource(uri);
	        ChallengeResponse lChallengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_BASIC);
	        lChallengeResponse.setRawValue(pAccessToken);
	        lClientResource.setChallengeResponse(lChallengeResponse);
	        return lClientResource;
	    }
	
	
	public Token getToken() {
		
		Token token = null;
		String pAccessToken = IDEALISTA_API_KEY_Y_SECRET_CODIFICADOS_BASE64;
		String uri = "https://api.idealista.com/oauth/token";
		ClientResource cr = this.getClientResource(uri, pAccessToken);
		
		try {
	
			Form form = new Form();
			form.set("grant_type", "client_credentials");
			form.set("scope", "read");
			Representation repr = form.getWebRepresentation();
	
		    token = cr.post(repr, Token.class);
		    
				} catch (ResourceException re) {
				System.err.println("Error al obtener el token: " +cr.getResponse().getStatus());
				}
		
	
		return token;
	
	}

	
}
