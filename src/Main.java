import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        String modenaInicial="";
        String modenaFinal="";
        ServiceApi service= new ServiceApi();

        double valorConvertir;

        while (continuar) {
            mostrarMenu();

            int opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                switch (opcion) {
                    case 1 -> {

                    modenaInicial="USD";
                    modenaFinal="ARS";
                    }
                    case 2 -> {

                        modenaInicial="ARS";
                        modenaFinal="USD";
                    }
                    case 3 -> {

                        modenaInicial="USD";
                        modenaFinal="EUR";
                    }
                    case 4 ->{

                        modenaInicial="BRL";
                        modenaFinal="USD";
                    }
                    case 5 -> {

                        modenaInicial="USD";
                        modenaFinal="COP";
                    }
                    case 6 ->{

                        modenaInicial="COP";
                        modenaFinal="USD";
                    }
                }
            } else if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta la próxima!");
                continuar = false;
            } else {
                System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 7.");
            }

            System.out.println();



            System.out.println("Ingrese el valor que desea convertir:");
            valorConvertir= scanner.nextDouble();
            Moneda respuesta=service.conversorBuscar(valorConvertir,modenaInicial,modenaFinal);
            System.out.println("El valor "+valorConvertir+" "+modenaInicial+" Corresponde al valor final de ==>> "+respuesta.conversion_result() + " "+modenaFinal);

        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("****************************************************");
        System.out.println("Sea bienvenido al conversor de monedas:");
        System.out.println("1) Dólar -> Peso argentino");
        System.out.println("2) Peso argentino -> Dólar");
        System.out.println("3) Dólar -> Euro");
        System.out.println("4) Real brasileño -> Dólar");
        System.out.println("5) Dólar -> Peso colombiano");
        System.out.println("6) Peso colombiano -> Dólar");
        System.out.println("7) Salir");
        System.out.print("Elija una opción válida: ");
        System.out.println();
    }
}
