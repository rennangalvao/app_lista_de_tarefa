package dev.rennangalvao.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import dev.rennangalvao.listadetarefas.model.Tarefa;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase whrite ;
    private SQLiteDatabase  read;

    public TarefaDAO( Context context) {
        DbHelper db = new DbHelper( context );
        whrite = db.getWritableDatabase(); // Salva
        read = db.getReadableDatabase();   // Recuperar
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put( "nome", tarefa.getNomeTarefa() );
        try {
            whrite.insert(DbHelper.TABELA_TAREFAS, null, cv );
            Log.i("INFO", "Tarefa salva com sucesso!");
        }catch (Exception e){
            Log.i("INFO", "Erro ao salvar!" + e.getMessage() );
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
