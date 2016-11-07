package boletim.labsi.brunowesley.boletim;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Login extends BaseActivity {
    @BindView(R.id.txt_matricula) EditText matricula;
    @BindView(R.id.txt_senha) EditText senha;
    @BindView(R.id.txt_error) TextView error;
    @BindView(R.id.btn_login) Button login;

      @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
          ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void click(){
        if(matricula.getText().toString().equals("admin") && senha.getText().toString().equals("admin")){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }else{
            error.setText("Matricula ou senha invalidos");
        }
    }


}
