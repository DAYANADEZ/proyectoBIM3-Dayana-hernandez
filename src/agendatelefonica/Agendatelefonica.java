package agendatelefonica;

import java.util.Scanner;

public class Agendatelefonica {
        
    static contacto misContactos[] = new contacto[15];
    static int contador = 0;
    static int d;
    static String nombrei, domicilioi;

    public static void main(String[] args) {
        int op = 0;
        Scanner entrada = new Scanner(System.in);
        while (op != 5) {
            System.out.println("--------------------------------------------");
            System.out.println("**************AGENDA TELEFONICA**************");
            System.out.println("--------------------MENU--------------------");
            System.out.println("1. Guardar contacto");
            System.out.println("2. Ver contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Actualizar datos del contacto");
            System.out.println("5. Salir");
            System.out.println("--------------------------------------------");
            System.out.println("ingrese un numero de opcion:");
            System.out.println("--------------------------------------------");
            op = entrada.nextInt();
            
            if (op == 1) {
                System.out.println("AGREGA UN NUEVO CONTACTO");
                crearContacto();
            } else if (op == 2) {
                System.out.println("------------TUS CONTACTOS INGRESADOS SON-----------------");
                verContactos();
            } else if (op == 3) {
                System.out.println("--------------BUSCAR CONTACTO-------------");
                System.out.println("Ingresa el numero de tu contacto");
                Scanner teclado = new Scanner(System.in);
                String numero = teclado.nextLine();
                System.out.println(verContacto(numero));
            } else if (op == 4) {
                System.out.println("--MODIFICAR CONTACTO--");
                System.out.println("Ingrese el numero del contacto que desea modificar: ");
                Scanner entrada1 = new Scanner(System.in);
                String numero = entrada1.nextLine();
                System.out.println(ActualizarContacto(numero));
                System.out.println("nombre: " + misContactos[d].verNombre());
                System.out.println("numero: " + misContactos[d].verNumero());
                System.out.println("domicilio: " + misContactos[d].verDomicilio());
                System.out.println("***************************************************");
            } else if (op == 5) {
                System.out.println("-*-*PROGRAMA FINALIZADO*-*-");
                break;
            } else {
                System.out.println("##OPCION INCORRECTA##");
            }
        }
    }

    //agregar contacto
    static public void crearContacto() {
        if (contador >= 15) {
            System.out.println("---------------------------------------");
            System.out.println("*********lA MEMORIA ESTA LLENA*********");
            System.out.println("---------------------------------------");
        } else {
            Scanner teclado = new Scanner(System.in);
            System.out.println("--------------NUEVO CONTACTO--------------");
            System.out.println("Ingrese el nombre del nuevo contacto");
            String nombre = teclado.nextLine();
            System.out.println("Ingrese el numero del contacto");
            String telefono = teclado.nextLine();
            System.out.println("Ingrese el domicilio de tu contacto");
            String domicilio = teclado.nextLine();
            misContactos[contador] = new contacto(nombre, telefono, domicilio);
            System.out.println("DATO ALMACENADO");
            contador++;
        }
    }

    //mostrar contactos
    static public void verContactos() {
        for (int i = 0; i < contador; i++) {
            System.out.println("Nombre: " + misContactos[i].verNombre());
            System.out.println("Numero: " + misContactos[i].verNumero());
            System.out.println("Domicilio: " + misContactos[i].verDomicilio());
            System.out.println("#####################################");
        }
    }

    //ver solo un contacto
    static public String verContacto(String telefono) {
        int posicion = -1;
        for (int i = 0; i < 15; i++) {
            if (misContactos[i] != null) {
                if (misContactos[i].verNumero().equals(telefono)) {
                    posicion = i;
                    break;
                }
            }
        }
        if (posicion != -1) {
            return "numero: " + misContactos[posicion].verNumero() + " domicilio: " + misContactos[posicion].verDomicilio() + " nombre: " + misContactos[posicion].verNombre();
        } else {
            return "#####CONTACTO NO ENCONTRADO#####";
        }

    }

    //modificar los datos con setters
    static public String ActualizarContacto(String numero) {
        Scanner teclado1 = new Scanner(System.in);
        int posicion = -1;
        for (int i = 0; i < 15; i++) {
            if (misContactos[i] != null) {
                if (misContactos[i].verNumero().equals(numero)) {
                    posicion = i;
                    break;
                }
            }
        }
        if (posicion != -1) {
            System.out.println("----------------------------------------------");
            System.out.println("Ingrese el nombre");
            nombrei = teclado1.nextLine();
            System.out.println("Ingrese el domicilio");
            domicilioi = teclado1.nextLine();
            misContactos[d].SetNombre(nombrei);
            misContactos[d].SetDomicilio(domicilioi);
            return "-----Datos guardados con exito-----";
        } else {
            return "Contacto no encontrado";
        }
    }
}


