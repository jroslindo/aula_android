package joaopauloroslindo.calculadoradearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PedeDadoCirculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pede_dado_circulo);
    }

    public void ProximaJanela (View quemclicou){
        EditText Dado = (EditText) findViewById(R.id.RaioDado);
        if(Dado.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Todos os dados devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }
        Double dado = Double.parseDouble(Dado.getText().toString());
        Double Pi= 3.14159265359;

        Double Resposta= Pi*(dado*dado);

        Bundle mochilaCirculo = new Bundle();
        mochilaCirculo.putDouble("Resposta",Resposta);

        Intent intencao = new Intent(getApplicationContext(), RespostaCirculo.class);

        intencao.putExtras(mochilaCirculo);
        finish();
        startActivity(intencao);
    }
}
