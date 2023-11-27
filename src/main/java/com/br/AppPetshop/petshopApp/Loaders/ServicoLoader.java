package com.br.AppPetshop.petshopApp.Loaders;


import com.br.AppPetshop.petshopApp.Model.domain.Servico;
import com.br.AppPetshop.petshopApp.Model.service.ServicoService;
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
@Order(2)
public class ServicoLoader implements ApplicationRunner {

    @Autowired
      ServicoService servicoService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String rota = "C:/Users/elian/OneDrive/Escritorio/[000] Projeto de Bloco/petshopApp/src/main/java/com/br/AppPetshop/petshopApp/files/Servicos.txt";
        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while (leitura != null) {

            dataSet = leitura.split(";");

            leitura = leitordeLinha.readLine();
            Servico servico = getServico(dataSet);

            servicoService.incluirServico(servico);

        }
        for (Servico servico : servicoService.obterServicos()) {
            System.out.println("[Procedimento:] " + servico);
        }
    }


    private static Servico getServico(String[] dataSet) {


        Servico servico = new Servico();

        servico.setValor(Double.parseDouble(dataSet[0]));
        servico.setCategoria(dataSet[1]);
        servico.setAvaliacao(Integer.parseInt(dataSet[2]));
        servico.setNomeEspecialista(dataSet[3]);
        servico.setAreaEspecialista(dataSet[4]);
        servico.setTipoAtendimento(dataSet[5]);
        servico.setCodigo(Integer.parseInt(dataSet[6]));


        return servico;
    }


}
