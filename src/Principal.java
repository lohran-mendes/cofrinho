    import java.util.Scanner;

    public class Principal {

        public enum tipoMoedaEnum {
                REAL, DOLAR, EURO
            }

        public static void main(String[] args) {

            int opcaoEscolhida = 1;
            int entradaDoTipoDeMoeda;
            double valorMoeda;

            tipoMoedaEnum tipoMoeda;

            Cofrinho cofrinho = new Cofrinho();
            Scanner entrada = new Scanner(System.in);

            while (opcaoEscolhida != 0) {
            System.out.println("\nCofrinho:");
            textoInicial();
            opcaoEscolhida = lerInteiro(entrada);

            switch (opcaoEscolhida){
                case 0:
                    System.out.println("\nEncerrando o programa...");
                    break;

                case 1:
                    textoTipoMoeda();
                    entradaDoTipoDeMoeda = lerInteiro(entrada);
                    verificaEntrada(entradaDoTipoDeMoeda, entrada);
                    if(entradaDoTipoDeMoeda != 0 ){
                    tipoMoeda = converteEntradaEmTipo(entradaDoTipoDeMoeda);
                    System.out.println("\nQual o valor a ser inserido?");
                    valorMoeda = lerDouble(entrada);;
                    cofrinho.adicionar(valorMoeda, tipoMoeda);
                    }
                    break;

                case 2:
                    textoTipoMoeda();
                    entradaDoTipoDeMoeda = lerInteiro(entrada);
                    verificaEntrada(entradaDoTipoDeMoeda, entrada);
                    if(entradaDoTipoDeMoeda != 0 ){
                    tipoMoeda = converteEntradaEmTipo(entradaDoTipoDeMoeda);
                    System.out.println("\nQual o valor a ser removido?");
                    valorMoeda = lerDouble(entrada);
                    cofrinho.remover(valorMoeda, tipoMoeda);
                    }
                    break;

                case 3:
                    cofrinho.listagemMoedas();
                    break;

                case 4:
                    cofrinho.totalConvertido();
                    break;

                default:
                    System.out.println("\nA opção escolhida é inválida, tente novamente!");
            }
            }
        }
        static int lerInteiro(Scanner entrada) {
            while (true) {
                try {
                    return entrada.nextInt();
                } catch (Exception e) {
                    System.out.println("\nO valor inserido deve ser um valor inteiro");
                    entrada.nextLine();
                }
            }
        }

        static double lerDouble(Scanner entrada) {
            while (true) {
                try {
                    return entrada.nextDouble();
                } catch (Exception e) {
                    System.out.println("\nO valor inserido deve ser um valor double");
                    entrada.nextLine();
                }
            }
        }

        static void verificaEntrada(int valor, Scanner entrada) {
            while(valor != 1 && valor != 2 && valor != 3 && valor != 0){
                System.out.println("Valor inválido, tente novamente!");
                textoTipoMoeda();
                valor = lerInteiro(entrada);
            }

        }
        static void textoTipoMoeda(){
            System.out.println("""
                            \nQual o tipo da moeda?
                            1 - Real
                            2 - Dólar
                            3 - Euro
                            0 - Cancelar""");
            }
        static void textoInicial(){
            System.out.println("""
                    1-Adicionar Moeda
                    2-Remover Moeda
                    3-Listar Moedas
                    4-Calcular total convertido para Real
                    0-Encerrar""");
        }
        static tipoMoedaEnum converteEntradaEmTipo(int tipoMoeda){
            return switch (tipoMoeda) {
                case 1, 0 -> tipoMoedaEnum.REAL;
                case 2 -> tipoMoedaEnum.DOLAR;
                case 3 -> tipoMoedaEnum.EURO;
                default -> throw new IllegalArgumentException("Valor inválido para tipo de moeda.");
            };
        }


    }