package boletim.labsi.brunowesley.boletim.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import boletim.labsi.brunowesley.boletim.BoletimApplication;
import boletim.labsi.brunowesley.boletim.MainActivity;
import boletim.labsi.brunowesley.boletim.R;
import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by wesle on 28/11/2016.
 */

public class FormAnotacoes extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.layout_fragment_dialog_anotacao);
        Button btnFechar = (Button) findViewById(R.id.btn_cancelar);
        Button btnSalvar = (Button) findViewById(R.id.btn_salvar);
        final EditText txtTitulo = (EditText) findViewById(R.id.txt_titulo);
        final EditText txtDescricao = (EditText) findViewById(R.id.txt_descricao);
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
                    BoletimApplication.Comunicador(descricao, titulo);
                }
                finish();
            }
        });
    }


}
