/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelocomplejoconinf;

import static modelocomplejoconinf.ModeloComplejoConInf.T;
import static modelocomplejoconinf.ModeloComplejoConInf.t;

/**
 *
 * @author Maria Reina
 */
public class ambulancia {
    private int num;
    private double entraSal[];
    private double registro[];
    private int zona; //La Zona va a poder ser A, B o N en la última cuando es ninguna.
    private int contador;
    private int contadorZona[];
    
    
    public ambulancia(int unNum, int unaZona){
        this.num=unNum;
        this.zona=unaZona;
        entraSal=new double[2];
        registro=new double[T];
        contador=1;
        contadorZona=new int []{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    }
        
    public int getContadorZona(int i){
        return contadorZona[i-1];
    }
     
    public void aumentarContadorZona(int i){
        contadorZona[i-1]++;
    }

    
    public int getContador(){
        return contador;
    }
    
    public void aumentarContador(){
        contador++;
    }
    public void disminuirContador(){
        contador--;
    }    
    
    public int getZona(){
        return zona;
    }
    
    public void setZona(int nuevaZona){
        zona=nuevaZona;
    }
    
    public int getNum(){
        return num;
    }
    
    public double getEntraSal(int i){
        return entraSal[i];
    }
    
    
    public double getRegistro(int i){
        return registro[i-1];
    }   
    
    public void setNum (int otroNum){
        num=otroNum;
    }
    
    public void setEntraSal(int i, double otroEntraSal){
        entraSal[i]=otroEntraSal;
    }
    
 
    
    public void setRegistro(int veces, double otroRegistro){
        registro[veces-1]=otroRegistro;
    }
    
      
 
    
    
}
