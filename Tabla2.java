/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Random;

/**
 *
 * @author Tai Yu Chen
 */
public class Tabla2 extends Tabla{
    private Random random= new Random();
    private Pieza[][] tabla;
    private int fila;
    private int columna;
    
    public Tabla2(int fila,int columna){
        super(fila,columna);
        this.tabla = new Pieza[fila][columna];
        this.fila=fila;
        this.columna=columna;
    }
    
    @Override
    public Pieza getTabla(int fila , int columna){
        return tabla[fila][columna];
    }
    
    public void agregaarPieza(){
        for(int i=0; i<tabla.length;i++){
            for(int j=0;j<tabla.length;j++){
                int up=random.nextInt(9);
                int down=random.nextInt(9);
                int right=random.nextInt(9);
                int left=random.nextInt(9);
                tabla[i][j]=new Pieza(up,down,right,left);
                tabla[i][j].crearPieza();
            }
        }
    }
    public void visibleTabla(){
        System.out.println("****************************************************************************************************");
        System.out.println("\t\t\t\t\tTable 2");
        System.out.println("****************************************************************************************************");
        System.out.println("\t\t1"+"\t\t2"+"\t\t3"+"\t\t4"+"\t\t5"+"\t\t6");
        System.out.println(" ");
        for(int i=0; i<tabla.length;i++){
            System.out.println(" ");
             System.out.print((i+1)+"\t ");
            for(int j=0;j<tabla.length;j++){
                if(tabla[i][j]!=null){
                    tabla[i][j].visiblePieza();
                }
            }
            System.out.println(" ");
            System.out.println(" ");
        }
        System.out.println("****************************************************************************************************");
    }
    public boolean verificarPieza(int fil2,int colu2,Tabla tabla1, int fil1,int colu1){
        if(this.tabla[fil2][colu2]==null){
            if(tabla1.getTabla(fil1, colu1)!=null){
                return true;
            }
        }return false;
    }
    public void volverCasa(int fil2,int colu2,Tabla tabla1, int fil1,int colu1){
        tabla[fil2][colu2]=tabla1.getTabla(fil1, colu1);
    }
}
