package com.boletim.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.boletim.dao.AlunoDAO;
import com.boletim.model.Aluno;
import com.boletim.model.Anotacoes;
import com.boletim.model.DataProvas;
import com.boletim.model.Disciplina;
import com.boletim.model.Notas;

public class AlunoController {
	
	public ArrayList<Aluno> listarTodos(){
		return AlunoDAO.getInstance().listarTodos();
	}


	public ArrayList<Notas> listarNotas(Aluno a) {
		return AlunoDAO.getInstance().listarNotas(a);
	}


	public ArrayList<Anotacoes> listarAnotacoes(Aluno a) {
		return AlunoDAO.getInstance().listarAnotacoes(a);
	}


	public ArrayList<DataProvas> listarDatas(Aluno a) {
		return AlunoDAO.getInstance().listarDatas(a);
	}


	public boolean inserirAnotacao(Anotacoes content) throws SQLException{
		return AlunoDAO.getInstance().inserirAnotacao(content);
	}


	public boolean inserirProva(DataProvas a) throws SQLException {
		return AlunoDAO.getInstance().inserirProva(a);
	}


	public Disciplina getDisciplina(String nome) {
		return AlunoDAO.getInstance().getDisciplinaPeloNome(nome);
	}

}
