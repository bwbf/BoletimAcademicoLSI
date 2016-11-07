package boletim.labsi.brunowesley.boletim.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.adapter.TabAdapterHorario;

/**
 * Created by wesle on 07/11/2016.
 */

public class HorarioTabFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_horario_tab, container, false);
        //VIew Pager
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new TabAdapterHorario(getContext(), getChildFragmentManager()));
        // Tabs
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        // Cria as tabs com o mesmo adapter utilizado pelo ViewPager
        tabLayout.setupWithViewPager(viewPager);
        int cor = ContextCompat.getColor(getContext(),R.color.white);
        // Cor branca no texto (o fundo azul foi definido no layout)
        tabLayout.setTabTextColors(cor, cor);
        return view;
    }
}
