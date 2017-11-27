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
        //.setText(v.getDataAbastecimento());



        /*if(v.getNome().toLowerCase().equals("gol")){
            this.ivFotografia.setImageResource(R.drawable.gol);
        }else if (v.getNome().toLowerCase().equals("f50")){
            this.ivFotografia.setImageResource(R.drawable.ferrari);
        }else{
            this.ivFotografia.setImageResource(R.drawable.fusca);
        }*/
    }
}
