package joaopauloroslindo.calculadoradearea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ActionForButton (View quemclicou) {
        RadioGroup Seleciona = (RadioGroup) findViewById(R.id.RadGroup);
        if (Seleciona.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Selecione uma opção", Toast.LENGTH_SHORT).show();
            return;
        }


        if (Seleciona.getCheckedRadioButtonId() == R.id.RadioCirculo) {
            Intent intencao = new Intent(getApplicationContext(), PedeDadoCirculo.class);
            startActivity(intencao);
        }
        if (Seleciona.getCheckedRadioButtonId() == R.id.RadioQuadrado) {
            Intent intencao = new Intent(getApplicationContext(), PedeDadoQuadrado.class);
            startActivity(intencao);
        }
        if (Seleciona.getCheckedRadioButtonId() == R.id.RadioTriangulo) {
            Intent intencao = new Intent(getApplicationContext(), PedeDadoTriangulo.class);
            startActivity(intencao);
        }


    }
}