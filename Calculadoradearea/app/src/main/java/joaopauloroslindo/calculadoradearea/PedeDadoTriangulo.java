package joaopauloroslindo.calculadoradearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PedeDadoTriangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pede_dado_triangulo);
    }

    public void ProximaJanela (View quemclicou){
        EditText Dado = (EditText) findViewById(R.id.Base);
        EditText Dado2 = (EditText) findViewById(R.id.Altura);
        Double dado = Double.parseDouble(Dado.getText().toString());
        Double dado2 = Double.parseDouble(Dado2.getText().toString());

        Double Resposta= dado*dado2/2;

        Bundle mochilaCirculo = new Bundle();
        mochilaCirculo.putDouble("Resposta",Resposta);

        Intent intencao = new Intent(getApplicationContext(), RespostaTriangulo.class);

        intencao.putExtras(mochilaCirculo);

        startActivity(intencao);
    }
}
