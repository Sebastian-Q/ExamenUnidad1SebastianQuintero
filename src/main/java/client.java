import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class client {
    private static Scanner sc = new Scanner(System.in) ;
    public static void main(String[] args) throws MalformedURLException, XmlRpcException, SQLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1300"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        DaoArchivo dao = new DaoArchivo();
        archive procesos = new archive();
        int opc = 0;
        int id = 0, numero1, numero2, numero3;
        char l1, l2,l3,l4,l5,l6,l7,l8,l9,l10;
        String n1,n2,n3,n4,n5,n6,n7,n8,n9,n10="";
        String name ="", primApellido="", segunApellido, curp, fechaNacimiento, rfc;

        do {
            System.out.println("Seleccionar una opcion");
            System.out.println("1.-Introducir una nueva Persona \n2.-Consultar Datos 1 persona \n3.-Modificar Datos \n4.-Eliminar Datos \n5.-Consultar Datos \n6.-Salir");
            opc = sc.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Intoduccir Nombre:");
                    name = sc.next();
                    System.out.println("Intoduccir Primer Apellido:");
                    primApellido = sc.next();
                    System.out.println("Intoduccir Segundo Apellido:");
                    segunApellido = sc.next();
                    System.out.println("Intoduccir Curp:");
                    curp = sc.next();

                    System.out.println("Intoduccir Fecha de Nacimiento (ejemplo 03/07/2002):");
                    fechaNacimiento = sc.next();

                    l1 = primApellido.charAt(0);
                    l2 = primApellido.charAt(1);
                    l3 = segunApellido.charAt(0);
                    l4 = name.charAt(0);
                    l5 = fechaNacimiento.charAt(8);
                    l6 = fechaNacimiento.charAt(9);
                    l7 = fechaNacimiento.charAt(3);
                    l8 = fechaNacimiento.charAt(4);
                    l9 = fechaNacimiento.charAt(0);
                    l10 = fechaNacimiento.charAt(1);
                    n1 = String.format(String.valueOf(l1));
                    n2 = String.format(String.valueOf(l2));
                    n3 = String.format(String.valueOf(l3));
                    n4 = String.format(String.valueOf(l4));
                    n5 = String.format(String.valueOf(l5));
                    n6 = String.format(String.valueOf(l6));
                    n7 = String.format(String.valueOf(l7));
                    n8 = String.format(String.valueOf(l8));
                    n9 = String.format(String.valueOf(l9));
                    n10 = String.format(String.valueOf(l10));
                    Random aleatorio = new Random();
                    numero1 = aleatorio.nextInt((10)+1);
                    numero2 = aleatorio.nextInt((10)+1);
                    numero3 = aleatorio.nextInt((10)+1);
                    rfc = n1+n2+n3+n4+n5+n6+n7+n8+n9+n10+ numero1+ numero2 + numero3;
                    rfc=rfc.toUpperCase();
                    System.out.println("Su RFC: "+ rfc);
                    archive.insertarPersona(id, name, primApellido, segunApellido, curp, fechaNacimiento, rfc);
                    break;
                case 2:
                    System.out.println("Introducir su CURP");
                    curp = sc.next();
                    archive.llamar1persona(curp);
                    break;
                case 3:
                    System.out.println("Introducir su ID");
                    id = sc.nextInt();
                    System.out.println("Intoduccir Nombre:");
                    name = sc.next();
                    System.out.println("Intoduccir Primer Apellido:");
                    primApellido = sc.next();
                    System.out.println("Intoduccir Segundo Apellido:");
                    segunApellido = sc.next();
                    System.out.println("Intoduccir Curp:");
                    curp = sc.next();
                    System.out.println("Intoduccir Fecha de Nacimiento (ejemplo 03/07/2002):");
                    fechaNacimiento = sc.next();

                    l1 = primApellido.charAt(0);
                    l2 = primApellido.charAt(1);
                    l3 = segunApellido.charAt(0);
                    l4 = name.charAt(0);
                    l5 = fechaNacimiento.charAt(8);
                    l6 = fechaNacimiento.charAt(9);
                    l7 = fechaNacimiento.charAt(3);
                    l8 = fechaNacimiento.charAt(4);
                    l9 = fechaNacimiento.charAt(0);
                    l10 = fechaNacimiento.charAt(1);
                    n1 = String.format(String.valueOf(l1));
                    n2 = String.format(String.valueOf(l2));
                    n3 = String.format(String.valueOf(l3));
                    n4 = String.format(String.valueOf(l4));
                    n5 = String.format(String.valueOf(l5));
                    n6 = String.format(String.valueOf(l6));
                    n7 = String.format(String.valueOf(l7));
                    n8 = String.format(String.valueOf(l8));
                    n9 = String.format(String.valueOf(l9));
                    n10 = String.format(String.valueOf(l10));
                    Random rand = new Random();
                    numero1 = rand.nextInt((10)+1);
                    numero2 = rand.nextInt((10)+1);
                    numero3 = rand.nextInt((10)+1);
                    rfc = n1+n2+n3+n4+n5+n6+n7+n8+n9+n10+ numero1+ numero2 + numero3;
                    rfc=rfc.toUpperCase();
                    System.out.println("Nuevo RFC: "+ rfc);
                    archive.update(id, name, primApellido, segunApellido, curp, fechaNacimiento, rfc);

                    break;
                case 4:
                    System.out.println("Ingresa el RFC");
                    rfc = sc.next();
                    archive.delete(rfc);
                    break;
                case 5:
                    archive.llamar();
                case 6:
                    System.out.println("adios......");
                    break;
                default:
                    System.out.println("No selecciono ninguna opcion");
            }

        }while (opc != 6);

    }
}
