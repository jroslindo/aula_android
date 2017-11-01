package joaopauloroslindo.calculadoradearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RespostaQuadrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta_quadrado);

        TextView textResposta = (TextView) findViewById(R.id.OndeVaiAResposta);

        Double calculo = getIntent().getExtras().getDouble("Resposta");

        textResposta.setText("Área: " + String.format("%.4f", calculo)  + "cm²");
    }

    public void voltar (View quemclicou){
        Intent volta = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(volta);
    }
}
