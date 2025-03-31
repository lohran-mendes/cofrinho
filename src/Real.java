public class Real extends Moeda {

    public Real(double valor) {
        super(valor, "Real");
    }

    @Override
    public double converter() {
        return valor;
    }

    @Override
    public double info() {
        System.out.println("O valor acumulado em Real é igual a: " + valor);
        return valor;
    }
}


