package main.java.com.zerolcamb.principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import main.java.com.zerolcamb.clases.Datos;

/**
 *
 * @author Zerol
 */
public class Principal {
    public static void main(String[] args) throws IOException, ParseException  {
        /* 
        * Este programa lee un archivo de mediciones y crea un objeto del tipo
        * datos, los cuales guarda en una lista que se puede ordenar
        */
        
        // Lista donde se guardan las mediciones
        List<Datos> mediciones = new ArrayList<>();
        
        /* Auxiliares */
        // String auxiliar que recorre el archivo linea por linea
        String line; 
        // Date auxiliar que guarda la fecha leida
        Date aux;
        // Objeto Datos auxiliar para almacenarlo en la lista de mediciones
        Datos dato;
        // Declaracion del formato de la fecha, en este caso es:yyyyMMddHHmmss
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        
        // Nombre del archivo
        String file_name = "leer_archivo/leer.txt";
        // Declaración del Buffered reader
        BufferedReader in = null;
        
        // Se intentara abrir el archivo
        try {
            in = new BufferedReader(new FileReader(file_name));
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo");
            System.exit(0);
        } 
        
        System.out.println("Archivo leido con exito");
        // Contador auxiliar
        int contador = 1;
        
        // Mientras la linea almacenada en line no sea nula
        while((line = in.readLine()) != null){
            // Si la linea empieza con "TimeStamp" se pasa a la siguiente linea
            if(line.startsWith("TimeStamp")) continue; 
            // Se separan los datos leidos de la linea con una coma
            String[] data = line.split(",", 0);
            // El primer dato leido siempre es la fecha
            aux = df.parse(data[0]);
            // Con el contador auxiliar, la fecha auxiliar y el segundo dato
            // leido el cual siempre es la distancia se construye un objeto Datos
            dato = new Datos(contador, aux, Double.parseDouble(data[1]));
            // Se añade el objeto creado a la lista de mediciones
            mediciones.add(dato);
            // Se incrementa el contador
            contador++;
        }
        // Se ordena la lista del más grande al más pequeño
        Collections.sort(mediciones);
        // Se imprimen los objetos de la lista de mediciones
        for(Datos _dato : mediciones) System.out.println(_dato);
        // Se cierra el archivo
        in.close();
    }
}
