package com.br.AppPetshop.petshopApp.Model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {

    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;


    @Override
    public String toString()
    {
        return "Rua: "+getLogradouro() + ", Número: " + getNumero() + " ," + getCidade() + " - " + getEstado() + ". CEP: " + getCep() + ". ";
    }
}