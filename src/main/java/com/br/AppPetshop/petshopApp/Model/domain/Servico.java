package com.br.AppPetshop.petshopApp.Model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Servico {

    private double valor;
    private String categoria;
    private int avaliacao;
    private String nomeEspecialista;
    private String areaEspecialista;
    private String tipoAtendimento;
    private int codigo;


    @Override
    public String toString()
    {
        return getValor() + ";" + getCategoria() + ";" + getAvaliacao() + ";" + getNomeEspecialista() + ";" + getAreaEspecialista() + ";" + getTipoAtendimento() + ";" + getCodigo();
    }
}