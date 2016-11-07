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
import boletim.labsi.brunowesley.boletim.Model.Notas;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import boletim.labsi.brunowesley.boletim.adapter.NotasAdapter;

public class NotasFragment extends BaseFragment {
    private List<Notas> notas;
    protected RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notas, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_notas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskNotas();
    }

    private void taskNotas() {
        this.notas = AlunoMockService.getNotas();
        recyclerView.setAdapter(new NotasAdapter(getContext(), notas, onClickNota()));
    }

    private  NotasAdapter.NotasOnClickListner onClickNota() {
        return new NotasAdapter.NotasOnClickListner() {
            @Override
            public void onClicNotas(View view, int idx) {
                Notas a = notas.get(idx);
            }
        };
    }
}
