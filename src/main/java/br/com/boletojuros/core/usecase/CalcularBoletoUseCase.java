package br.com.boletojuros.core.usecase;

import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.domain.enums.TipoBoleto;
import br.com.boletojuros.core.domain.enums.TipoExcecao;
import br.com.boletojuros.core.exception.ApplicationException;
import br.com.boletojuros.core.ports.in.CalculoBoletoPort;
import br.com.boletojuros.core.ports.out.ComplementoBoletoPort;
import br.com.boletojuros.core.ports.out.SalvarcalculoBoletoPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {

    private static final BigDecimal JUROS_DIARIOS = BigDecimal.valueOf(0.033);
    private final ComplementoBoletoPort complementoBoletoPort;
    private final SalvarcalculoBoletoPort salvarcalculoBoletoPort;

    public CalcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort, SalvarcalculoBoletoPort salvarcalculoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
        this.salvarcalculoBoletoPort = salvarcalculoBoletoPort;
    }

    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
        // TODO - calcular boleto
        var boleto = complementoBoletoPort.executar(codigo);
        var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
        var valorJurosDia = JUROS_DIARIOS.multiply(boleto.getValor()).divide(BigDecimal.valueOf(100));
        var juros = valorJurosDia.multiply(BigDecimal.valueOf(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);
        var boletoCalculado = BoletoCalculado.builder()
                .codigo(boleto.getCodigo())
                .dataPagamento(dataPagamento)
                .juros(juros)
                .dataVencimento(boleto.getDataVencimento())
                .valorOriginal(boleto.getValor())
                .valor(boleto.getValor())
                .tipo(boleto.getTipo())
                .build();


        //TODO - Salvar Boleto

        salvarcalculoBoletoPort.executar(boletoCalculado);

        return boletoCalculado;
    }

    private void validar(Boleto boleto){
        if (boleto.getTipo() != TipoBoleto.XPTO){
            throw new ApplicationException(TipoExcecao.TIPO_BOLETO_INVALIDO);
        }

        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
            throw new ApplicationException(TipoExcecao.BOLETO_NAO_VENCIDO);
            }
        }

        private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento){
            return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
        }
    }

