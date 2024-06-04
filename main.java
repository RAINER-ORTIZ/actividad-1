import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();
    static Usuario usuarioActual = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (usuarioActual == null) {
                System.out.println("1. Registrar");
                System.out.println("2. Iniciar Sesión");
                System.out.println("3. Salir");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // consumir nueva línea

                if (opcion == 1) {
                    registrar(scanner);
                } else if (opcion == 2) {
                    iniciarSesion(scanner);
                } else if (opcion == 3) {
                    break;
                } else {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("1. Agregar Pedido");
                System.out.println("2. Editar Pedido");
                System.out.println("3. Listar Pedidos");
                System.out.println("4. Eliminar Pedido");
                System.out.println("5. Cerrar Sesión");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // consumir nueva línea

                if (opcion == 1) {
                    agregarPedido(scanner);
                } else if (opcion == 2) {
                    editarPedido(scanner);
                } else if (opcion == 3) {
                    listarPedidos();
                } else if (opcion == 4) {
                    eliminarPedido(scanner);
                } else if (opcion == 5) {
                    usuarioActual = null;
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        }
        scanner.close();
    }

    public static void registrar(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        usuarios.add(new Usuario(nombre, username, password, email));
        System.out.println("Usuario registrado con éxito.");
    }

    public static void iniciarSesion(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                usuarioActual = usuario;
                System.out.println("Sesión iniciada.");
                return;
            }
        }
        System.out.println("Credenciales incorrectas.");
    }

    public static void agregarPedido(Scanner scanner) {
        System.out.print("Nombre de quien envía el pedido: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo de pedido: ");
        String tipo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha de entrega: ");
        String fechaEntrega = scanner.nextLine();
        System.out.print("Fecha de recolección: ");
        String fechaRecoleccion = scanner.nextLine();
        System.out.print("Cantidad de artículos: ");
        int cantidad = scanner.nextInt();
        System.out.print("Costo: ");
        double costo = scanner.nextDouble();
        scanner.nextLine(); // consumir nueva línea
        pedidos.add(new Pedido(pedidos.size() + 1, nombre, tipo, descripcion, fechaEntrega, fechaRecoleccion, cantidad, costo));
        System.out.println("Pedido agregado con éxito.");
    }

    public static void editarPedido(Scanner scanner) {
        System.out.print("ID del pedido a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consumir nueva línea
        Pedido pedido = buscarPedido(id);
        if (pedido != null) {
            System.out.print("Nuevo nombre (anterior: " + pedido.getNombre() + "): ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo tipo de pedido (anterior: " + pedido.getTipo() + "): ");
            String tipo = scanner.nextLine();
            System.out.print("Nueva descripción (anterior: " + pedido.getDescripcion() + "): ");
            String descripcion = scanner.nextLine();
            System.out.print("Nueva fecha de entrega (anterior: " + pedido.getFechaEntrega() + "): ");
            String fechaEntrega = scanner.nextLine();
            System.out.print("Nueva fecha de recolección (anterior: " + pedido.getFechaRecoleccion() + "): ");
            String fechaRecoleccion = scanner.nextLine();
            System.out.print("Nueva cantidad de artículos (anterior: " + pedido.getCantidad() + "): ");
            int cantidad = scanner.nextInt();
            System.out.print("Nuevo costo (anterior: " + pedido.getCosto() + "): ");
            double costo = scanner.nextDouble();
            scanner.nextLine(); // consumir nueva línea

            pedido.setNombre(nombre);
            pedido.setTipo(tipo);
            pedido.setDescripcion(descripcion);
            pedido.setFechaEntrega(fechaEntrega);
            pedido.setFechaRecoleccion(fechaRecoleccion);
            pedido.setCantidad(cantidad);
            pedido.setCosto(costo);
            System.out.println("Pedido editado con éxito.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    public static void eliminarPedido(Scanner scanner) {
        System.out.print("ID del pedido a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consumir nueva línea
        Pedido pedido = buscarPedido(id);
        if (pedido != null) {
            pedidos.remove(pedido);
            System.out.println("Pedido eliminado con éxito.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public static Pedido buscarPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
}
