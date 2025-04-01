public class Euro extends Moeda {

    //  Aqui eu extendo a minha classe moeda e ainda uso o metodo cotacao para puxar o valor atual do euro em reais
    // caso não consigo pegar o valor atual eu deixo um valor pré definido que seria parecido com o valor.
    // também uso o converter para que cada valor instanciado possa ser convertido para real.

    public Euro(double valor) {
        super(valor, "Euro");
    }

    @Override
    public double converter() {
        double cotacaoAtual = new ApiCotacao().getCotacao(Principal.tipoMoedaEnum.EURO);
        double cotacao = cotacaoAtual != 0? cotacaoAtual: 6.20;
        return valor * cotacao;
    }

    @Override
    public double info() {
        return valor;
    }

    public static void cotacao(){
        double cotacaoAtual = new ApiCotacao().getCotacao(Principal.tipoMoedaEnum.EURO);
        double cotacao = cotacaoAtual != 0? cotacaoAtual:  6.20;
        System.out.println("Um Euro atualmente equivale a: R$" + cotacao);
    }
}
