/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelocomplejoconinf;

import static modelocomplejoconinf.ModeloComplejoConInf.a;

/**
 *
 * @author Maria Reina
 */
public class zona {
    private int unaZona;
    private double ratePx;
    private int ambulanciasEnZona[];
    private int costo;
    private int contador;
    private int rutas[];
    
    public zona (int unaZona, double unRatePx, int unCosto) {
        this.unaZona=unaZona;
        this.ratePx=unRatePx;
        this.costo=unCosto;
        ambulanciasEnZona= new int [a+1];
        contador=0;
        rutas=new int[7];
    }    
    
    public int getContador(){
        return contador;
    }
    
    public int setContador(int num){
        return contador=num;
    }    
    
    public void aumentarContador(){
        contador=contador+1;
    }
    public void disminuirContador(){
        contador=contador-1;
    }     
    
    public int getZona(){
        return unaZona;
    }
    
    public int getCosto(){
        return costo;
    }    

    public int getAmbulanciaEnZona(int i){
        return ambulanciasEnZona[i];
    }    
    
    public double getRatePx(){
        return ratePx;
    }
    
    public void setCosto(int unCosto){
        costo=unCosto;
    }
    
    public void setZona(int otraZona){
        unaZona=otraZona;
    }
    
    public void setAmbulanciaEnZona(int i, int otraAmbulanciaEnEsaZona){
        ambulanciasEnZona[i]=otraAmbulanciaEnEsaZona;
    }     
    
    public void setRatePx(double otroRatePx){
        ratePx=otroRatePx;
    }    
    
    public int getRutas(int i){
        return rutas[i];
    }
    
    public void setRutas( int rutaNueva[]){
      rutas=rutaNueva;
    }
        
    public int lugarUltimaAmbulanciaEnZona(){
        int i=0;

        while(ambulanciasEnZona[i] != 0){
            i++;
        }
        return i;            
    }
    
    public int lugarUltimaOpcionRutas(){
        int i=0;

        while(rutas[i] != 0){
            i++;
        }
        return i;            
    }
    
   public void recorrerIzq(){
       int i;
       for (i=0; i<(a-1);i++)
           ambulanciasEnZona[i]=ambulanciasEnZona[i+1];
       ambulanciasEnZona[i]=0;
   }    
}
