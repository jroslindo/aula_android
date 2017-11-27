package joaopauloroslindo.recycleviewexercise;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;

public class EscolheData extends AppCompatActivity {
private DatePicker dataDoCalendario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhe_data);
    }

    public void retorna (View quemclicou){
        dataDoCalendario = (DatePicker) findViewById(R.id.dpData);
        String Data_retornado = new String();
        Data_retornado = ""+ dataDoCalendario.getDayOfMonth() +"/" + (dataDoCalendario.getMonth()+1) + "/" + dataDoCalendario.getYear() ;

        Intent intencao = new Intent(this, NovoAbastecimento.class);
        intencao.putExtra("Data_Retornado", Data_retornado);
        setResult(Activity.RESULT_OK, intencao);
        finish();

    }
}
