package joaopauloroslindo.recycleviewexercise;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        String BotaNaPorra = data.getStringExtra("Data_Retornado");
        EditText aPorra = (EditText) findViewById(R.id.etData);
        aPorra.setText(BotaNaPorra);

    }

    public void VaiParaEscolhaAData(View quemclicou) {
        Intent intencao = new Intent(getApplicationContext(), EscolheData.class);
        String DataRetornado = new String();

        intencao.putExtra("DataRetorno", DataRetornado);
        startActivityForResult(intencao, 1);
    }

    public void confirmar (View quemclicou){
        EditText etkilometragem = (EditText) findViewById(R.id.etKilometragem);
        EditText etAbastecido = (EditText) findViewById(R.id.etLitros);
        EditText etData = (EditText) findViewById(R.id.etData);
        Spinner etPosto = (Spinner) findViewById(R.id.spinner_postos);



        Intent intencao = new Intent(this, MainActivity.class);
        intencao.putExtra("dado_kilometragem1", etkilometragem.getText().toString());
        intencao.putExtra("dado_combustivel1", etAbastecido.getText().toString());
        intencao.putExtra("dado_dataAbastecimento1", etData.getText().toString());
        intencao.putExtra("dado_posto1", etPosto.getSelectedItem().toString());

        setResult(Activity.RESULT_OK, intencao);
        finish();
    }
}
