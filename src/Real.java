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
        return valor;
    }
}


