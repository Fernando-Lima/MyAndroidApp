package com.example.fernando.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

import com.example.fernando.myapplication.DAO.UsuarioDAO;

public class SplashScreenActivity extends DebugActivity {
    UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();

        dao = new UsuarioDAO(this);
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

}
