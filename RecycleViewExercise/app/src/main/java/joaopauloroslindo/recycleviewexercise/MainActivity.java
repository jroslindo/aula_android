package joaopauloroslindo.recycleviewexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void VaiParaNovoAbastecimento(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), NovoAbastecimento.class);

        startActivity(intencao);
    }

    public void VaiParaKLista(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), ListaDeAbastecimentos.class);

        startActivity(intencao);
    }
}
