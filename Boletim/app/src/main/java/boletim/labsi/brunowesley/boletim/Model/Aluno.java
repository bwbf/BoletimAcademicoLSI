package boletim.labsi.brunowesley.boletim.Model;

import java.util.List;

/**
 * Created by Bruno on 06/11/2016.
 */

public class Aluno {

    private int ID;
    private String nome;
    private int matricula;
    private String senha;
    private List<Notas> notas;
    private List<Anotacoes> anotacoes;
    private List<DataProvas> dataProvas;

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }

    public List<Anotacoes> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<Anotacoes> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public List<DataProvas> getDataProvas() {
        return dataProvas;
    }

    public void setDataProvas(List<DataProvas> dataProvas) {
        this.dataProvas = dataProvas;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
