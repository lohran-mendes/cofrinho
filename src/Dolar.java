public class Dolar extends Moeda {

    //  Aqui eu extendo a minha classe moeda e ainda uso o metodo cotacao para puxar o valor atual do Dólar em reais
    // caso não consigo pegar o valor atual eu deixo um valor pré definido que seria parecido com o valor.
    // também uso o converter para que cada valor instanciado possa ser convertido para real.

    public Dolar(double valor) {
        super(valor, "Dolar");
    }

    @Override
    public double converter() {
        double cotacaoAtual = new ApiCotacao().getCotacao(Principal.tipoMoedaEnum.DOLAR);
        double cotacao = cotacaoAtual != 0? cotacaoAtual: 5.80;
        return valor * cotacao;
    }

    @Override
    public double info() {
        return valor;
    }

    public static void cotacao(){
        double cotacaoAtual = new ApiCotacao().getCotacao(Principal.tipoMoedaEnum.DOLAR);
        double cotacao = cotacaoAtual != 0? cotacaoAtual:  5.80;
        System.out.println("\nUm Dólar atualmente equivale a: R$" + cotacao);
    }
}
