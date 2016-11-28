package boletim.labsi.brunowesley.boletim.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import boletim.labsi.brunowesley.boletim.Model.Disciplina;
import boletim.labsi.brunowesley.boletim.Model.Notas;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import boletim.labsi.brunowesley.boletim.adapter.HorarioAdapter;
import boletim.labsi.brunowesley.boletim.service.BoletimService;

public class HorarioFragment extends BaseFragment {
    protected RecyclerView recyclerView;
    private List<Disciplina> disciplinas;
    private String tipo;

    public static HorarioFragment newInstance(int tipo){
        Bundle args = new Bundle();
        args.putInt("tipo", tipo);
        HorarioFragment f = new HorarioFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            this.tipo = getArguments().getString("tipo");
        }
        getTaks();
    }

    private void getTaks() {
        new GetDisciplinaTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_horario, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskDisciplinas();
    }

    private void taskDisciplinas() {
        //this.disciplinas = AlunoMockService.getDisciplinas(getContext(), tipo);
        this.disciplinas = BoletimService.getDisciplinas();
        recyclerView.setAdapter(new HorarioAdapter(disciplinas, getContext(), onClickHorario() ));
    }

    private HorarioAdapter.HorarioOnClickListener onClickHorario() {
        return new HorarioAdapter.HorarioOnClickListener(){
            @Override
            public void onClickDisciplina(View view, int idx) {
                if(disciplinas != null && disciplinas.size()<0){
                    Disciplina c = disciplinas.get(idx);
                }

            }
        };
    }

    private class GetDisciplinaTask extends AsyncTask<Void, Void, List<Disciplina>> {

        @Override
        protected List<Disciplina> doInBackground(Void... params) {

            try {BoletimService.getNotas(getContext(), BoletimApplication.getID());
                return  BoletimService.getDisciplinas();

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Disciplina> disciplinas) {
            if(disciplinas != null){
                recyclerView.setAdapter(new HorarioAdapter(disciplinas,getContext(), onClickHorario()));
            }
        }
    }


}
