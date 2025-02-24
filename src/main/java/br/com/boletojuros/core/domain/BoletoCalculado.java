package br.com.boletojuros.core.domain;

import br.com.boletojuros.core.domain.enums.TipoBoleto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BoletoCalculado {

    private final String codigo;
    private final BigDecimal valorOriginal;
    private final BigDecimal valor;
    private final LocalDate dataVencimento;
    private final LocalDate dataPagamento;
    private final BigDecimal juros;
    private final TipoBoleto tipo;

    // 🔹 Construtor privado para evitar instanciação direta
    private BoletoCalculado(Builder builder) {
        this.codigo = builder.codigo;
        this.valorOriginal = builder.valorOriginal;
        this.valor = builder.valor;
        this.dataVencimento = builder.dataVencimento;
        this.dataPagamento = builder.dataPagamento;
        this.juros = builder.juros;
        this.tipo = builder.tipo;
    }

    // 🔹 Getters
    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public TipoBoleto getTipo() {
        return tipo;
    }

    // 🔹 Classe Builder Interna
    public static class Builder {
        private String codigo;
        private BigDecimal valorOriginal;
        private BigDecimal valor;
        private LocalDate dataVencimento;
        private LocalDate dataPagamento;
        private BigDecimal juros;
        private TipoBoleto tipo;

        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder valorOriginal(BigDecimal valorOriginal) {
            this.valorOriginal = valorOriginal;
            return this;
        }

        public Builder valor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public Builder dataVencimento(LocalDate dataVencimento) {
            this.dataVencimento = dataVencimento;
            return this;
        }

        public Builder dataPagamento(LocalDate dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        public Builder juros(BigDecimal juros) {
            this.juros = juros;
            return this;
        }

        public Builder tipo(TipoBoleto tipo) {
            this.tipo = tipo;
            return this;
        }

        public BoletoCalculado build() {
            return new BoletoCalculado(this);
        }
    }

    // 🔹 Método para iniciar a construção do objeto
    public static Builder builder() {
        return new Builder();
    }
}
