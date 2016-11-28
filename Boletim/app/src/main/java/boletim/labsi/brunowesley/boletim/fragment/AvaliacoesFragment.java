package boletim.labsi.brunowesley.boletim.fragment;


import android.content.Intent;
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
import java.util.List;

import boletim.labsi.brunowesley.boletim.BoletimApplication;
import boletim.labsi.brunowesley.boletim.Model.AlunoMockService;
import boletim.labsi.brunowesley.boletim.Model.DataProvas;
import boletim.labsi.brunowesley.boletim.Model.Disciplina;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import boletim.labsi.brunowesley.boletim.adapter.AvaliacoesAdapter;
import boletim.labsi.brunowesley.boletim.service.BoletimService;


public class AvaliacoesFragment extends BaseFragment {

    private List<DataProvas> provas;
    protected RecyclerView recyclerView;
    private DataProvas prova = new DataProvas();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avaliacoes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_avaliacoes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        new getProvasTask().execute();
        view.findViewById(R.id.fab_provas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /*new anotacoesTask().execute();
                new getAnotacoesTask().execute();*/
                Intent intent = new Intent(getContext(), FormProvas.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskAvaliacoes();
    }

    private void taskAvaliacoes() {
        this.provas = BoletimService.getDataResult();
        recyclerView.setAdapter(new AvaliacoesAdapter(getContext(), provas, onClickAvaliacao()));
    }

    private AvaliacoesAdapter.AvaliacoesClickListner onClickAvaliacao(){
        return new AvaliacoesAdapter.AvaliacoesClickListner() {
            @Override
            public void onClicAvaliacao(View view, int idx) {
                if(provas != null && !provas.isEmpty()) {
                    DataProvas data = provas.get(idx);
                }
            }
        };
    }

    private class getProvasTask extends AsyncTask<Void, Void, List<DataProvas>> {

        @Override
        protected List<DataProvas> doInBackground(Void... params) {

            try {
                return BoletimService.getProvas(getContext(), BoletimApplication.getID());

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<DataProvas> provas) {
            if (provas != null) {
                recyclerView.setAdapter(new AvaliacoesAdapter(getContext(), provas, onClickAvaliacao()));
            }
        }
    }

    private class anotacoesTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                Disciplina dis = BoletimService.getDisplina(getContext());
                prova.setDisciplina(dis);
                return  BoletimService.insereNota(prova);

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
            if(provas != null){
                recyclerView.setAdapter(new AvaliacoesAdapter(getContext(),provas,onClickAvaliacao()));
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(BoletimApplication.getComunicadorA() != null  && BoletimApplication.getComunicadorB() != null ){
            prova.setData_prova(BoletimApplication.getComunicadorA());
            prova.setId_usuario(BoletimApplication.getID());
            new anotacoesTask().execute();
            new getProvasTask().execute();
            BoletimApplication.setComunicadorA(null);
            //BoletimApplication.setComunicadorB(null);
        }
    }
}
