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

            // Aqui eu faço um loop para ter certeza que vou continuar printando as opções no console caso usuario não
            // peça para que o programa seja encerrado
            while (opcaoEscolhida != 0) {
            System.out.println("\nCofrinho:");
            textoInicial();
            opcaoEscolhida = lerInteiro(entrada);

            // faço a verificação da opção escolhida para fazer o que o usuário pede
            switch (opcaoEscolhida){
                case 0:
                    System.out.println("\nEncerrando o programa...");
                    entrada.close();
                    break;

                case 1:

                    // Adiciono um valor ao cofrinho de acordo com o usuario
                    textoTipoMoeda();
                    entradaDoTipoDeMoeda = lerInteiro(entrada);
                    verificaEntrada(entradaDoTipoDeMoeda, entrada);
                    if(entradaDoTipoDeMoeda != 0 ){
                    tipoMoeda = converteEntradaEmTipo(entradaDoTipoDeMoeda);
                    System.out.println("\nQual o valor a ser inserido?");
                    valorMoeda = lerDouble(entrada);
                    cofrinho.adicionar(valorMoeda, tipoMoeda);
                    }
                    break;

                case 2:

                    // Removo um valor ao cofrinho de acordo com o usuario
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

                    // Listo os valores do cofrinho para o usuario
                    cofrinho.listagemMoedas();
                    break;

                case 4:

                    // Listo os valores do cofrinho já convertido em reais para o usuario
                    cofrinho.totalConvertido();
                    break;

                default:
                    System.out.println("\nA opção escolhida é inválida, tente novamente!");
            }
            }
        }

        // Leio os valores e verifico se sao do tipo inteiro
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

        // Leio os valores e verifico se sao do tipo double
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

        // verifico se a entrada do usuário está entre as disponíveis
        static void verificaEntrada(int valor, Scanner entrada) {
            while(valor != 1 && valor != 2 && valor != 3 && valor != 0){
                System.out.println("Valor inválido, tente novamente!");
                textoTipoMoeda();
                valor = lerInteiro(entrada);
            }

        }
        // printo o texto de escolha para o usuário
        static void textoTipoMoeda(){
            System.out.println("""
                            \nQual o tipo da moeda?
                            1 - Real
                            2 - Dólar
                            3 - Euro
                            0 - Cancelar""");
            }
            // printo o texto de escolha para o usuário
        static void textoInicial(){
            System.out.println("""
                    1-Adicionar Moeda
                    2-Remover Moeda
                    3-Listar Moedas
                    4-Calcular total convertido para Real
                    0-Encerrar""");
        }
        // converto o tipo de moeda pra enum para que o meu codigo fique mais simples facil de ler.
        static tipoMoedaEnum converteEntradaEmTipo(int tipoMoeda){
            return switch (tipoMoeda) {
                case 1, 0 -> tipoMoedaEnum.REAL;
                case 2 -> tipoMoedaEnum.DOLAR;
                case 3 -> tipoMoedaEnum.EURO;
                default -> throw new IllegalArgumentException("Valor inválido para tipo de moeda.");
            };
        }


    }