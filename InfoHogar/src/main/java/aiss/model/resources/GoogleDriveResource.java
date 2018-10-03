package aiss.model.resources;

import java.util.Map;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.googleDrive.FileItem;

public class GoogleDriveResource {
	private static final Logger log = Logger.getLogger(GoogleDriveResource.class.getName());
	private String access_token;
	

	public GoogleDriveResource(String access_token) {
		this.access_token = access_token;
	}
	

	
	
	
	public String crearFichero(FileItem fichero, String contenido) {

		ClientResource cr = null;
		String id = null;
		try {
			cr = new ClientResource("https://www.googleapis.com/drive/v2/files" + "?access_token=" + access_token);
			FileItem nuevoFichero = cr.post(fichero, FileItem.class);
			id = nuevoFichero.getId();
			cr = new ClientResource("https://www.googleapis.com/upload/drive/v2/files" + "/" + id + "?uploadType=media&access_token=" + access_token);
			Map<String, Object> headers = cr.getRequestAttributes();
			headers.put("Content-Type", "text/plain");
			cr.put(contenido);
		} catch (ResourceException re) {
			log.warning("Error when inserting file: " + cr.getResponse().getStatus());
		}
		return id;
	}
	
	
	
}
