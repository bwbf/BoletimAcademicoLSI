package boletim.labsi.brunowesley.boletim.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import boletim.labsi.brunowesley.boletim.Model.AlunoMockService;
import boletim.labsi.brunowesley.boletim.Model.DataProvas;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import boletim.labsi.brunowesley.boletim.adapter.AvaliacoesAdapter;


public class AvaliacoesFragment extends BaseFragment {

    private List<DataProvas> provas;
    protected RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avaliacoes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_avaliacoes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskAvaliacoes();
    }

    private void taskAvaliacoes() {
        this.provas = AlunoMockService.getDataProvas();
        recyclerView.setAdapter(new AvaliacoesAdapter(getContext(), provas, onClickAvaliacao()));
    }

    private AvaliacoesAdapter.AvaliacoesClickListner onClickAvaliacao(){
        return new AvaliacoesAdapter.AvaliacoesClickListner() {
            @Override
            public void onClicAvaliacao(View view, int idx) {
                DataProvas data = provas.get(idx);
            }
        };
    }
}
