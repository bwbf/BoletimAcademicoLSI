package boletim.labsi.brunowesley.boletim.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import boletim.labsi.brunowesley.boletim.BoletimApplication;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.fragment.HorarioFragment;

/**
 * Created by wesle on 07/11/2016.
 */

public class TabAdapterHorario extends FragmentPagerAdapter {

    private Context context;

    public TabAdapterHorario(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return context.getString(R.string.segunda);
        }else if (position == 1){
            return context.getString(R.string.terca);
        }else if (position == 2){
            return context.getString(R.string.quarta);
        }
        else if (position == 3){
            return context.getString(R.string.quinta);
        }return context.getString(R.string.sexta);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        if (position == 0){
            f = HorarioFragment.newInstance(R.string.segunda);
        }else if (position == 1){
            f = HorarioFragment.newInstance(R.string.terca);
        }else if (position == 2){
            f = HorarioFragment.newInstance(R.string.quarta);
        }else if (position == 3){
            f = HorarioFragment.newInstance(R.string.quinta);
        }else{
            f = HorarioFragment.newInstance(R.string.sexta);
        }

        return f;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
