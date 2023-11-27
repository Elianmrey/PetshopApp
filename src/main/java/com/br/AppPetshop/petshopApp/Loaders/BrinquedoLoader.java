package com.br.AppPetshop.petshopApp.Loaders;

import com.br.AppPetshop.petshopApp.Model.domain.Brinquedo;
import com.br.AppPetshop.petshopApp.Model.domain.Endereco;
import com.br.AppPetshop.petshopApp.Model.domain.Solicitante;
import com.br.AppPetshop.petshopApp.Model.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
@Component
@Repository
@Order(4)
public class BrinquedoLoader implements ApplicationRunner {

 @Autowired
    BrinquedoService brinquedoService;

    @Override
     public void run(ApplicationArguments args) throws Exception  {

        final String rota = "C:/Users/elian/OneDrive/Escritorio/[000] Projeto de Bloco/petshopApp/src/main/java/com/br/AppPetshop/petshopApp/files/Brinquedos.txt";

        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while ( leitura != null)
        {

            dataSet = leitura.split(";");


            Brinquedo brinquedo = getBrinquedo(dataSet);

            brinquedoService.incluirBrinquedo(brinquedo);

            leitura = leitordeLinha.readLine();
        }
        for(Brinquedo brinquedo: brinquedoService.obterBrinquedos() )
        {
            System.out.println("[Brinquedo:] " + brinquedo);
        }
    }


    private static Brinquedo getBrinquedo(String[] dataSet) {

        Brinquedo brinquedo = new Brinquedo();

        brinquedo.setNome(dataSet[0]);
        brinquedo.setValor(Double.parseDouble(dataSet[1]));
        brinquedo.setCategoria(dataSet[2]);
        brinquedo.setCodigo(Integer.parseInt(dataSet[3]));
        brinquedo.setTipoBrinquedo(dataSet[4]);
        brinquedo.setFabricante(dataSet[5]);
        brinquedo.setAvaliacaoMedia(Integer.parseInt(dataSet[6]));
        brinquedo.setIdadeRecomendada(Integer.parseInt(dataSet[7]));
        brinquedo.setReciclavel(Boolean.parseBoolean(dataSet[8]));

        return brinquedo;
    }

}
