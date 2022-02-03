package dev.rennangalvao.listadetarefas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.rennangalvao.listadetarefas.R;
import dev.rennangalvao.listadetarefas.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {

    private List<Tarefa> listaTarefas;

    public TarefaAdapter(List<Tarefa> lista) {
        this.listaTarefas = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemlista = LayoutInflater.from( parent.getContext() )
                .inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new MyViewHolder( itemlista );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Tarefa tarefa = listaTarefas.get( position );
        holder.tarefa.setText( tarefa.getNomeTarefa() );
    }

    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tarefa;

        public MyViewHolder(View itemView){
            super(itemView);

            tarefa = itemView.findViewById(R.id.textTarefa);
        }
    }
}
