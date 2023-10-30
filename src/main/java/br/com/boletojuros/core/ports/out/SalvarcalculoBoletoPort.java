package br.com.boletojuros.core.ports.out;

import br.com.boletojuros.core.domain.BoletoCalculado;

public interface SalvarcalculoBoletoPort {
    void executar(BoletoCalculado boletoCalculado);
}
