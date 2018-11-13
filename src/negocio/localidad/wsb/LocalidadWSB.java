package negocio.localidad.wsb;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import negocio.FactoriaNegocio;
import negocio.localidad.SALocalidad;
import negocio.localidad.TLocalidad;


@Path("/localidad/wsb")
public class LocalidadWSB {
	@GET
	@Path("/read/{id}")
	@Produces("text/plain")
	public String readGET(@PathParam("id") String id)
	{
		FactoriaNegocio negocio = FactoriaNegocio.getInstancia();
		SALocalidad service = negocio.generaSALocalidad();
		String res = "";
		try {
			res = service.read((Integer.parseInt(id))).toString();
			
		} catch (Exception e) {
			// TODO: handle exception
			res = "Not found!";
		}
		return res;
	}
	
	@POST
	public Response readPOST(String s)
	{	
		List<String> l = Arrays.asList(s.split("\\s*,\\s*"));
		FactoriaNegocio negocio = FactoriaNegocio.getInstancia();
		SALocalidad service = negocio.generaSALocalidad();
		String res = "";
		try {
			res = service.read((Integer.parseInt(s))).toString();
			
		} catch (Exception e) {
			// TODO: handle exception
			res = "Not found!";
		}
		return Response.ok(res).build();
	}
	
	@DELETE
	@Produces("text/plain")
	public String readDELETE(@QueryParam("id") String id)
	{	
		FactoriaNegocio negocio = FactoriaNegocio.getInstancia();
		SALocalidad service = negocio.generaSALocalidad();
		
		return service.read(Integer.parseInt(id)).toString();
	}
	
	@PUT
	@Path("/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public String insertPUTjson(TLocalidad l)
	{
		String mensaje = "";
		SALocalidad sa= FactoriaNegocio.getInstancia().generaSALocalidad();
		int res= sa.create(l);
          
        if (res>0) { mensaje="Se ha creado la localidad con id "+ res; }
        else {mensaje= "Error en la creacion"; }
        
        return mensaje;
	}

	@PUT
	public String readPUT(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido)
	{	
		return "";
	}
	
}
