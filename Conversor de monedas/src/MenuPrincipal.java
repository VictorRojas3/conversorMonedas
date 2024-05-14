import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        Conversor conversor = new Conversor();
        String desde = "";
        String para = "";
        double monto = 0;
        String insertarValor = "Inserte el valor que desee convertir";
        int opcion;

        while (!salir) {
            String menu = """
                ************************************************
                Bienvenid@ al conversor de monedas de Chaptter
                ************************************************
                Tenemos las siguientes opciones de cambio:
                1.- Dolar -> Peso Argentino
                2.- Peso Argentino -> Dolar
                3.- Dolar -> Real Brasileño
                4.- Real Brasileño -> Dolar
                5.- Dolar -> Peso Mexicano
                6.- Peso Mexicano -> Dolar
                7.- Dolar -> Peso Colombiano
                8.- Peso Colombiano -> Dolar
                9.- Salir
                Seleccione la opcion de conversion:
                """;
            System.out.println(menu);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    desde = "USD";
                    para = "ARS";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 2:
                    desde = "ARS";
                    para = "USD";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 3:
                    desde = "USD";
                    para = "BRL";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 4:
                    desde = "BRL";
                    para = "USD";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 5:
                    desde = "USD";
                    para = "MXN";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 6:
                    desde = "MXN";
                    para = "USD";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 7:
                    desde = "USD";
                    para = "COP";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 8:
                    desde = "COP";
                    para = "USD";
                    System.out.println(insertarValor);
                    monto = scanner.nextDouble();
                    break;
                case 9:
                    salir = true;
                    System.out.println("Gracias por utilizar el conversor de Chaptter, te esperamos pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

            if (opcion >= 1 && opcion <= 8) {
                double resultado = conversor.convertir(desde, para, monto);
                System.out.println("El resultado de la conversión es: " + resultado +" "+ para);
            }
        }

        scanner.close();
    }
}
