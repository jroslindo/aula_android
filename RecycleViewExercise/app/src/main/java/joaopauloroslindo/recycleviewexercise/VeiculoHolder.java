package joaopauloroslindo.recycleviewexercise;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joaonote on 11/27/17.
 */

public class VeiculoHolder extends RecyclerView.ViewHolder {
    private TextView tvKilometragem;
    private TextView tvLitros;
    private TextView tvData;
    private ImageView ivPosto;

    public VeiculoHolder(View itemView) {
        super(itemView);

        this.tvKilometragem = itemView.findViewById(R.id.tvKilometragem);
        this.tvLitros = itemView.findViewById(R.id.tvLitros);
        this.tvData = itemView.findViewById(R.id.tvData);
        this.ivPosto = itemView.findViewById(R.id.ivPosto);
    }

    public void atualizaOVeiculoQueVoceEstaApresentando(Veiculos v){
        tvKilometragem.setText(Integer.toString(v.getKilometragem()));
        tvLitros.setText(Double.toString(v.getCombustivel()));
        tvData.setText(v.getDataAbastecimento());

        if(v.getPosto().equals("Petrobras")){
            ivPosto.setImageResource(R.drawable.petrobras);
        }else if (v.getPosto().equals("Ipiranga")){
            ivPosto.setImageResource(R.drawable.ipiranga);
        }else if (v.getPosto().equals("Shell")){
            ivPosto.setImageResource(R.drawable.shell);
        }else if (v.getPosto().equals("Texaco")){
            ivPosto.setImageResource(R.drawable.texaco);
        }
    }
}
