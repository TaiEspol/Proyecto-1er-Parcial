/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Tai Yu Chen
 */
public class Tabla1 extends Tabla {
    private Pieza[][] tabla1;
    private int fila;
    private int columna;
    
    public Tabla1(int fila, int columna){
        super(fila,columna);
       tabla1=new Pieza[fila][columna];
       this.fila=fila;
       this.columna=columna;
    }
    @Override
    public Pieza getTabla(int fila , int columna){
        return tabla1[fila][columna];
    }

    public Pieza[][] getTabla() {
        return tabla1;
    }
    

    public void setTabla1(Pieza[][] tabla1) {
        this.tabla1 = tabla1;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public boolean verificarPieza(int fila, int columna, Tabla tabla, int fil, int col){
        if(tabla.getTabla(fil, col)!=null){
            if(tabla1[fila][columna]==null){
                if(fila>0 && fila< this.getFila() && columna>0 && columna<this.getColumna()){
                }
                // Revisa los alrededores de las piezas ubicadas en las esquinas de la matriz
                else if(fila==0 && columna==0){
                }else if(fila==tabla1.length && columna==tabla1.length){
                }else if(fila==0 && columna==this.getColumna()){
                }else if(fila==this.getFila() && columna==0){
                }
            }
        }
        return false;
    }
    /*tabla1[fila-1][columna]
    *tabla1[fila][columna-1]
    tabla1[fila][columna+1]
    tabla1[fila+1][columna]
   */
    public void agregarPieza(int fila, int columna, Tabla tabla, int fil, int col){
        tabla1[fila][columna]=tabla.getTabla(fil, col);
    }
}
