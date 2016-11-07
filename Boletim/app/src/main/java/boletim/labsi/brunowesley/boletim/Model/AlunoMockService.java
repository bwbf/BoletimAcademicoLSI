package boletim.labsi.brunowesley.boletim.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wesle on 07/11/2016.
 */

public class AlunoMockService {

    public static List<Disciplina> getDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList<>();
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("PLP");
        disciplina.setCargaHoraria("3");
        disciplina.setHoraInicial("18h30");
        disciplina.setDia("Segunda");

        disciplinas.add(disciplina);

        disciplina = new Disciplina();
        disciplina.setNome("Banco de Dados");
        disciplina.setCargaHoraria("4");
        disciplina.setHoraInicial("20h20");
        disciplina.setDia("Segunda");

        disciplinas.add(disciplina);

        disciplina = new Disciplina();
        disciplina.setNome(".NET");
        disciplina.setCargaHoraria("5");
        disciplina.setHoraInicial("18:30");
        disciplina.setDia("Terça");

        disciplinas.add(disciplina);

        disciplina = new Disciplina();
        disciplina.setNome("Lab Banco de Dados");
        disciplina.setCargaHoraria("2");
        disciplina.setHoraInicial("20h20");
        disciplina.setDia("Terça");

        disciplinas.add(disciplina);

        disciplina = new Disciplina();
        disciplina.setNome("Programação");
        disciplina.setCargaHoraria("2");
        disciplina.setHoraInicial("18h30");
        disciplina.setDia("Quarta");

        disciplinas.add(disciplina);

        disciplina = new Disciplina();
        disciplina.setNome("Lab Programação");
        disciplina.setCargaHoraria("2");
        disciplina.setHoraInicial("20h20");
        disciplina.setDia("Quarta");

        disciplinas.add(disciplina);


        disciplina = new Disciplina();
        disciplina.setNome("SI");
        disciplina.setCargaHoraria("2");
        disciplina.setHoraInicial("18h30");
        disciplina.setDia("Quinta");

        disciplinas.add(disciplina);


        disciplina = new Disciplina();
        disciplina.setNome("Lab SI");
        disciplina.setCargaHoraria("2");
        disciplina.setHoraInicial("20h20");
        disciplina.setDia("Quinta");

        disciplinas.add(disciplina);

        disciplina = new Disciplina();
        disciplina.setNome("MAP");
        disciplina.setCargaHoraria("2");
        disciplina.setHoraInicial("18h30");
        disciplina.setDia("Sexta");

        disciplinas.add(disciplina);


        disciplina = new Disciplina();
        disciplina.setNome("Android");
        disciplina.setCargaHoraria("2");
        disciplina.setHoraInicial("20h20");
        disciplina.setDia("Sexta");

        disciplinas.add(disciplina);

        return disciplinas;

    }



    public static List<Disciplina> getDisciplinas(Context context, String tipo) {
        List<Disciplina> listas = getDisciplinas();
        if (tipo == "Segunda"){
            List<Disciplina> filtro = new ArrayList<>();
            for (Disciplina lista : listas){
                if (lista.getDia().equals(tipo)){
                    filtro.add(lista);
                }
        }return filtro;

        }else if(tipo == "Terça"){
            List<Disciplina> filtro = new ArrayList<>();
            for (Disciplina lista : listas){
                if (lista.getDia().equals(tipo)){
                    filtro.add(lista);
                }
            }return filtro;}
        else if(tipo == "Quarta"){
            List<Disciplina> filtro = new ArrayList<>();
            for (Disciplina lista : listas){
                if (lista.getDia().equals(tipo)){
                    filtro.add(lista);
                }
            }return filtro;}
        else if(tipo == "Quinta"){
            List<Disciplina> filtro = new ArrayList<>();
            for (Disciplina lista : listas){
                if (lista.getDia().equals(tipo)){
                    filtro.add(lista);
                }
            }return filtro;}
        else if(tipo == "Sexta") {
            List<Disciplina> filtro = new ArrayList<>();
            for (Disciplina lista : listas) {
                if (lista.getDia().equals(tipo)) {
                    filtro.add(lista);
                }
            }
            return filtro;
        }
        return listas;
        }

    public static List<Notas> getNotas() {
        List<Notas> notas =  new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas = getDisciplinas();
        for (Disciplina disciplina : disciplinas){
            Notas nota = new Notas();
            nota.setDisciplina(disciplina);
            nota.setNota_um("0.0");
            nota.setNota_dois("0.0");
            nota.setSub_um("0.0");
            nota.setSub_dois("0.0");
            nota.setNota_final("0.0");
            notas.add(nota);
        } return notas;

    }

    public static List<Anotacoes> getAnotacoes() {
        List<Anotacoes> anotacoes = new ArrayList<>();
        Anotacoes a = new Anotacoes();
        a.setTitulo("Mock Teste 1");
        a.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel porta odio. Donec imperdiet ipsum dolor, in bibendum justo maximus id. Donec varius interdum ornare.");

        anotacoes.add(a);

        a = new Anotacoes();
        a.setTitulo("Mock Teste 2");
        a.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel porta odio. Donec imperdiet ipsum dolor, in bibendum justo maximus id. Donec varius interdum ornare.");
        anotacoes.add(a);
        return anotacoes;
    }


    public static List<DataProvas> getDataProvas() {
        List<DataProvas> provas = new ArrayList<>();
        DataProvas dataProvas = new DataProvas();

        Disciplina disciplina = new Disciplina();
        disciplina.setNome("PLP");
        disciplina.setCargaHoraria("3");
        disciplina.setHoraInicial("18h30");
        disciplina.setDia("Segunda");

        dataProvas.setDisciplina(disciplina);
        dataProvas.setData_prova("22/10/2016");

        provas.add(dataProvas);

        dataProvas.setDisciplina(disciplina);
        dataProvas.setData_prova("22/11/2016");
        provas.add(dataProvas);

        dataProvas.setDisciplina(disciplina);
        dataProvas.setData_prova("22/12/2016");
        provas.add(dataProvas);

        dataProvas.setDisciplina(disciplina);
        dataProvas.setData_prova("22/11/2017");
        provas.add(dataProvas);
        return provas;
    }
}
