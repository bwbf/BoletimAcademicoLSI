package boletim.labsi.brunowesley.boletim.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import boletim.labsi.brunowesley.boletim.R;


public class AnotacoesFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anotacoes, container, false);
    }

}
