package com.br.AppPetshop.petshopApp.Model.service;

import com.br.AppPetshop.petshopApp.Model.domain.Brinquedo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BrinquedoService {

    private final Map<Integer, Brinquedo> mapa = new HashMap<>();

    public void incluirBrinquedo(Brinquedo brinquedo)
    {
        mapa.put(brinquedo.getCodigo(), brinquedo);
    }

    public List<Brinquedo> obterBrinquedos(){

        return mapa.values().stream().toList();
    }
}
