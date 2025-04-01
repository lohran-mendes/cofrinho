import java.util.Objects;

// Aqui eu crio uma classe abstrata moeda para usar em outras classes e sobrescrevo metodos que eu terei que usar mais a frente.

public abstract class Moeda {
    double valor;
    String tipo;

    public Moeda(double valor, String tipo){
        this.valor = valor;
        this.tipo = tipo;
    }

    public abstract double  converter();

    public abstract double info();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda moeda = (Moeda) obj;
        return Double.compare(moeda.valor, valor) == 0 && tipo.equals(moeda.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, tipo);
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Valor: " + valor;
    }
}
