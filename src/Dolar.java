public class Dolar extends Moeda {

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
