package boletim.labsi.brunowesley.boletim;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import boletim.labsi.brunowesley.boletim.Model.Aluno;
import boletim.labsi.brunowesley.boletim.activity.BaseActivity;
import boletim.labsi.brunowesley.boletim.service.BoletimService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Login extends BaseActivity {
    @BindView(R.id.txt_matricula) EditText matricula;
    @BindView(R.id.txt_senha) EditText senha;
    @BindView(R.id.txt_error) TextView error;
    @BindView(R.id.btn_login) Button login;
    List<Aluno> alunologin = new ArrayList<Aluno>();
    Boolean Sucesso = false;


      @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
          ButterKnife.bind(this);
          getTaks();
      }

    private void getTaks() {
        new GetAlunosTask().execute();
    }

    @OnClick(R.id.btn_login)
    public void click(){
        alunologin = BoletimService.getResult();
        for (Aluno aluno: alunologin){
            if(Integer.parseInt(matricula.getText().toString()) == aluno.getMatricula() && senha.getText().toString().equals(aluno.getSenha())){
                Sucesso = true;
                BoletimApplication.setID(aluno.getID());
            }
        }if(Sucesso == true){
            openHome();
            Sucesso = false;
            error.setText("");
        }else error.setText("Matricula ou senha invalidos");
    }

    private void openHome() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    private class GetAlunosTask extends AsyncTask<Void, Void, List<Aluno>>{

        @Override
        protected List<Aluno> doInBackground(Void... params) {

            try {
                return BoletimService.getAlunos(getContext());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    }


}
