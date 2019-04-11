
package br.usjt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class ListaLocaisActivity extends AppCompatActivity {

    private LatLongDao localizacaoDAO;
    private RecyclerView locationsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);
        localizacaoDAO = new  LatLongDao(this);
        ArrayList<LatLongLocalizacao> localizacoes = (ArrayList<LatLongLocalizacao>) localizacaoDAO.lista();
        locationsRecyclerView = findViewById(R.id.localizacoesRecyclerView);
        locationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LocaisRecyclerViewAdapter adapter = new LocaisRecyclerViewAdapter(localizacoes);
        locationsRecyclerView.setAdapter(adapter);
    }
}
