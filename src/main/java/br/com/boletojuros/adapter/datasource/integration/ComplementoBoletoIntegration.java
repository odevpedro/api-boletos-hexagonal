package br.com.boletojuros.adapter.datasource.integration;

import br.com.boletojuros.adapter.datasource.integration.client.ComplementoBoletoClient;
import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.ports.out.ComplementoBoletoPort;

public class ComplementoBoletoIntegration implements ComplementoBoletoPort {

    private final ComplementoBoletoClient client;

    public ComplementoBoletoIntegration(ComplementoBoletoClient client) {
        this.client = client;
    }

    @Override
    public Boleto executar(String codigo) {
        var boletoDTO = client.getBoleto(codigo);
        return null;
    }
}
