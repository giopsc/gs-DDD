package br.com.fiap.demo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.seriesapi.model.Responsavel;
import br.com.fiap.seriesapi.service.ResponsavelService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("usuario")
public class ResponsavelResource {
	
	private ResponsavelService service = new ResponsavelService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Responsavel> index(){
		return service.findAll();
	}
	
	@GET
	@Path("{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response get( @PathParam("id") Long id) throws SQLException {
		var serie =  service.findById(id);
		if (serie == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		
		return Response.ok(serie).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") Long id) throws SQLException {
		var serie = service.findById(id);
		
		if (serie == null)
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		
		service.delete(id);
		return Response.noContent().build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Responsavel serie) {
		if(!service.create(serie)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.ok(serie).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Responsavel serie) throws SQLException {
		var serieEncontrada = service.findById(id);
		
		if (serieEncontrada == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		if (!service.update(serie)){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.ok(serie).build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
