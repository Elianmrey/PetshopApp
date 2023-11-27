package com.br.AppPetshop.petshopApp.Model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agendamento {

    private Servico servico;
    private Solicitante solicitante;
    private LocalDateTime dataHora;

    @Override
    public String toString()
    {
        return servico.toString() + "; " + solicitante.toString() + "; " + dataHora.format(ISO_LOCAL_DATE_TIME) + ". ";
    }
}