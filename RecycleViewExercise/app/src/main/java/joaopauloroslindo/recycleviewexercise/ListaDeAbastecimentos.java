package joaopauloroslindo.recycleviewexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListaDeAbastecimentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_abastecimentos);

        Realm realm = Realm.getDefaultInstance();

        RealmResults<Veiculos> result1 = realm.where(Veiculos.class).findAll();
        ArrayList<Veiculos> arrayParaResultado=new ArrayList<>();

        for(int i = 0; i < result1.size(); i++){
            Veiculos atual = result1.get(i);
            arrayParaResultado.add(atual);
        }


        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);
        VeiculoAdapter adaptador = new VeiculoAdapter();
        adaptador.setListaVeiculos( arrayParaResultado);//aki mudar
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter( adaptador );
    }
}
