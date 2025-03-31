public class Euro extends Moeda {

    String tipo = "Euro";

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

    public static double cotacao(){
        double cotacaoAtual = new ApiCotacao().getCotacao(Principal.tipoMoedaEnum.EURO);
        double cotacao = cotacaoAtual != 0? cotacaoAtual:  6.20;
        System.out.println("Um Euro atualmente equivale a: R$" + cotacao);
        return cotacao;
    }
}
