package joaopauloroslindo.recycleviewexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListaDeAbastecimentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_abastecimentos);

        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);
        VeiculoAdapter adaptador = new VeiculoAdapter();

        Veiculos teste = new Veiculos();
        teste.setCombustivel(Double.parseDouble(getIntent().getStringExtra("0")));
        teste.setPosto((getIntent().getStringExtra("3")));
        teste.setKilometragem(Integer.parseInt(getIntent().getStringExtra("2")));
        teste.setDataAbastecimento((getIntent().getStringExtra("1")));

        ArrayList<Veiculos> testeLista = new ArrayList<>();
        testeLista.add(teste);

        adaptador.setListaVeiculos( testeLista);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter( adaptador );
    }
}
