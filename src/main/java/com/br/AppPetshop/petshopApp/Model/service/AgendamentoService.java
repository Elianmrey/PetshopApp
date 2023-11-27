package com.br.AppPetshop.petshopApp.Model.service;

import com.br.AppPetshop.petshopApp.Model.domain.Agendamento;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service

public class AgendamentoService {


    private final Map<LocalDateTime, Agendamento> mapa = new HashMap<>();

    public void incluirAgendamento(Agendamento agendamento)
    {
        mapa.put(agendamento.getDataHora(), agendamento);
    }

    public List<Agendamento> obterAgendamentos(){

        return mapa.values().stream().toList();
    }
}
