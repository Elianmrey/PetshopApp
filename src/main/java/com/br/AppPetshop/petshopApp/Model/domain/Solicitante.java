package com.br.AppPetshop.petshopApp.Model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Solicitante {

    private String nome;
    private String cpf;
    private String email;
    private Endereco endereco;
    private String tipoPet;
    private List<Agendamento> listaAgendamento;
    private List<Produto> listaProdutos;

    @Override
    public String toString()
    {
        return "Nome: " + getNome() + "; CPF: " + getCpf() + "; E-mail: " + getEmail() + "; Endereço: " + getEndereco() + "; Tipo de Pet: " + getTipoPet() + "; Agendamentos Confirmados: " + getListaAgendamento()  + "; Produtos Adquiridos: " + getListaProdutos();
    }
}
