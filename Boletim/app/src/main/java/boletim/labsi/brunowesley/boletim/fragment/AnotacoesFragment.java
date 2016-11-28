package boletim.labsi.brunowesley.boletim.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
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


public class AnotacoesFragment extends BaseFragment {
    private List<Anotacoes> anotacoes = new ArrayList<Anotacoes>();
    protected RecyclerView recyclerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_anotacoes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_anotacoes_dois);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        new getAnotacoesTask().execute();
        view.findViewById(R.id.fab_anotacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new anotacoesTask().execute();
                new getAnotacoesTask().execute();
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
                Anotacoes c = anotacoes.get(idx);
            }
        };
    }

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

            try {Anotacoes anotacoes = new Anotacoes();
                anotacoes.setTitulo("Teste de Inserir");
                anotacoes.setDescricao("Funfa");
                anotacoes.setData("28/11/2016");
                anotacoes.setId_aluno(BoletimApplication.getID());
                return  BoletimService.insereAnotacoes(anotacoes);

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

}
