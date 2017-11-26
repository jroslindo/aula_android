package joaopauloroslindo.recycleviewexercise;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NovoAbastecimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_abastecimento);

        //Para o spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_postos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Array_Postos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void VaiParaEscolhaAData(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), EscolheData.class);

        startActivity(intencao);
    }
}
