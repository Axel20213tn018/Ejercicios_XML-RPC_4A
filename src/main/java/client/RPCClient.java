package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner input = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        int opc;
        do{
            System.out.println("Seleccione un ejercicio:");
            System.out.println("1) IMC");
            System.out.println("2) Producto, suma, promedio");
            System.out.println("3) Suma rango");
            System.out.println("4) Arreglo de 5 enteros (Incompleto)");
            System.out.println("5) Salir");
            opc = input.nextInt();
            switch(opc){
                case 1:
                    //Se piden los datos por teclado
                    System.out.println("Escribe tu nombre: ");
                    String name = input.next();
                    System.out.println("Escribe tu peso (En Kg): ");
                    double peso = input.nextDouble();
                    System.out.println("Escribe tu estatura (En Metros): ");
                    double altura = input.nextDouble();

                    //Guarda el nombre, peso y la altura en un arreglo de objeto
                    Object[] data = {name, peso, altura};

                    //Ejecuta el metodo IMC enviando el objeto
                    String response = (String) client.execute("Methods.IMC", data);

                    //Muestra la respuesta del servidor en pantalla
                    System.out.println(response);
                    break;
                case 2:
                    System.out.println("Escribe un numero: ");
                    int num1 = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    int num2 = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    int num3 = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    int num4 = input.nextInt();

                    Object[] datos ={num1, num2, num3, num4};

                    String response2 = (String) client.execute("Methods.resultados", datos);

                    System.out.println(response2 + "\n");
                    break;
                case 3:
                    System.out.println("Escribe un numero: ");
                    int nume1 = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    int nume2 = input.nextInt();

                    Object[] datos2 ={nume1, nume2};

                    String response3 = (String) client.execute("Methods.suma", datos2);

                    System.out.println(response3);
                    break;
                case 4:
                    Object[] numeros = new Object[5];

                    System.out.println("Escribe un numero: ");
                    numeros[0] = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    numeros[1] = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    numeros[2] = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    numeros[3] = input.nextInt();

                    System.out.println("Escribe otro numero: ");
                    numeros[4] = input.nextInt();

                    String response4 = (String) client.execute("Methods.acomodo", numeros);

                    System.out.println(response4);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(opc != 5);
    }
}
