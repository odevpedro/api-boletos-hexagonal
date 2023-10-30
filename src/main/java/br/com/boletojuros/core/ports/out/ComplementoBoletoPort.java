package br.com.boletojuros.core.ports.out;

import br.com.boletojuros.core.domain.Boleto;

public interface ComplementoBoletoPort {
    Boleto executar(String codigo);
}
