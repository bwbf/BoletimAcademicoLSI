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
import boletim.labsi.brunowesley.boletim.Model.Anotacoes;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.adapter.AnotacoesAdapter;


public class AnotacoesFragment extends BaseFragment {
    private List<Anotacoes> anotacoes;
    protected RecyclerView recyclerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anotacoes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_anotacoes_dois);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskAnotacoes();
    }

    private void taskAnotacoes() {
        this.anotacoes = AlunoMockService.getAnotacoes();
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
}
