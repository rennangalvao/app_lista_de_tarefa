package dev.rennangalvao.listadetarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import dev.rennangalvao.listadetarefas.R;
import dev.rennangalvao.listadetarefas.helper.TarefaDAO;
import dev.rennangalvao.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editText;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editText = findViewById(R.id.textTarefa);

        // Recuperar tarefa, caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra( "tarefaSelecionada");

        //Configurar tarefa na caixa de texto
        if ( tarefaAtual != null){
            editText.setText( tarefaAtual.getNomeTarefa() );
        }
    }

     // Adicionar menu Salvar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // método de click " salvar"
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.action_salvar:
                //Executa ação para o item salvar
                TarefaDAO tarefaDAO = new TarefaDAO( getApplicationContext() );

                if ( tarefaAtual != null){ //edição
                    String nomeTarefa = editText.getText().toString();
                    if (!nomeTarefa.isEmpty()){
                        finish();
                        Toast.makeText(getApplicationContext(),
                                "Sucesso ao atualizar tarefa!",
                                Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao atualizar!",
                                Toast.LENGTH_LONG).show();
                    }
                }else { //Salvar

                    String nomeTarefa = editText.getText().toString();
                    if (!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if ( tarefaDAO.salvar( tarefa ) ){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao salvar tarefa!",
                                    Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao salvar!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}