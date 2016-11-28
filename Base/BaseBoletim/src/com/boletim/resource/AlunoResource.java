package com.boletim.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.boletim.controller.AlunoController;
import com.boletim.model.Aluno;
import com.boletim.model.Anotacoes;
import com.boletim.model.DataProvas;
import com.boletim.model.Disciplina;
import com.boletim.model.Notas;
import com.google.gson.Gson;

@Path("/aluno")
public class AlunoResource {

	Aluno a = new Aluno();
	
	
	
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Aluno> listarTodos(){
		return new AlunoController().listarTodos();
	}
	
	@GET
	@Path("/notas/{id}")
	@Produces("application/json")
	public ArrayList<Notas> getNotas(@PathParam("id") int id){
		a.setId(id);
		return new AlunoController().listarNotas(a);
		
	}
	
	@GET
	@Path("/anotacoes/{id}")
	@Produces("application/json")
	public ArrayList<Anotacoes> getAnotacoes(@PathParam("id") Integer id){
		a.setId(id);
		return new AlunoController().listarAnotacoes(a);
		
	}
	
	@GET
	@Path("/dataProvas/{id}")
	@Produces("application/json")
	public ArrayList<DataProvas> getDataProvas(@PathParam("id") Integer id){
		a.setId(id);
		return new AlunoController().listarDatas(a);
		
	}
	
	@GET
	@Path("/discprova/{nome}")
	@Produces("application/json")
	public Disciplina getDisplina(@PathParam("nome") String nome){
		return new AlunoController().getDisciplina(nome);
		
	}
	
	@POST
    @Consumes({"application/json"})
    @Path("/insere/anotacao/")
	public boolean inserir(String content) throws SQLException{
		Gson g = new Gson();
		Anotacoes a = g.fromJson(content, Anotacoes.class);
		return new AlunoController().inserirAnotacao(a);
	}
	
	@POST
    @Consumes({"application/json"})
    @Path("/insere/provas/")
	public boolean inserirData(String content) throws SQLException{
		Gson g = new Gson();
		DataProvas a = g.fromJson(content, DataProvas.class);
		return new AlunoController().inserirProva(a);
	}

	
	

}
