package joaopauloroslindo.recycleviewexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ArrayList<Veiculos> listaPrincipal = new ArrayList<>();

    public void VaiParaNovoAbastecimento(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), NovoAbastecimento.class);

        int kilometragem = 0;
        double combustivel=0;
        String dataAbastecimento= new String();
        String posto=new String();

        intencao.putExtra("dado_kilometragem", kilometragem);
        intencao.putExtra("dado_combustivel", combustivel);
        intencao.putExtra("dado_dataAbastecimento", dataAbastecimento);
        intencao.putExtra("dado_posto", posto);


        startActivityForResult(intencao,1);
    }

    public void VaiParaLista(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), ListaDeAbastecimentos.class);

        intencao.putExtra("tamanho", listaPrincipal.size());
        int nomeVar = 0;
        for(int i=0; i<listaPrincipal.size(); i++){
            intencao.putExtra( "0", listaPrincipal.get(i).getCombustivel());
            nomeVar++;
            intencao.putExtra("1", listaPrincipal.get(i).getDataAbastecimento());
            nomeVar++;
            intencao.putExtra("2", listaPrincipal.get(i).getKilometragem());
            nomeVar++;
            intencao.putExtra("3", listaPrincipal.get(i).getPosto());
            nomeVar++;
        }
        startActivity(intencao);
    }


    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        Veiculos para_o_array = new Veiculos();

        para_o_array.setKilometragem(Integer.parseInt(data.getStringExtra("dado_kilometragem1")));
        para_o_array.setCombustivel(Double.parseDouble(data.getStringExtra("dado_combustivel1")));
        para_o_array.setDataAbastecimento(data.getStringExtra("dado_combustivel1"));
        para_o_array.setPosto(data.getStringExtra("dado_posto1"));

        listaPrincipal.add(para_o_array);
    }
}
