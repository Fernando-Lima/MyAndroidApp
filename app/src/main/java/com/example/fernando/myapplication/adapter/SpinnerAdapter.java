package com.example.fernando.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fernando.myapplication.Model.Categoria;

import java.util.List;

/**
 * Created by Fernando on 15/03/2018.
 */

public class SpinnerAdapter extends BaseAdapter {
    private Context context;
    private List<Categoria> categorias;

    public SpinnerAdapter (Context context, List<Categoria> categorias){
    this.context = context;
    this.categorias = categorias;
    }
    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        if (categorias != null && categorias.size() >0) {
            final Categoria categoria = categorias.get(position);
            tv.setText(categoria.getNome());
            tv.setTextSize(18);
            tv.setPadding(60,40,40,60);
        }
        return tv;
    }
}
