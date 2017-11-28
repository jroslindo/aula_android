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

public class MainActivity extends AppCompatActivity {
    ArrayList<Veiculos> listaPrincipal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onStart() {
        super.onStart();  // Always call the superclass method first

        if(listaPrincipal.size() > 0) {
            Double totalLitros = 0.0;
            for (int i = 0; i < listaPrincipal.size(); i++) {
                totalLitros += listaPrincipal.get(i).getCombustivel();
            }

            int ultimo = listaPrincipal.get(listaPrincipal.size() - 1).getKilometragem();
            int primeiro = listaPrincipal.get(0).getKilometragem();
            double resposta = 0;
            if (ultimo == primeiro) {
                resposta = ultimo / totalLitros;
            } else {
                resposta = (ultimo - primeiro) / totalLitros;
            }

            TextView tvresposta = (TextView) findViewById(R.id.tvResposta);
            tvresposta.setText(String.format("%.4f", resposta));
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
        Bundle mochilinha = new Bundle();



        int nomeVar = 0;
        String muda="0";
        for(int i=0; i<listaPrincipal.size(); i++){
            mochilinha.putDouble( muda, listaPrincipal.get(i).getCombustivel());
            nomeVar++;
            muda=""+nomeVar;
            mochilinha.putString(muda, listaPrincipal.get(i).getDataAbastecimento());
            nomeVar++;
            muda=""+nomeVar;
            mochilinha.putInt(muda, listaPrincipal.get(i).getKilometragem());
            nomeVar++;
            muda=""+nomeVar;
            mochilinha.putString(muda, listaPrincipal.get(i).getPosto());
            nomeVar++;
            muda=""+nomeVar;
        }
        mochilinha.putInt("tamanho", nomeVar);
        intencao.putExtras(mochilinha);
        startActivity(intencao);

    }


    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                Veiculos para_o_array = new Veiculos();

                para_o_array.setKilometragem(Integer.parseInt(data.getStringExtra("dado_kilometragem1")));
                para_o_array.setCombustivel(Double.parseDouble(data.getStringExtra("dado_combustivel1")));
                para_o_array.setDataAbastecimento(data.getStringExtra("dado_dataAbastecimento1"));
                para_o_array.setPosto(data.getStringExtra("dado_posto1"));

                listaPrincipal.add(para_o_array);
            }
        }



    }
}
