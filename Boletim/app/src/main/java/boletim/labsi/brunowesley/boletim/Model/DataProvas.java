package boletim.labsi.brunowesley.boletim.Model;

/**
 * Created by Bruno on 06/11/2016.
 */
public class DataProvas {
    private int id_usuario;
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

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }
}
