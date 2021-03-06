package com.example.fernando.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fernando.myapplication.DAO.CategoriaDAO;
import com.example.fernando.myapplication.DAO.ServicoDAO;
import com.example.fernando.myapplication.Model.Categoria;
import com.example.fernando.myapplication.Model.Servico;

import java.util.ArrayList;
import java.util.List;

public class CadGrupoActivity extends DebugActivity {

    private BottomNavigationView navigation;
    private ViewPager viewPager;
    private List<View> viewList;
    private EditText edtDescricao;
    private TextView tvTitulo;
    ServicoDAO servicoDAO;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_grupo);
        servicoDAO = new ServicoDAO(this);

        Intent it = getIntent();
        if(!it.getStringExtra("id").equals("")){
            showDialog(it.getStringExtra("id"));
        }
        initView();
    }

    private void initView(){
        View view1 = getLayoutInflater().inflate(R.layout.item_view_pager_1,null);
        View view2 = getLayoutInflater().inflate(R.layout.item_view_pager_2,null);
        View view3 = getLayoutInflater().inflate(R.layout.item_view_pager_3,null);

        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        viewPager = findViewById(R.id.view_pager_bottom_navigation);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    navigation.setSelectedItemId(R.id.navigation_home);
                    break;
                case 1:
                    navigation.setSelectedItemId(R.id.navigation_dashboard);
                    break;
                case 2:
                    navigation.setSelectedItemId(R.id.navigation_notifications);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    private void showDialog(String codigo){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(CadGrupoActivity.this);
        View v = getLayoutInflater().inflate(R.layout.cad_grupo_dialog,null);
        tvTitulo = (TextView)v.findViewById(R.id.tv_dialog_titulo);
        edtDescricao = (EditText)v.findViewById(R.id.edt_dialog_descricao);
        buscarServico(codigo);


        mBuilder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //salvar o grupo
            }
        });
        mBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               finish();
            }
        });
        mBuilder.setView(v);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

    }

    public void buscarServico(String codigo){
        Servico servico = new Servico();
        servico = servicoDAO.buscarServico(codigo);

        tvTitulo.setText(servico.getNome());
        edtDescricao.setText(servico.getDescricao());
    }
    private PagerAdapter pagerAdapter = new PagerAdapter() {


        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
            Log.i("ciclo","destruiu item view");
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            Log.i("ciclo","add item view");
            return viewList.get(position);
        }
    };

}
