package zerolcamb.com.principal;

import zerolcamb.com.clases.Moneda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Creado por César Arturo Mejia Bazan 2182005565
 * Programa de las 20 monedas defectuosas
 */

public class inicio {
    public static void main(String[] args) {
        // Se crea una lista de monedas
        List<Moneda> bolsa = new ArrayList<Moneda>();
        int fayuca = 0;
        for (int i = 0; i <= 199; i++) { // Se llena la bolsa de monedas
            if (fayuca < 9) {
                Moneda moneda = new Moneda(28, 10.329);
                bolsa.add(moneda);
                fayuca++; // Se aumenta el valor de fayuca
            } else { // si 1 de cada 10 es fayuca, se añade en fayuca > 9
                Moneda moneda = new Moneda(28, 8.254);
                bolsa.add(moneda);
                fayuca = 0; // Se reinicia el valor de fayuca
            }
        }
        Collections.shuffle(bolsa); // Se desordena la bolsa
        System.out.println("La bolsa tiene: " + bolsa.size() + " monedas"); // Se imprime cuantas monedas tiene la bolsa
        maquina(bolsa); // Se meten las monedas a la maquina
    }

    /* Funcion maquina que recibe un conjunto de monedas */
    public static void maquina(List<Moneda> bolsa) {
        int real = 0; // COntador de monedas reales
        int fayuca = 0; // Contador de monedas fayucas
        for (Moneda moneda : bolsa) { // Ciclo for de cada moneda en la bolsa
            if (isReal(moneda)) { // Si es una moneda real
                System.out.println("Moneda real");
                real++;
            } else { // Si es una moneda fayuca
                System.out.println("Moneda fayuca");
                fayuca++;
            }
        }
        System.out.println("Real: " + real + "\nFayuca: " + fayuca); // Se imprimen cuantas monedas reales se tuvieron y
                                                                     // las fayucas
    }

    /*
     * Función isReal que regresa una expresión booleana de acuerdo si la moneda es
     * real o falsa
     */
    public static boolean isReal(Moneda moneda) {
        if (moneda.getPeso() == 10.329)
            return true;
        else
            return false;
    }
}