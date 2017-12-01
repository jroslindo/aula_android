package joaopauloroslindo.recycleviewexercise;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    ArrayList<Veiculos> listaPrincipal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Realm.init(this);

    }

    public void onStart() {
        super.onStart();  // Always call the superclass method first
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Veiculos> result1 = realm.where(Veiculos.class).findAll();
        if(result1.size() > 0) {
            Double totalLitros = 0.0;
            for (int i = 0; i < result1.size(); i++) {
                totalLitros += result1.get(i).getCombustivel();
            }

            int ultimo = result1.get(result1.size() - 1).getKilometragem();
            int primeiro = result1.get(0).getKilometragem();
            double resposta = 0;
            if (ultimo == primeiro) {
                resposta = ultimo / totalLitros;
            } else {
                resposta = (ultimo - primeiro) / totalLitros;
            }

            TextView tvresposta = (TextView) findViewById(R.id.tvResposta);
            tvresposta.setText(String.format("%.3f", resposta));
        }
    }



    public void VaiParaNovoAbastecimento(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), NovoAbastecimento.class);

        int kilometragem = 0;
        double combustivel = 0;
        String dataAbastecimento = new String();
        String posto = new String();

        intencao.putExtra("dado_kilometragem", kilometragem);
        intencao.putExtra("dado_combustivel", combustivel);
        intencao.putExtra("dado_dataAbastecimento", dataAbastecimento);
        intencao.putExtra("dado_posto", posto);
        startActivityForResult(intencao,1);
    }

    public void VaiParaLista(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), ListaDeAbastecimentos.class);
        startActivity(intencao);
    }


    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==1){
            if(resultCode== Activity.RESULT_OK){

                Realm realm = Realm.getDefaultInstance(); //cria objeto tipo realm
                realm.beginTransaction(); // começa transação

                Veiculos paraOBanco = realm.createObject(Veiculos.class);
                paraOBanco.setCombustivel(Double.parseDouble(data.getStringExtra("dado_combustivel1")));
                paraOBanco.setDataAbastecimento(data.getStringExtra("dado_dataAbastecimento1"));
                paraOBanco.setKilometragem(Integer.parseInt(data.getStringExtra("dado_kilometragem1")));
                paraOBanco.setPosto(data.getStringExtra("dado_posto1"));
                realm.copyFromRealm(paraOBanco);

                realm.commitTransaction();
            }

        }



    }
}
