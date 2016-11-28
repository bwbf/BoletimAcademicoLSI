package boletim.labsi.brunowesley.boletim.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import boletim.labsi.brunowesley.boletim.BoletimApplication;
import boletim.labsi.brunowesley.boletim.Model.AlunoMockService;
import boletim.labsi.brunowesley.boletim.Model.Anotacoes;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.adapter.AnotacoesAdapter;
import boletim.labsi.brunowesley.boletim.service.BoletimService;


public class AnotacoesFragment extends BaseFragment{
    private List<Anotacoes> anotacoes = new ArrayList<Anotacoes>();
    protected RecyclerView recyclerView;
    private final static Anotacoes anotacao = new Anotacoes();


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_anotacoes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_anotacoes_dois);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        new getAnotacoesTask().execute();
        view.findViewById(R.id.fab_anotacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /*new anotacoesTask().execute();
                new getAnotacoesTask().execute();*/
                Intent intent = new Intent(getContext(), FormAnotacoes.class);
                startActivity(intent);
            }
        });
        return view;
    }






    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskAnotacoes();
    }

    private void taskAnotacoes() {
        this.anotacoes = BoletimService.getAnotacoesResult();
        recyclerView.setAdapter(new AnotacoesAdapter(getContext(), anotacoes, onClickAnotacao()));
    }

    private AnotacoesAdapter.AnotacoesClickListner onClickAnotacao(){
        return new AnotacoesAdapter.AnotacoesClickListner() {
            @Override
            public void onClicAnotacoes(View view, int idx) {
                if (anotacoes != null && !anotacoes.isEmpty()){
                    Anotacoes c = anotacoes.get(idx);
                }

            }
        };
    }

  /*  @Override
    public void info(String descricao, String titulo) {
        anotacao.setTitulo(titulo);
        anotacao.setDescricao(descricao);
        anotacao.setId_aluno(BoletimApplication.getID());
        new anotacoesTask().execute();
        new getAnotacoesTask().execute();
    }*/

    private class getAnotacoesTask extends AsyncTask<Void, Void, List<Anotacoes>> {

        @Override
        protected List<Anotacoes> doInBackground(Void... params) {

            try {
                return  BoletimService.getAnotacoes(getContext(), BoletimApplication.getID());

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Anotacoes> anotacoes) {
            if(anotacoes != null){
                recyclerView.setAdapter(new AnotacoesAdapter(getContext(),anotacoes, onClickAnotacao()));
            }
        }
    }

    private class anotacoesTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                return  BoletimService.insereAnotacoes(anotacao);

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e1) {
                e1.printStackTrace();
            }return false;
        }

        @Override
        protected void onPostExecute(Boolean teste) {
            if(anotacoes != null){
                recyclerView.setAdapter(new AnotacoesAdapter(getContext(),anotacoes,onClickAnotacao()));
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(BoletimApplication.getComunicadorA() != null  && BoletimApplication.getComunicadorB() != null ){
            anotacao.setTitulo(BoletimApplication.getComunicadorA());
            anotacao.setDescricao(BoletimApplication.getComunicadorB());
            anotacao.setId_aluno(BoletimApplication.getID());
            new anotacoesTask().execute();
            new getAnotacoesTask().execute();
            BoletimApplication.setComunicadorA(null);
            BoletimApplication.setComunicadorB(null);
        }
    }
}
