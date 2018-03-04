package com.example.fernando.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

import com.example.fernando.myapplication.DAO.CategoriaDAO;
import com.example.fernando.myapplication.DAO.ServicoDAO;
import com.example.fernando.myapplication.DAO.UsuarioDAO;
import com.example.fernando.myapplication.Model.Categoria;
import com.example.fernando.myapplication.Model.Servico;

public class SplashScreenActivity extends DebugActivity {
    UsuarioDAO dao;
    ServicoDAO servicoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();

        dao = new UsuarioDAO(this);
        servicoDAO = new ServicoDAO(this);
        dao.checarTabela();
        if(dao.checarTabela() == true){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showMain();
                }
            },1000);
            Log.i("usuario", "Existe um usuário");
        }else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.i("usuario","não existe um usuário");
                    showHellow();
                }
            },1000);

        }
        try{
            //salvarCategoria();
            //salvarServico();
            Log.i("banco", "servico salvo com sucesso");
        }catch (Exception e){
            e.printStackTrace();
            Log.e("banco", "Erro ao salvar categoria"+e);
        }
    }
    public void showHellow(){
        Intent intent =  new Intent(SplashScreenActivity.this,HellowActivity.class);
        startActivity(intent);
        finish();
    }
    public void showMain(){
        Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void salvarServico(){
        Categoria categoria = new Categoria();
        categoria.setId((long)3);
        Servico servico = new Servico();
        servico.setNome("Alura");
        servico.setDescricao("curso de programação");
        servico.setCategoria(categoria);
        servicoDAO.salvar(servico);
    }

}
