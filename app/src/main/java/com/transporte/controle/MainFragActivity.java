package com.transporte.controle;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainFragActivity extends Activity
            implements ListaAcentos.InterfaceDaLista{

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frag);


    }


    public void onClick(View v){

        switch (v.getId()) {

            case R.id.voltar:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void itemClicked(long id){

        DetalhesPassageirosActivity detalhes = new DetalhesPassageirosActivity();

        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();

        detalhes.setWord(id);
        fragmentTransaction.replace(R.id.fragment_container, detalhes);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

    }
}
