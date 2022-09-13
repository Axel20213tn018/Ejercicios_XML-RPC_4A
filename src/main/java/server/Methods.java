package server;

import java.util.Arrays;

public class Methods {
    public double addition (double num1, double num2){
        return num1 + num2;
    }

    public String IMC(String name, double peso, double altura){
        double imc = peso / (altura*altura);

        return "Hola "+ name +", tu IMC es: " + imc;
    }

    public String resultados(int num1, int num2, int num3, int num4){
        int producto = num1 * num2 * num3 * num4;
        int suma = num1 + num2 + num3 + num4;
        double promedio = (num1 + num2 + num3 + num4) / 4;

        return "Hola, el producto es: " + producto + ", la suma es: " + suma + ", el promedio es: " + promedio;
    }

    public String suma (int num1, int num2){
        int acum = 0;
        if (num1 < num2){
            for (int i = num1; i <= num2; i++){
                acum = acum +  i;
            }
        }else {
            for (int i = num2; i <= num1; i++){
                acum = acum +  i;
            }
        }
        return "Resultado --> " + acum;
    }

    public Object[] numeros = new Object[5];

    public String acomodo (Object[] numeros){
        this.numeros = numeros;
        Arrays.sort(this.numeros);

        return Arrays.toString(this.numeros);
    }
}
