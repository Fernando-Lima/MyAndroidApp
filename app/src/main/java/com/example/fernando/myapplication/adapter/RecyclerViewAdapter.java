package com.example.fernando.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fernando.myapplication.Model.Servico;
import com.example.fernando.myapplication.R;

import java.util.List;

/**
 * Created by Fernando on 30/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderServico> {
    private List<Servico> servicos;

    public RecyclerViewAdapter (List<Servico> servicos){
        this.servicos = servicos;
    }
    @Override
    public RecyclerViewAdapter.ViewHolderServico onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());                                    // referência de uma classe layout inflater
        View view = layoutInflater.inflate(R.layout.list_servico_item, parent,false);                    // referência da view, layout de cada linha
        ViewHolderServico holderServicoo = new ViewHolderServico(view);                                              // criamos objeto ViewHolderServico
        return holderServicoo;                                                                                       // retorna a referência da classe ViewHolderServico
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolderServico holder, int position) {

        if((servicos != null && servicos.size()>0)){
            Servico servico = servicos.get(position);
            holder.tvNome.setText(servico.getNome());
            holder.tvDescricao.setText(servico.getDescricao());
            holder.tvCategoria.setText(servico.getCategoria());
        }
    }

    @Override
    public int getItemCount() {
        return servicos.size();
    }

    public static class ViewHolderServico extends RecyclerView.ViewHolder{

        public TextView tvNome;
        public TextView tvDescricao;
        public TextView tvCategoria;

        public ViewHolderServico(View itemView) {
            super(itemView);

            tvNome = (TextView)itemView.findViewById(R.id.list_item_servico_tv_nome);
            tvDescricao = (TextView)itemView.findViewById(R.id.list_item_servico_tv_descricao);
            tvCategoria = (TextView)itemView.findViewById(R.id.list_item_servico_tv_categoria);
        }
    }

}
