package com.br.AppPetshop.petshopApp.Model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Produto {

    private String nome;
    private double valor;
    private String categoria;
    private int codigo;


    @Override
    public String toString()
    {
        return nome +";"+ valor +";"+ categoria +";"+ codigo;
    }

}
