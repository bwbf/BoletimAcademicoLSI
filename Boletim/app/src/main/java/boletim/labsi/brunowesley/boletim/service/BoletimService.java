package boletim.labsi.brunowesley.boletim.service;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import boletim.labsi.brunowesley.boletim.BoletimApplication;
import boletim.labsi.brunowesley.boletim.Model.Aluno;
import boletim.labsi.brunowesley.boletim.Model.Anotacoes;
import boletim.labsi.brunowesley.boletim.Model.Disciplina;
import boletim.labsi.brunowesley.boletim.Model.Notas;
import livroandroid.lib.utils.HttpHelper;

/**
 * Created by wesle on 27/11/2016.
 */

public class BoletimService {

    private static final String URL_LISTAR = "http://192.168.3.103:8080/BaseBoletim/aluno/listarTodos";
    private static final String URL_NOTAS = "http://192.168.3.103:8080/BaseBoletim/aluno/notas/{id}";
    private static final String URL_ANOTACOES = "http://192.168.3.103:8080/BaseBoletim/aluno/anotacoes/{id}";
    private static final String URL_INSERIR_ANOTACAO = "http://192.168.3.103:8080/BaseBoletim/aluno/insere/anotacao/";
    private static List<Aluno> result = new ArrayList<Aluno>();
    private static List<Notas> notasResult = new ArrayList<Notas>();
    private static List<Disciplina> disciplinasResult = new ArrayList<Disciplina>();
    private static List<Anotacoes> anotacoesResult = new ArrayList<Anotacoes>();

    public static List<Aluno> getAlunos(Context context) throws IOException{
        String url = URL_LISTAR;
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

    public static List<Anotacoes> getAnotacoes(Context context, int id) throws IOException, JSONException {
        String idString = Integer.toString(id);
        String url = URL_ANOTACOES.replace("{id}", idString);
        HttpHelper http = new HttpHelper();
        String json = http.doGet(url);
        List<Anotacoes> anotacoes = parserJsonAnotacoes(context, json);
        setResultAnotacoes(anotacoes);
        return  anotacoes;
    }

    private static void setResultAnotacoes(List<Anotacoes> anotacoes) {
        anotacoesResult = anotacoes;
    }

    public static List<Anotacoes> getAnotacoesResult() {
        return anotacoesResult;
    }

    private static List<Anotacoes> parserJsonAnotacoes(Context context, String json) throws JSONException {
        List<Anotacoes> a = new ArrayList<Anotacoes>();
        JSONObject root = new JSONObject(json);
        JSONArray obj = root.getJSONArray("anotacoes");
        for (int i = 0; i < obj.length(); i++){
            JSONObject d = obj.getJSONObject(i);
            Anotacoes ano = new Anotacoes();
            ano.setTitulo(d.optString("titulo"));
            ano.setDescricao(d.optString("descricao"));
            ano.setData(d.getString("data_anotacao"));
            a.add(ano);
        }
        return a;
    }

    private static List<Notas> parserJsonNotas(Context context, String json) throws JSONException {
        List<Notas> notas = new ArrayList<Notas>();
        JSONObject root = new JSONObject(json);
        JSONArray obj = root.getJSONArray("notas");
        disciplinasResult = new ArrayList<Disciplina>();
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

    public static boolean insereAnotacoes(Anotacoes anotacoes) throws Exception {
        Gson g = new Gson();
        String json = g.toJson(anotacoes, Anotacoes.class);
        HttpHelper http = new HttpHelper();
        sendPost(URL_INSERIR_ANOTACAO, json, "POST");
        return true;
    }


    private static void sendPost(String url, String urlParameters, String method) throws Exception {

        String USER_AGENT = "Mozilla/5.0";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        //String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }


}
