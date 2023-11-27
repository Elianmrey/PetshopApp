package com.br.AppPetshop.petshopApp.Model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Brinquedo extends Produto {

    private String tipoBrinquedo;
    private String fabricante;
    private int avaliacaoMedia;
    private int idadeRecomendada;
    private boolean reciclavel;
    private String reciclavelFormat = reciclavel ? "Sim" : "Não";

    @Override
    public String toString()
    {
        return super.toString() +";"+ tipoBrinquedo +";"+ fabricante +";"+ avaliacaoMedia +";"+ idadeRecomendada +";"+ reciclavelFormat;
    }

}