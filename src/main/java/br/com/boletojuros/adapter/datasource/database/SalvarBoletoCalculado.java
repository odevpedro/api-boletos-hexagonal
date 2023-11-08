package br.com.boletojuros.adapter.datasource.database;

import br.com.boletojuros.adapter.datasource.database.repository.BoletoCalculadoRepository;
import br.com.boletojuros.adapter.datasource.mapper.BoletoCalculadoMapper;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.ports.out.SalvarcalculoBoletoPort;
import org.springframework.stereotype.Component;

@Component
public class SalvarBoletoCalculado implements SalvarcalculoBoletoPort {

    private final BoletoCalculadoRepository repository;
    private final BoletoCalculadoMapper mapper;

    public SalvarBoletoCalculado(BoletoCalculadoRepository repository, BoletoCalculadoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void executar(BoletoCalculado boletoCalculado) {
        var entity = mapper.toEntity(boletoCalculado);
        repository.save(entity);

    }
}
