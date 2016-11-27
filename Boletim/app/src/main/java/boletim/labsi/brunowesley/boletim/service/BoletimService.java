package boletim.labsi.brunowesley.boletim.service;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import boletim.labsi.brunowesley.boletim.Model.Aluno;
import boletim.labsi.brunowesley.boletim.Model.Disciplina;
import boletim.labsi.brunowesley.boletim.Model.Notas;
import livroandroid.lib.utils.HttpHelper;

/**
 * Created by wesle on 27/11/2016.
 */

public class BoletimService {

    private static final String URL = "http://192.168.3.103:8080/BaseBoletim/aluno/listarTodos";
    private static final String URL_NOTAS = "http://192.168.3.103:8080/BaseBoletim/aluno/notas/{id}";
    private static List<Aluno> result = new ArrayList<Aluno>();
    private static List<Notas> notasResult = new ArrayList<Notas>();
    private static List<Disciplina> disciplinasResult = new ArrayList<Disciplina>();

    public static List<Aluno> getAlunos(Context context) throws IOException{
        String url = URL;
        HttpHelper http = new HttpHelper();
        String json = http.doGet(url);
        List<Aluno> alunos = parserJson(context, json);
        setResult(alunos);
        return  alunos;
    }

    private static void setResult(List<Aluno> alunos) {
        result = alunos;
    }

    public static List<Aluno> getResult(){
        return result;
    }

    private static List<Aluno> parserJson(Context context, String json) throws IOException {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            JSONObject root = new JSONObject(json);
            JSONArray obj = root.getJSONArray("aluno");
            //JSONArray jsonAlunos = obj.getJSONArray(("aluno"));

            for (int i = 0; i < obj.length(); i++){
                JSONObject jsonAluno = obj.getJSONObject(i);
                Aluno aluno = new Aluno();
                aluno.setID(jsonAluno.getInt("id"));
                aluno.setNome(jsonAluno.optString("nome"));
                aluno.setMatricula(jsonAluno.optInt("matricula"));
                aluno.setSenha(jsonAluno.optString("senha"));
                alunos.add(aluno);
            }

        }catch (JSONException e){
            throw new IOException(e.getMessage(), e);
        }
        return alunos;
    }

    public static List<Notas> getNotas(Context context,int id) throws IOException, JSONException {
        String idString = Integer.toString(id);
        String url = URL_NOTAS.replace("{id}", idString);
        HttpHelper http = new HttpHelper();
        String json = http.doGet(url);
        List<Notas> notas = parserJsonNotas(context, json);
        setResultNotas(notas);
        return  notas;
    }

    private static List<Notas> parserJsonNotas(Context context, String json) throws JSONException {
        List<Notas> notas = new ArrayList<Notas>();
        JSONObject root = new JSONObject(json);
        JSONArray obj = root.getJSONArray("notas");
        for (int i = 0; i < obj.length(); i++){
            JSONObject jsonDisciplina = obj.getJSONObject(i);
            JSONObject disciplina = jsonDisciplina.optJSONObject("disciplina");
            Disciplina dis = new Disciplina();
            dis.setNome(disciplina.optString("nome"));
            dis.setHoraInicial(disciplina.optString("horaInicial"));
            dis.setCargaHoraria(disciplina.optString("cargaHoraria"));
            dis.setDia(disciplina.optString("dia"));
            disciplinasResult.add(dis);
            Notas nota = new Notas();
            nota.setDisciplina(dis);
            nota.setNota_um(jsonDisciplina.optString("nota_um"));
            nota.setSub_um(jsonDisciplina.optString("sub_um"));
            nota.setNota_dois(jsonDisciplina.optString("nota_dois"));
            nota.setSub_dois(jsonDisciplina.optString("sub_dois"));
            nota.setNota_final(jsonDisciplina.optString("nota_final"));
            notas.add(nota);
        }
        return notas;
    }

    public static List<Notas> getNotas() {
        return notasResult;
    }
    private static void setResultNotas(List<Notas> notas) {
        notasResult = notas;
    }

    public static List<Disciplina> getDisciplinas() {
        return disciplinasResult;
    }

}
