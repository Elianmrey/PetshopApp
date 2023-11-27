package com.br.AppPetshop.petshopApp.Loaders;

import com.br.AppPetshop.petshopApp.Model.domain.Agendamento;
import com.br.AppPetshop.petshopApp.Model.domain.Endereco;
import com.br.AppPetshop.petshopApp.Model.domain.Servico;
import com.br.AppPetshop.petshopApp.Model.domain.Solicitante;
import com.br.AppPetshop.petshopApp.Model.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;


@Component
@Repository
@Order(3)
public class AgendamentoLoader implements ApplicationRunner {

    @Autowired
    AgendamentoService agendamentoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String rota = "C:/Users/elian/OneDrive/Escritorio/[000] Projeto de Bloco/petshopApp/src/main/java/com/br/AppPetshop/petshopApp/files/Agendamentos.txt";
        FileReader arquivo = new FileReader(rota);
        BufferedReader leitordeLinha = new BufferedReader(arquivo);

        String leitura = leitordeLinha.readLine();
        String[] dataSet;

        while (leitura != null) {

            dataSet = leitura.split(";");

            Agendamento agendamento = getAgendamento(dataSet, LocalDateTime.now());


            agendamentoService.incluirAgendamento(agendamento);

            leitura = leitordeLinha.readLine();
        }
        for (Agendamento agendamento : agendamentoService.obterAgendamentos()) {
            System.out.println("[Agendamento:] " + agendamento);
        }
    }

    private static Agendamento getAgendamento(String[] dataSet, LocalDateTime dataHora)
    {
        var solicitante = getSolicitante(dataSet);
        var servico = getServico(dataSet);


        return new Agendamento(servico,solicitante,dataHora);

    }
    private static Solicitante getSolicitante(String[] dataSet) {

        Solicitante cliente = new Solicitante();

        cliente.setNome(dataSet[0]);
        cliente.setCpf(dataSet[1]);
        cliente.setEmail(dataSet[2]);

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dataSet[3]);
        endereco.setCidade(dataSet[4]);
        endereco.setEstado(dataSet[5]);
        endereco.setCep(dataSet[6]);
        endereco.setNumero(dataSet[7]);
        cliente.setEndereco(endereco);
        cliente.setTipoPet(dataSet[8]);
        cliente.setListaAgendamento(null);
        cliente.setListaProdutos(null);
        return cliente;
    }

    private static Servico getServico(String[] dataSet) {

        Servico servico = new Servico();

        servico.setValor(Double.parseDouble(dataSet[9]));
        servico.setCategoria(dataSet[10]);
        servico.setAvaliacao(Integer.parseInt(dataSet[11]));
        servico.setNomeEspecialista(dataSet[12]);
        servico.setAreaEspecialista(dataSet[13]);
        servico.setTipoAtendimento(dataSet[14]);
        servico.setCodigo(Integer.parseInt(dataSet[15]));


        return servico;
    }


}


