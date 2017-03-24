package com.ipartek.formacion.perrera.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ipartek.formacion.perrera.dao.PerroDAOImpl;
import com.ipartek.formacion.perrera.pojo.Perro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/perro")
@Api(value = "/perro")
public class PerroController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Listado de Perros", notes = "Listado de perros existentes en la perrera, limitado a 1.000", response = Perro.class, responseContainer = "List")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo OK"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	public Response getAll(
			@ApiParam(name = "orderBy", required = false, value = "Filtro para ordenar los perros de forma ascendente o descendente, posibles valores [asc|desc]") @DefaultValue("asc") @QueryParam("orderBy") String orderBy,
			@ApiParam(name = "campo", required = false, value = "Filtro para ordenar por 'campo' los perros, posibles valores [id|nombre|raza]") @DefaultValue("id") @QueryParam("campo") String campo) {
		try {

			PerroDAOImpl dao = PerroDAOImpl.getInstance();
			ArrayList<Perro> perros = (ArrayList<Perro>) dao.getAll(orderBy, campo);
			return Response.ok().entity(perros).build();

		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@SuppressWarnings("finally")
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Detalle de un Perro", notes = "Detalle de un perro existente en la perrera", response = Perro.class, responseContainer = "Perro")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Todo OK"),
			@ApiResponse(code = 204, message = "No existe perro con esa ID"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	public Response detalle(@PathParam("id") long idPerro) {

		Response response = Response.noContent().build();
		Perro perro = null;

		try {

			PerroDAOImpl dao = PerroDAOImpl.getInstance();
			perro = dao.getById(idPerro);

			if (perro != null) {
				response = Response.ok().entity(perro).build();
			}

		} catch (Exception e) {

			response = Response.serverError().build();
			e.printStackTrace();

		} finally {
			return response;
		}

	}

	@SuppressWarnings("finally")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Insertar un Perro", notes = "Insertar un nuevo perro en la perrera", response = Perro.class, responseContainer = "Perro")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Creado correctamente"),
			@ApiResponse(code = 202, message = "Los parametros proporcionados son incorrectos"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	public Response insertar(Perro perro) {

		Response response = Response.status(Response.Status.ACCEPTED).build();

		try {

			PerroDAOImpl dao = PerroDAOImpl.getInstance();
			if (dao.insert(perro)) {
				response = Response.status(Response.Status.CREATED).entity(perro).build();
			}

		} catch (Exception e) {

			response = Response.serverError().build();
			e.printStackTrace();

		} finally {
			return response;
		}

	}

	@SuppressWarnings("finally")
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Modificar un Perro", notes = "Modifica un perro existente de la perrera", response = Perro.class, responseContainer = "Perro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Modificado correctamente"),
			@ApiResponse(code = 204, message = "No existe perro con esa ID"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	public Response modificar(Perro perro) {

		Response response = Response.noContent().build();

		try {

			PerroDAOImpl dao = PerroDAOImpl.getInstance();
			if (dao.update(perro)) {
				response = Response.ok().entity(perro).build();
			}

		} catch (Exception e) {

			response = Response.serverError().build();
			e.printStackTrace();

		} finally {
			return response;
		}

	}

	@SuppressWarnings("finally")
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Eliminar un Perro", notes = "Se elimina un perro de la perrera", response = Perro.class, responseContainer = "Perro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Eliminado correctamente"),
			@ApiResponse(code = 204, message = "No existe perro con esa ID"),
			@ApiResponse(code = 500, message = "Error inexperado en el servidor") })
	public Response eliminar(@PathParam("id") long idPerro) {

		Response response = Response.noContent().build();

		try {

			PerroDAOImpl dao = PerroDAOImpl.getInstance();
			if (dao.delete(idPerro)) {
				response = Response.ok().entity(idPerro).build();
			}

		} catch (Exception e) {

			response = Response.serverError().build();
			e.printStackTrace();

		} finally {
			return response;
		}

	}

}