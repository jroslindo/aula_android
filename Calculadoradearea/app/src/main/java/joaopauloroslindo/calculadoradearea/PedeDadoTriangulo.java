package joaopauloroslindo.calculadoradearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PedeDadoTriangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pede_dado_triangulo);
    }

    public void ProximaJanela (View quemclicou){
        EditText Dado = (EditText) findViewById(R.id.Base);
        EditText Dado2 = (EditText) findViewById(R.id.Altura);
        if(Dado.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Todos os dados devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }
        if(Dado2.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Todos os dados devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }
        Double dado = Double.parseDouble(Dado.getText().toString());
        Double dado2 = Double.parseDouble(Dado2.getText().toString());

        Double Resposta= dado*dado2/2;

        Bundle mochilaCirculo = new Bundle();
        mochilaCirculo.putDouble("Resposta",Resposta);

        Intent intencao = new Intent(getApplicationContext(), RespostaTriangulo.class);

        intencao.putExtras(mochilaCirculo);
        finish();
        startActivity(intencao);
    }
}
