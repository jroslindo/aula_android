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



        Veiculos teste = new Veiculos();
        ArrayList<Veiculos> testeLista = new ArrayList<>();
        String soParaNome="";
        String soParaNome1="";
        String soParaNome2="";
        String soParaNome3="";
        int i=0;
        while(i<getIntent().getExtras().getInt("tamanho")){
            soParaNome=""+i;
            soParaNome1=""+(i+1);
            soParaNome2=""+(i+2);
            soParaNome3=""+(i+3);
            testeLista.add(new Veiculos(getIntent().getExtras().getInt(soParaNome2),
                    getIntent().getExtras().getDouble(soParaNome),
                    getIntent().getExtras().getString(soParaNome1),
                    getIntent().getExtras().getString(soParaNome3)));
            i+=4;
        }




        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);
        VeiculoAdapter adaptador = new VeiculoAdapter();
        adaptador.setListaVeiculos( testeLista);
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter( adaptador );
    }
}
