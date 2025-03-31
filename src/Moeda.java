import java.util.Objects;

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
