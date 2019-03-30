package com.transporte.controle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.nio.FloatBuffer;

public class RelatorioActivity extends Activity {

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        final Intent inte = new Intent(this, MainActivity.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.voltar);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(v.getId() == R.id.voltar) {

                    startActivity(inte);}
            }
        });

       /* TableRow tableRow = findViewById(R.id.tabelaRelatorio);
        tableRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                if(v.getId() == R.id.alterarBtnRel){
                    toast.setText("funcionol");
                    toast.show();
                }
            }
        }
        );*/
        //View view = new View(findViewById(R.id.tabelaRelatorio).setOnContextClickListener();
    }

    public void onClick(View v){
       Toast toast = Toast.makeText(this,null,Toast.LENGTH_SHORT);
        DataBase dataBase = new DataBase(this);
        SQLiteDatabase db = dataBase.getWritableDatabase();

        switch (v.getId()){
            case R.id.valorEdRe: toast.setText("valor");
                toast.show();break;
            case R.id.dataEdRe: toast.setText("DATA");
                toast.show();break;
            case R.id.incluirBtnRel: toast.setText("incluir");
                toast.show();

                EditText valor = findViewById(R.id.valorEdRe);
                EditText data = findViewById(R.id.dataEdRe);

                String vl = valor.toString();
                String dt = data.toString();

                //ACESSE O SITE https://www.devmedia.com.br/criando-um-crud-com-android-studio-e-sqlite/32815

                db.execSQL("INSERT INTO tabelaVeiculo VALUES('" + vl +"','"+ dt+"');" ,null);
                /*toast.setText("passou por aqui");
                toast.show();*/
                       }

       if(v.getId() == R.id.alterarBtnRel){
                TableLayout tabela = findViewById(R.id.editarRel);
                tabela.setVisibility(View.VISIBLE);
       }
    }
    }
