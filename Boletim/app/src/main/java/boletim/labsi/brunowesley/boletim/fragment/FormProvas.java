package boletim.labsi.brunowesley.boletim.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import boletim.labsi.brunowesley.boletim.BoletimApplication;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.activity.BaseActivity;

/**
 * Created by wesle on 28/11/2016.
 */

public class FormProvas extends BaseActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_fragment_dialog_provas);
            Button btnFechar = (Button) findViewById(R.id.btn_canr);
            Button btnSalvar = (Button) findViewById(R.id.btn_sal);
            final EditText txtTitulo = (EditText) findViewById(R.id.txt_tit);
            final EditText txtDescricao = (EditText) findViewById(R.id.txt_descri);
            btnFechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            btnSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String descricao = txtDescricao.getText().toString();
                    String titulo = txtTitulo.getText().toString();
                    if(!descricao.equals("") && !titulo.equals("")){
                        BoletimApplication.Comunicador(titulo, descricao);
                    }
                    finish();
                }
            });
        }

}
