package joaopauloroslindo.recycleviewexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by João on 27/11/2017.
 */

public class Veiculos {

    private int kilometragem;
    private double combustivel;
    private String dataAbastecimento;
    private String posto;

    public Veiculos(int kilometragem, double combustivel, String dataAbastecimento, String posto){
        this.combustivel = combustivel;
        this.dataAbastecimento = dataAbastecimento;
        this.kilometragem = kilometragem;
        this.posto = posto;
    }
    public Veiculos(){
    }


    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    public String getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(String dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}
