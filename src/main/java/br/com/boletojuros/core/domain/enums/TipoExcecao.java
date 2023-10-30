package br.com.boletojuros.core.domain.enums;

public enum TipoExcecao {
    BOLETO_INVALIDO{
        @Override
        public String getMensagemErro() {
            return "O boleto encontrado é invalido";
        }
    },
    TIPO_BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "Infelizmento só podemos calcular o juros dos boletos xpto";
        }
    },
    BOLETO_NAO_VENCIDO {
        @Override
        public String getMensagemErro() {
            return "O boleto informado ainda naõ está vencido";
        }
    };

    public abstract String getMensagemErro();

}
