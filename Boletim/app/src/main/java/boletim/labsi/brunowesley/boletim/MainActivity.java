package boletim.labsi.brunowesley.boletim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import boletim.labsi.brunowesley.boletim.fragment.HorarioFragment;
import boletim.labsi.brunowesley.boletim.fragment.HorarioTabFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setupNavDrawer();
        replaceFragment(new HorarioFragment());
    }
}
