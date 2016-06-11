/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Marbelisa
 */
public abstract class Tabla {
    private Pieza[][] tabla;
    private int fila;
    private int columna;
    
    public Tabla(int fila, int columna){
        tabla=new Pieza[fila][columna];
        this.fila=fila;
        this.columna=columna;
    }

    public Pieza[][] getTabla() {
        return tabla;
    }

    public void setTabla(Pieza[][] tabla) {
        this.tabla = tabla;
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
    
    public abstract Pieza getTabla(int fila , int columna);
    public abstract boolean verificarPieza(int fila, int columna, Tabla tabla, int fil, int col);
}
