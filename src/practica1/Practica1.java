/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jonna
 */
public class Practica1 {
    
    public static void leerFichero(String fich,  ArrayList<ArrayList<Integer>> _pieza, ArrayList<ArrayList<Integer>> _distancia, int unidades) throws IOException {
        // Fichero del que queremos leer
        File fichero = new File(fich);
        Scanner s = null;
        
        try {
            // Leemos el contenido del fichero
            s = new Scanner(fichero);

            //ArrayList<Pieza> piezas = _pieza;   
            ArrayList<ArrayList<Integer>> piezas = _pieza;
            ArrayList<ArrayList<Integer>> distincias = _distancia;
            int ite = 0;
            
            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                String linea = s.nextLine(); 	// Guardamos la linea en un String
                String[] cortarString = linea.split(" ");
                ArrayList<Integer> numeros = new ArrayList<Integer>();
                                    
                //System.out.println(linea);
                if (ite == 0) {
                    unidades = Integer.parseInt(linea);
                    System.out.println(unidades);
                }else if(ite >= 2 && ite <= (unidades + 1)){
                    for (int i = 0; i < cortarString.length; i++) {
                        if (cortarString[i].compareTo("") != 0) {
                            int num_i = Integer.parseInt(cortarString[i]);
                            numeros.add(num_i);                            
                        }
                    }
                    piezas.add(numeros);
                }else if(ite > (unidades + 2)){
                    for (int i = 0; i < cortarString.length; i++) {
                        if (cortarString[i].compareTo("") != 0) {
                            int num_i = Integer.parseInt(cortarString[i]);
                            numeros.add(num_i);                            
                        }
                    }
                    distincias.add(numeros);
                }
                ite++;
            }
                
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }
    
    public static void mostrarDatos(ArrayList<ArrayList<Integer>> piezas, ArrayList<ArrayList<Integer>> distancias){
        System.out.println("PIEZAS");
        for(int i = 0; i < piezas.size(); i ++){
            for(int j = 0; j < piezas.get(i).size(); j++){
                System.out.print(piezas.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        
        System.out.println("DISTANCIAS");
        
        for(int i = 0; i < distancias.size(); i ++){
            for(int j = 0; j < distancias.get(i).size(); j++){
                System.out.print(distancias.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here        
        ArrayList<ArrayList<Integer>> piezas = new ArrayList<>();
        ArrayList<ArrayList<Integer>> distancias = new ArrayList<>();
        int unidades = 4;

        leerFichero("instancias/ejemplo/ejemplo.txt", piezas, distancias, unidades);
        mostrarDatos(piezas, distancias);
        
        Greedy greedy = new Greedy(unidades, piezas, distancias);
        
        System.out.println("La solucion es: "+greedy.solucion());
    }
    
}
