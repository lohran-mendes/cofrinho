import java.util.ArrayList;

public class Cofrinho {
    public final ArrayList<Moeda> listaMoedas = new ArrayList<>();

    public void adicionar(double valor, Principal.tipoMoedaEnum tipoMoeda){
        switch (tipoMoeda){
            case REAL:
                listaMoedas.add(new Real(valor));
                break;
            case DOLAR:
                listaMoedas.add(new Dolar(valor));
                break;
            case EURO:
                listaMoedas.add(new Euro(valor));
                break;
        }
    }

    public void remover(double valor, Principal.tipoMoedaEnum tipoMoeda){
        switch (tipoMoeda){
            case REAL:
                if(listaMoedas.contains(new Real(valor))) {
                    listaMoedas.remove(new Real(valor));
                } else System.out.println("\nO valor não existe no cofrinho para ser removido");
                break;
            case DOLAR:
                if(listaMoedas.contains(new Dolar(valor))) {
                listaMoedas.remove(new Dolar(valor));
                } else System.out.println("\nO valor não existe no cofrinho para ser removido");
                break;
            case EURO:
                if(listaMoedas.contains(new Euro(valor))) {
                listaMoedas.remove(new Euro(valor));
                } else System.out.println("\nO valor não existe no cofrinho para ser removido");
                break;
        }
    }
    public void listagemMoedas(){
        System.out.println("\nListando moedas:");
        for (Moeda moeda : listaMoedas) {
        System.out.println(moeda.toString());
        }
    }
    public void totalConvertido(){
        double valorConvertido = 0;
        for(Moeda moeda : listaMoedas) {
            valorConvertido += moeda.converter();
        }
        Dolar.cotacao();
        Euro.cotacao();
        System.out.println("Valor total convertido em Reais:\nR$ " + valorConvertido);
    }

}
