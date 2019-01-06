/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;

/**
 *
 * @author jonna
 */
public class Greedy {
    private ArrayList<ArrayList<Integer>> piezas;
    private ArrayList<ArrayList<Integer>> distancias;
    private int num;
    private int[] permutaciones;
            
    public Greedy(int num, ArrayList<ArrayList<Integer>> piezas, ArrayList<ArrayList<Integer>> distancias){
        this.num = num;
        this.piezas = piezas;
        this.distancias = distancias;
        
        permutaciones = new int[num];
        /**Inicializar el vector de permutaciones - cambiar por random*/
        permutaciones = new int[] {2, 3, 0, 1};
    }
    
    public int solucion(){
        int sol = 0;                       
        
        for (int i = 0; i < num; i++) {
            int ite = 0;
            
            while(ite < num){
                if (ite != i) {
                    sol += piezas.get(i).get(ite) * distancias.get(permutaciones[i]).get(permutaciones[ite]);  
                }                                                
                ite++;
            }
        }
                
        return sol;
    }
}
