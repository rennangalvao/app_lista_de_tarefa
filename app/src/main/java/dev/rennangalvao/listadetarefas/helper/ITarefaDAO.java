package dev.rennangalvao.listadetarefas.helper;

import java.util.List;

import dev.rennangalvao.listadetarefas.model.Tarefa;

public interface ITarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public  boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();

}
