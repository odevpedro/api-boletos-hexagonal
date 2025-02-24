package br.com.boletojuros.core.domain;


import br.com.boletojuros.core.domain.enums.TipoBoleto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto {
    private String codigo;
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private TipoBoleto tipo;

    public Boleto(String codigo, LocalDate dataVencimento, BigDecimal valor, TipoBoleto tipo) {
        this.codigo = codigo;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.tipo = tipo;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoBoleto getTipo() {
        return tipo;
    }
}
