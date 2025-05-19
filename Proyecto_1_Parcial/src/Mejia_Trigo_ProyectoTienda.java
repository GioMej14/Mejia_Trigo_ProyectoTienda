/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author trigo
 */
import java.util.Scanner;

public class Mejia_Trigo_ProyectoTienda {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double caja = 0;
        double totalVentas = 0, totalCompras = 0;
        int numVentas = 0, numCompras = 0;
        double ventaMayor = 0, compraMayor = 0;
        double azucarVendida = 0, avenaVendida = 0, trigoVendido = 0, maizVendido = 0;
        double stockAzucar = 0, stockAvena = 0, stockTrigo = 0, stockMaiz = 0;
        boolean cajaCerradaHoy = false;

        boolean cajaAbierta = false;
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir");

            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.print("Seleccione una opción: ");
                if (input.hasNextInt()) {
                    opcion = input.nextInt();
                    if (opcion >= 1 && opcion <= 6) {
                        entradaValida = true;
                    } else {
                        System.out.println("Opción inválida. Ingrese un número del 1 al 6.");
                    }
                } else {
                    System.out.println("Error. Ingrese solo números.");
                    input.next(); //limpiar entrada incorrecta
                }
            }

            switch (opcion) {
                case 1:
                    if (!cajaCerradaHoy) {
                        int efectivo = 0;
                        entradaValida = false;

                        while (!entradaValida) {
                            System.out.print("Ingrese efectivo a la caja: L. ");
                            if (input.hasNextInt()) {
                                efectivo = input.nextInt();
                                if (efectivo > 0) {
                                    entradaValida = true;
                                } else {
                                    System.out.println("Cantidad inválida. Debe ser mayor que 0.");
                                }
                            } else {
                                System.out.println("Entrada inválida. Ingrese solo números.");
                                input.next();
                            }
                        }

                        caja += efectivo;
                        System.out.printf("Caja abierta. Se agregó Lps. %.2f\n", (double) efectivo);
                    } else {
                        System.out.println("Caja reabierta. No se permite ingresar más efectivo hoy.");
                    }

                    cajaAbierta = true;
                    break;

                case 2:
                    if (!cajaAbierta) {
                        System.out.println("Debe abrir la caja primero.");
                        break;
                    }

                    char tipoCliente = ' ';
                    boolean entradaTipoClienteValida = false;

                    while (!entradaTipoClienteValida) {
                        System.out.print("Tipo de cliente (A/B/C): ");
                        String entrada = input.next().toUpperCase();
                        if (entrada.equals("A") || entrada.equals("B") || entrada.equals("C")) {
                            tipoCliente = entrada.charAt(0);
                            entradaTipoClienteValida = true;
                        } else {
                            System.out.println("Entrada inválida. Solo A, B o C.");
                        }
                    }

                    double kgAzucar = 0,
                     kgAvena = 0,
                     kgTrigo = 0,
                     kgMaiz = 0;
                    boolean comproAzucar = false,
                     comproAvena = false,
                     comproTrigo = false,
                     comproMaiz = false;

                    //Catalogo personalizado
                    System.out.println("\n--- CATÁLOGO DE PRODUCTOS DISPONIBLES ---");
                    System.out.println("Código | Producto | Precio");
                    System.out.println("-------------------------------");

                    if (tipoCliente == 'A') {
                        System.out.println("1      | Azúcar   | Lps. 30.0");
                        System.out.println("2      | Avena    | Lps. 25.0");
                        System.out.println("3      | Trigo    | Lps. 32.0");
                        System.out.println("4      | Maíz     | Lps. 20.0");
                    } else if (tipoCliente == 'B') {
                        System.out.println("1      | Azúcar   | Lps. 30.0");
                        System.out.println("2      | Avena    | Lps. 25.0");
                        System.out.println("3      | Trigo    | Lps. 32.0");
                    } else if (tipoCliente == 'C') {
                        System.out.println("4      | Maíz     | Lps. 20.0");
                    }

                    System.out.println();

                    double subtotal = 0;
                    boolean continuar = true;

                    while (continuar) {
                        int codigo = 0;
                        boolean entradaCodigoValida = false;

                        while (!entradaCodigoValida) {
                            System.out.print("Código del producto (1-4): ");
                            if (input.hasNextInt()) {
                                codigo = input.nextInt();
                                if (codigo >= 1 && codigo <= 4) {
                                    entradaCodigoValida = true;
                                } else {
                                    System.out.println("Código inválido.");
                                }
                            } else {
                                System.out.println("Entrada inválida.");
                                input.next();
                            }
                        }

                        boolean puedeComprar = false;
                        if (tipoCliente == 'A') {
                            puedeComprar = true;
                        } else if (tipoCliente == 'B' && (codigo >= 1 && codigo <= 3)) {
                            puedeComprar = true;
                        } else if (tipoCliente == 'C' && codigo == 4) {
                            puedeComprar = true;
                        }

                        if (!puedeComprar) {
                            System.out.println("Este cliente no puede comprar ese producto.");
                        } else {
                            double kg = 0;
                            boolean entradaCantidadValida = false;

                            while (!entradaCantidadValida) {
                                System.out.print("Cantidad en kg: ");
                                if (input.hasNextDouble()) {
                                    kg = input.nextDouble();
                                    if (kg > 0) {
                                        entradaCantidadValida = true;
                                    } else {
                                        System.out.println("Debe ser mayor que 0.");
                                    }
                                } else {
                                    System.out.println("Entrada inválida.");
                                    input.next();
                                }
                            }

                            boolean hayStock = false;
                            if (codigo == 1 && stockAzucar >= kg) {
                                hayStock = true;
                            }
                            if (codigo == 2 && stockAvena >= kg) {
                                hayStock = true;
                            }
                            if (codigo == 3 && stockTrigo >= kg) {
                                hayStock = true;
                            }
                            if (codigo == 4 && stockMaiz >= kg) {
                                hayStock = true;
                            }

                            if (!hayStock) {
                                System.out.println("No hay suficiente stock de este producto.");
                            } else {
                                if (codigo == 1) {
                                    subtotal += kg * 30;
                                    azucarVendida += kg;
                                    stockAzucar -= kg;
                                    kgAzucar += kg;
                                    comproAzucar = true;
                                }
                                if (codigo == 2) {
                                    subtotal += kg * 25;
                                    avenaVendida += kg;
                                    stockAvena -= kg;
                                    kgAvena += kg;
                                    comproAvena = true;
                                }
                                if (codigo == 3) {
                                    subtotal += kg * 32;
                                    trigoVendido += kg;
                                    stockTrigo -= kg;
                                    kgTrigo += kg;
                                    comproTrigo = true;
                                }
                                if (codigo == 4) {
                                    subtotal += kg * 20;
                                    maizVendido += kg;
                                    stockMaiz -= kg;
                                    kgMaiz += kg;
                                    comproMaiz = true;
                                }
                            }
                        }

                        System.out.print("¿Desea comprar otro producto? (s/n): ");
                        continuar = input.next().toLowerCase().startsWith("s");
                    }

                    double descuento = 0;
                    if (subtotal > 5000) {
                        descuento = 0.10;
                    } else if (subtotal >= 1000) {
                        descuento = 0.05;
                    }

                    double impuesto = subtotal * 0.07;
                    double total = subtotal - subtotal * descuento + impuesto;
                    caja += total;
                    totalVentas += total;
                    numVentas++;
                    if (total > ventaMayor) {
                        ventaMayor = total;
                    }

                    if (subtotal == 0) {
                        System.out.println("No se realizaron compras. No se generó factura.");
                        break;
                    }

                    //FActura
                    System.out.println("===========================================");
                    System.out.println("              FACTURA DE VENTA             ");
                    System.out.println("===========================================");
                    System.out.printf("%-10s %-15s %-8s %-10s %-10s\n",
                            "Código", "Producto", "Kg", "Precio", "Subtotal");
                    System.out.println("------------------------------------------------");

                    if (comproAzucar) {
                        System.out.printf("%-10d %-15s %-8.2f L%-9.2f L%-9.2f\n",
                                1, "Azúcar", kgAzucar, 30.0, kgAzucar * 30.0);
                    }
                    if (comproAvena) {
                        System.out.printf("%-10d %-15s %-8.2f L%-9.2f L%-9.2f\n",
                                2, "Avena", kgAvena, 25.0, kgAvena * 25.0);
                    }
                    if (comproTrigo) {
                        System.out.printf("%-10d %-15s %-8.2f L%-9.2f L%-9.2f\n",
                                3, "Trigo", kgTrigo, 32.0, kgTrigo * 32.0);
                    }
                    if (comproMaiz) {
                        System.out.printf("%-10d %-15s %-8.2f L%-9.2f L%-9.2f\n",
                                4, "Maíz", kgMaiz, 20.0, kgMaiz * 20.0);
                    }

                    System.out.println("------------------------------------------------");
                    System.out.printf("Subtotal:           L%.2f\n", subtotal);
                    System.out.printf("Descuento:          L%.2f\n", subtotal * descuento);
                    System.out.printf("Impuesto (7%%):      L%.2f\n", impuesto);
                    System.out.printf("TOTAL A PAGAR:      L%.2f\n", total);
                    System.out.println("===========================================");
                    System.out.println("Gracias por su compra. Vuelva pronto.");
                    System.out.println("===========================================");
                    break;

                case 3:
                    if (!cajaAbierta) {
                        System.out.println("Debe abrir la caja primero.");
                        break;
                    }

                    char tipoProveedor = ' ';
                    entradaValida = false;

                    while (!entradaValida) {
                        System.out.print("Tipo de proveedor (A/B/C): ");
                        String entrada = input.next().toUpperCase();
                        if (entrada.equals("A") || entrada.equals("B") || entrada.equals("C")) {
                            tipoProveedor = entrada.charAt(0);
                            entradaValida = true;
                        } else {
                            System.out.println("Entrada inválida.");
                        }
                    }

                    //Catalogo del proveedor
                    System.out.println("\n--- CATÁLOGO DEL PROVEEDOR ---");
                    System.out.println("Código | Producto | Precio");
                    System.out.println("-------------------------------");

                    if (tipoProveedor == 'A') {
                        System.out.println("1      | Azúcar   | Lps. 25.0");
                        System.out.println("4      | Maíz     | Lps. 18.0");
                    } else {
                        if (tipoProveedor == 'B') {
                            System.out.println("2      | Avena    | Lps. 20.0");
                            System.out.println("3      | Trigo    | Lps. 30.0");
                        } else {
                            if (tipoProveedor == 'C') {
                                System.out.println("2      | Avena    | Lps. 22.0");
                            }
                        }
                    }
                    System.out.println();

                    int codCompra = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Código del producto (1-4): ");
                        if (input.hasNextInt()) {
                            codCompra = input.nextInt();
                            if (codCompra >= 1 && codCompra <= 4) {
                                entradaValida = true;
                            } else {
                                System.out.println("Código inválido.");
                            }
                        } else {
                            System.out.println("Entrada inválida.");
                            input.next();
                        }
                    }

                    boolean puedeVender = false;
                    if (tipoProveedor == 'A' && (codCompra == 1 || codCompra == 4)) {
                        puedeVender = true;
                    }
                    if (tipoProveedor == 'B' && (codCompra == 2 || codCompra == 3)) {
                        puedeVender = true;
                    }
                    if (tipoProveedor == 'C' && codCompra == 2) {
                        puedeVender = true;
                    }

                    if (!puedeVender) {
                        System.out.println("Este proveedor no vende ese producto.");
                        break;
                    }

                    double kgCompra = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Cantidad en kg: ");
                        if (input.hasNextDouble()) {
                            kgCompra = input.nextDouble();
                            if (kgCompra > 0) {
                                entradaValida = true;
                            } else {
                                System.out.println("Debe ser mayor que 0.");
                            }
                        } else {
                            System.out.println("Entrada inválida.");
                            input.next();
                        }
                    }

                    double precioCompra = 0;
                    if (tipoProveedor == 'A') {
                        if (codCompra == 1) {
                            precioCompra = 25;
                        }
                        if (codCompra == 4) {
                            precioCompra = 18;
                        }
                    }
                    if (tipoProveedor == 'B') {
                        if (codCompra == 2) {
                            precioCompra = 20;
                        }
                        if (codCompra == 3) {
                            precioCompra = 30;
                        }
                    }
                    if (tipoProveedor == 'C' && codCompra == 2) {
                        precioCompra = 22;
                    }

                    double totalCompra = precioCompra * kgCompra;

                    if (totalCompra > caja) {
                        System.out.println("No hay suficiente dinero en caja.");
                    } else {
                        caja -= totalCompra;
                        totalCompras += totalCompra;
                        numCompras++;
                        if (totalCompra > compraMayor) {
                            compraMayor = totalCompra;
                        }

                        //Aumento de stock
                        if (codCompra == 1) {
                            stockAzucar += kgCompra;
                        }
                        if (codCompra == 2) {
                            stockAvena += kgCompra;
                        }
                        if (codCompra == 3) {
                            stockTrigo += kgCompra;
                        }
                        if (codCompra == 4) {
                            stockMaiz += kgCompra;
                        }

                        System.out.printf("Compra realizada por Lps. %.2f\n", totalCompra);
                    }
                    break;

                case 4:
                    System.out.printf("Caja actual: %.2f\n", caja);
                    System.out.printf("Ventas: %d, Total: %.2f\n", numVentas, totalVentas);
                    System.out.printf("Compras: %d, Total: %.2f\n", numCompras, totalCompras);
                    System.out.printf("Ganancia: %.2f\n", totalVentas - totalCompras);
                    System.out.printf("Mayor venta: %.2f, Mayor compra: %.2f\n", ventaMayor, compraMayor);

                    String estrella = "Azúcar";
                    double maxKg = azucarVendida;

                    if (avenaVendida > maxKg) {
                        maxKg = avenaVendida;
                        estrella = "Avena";
                    }
                    if (trigoVendido > maxKg) {
                        maxKg = trigoVendido;
                        estrella = "Trigo";
                    }
                    if (maizVendido > maxKg) {
                        maxKg = maizVendido;
                        estrella = "Maíz";
                    }

                    System.out.println("Producto estrella: " + estrella);
                    break;

                case 5:

                    if (!cajaAbierta) {
                        System.out.println("Debe abrir la caja primero.");
                        break;
                    }

                    System.out.printf("Efectivo en caja: Lps. %.2f\n", caja);
                    double maxDeposito = caja * 0.6;
                    double deposito = 0;
                    boolean entradaDepositoValida = false;

                    while (!entradaDepositoValida) {
                        System.out.printf("¿Cuánto desea depositar en el banco? (máx Lps. %.2f): ", maxDeposito);
                        if (input.hasNextDouble()) {
                            deposito = input.nextDouble();
                            if (deposito >= 0 && deposito <= maxDeposito) {
                                entradaDepositoValida = true;
                            } else {
                                System.out.println("Depósito inválido. Ingrese un valor entre 0 y " + maxDeposito);
                            }
                        } else {
                            System.out.println("Entrada inválida.");
                            input.next();
                        }
                    }

                    caja -= deposito;
                    System.out.printf("Depósito realizado: Lps. %.2f\n", deposito);
                    System.out.printf("Efectivo restante en caja: Lps. %.2f\n", caja);

                    //Reiniciar acumuladores y contadores
                    numVentas = 0;
                    numCompras = 0;
                    totalVentas = 0;
                    totalCompras = 0;
                    ventaMayor = 0;
                    compraMayor = 0;
                    azucarVendida = 0;
                    avenaVendida = 0;
                    trigoVendido = 0;
                    maizVendido = 0;

                    //Cerrar la caja
                    cajaAbierta = false;
                    cajaCerradaHoy = true;

                    System.out.println("Caja cerrada exitosamente. Todos los contadores han sido reiniciados.");
                    break;

                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
            }
        } while (opcion != 6);
    }
}
