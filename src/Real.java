public class Real extends Moeda {

    //  Aqui eu extendo a minha classe moeda, como essa moeda é o de real eu não preciso fazer a conversão para nada
    // o que reduz o trabalho de criar mais métodos.

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


