package com.example.fernando.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fernando.myapplication.CadGrupoActivity;
import com.example.fernando.myapplication.CadServicoActivity;
import com.example.fernando.myapplication.Model.Servico;
import com.example.fernando.myapplication.R;

import java.util.List;

/**
 * Created by Fernando on 30/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderServico> {
    private List<Servico> servicos;
    private Context context;

    public RecyclerViewAdapter (List<Servico> servicos, Context context){
        this.servicos = servicos;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolderServico onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());                                    // referência de uma classe layout inflater
        View view = layoutInflater.inflate(R.layout.list_servico_item, parent,false);                    // referência da view, layout de cada linha
        ViewHolderServico holderServicoo = new ViewHolderServico(view);                                              // criamos objeto ViewHolderServico
        return holderServicoo;                                                                                       // retorna a referência da classe ViewHolderServico
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolderServico holder, int position) {

        if((servicos != null && servicos.size()>0)){
            final ViewHolderServico holderServico = (ViewHolderServico) holder;
            final Servico servico = servicos.get(position);
            holder.tvNome.setText(servico.getNome());
            holder.tvDescricao.setText(servico.getDescricao());
            holder.tvCategoria.setText(servico.getIdCategoria().toString());

            holderServico.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String codigo = String.valueOf(servico.getId());
                    Intent it  = new Intent(context, CadGrupoActivity.class);
                    it.putExtra("id",codigo);
                    context.startActivity(it);
                }
            });
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
        private View mView;

        public ViewHolderServico(View itemView) {
            super(itemView);
            mView = itemView;

            tvNome = (TextView)itemView.findViewById(R.id.list_item_servico_tv_nome);
            tvDescricao = (TextView)itemView.findViewById(R.id.list_item_servico_tv_descricao);
            tvCategoria = (TextView)itemView.findViewById(R.id.list_item_servico_tv_categoria);
        }
    }

}
