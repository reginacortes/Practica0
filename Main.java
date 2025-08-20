import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args){ 
        //Cola creada a partir de valores generados de forma aleatoria
        // Cola para simular pacientes con niveles de urgencia, cada paciente tiene un nivel de urgencia entre 1 y 10
        Cola<Integer> cola = new Cola<>();
        Random random = new Random();
        List<Long> tiemposInsercion = new ArrayList<>();
        long tiempoOrdenamiento;

        // Medir tiempos de inserción
        long inicioInsertar = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            cola.Insertar(random.nextInt(10) + 1);
        }
        long tiempoInsertar = System.nanoTime() - inicioInsertar;

         // Medir tiempo de ordenamiento
        long startOrdenar = System.nanoTime();
        cola.Ordenar();
        long endOrdenar = System.nanoTime();
        tiempoOrdenamiento = endOrdenar - startOrdenar;

        try (FileWriter writer = new FileWriter("tiempos2.csv")) {
            writer.write("Metodo,Tiempo(ns)\n");
            writer.write("Insertar," + tiempoInsertar + "\n");
            writer.write("Ordenar," + tiempoOrdenamiento + "\n");
            System.out.println("Tiempos guardados en tiempos2.csv ");
        } catch  (IOException e) {
            e.printStackTrace();
        }
            

        //Arbol binario creado a partir de valores generados de forma aleatoria

        ArbolBinario<Integer> arbol = new ArbolBinario<>();
        int cont = 0;

        
        // Medir tiempos de inserción
        long inicioInserArbol = System.nanoTime();
        while(cont <= 1000){
            Random val = new Random();
            arbol.Insertar(val.nextInt(10) + 1);
            cont++;
        }
        long tiempoInsertarArbol = System.nanoTime() - inicioInserArbol;

        
        try (FileWriter writer = new FileWriter("tiempos3.csv")) {
            writer.write("Metodo,Tiempo(ns)\n");
            writer.write("Insertar," + tiempoInsertar + "\n");
            writer.write("Ordenar," + tiempoOrdenamiento + "\n");
            System.out.println("Tiempos guardados en tiempos3.csv ");
        } catch  (IOException e) {
            e.printStackTrace();
        }
    }
}