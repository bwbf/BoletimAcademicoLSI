package boletim.labsi.brunowesley.boletim.Model;

/**
 * Created by Bruno on 06/11/2016.
 */

public class Notas {

    private Disciplina disciplina;
    private String nota_um;
    private String nota_dois;
    private String sub_um;
    private String sub_dois;
    private String nota_final;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getNota_um() {
        return nota_um;
    }

    public void setNota_um(String nota_um) {
        this.nota_um = nota_um;
    }

    public String getNota_dois() {
        return nota_dois;
    }

    public void setNota_dois(String nota_dois) {
        this.nota_dois = nota_dois;
    }

    public String getSub_um() {
        return sub_um;
    }

    public void setSub_um(String sub_um) {
        this.sub_um = sub_um;
    }

    public String getSub_dois() {
        return sub_dois;
    }

    public void setSub_dois(String sub_dois) {
        this.sub_dois = sub_dois;
    }

    public String getNota_final() {
        return nota_final;
    }

    public void setNota_final(String nota_final) {
        this.nota_final = nota_final;
    }
}
