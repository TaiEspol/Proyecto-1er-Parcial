/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Tai Yu chen
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

    @Override
    public Pieza[][] getTabla() {
        return tabla1;
    }
    public void setTabla1(Pieza[][] tabla1) {
        this.tabla1 = tabla1;
    }

    @Override
    public int getFila() {
        return fila;
    }

    @Override
    public void setFila(int fila) {
        this.fila = fila;
    }

    @Override
    public int getColumna() {
        return columna;
    }

    @Override
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public void cambiarVacio(int fila, int columna){
        tabla1[fila][columna] = vacio[0];
    }
    
    public boolean verificarPieza(int fila, int columna, Tabla tablero, int fil, int col){
        //#########################################################################################################################
        //verificar si la casilla donde se vaya a colocar este vacia y que sus alrededores este igual
        if(tablero.getTabla(fil, col)!=null){//pieza escogida no debe ser vacia
            if(tabla1[fila][columna]==null){//casilla donde se va a colocar debe ser vacia
                if(fila>0 && fila< tabla1.length-1 && columna>0 && columna<tabla1.length-1){
                    if(tabla1[fila-1][columna]==null){//pieza ubicada arriba = p1 
                        if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                            if(tabla1[fila][columna+1]==null){//pieza ubicada en el lado derecho  = p3
                                if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                    return true;
                                }else{//p4 no es vacio
                                    if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                        return true;
                                    }else{
                                        return false;}
                                }
                            }else{//p3 no es vacio
                                if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                    if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }else{//p4 es vacio
                                        return true;}
                                }else{// no es compatible
                                    return false;}
                            }
                        }else{//p2 no es vacio
                            if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                if(tabla1[fila][columna+1]!=null){//p3 no es vacio
                                    if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                        if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                            if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                                return true;
                                            }else{
                                                return false;}
                                        }else{//p4 es vacio
                                            return true;}
                                    }else{// no es compatible
                                        return false;}
                                }else{//p3 es vacio
                                    if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{//no es compatible
                                            return false;}
                                    }else{//p4 es vacio
                                        return true;}
                                }
                            }else{//no es compatible
                                return false;}
                        }
                    }else{//p1 no es vacio
                        if(tabla1[fila-1][columna].getAbajo()==tablero.getTabla(fil, col).getArriba()){//verifica si es compatible
                            if(tabla1[fila][columna-1]!=null){//p2 no es vacio
                                if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                    if(tabla1[fila][columna+1]!=null){//p3 no es vacio
                                        if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                            if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                                if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                                    return true;
                                                }else{
                                                    return false;}
                                            }else{//p4 es vacio
                                                return true;}
                                        }else{// no es compatible
                                            return false;}
                                    }else{//p3 es vacio
                                        if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                            if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                                return true;
                                            }else{//no es compatible
                                                return false;}
                                        }else{//p4 es vacio
                                            return true;}
                                    }
                                }else{//no es compatible
                                    return false;}
                            }else{//cuando p2 es vacio
                                if(tabla1[fila][columna+1]!=null){//p3 no es vacio
                                    if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                        if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                            if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                                return true;
                                            }else{
                                                return false;}
                                        }else{//p4 es vacio
                                            return true;}
                                    }else{// no es compatible
                                        return false;}
                                }else{//p3 es vacio
                                    if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{//no es compatible
                                            return false;}
                                    }else{//p4 es vacio
                                        return true;}
                                }
                            }
                        }else{//si no es compatible
                            return false;}
                    }
                }
                //#########################################################################################################################
                // Revisa los alrededores de las piezas ubicadas en las esquinas de la matriz
                else if(fila==0 && columna==0){
                    if(tabla1[fila][columna]==null){
                        if(tabla1[fila][columna+1]==null){//p3 es vacio
                            if(tabla1[fila+1][columna]==null){//p4 es vacio
                                return true;
                            }else{//p4 no es vacio
                                if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                    return true;
                                }else{
                                    return false;}
                            }
                        }else{//p3 no es vacio
                                if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                    if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }else{//p4 es vacio
                                        return true;}
                                }else{// no es compatible
                                    return false;}
                            }
                    }else{
                        return false;
                    }
                }
                //##############################################################################################
                else if(fila==tabla1.length-1 && columna==tabla1.length-1){
                    if(tabla1[fila][columna]==null){
                        if(tabla1[fila-1][columna]==null){//pieza ubicada arriba = p1 
                            if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                                return true;
                            }else{//p2 no es vacio
                                if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                    return true;
                                }else{
                                    return false;}
                            }
                        }else{//p1 no es vacio
                            if(tabla1[fila-1][columna].getAbajo()==tablero.getTabla(fil, col).getArriba()){//verifica si es compatible
                                if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                                    return true;
                                }else{//p2 no es vacio
                                    if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                        return true;
                                    }else{//no es compatible
                                        return false;}
                                }
                            }else{//no es compatible
                                return false;}
                        }
                    }else{
                        return false;}        
                }
                //##############################################################################################
                else if(fila==0 && columna==tabla1.length-1){
                    if(tabla1[fila][columna]==null){
                        if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                            if(tabla1[fila+1][columna]==null){//p4 es vacio
                                return true;
                            }else{//p4 no es vacio
                                if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                    return true;
                                }else{
                                    return false;}
                            }
                        }else{//p2 no es vacio
                            if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                        if(tabla1[fila+1][columna]==null){//p4 es vacio
                                            return true;
                                        }else{//p4 no es vacio
                                            if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                                return true;
                                            }else{
                                                return false;}
                                        }
                            }else{//no es compatible
                                return false;}
                        }
                    }else{
                        return false;
                    }
                }
                //##############################################################################################
                else if(fila==tabla1.length-1 && columna==0){
                    if(tabla1[fila][columna]==null){
                        if(tabla1[fila-1][columna]==null){//pieza ubicada arriba = p1
                            if(tabla1[fila][columna+1]==null){//p3 es vacio
                                return true;
                            }else{// p3 no es vacio
                                if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                    return true;
                                }else{
                                    return false;}
                            }
                        }else{//p1 no es vacio
                            if(tabla1[fila-1][columna].getAbajo()==tablero.getTabla(fil, col).getArriba()){//verifica si es compatible
                                if(tabla1[fila][columna+1]==null){//p3 es vacio
                                    return true;
                                }else{// p3 no es vacio
                                    if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                        return true;
                                    }else{
                                        return false;}
                                }
                            }else{
                                return false;}
                        }
                    }else{
                        return false;}
                }
                //#########################################################################################################################
                //varifica las casillas que estan en el limite de la matriz
                else if(fila==0 && columna>0 && columna<tabla1.length-1){//casilleros de fila 0 
                    if(tabla1[fila][columna]==null){
                        if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                            if(tabla1[fila][columna+1]==null){//pieza ubicada en el lado derecho  = p3
                                if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                    return true;
                                }else{//p4 no es vacio
                                    if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                        return true;
                                    }else{
                                        return false;}
                                }
                            }else{//p3 no es vacio
                                if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                    if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }else{//p4 es vacio
                                        return true;}
                                }else{// no es compatible
                                    return false;}
                            }
                        }else{//p2 no es vacio
                            if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                if(tabla1[fila][columna+1]!=null){//p3 no es vacio
                                    if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                        if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                            if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                                return true;
                                            }else{
                                                return false;}
                                        }else{//p4 es vacio
                                            return true;}
                                    }else{// no es compatible
                                        return false;}
                                }else{//p3 es vacio
                                    if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{//no es compatible
                                            return false;}
                                    }else{//p4 es vacio
                                        return true;}
                                }
                            }else{//no es compatible
                                return false;}
                        }
                    }else{
                        return false;
                    }
                }
                //##############################################################################################
                else if(fila>0 && fila< tabla1.length-1 && columna==0){
                    if(tabla1[fila][columna]==null){
                        if(tabla1[fila-1][columna]==null){//pieza ubicada arriba = p1
                            if(tabla1[fila][columna+1]==null){//p3 es vacio
                                if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                    return true;
                                }else{//p4 no es vacio
                                    if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                        return true;
                                    }else{
                                        return false;}
                                }
                            }else{//p3 no es vacio
                                if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                    if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }else{//p4 es vacio
                                        return true;}
                                }else{// no es compatible
                                    return false;}
                            }
                        }else{//p1 no es vacio
                            if(tabla1[fila-1][columna].getAbajo()==tablero.getTabla(fil, col).getArriba()){//verifica si es compatible
                                if(tabla1[fila][columna+1]==null){//p3 es vacio
                                    if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                        return true;
                                    }else{//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }
                                }else{//p3 no es vacio
                                    if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                        if(tabla1[fila+1][columna]!=null){//p4 no es vacio
                                            if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                                return true;
                                            }else{
                                                return false;}
                                        }else{//p4 es vacio
                                            return true;}
                                    }else{// no es compatible
                                        return false;}
                                }
                            }else{
                                return false;}
                        }
                    }else{
                        return false;
                    }
                }
                //##############################################################################################
                else if(fila==tabla1.length-1 && columna>0 && columna<tabla1.length-1){ 
                    if(tabla1[fila][columna]==null){
                        if(tabla1[fila-1][columna]==null){//pieza ubicada arriba = p1
                            if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                                if(tabla1[fila][columna+1]==null){//p3 es vacio
                                    return true;
                                }else{// p3 no es vacio
                                    if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                        return true;
                                    }else{
                                        return false;}
                                }
                            }else{//p2 no es vacio
                                if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                    if(tabla1[fila][columna+1]==null){//p3 es vacio
                                        return true;
                                    }else{// p3 no es vacio
                                        if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }
                                }else{
                                    return false;
                                }
                            }
                        }else{//p1 no es vacio
                            if(tabla1[fila-1][columna].getAbajo()==tablero.getTabla(fil, col).getArriba()){//verifica si es compatible
                                if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                                    if(tabla1[fila][columna+1]==null){//p3 es vacio
                                        return true;
                                    }else{// p3 no es vacio
                                        if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }
                                }else{//p2 no es vacio
                                    if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                        if(tabla1[fila][columna+1]==null){//p3 es vacio
                                            return true;
                                        }else{// p3 no es vacio
                                            if(tabla1[fila][columna+1].getIzquierda()==tablero.getTabla(fil, col).getDerecha()){//verifica si es compatible
                                                return true;
                                            }else{
                                                return false;}
                                        }
                                    }else{
                                        return false;
                                    }
                                }
                            }else{
                                return false;
                            }
                        }
                    }else{
                        return false;
                    }
                }
                //##############################################################################################
                else if( fila>0 && fila<tabla1.length-1 && columna==this.getColumna()){
                    if(tabla1[fila-1][columna]==null){//pieza ubicada arriba = p1
                        if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                            if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                return true;
                            }else{//p4 no es vacio
                                if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                    return true;
                                }else{
                                    return false;}
                            }
                        }else{//p2 no es vacio
                            if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                    return true;
                                }else{//p4 no es vacio
                                    if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                        return true;
                                    }else{
                                        return false;}
                                }
                            }else{// no es compatible
                                return false;
                            }
                        }
                    }else{//p1 no es vacio
                        if(tabla1[fila-1][columna].getAbajo()==tablero.getTabla(fil, col).getArriba()){//verifica si es compatible
                            if(tabla1[fila][columna-1]==null){//pieza ubicada en el lado izquierdo = p2
                                if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                    return true;
                                }else{//p4 no es vacio
                                    if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                        return true;
                                    }else{
                                        return false;}
                                }
                            }else{//p2 no es vacio
                                if(tabla1[fila][columna-1].getDerecha()==tablero.getTabla(fil, col).getIzquierda()){//verifica si es compatible
                                    if(tabla1[fila+1][columna]==null){//pieza ubicada abajo = p4
                                        return true;
                                    }else{//p4 no es vacio
                                        if(tabla1[fila+1][columna].getArriba()==tablero.getTabla(fil, col).getAbajo()){//verifica si es compatible
                                            return true;
                                        }else{
                                            return false;}
                                    }
                                }else{// no es compatible
                                    return false;}
                            }
                        }else{
                            return false;
                        }
                    }
                }
            }else{// no es vacio
                return false;
            }
        }return false;
    }
    
    public void agregarPieza(int fila, int columna, Tabla tablero, int fil, int col){
        tabla1[fila][columna]=tablero.getTabla(fil, col);
        tablero.cambiarVacio(fil, col);
    }
    
    public int espaciosVacios(){
        int cont=0;
        for(int i=0; i<this.tabla1.length; i++){
            for(int j=0; j <this.tabla1.length; j++){
                if(this.tabla1[i][j]==null)
                   cont++;
            }
        }
        return cont;
    }
    
    
}
