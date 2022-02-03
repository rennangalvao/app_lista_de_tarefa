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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editText = findViewById(R.id.textTarefa);
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

                Tarefa tarefa = new Tarefa();
                tarefa.setNomeTarefa("Ir ao mercado");
                tarefaDAO.salvar( tarefa );

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}