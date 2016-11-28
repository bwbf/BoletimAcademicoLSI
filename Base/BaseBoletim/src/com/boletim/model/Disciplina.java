package com.boletim.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on 06/11/2016.
 */
@XmlRootElement
public class Disciplina{
	private int id_disciplina;
    private String nome;
    private String cargaHoraria;
    private String horaInicial;
    private String dia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

	public int getId() {
		return id_disciplina;
	}

	public void setId(int id) {
		this.id_disciplina = id;
	}
    
    
}
