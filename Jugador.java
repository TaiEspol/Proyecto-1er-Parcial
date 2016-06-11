/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Scanner;

/**
 *Borrador 1
 * @author Tai Yu Chen
 */
public final class Jugador {
    private Scanner entrada = new Scanner(System.in);
    int x;
    
    public void empezarJuego(){
        while(true){
            System.out.println("*****************************************************" + 
                "\n\t Bienvenido al juego de Tetravex" + "\n*****************************************************" );
            System.out.println("Elija la dimension que desea jugar" + "\n1. 2x2\n2. 3x3\n3. 4x4\n4. 5x5\n5. 6x6");
            x=entrada.nextInt();
            if(x==1){
                System.out.println("Selecciono el numero 1");
                break;
            }else if(x==2){
                System.out.println("Selecciono el numero 2");
                break;
            }else if(x==3){
                System.out.println("Selecciono el numero 3");
                break;
            }else if(x==4){
                System.out.println("Selecciono el numero 4");
                break;
            }else if(x==5){
                System.out.println("Selecciono el numero 5");
                break;
            }else{
                System.out.println("*****Error!! Elija nuevamente*****");
            }
        }
        
    }
    public void tabla(int fila, int columna){
        Tabla2 t2=new Tabla2(fila,columna);
        Tabla1 t1=new Tabla1(fila,columna);
        
        //######################## Imprimir Tabla ###########
        System.out.println("1. Mover pieza de una tabla a otra \n2.Mover pieza dentro de la tabla1");
        int y=entrada.nextInt();
        if(y==1){
            System.out.println("1.Mover de tabla 2 a tabla 1: \n2.Mover de tabla 1 a tabla 2 ");
            int z=entrada.nextInt();
            if(z==1){
                System.out.println("Elegir pieza de la tabla 2: " );
                System.out.println("Fila: " );
                int fil=entrada.nextInt();
                System.out.println("Columna: " );
                int colu=entrada.nextInt();
                //########################################################
                System.out.println("Elegir posicion para colocar pieza en tabla 1 : " );
                System.out.println("Fila: " );
                int fil1=entrada.nextInt();
                System.out.println("Columna: " );
                int colu1=entrada.nextInt();
                //######################################################
                if(t1.verificarPieza(fil1-1, colu1-1, t2, fil-1, colu-1) == true){
                    t1.agregarPieza(fil1-1, colu1-1, t2, fil-1, colu-1);
                }else{
                    System.out.println(" No se puede realizar la accion ");
                }
            }else if(z==2){
                System.out.println("Elegir pieza de la tabla 1: " );
                System.out.println("Fila: " );
                int fil=entrada.nextInt();
                System.out.println("Columna: " );
                int colu=entrada.nextInt();
                //########################################################
                System.out.println("Elegir posicion para colocar pieza en tabla 2 : " );
                System.out.println("Fila: " );
                int fil1=entrada.nextInt();
                System.out.println("Columna: " );
                int colu1=entrada.nextInt();
                //######################################################
                if(t2.verificarPieza(fil1-1,colu1-1,t1,fil-1,colu-1)==true){
                    t2.volverCasa(fil1-1, colu1-1, t1, fil-1,colu-1);
                }else{
                    System.out.println(" No se puede realizar la accion ");
                }
            }else{
                System.out.println(" Error!! elija de nuevo ");
            }
        }else if(y==2){
            System.out.println("Mover de: " );
                System.out.println("Fila: " );
                int fil=entrada.nextInt();
                System.out.println("Columna: " );
                int colu=entrada.nextInt();
                //########################################################
                System.out.println("Hasta : " );
                System.out.println("Fila: " );
                int fil1=entrada.nextInt();
                System.out.println("Columna: " );
                int colu1=entrada.nextInt();
                //######################################################
                if(t1.verificarPieza(fil1-1, colu1-1, t1, fil-1, colu-1)==true){
                    t1.agregarPieza(fil1-1, colu1-1, t1, fil-1, colu-1);
                }else{
                    System.out.println(" No se puede realizar la accion");
                }
        }else{
            System.out.println(" Error!! elija de nuevo ");
        }
    }
    
}
