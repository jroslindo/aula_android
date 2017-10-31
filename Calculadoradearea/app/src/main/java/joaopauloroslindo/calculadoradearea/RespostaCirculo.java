package joaopauloroslindo.calculadoradearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RespostaCirculo extends AppCompatActivity {

    private Bundle MochilaRecebida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta_circulo);

        Double calculo = getIntent().getExtras().getDouble("Resposta");


        TextView textResposta = (TextView) findViewById(R.id.OndeVaiAResposta);

        textResposta.setText("Área: " + calculo.toString().substring(0,8) + "cm²");
    }

    public void voltar (View quemclicou){
        Intent volta = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(volta);

    }




}
