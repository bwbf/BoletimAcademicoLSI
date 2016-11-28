package boletim.labsi.brunowesley.boletim.Model;

/**
 * Created by Bruno on 06/11/2016.
 */
public class Anotacoes {
    private Integer id_aluno;
    private String titulo;
    private String descricao;
    private String data;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId_aluno(Integer id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Integer getId_aluno() {
        return id_aluno;
    }

    @Override
    public String toString() {
        return "Anotacoes{" +
                "id_aluno=" + id_aluno +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
