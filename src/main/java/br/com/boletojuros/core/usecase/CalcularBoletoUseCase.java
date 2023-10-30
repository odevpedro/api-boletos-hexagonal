package br.com.boletojuros.core.usecase;

import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.ports.in.CalculoBoletoPort;
import br.com.boletojuros.core.ports.out.ComplementoBoletoPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {

    private final ComplementoBoletoPort complementoBoletoPort;

    public CalcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
    }


    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
        var boleto = complementoBoletoPort.executar(codigo);
        // TODO - validar o boleto

        //TODO - calcular boleto

        //TODO - Salvar Boleto
        return null;
    }
}
