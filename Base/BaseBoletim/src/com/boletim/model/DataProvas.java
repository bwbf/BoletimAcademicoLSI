package com.boletim.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on 06/11/2016.
 */
@XmlRootElement
public class DataProvas {
	private int id_aluno;
	private int id_disciplina;
    private Disciplina disciplina;
    private String data_prova;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getData_prova() {
        return data_prova;
    }

    public void setData_prova(String data_prova) {
        this.data_prova = data_prova;
    }

	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public int getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
    
    
}
