/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelocomplejoconinf;

import static modelocomplejoconinf.ModeloComplejoConInf.a;
import static modelocomplejoconinf.ModeloComplejoConInf.t;

public class sistema {
    private String nombre;
    private int ambulanciasNoActivas[];
    private int contadorXpx;

    public sistema(String unNombre){
        this.nombre=unNombre;
        ambulanciasNoActivas=new int [a+1];
        contadorXpx=0;
    }
    
    public int getContadorXpx(){
        return contadorXpx;
    }
    
    public void aumentarContadorXpx(){
        contadorXpx++;
    }    
    public String getNombre(){
        return nombre;
    }
    
    public int getAmbulanciaNoActiva(int i){
        return ambulanciasNoActivas[i];
    }
    
    public void setAmbulanciaNoActiva(int i, int unaAmbulancia){
        ambulanciasNoActivas[i]=unaAmbulancia;
    }    
    
        public int lugarUltimaAmbulanciaEnZona(){
        int i=0;
;
        while(ambulanciasNoActivas[i] != 0){
            i++;
        }
        return i;            
    }
    
   public void recorrerIzq(){
       int i;
       for (i=0; i<(a-1);i++)
           ambulanciasNoActivas[i]=ambulanciasNoActivas[i+1];
       ambulanciasNoActivas[i]=0;
   }

     
    public int cambioDeZonaComplejo(int zonaDeSalida, zona zona[], ambulancia laAmbulancia){
       int min=zonaDeSalida;
       int otra;
       int i=0;
       double tiempoEsperaMin;
       double tiempoEsperaOtra=0;
        while (zona[zonaDeSalida-1].getRutas(i)!=0){
           tiempoEsperaMin=(zona[min-1].getCosto())*(zona[min-1].lugarUltimaAmbulanciaEnZona()-1)*(zona[min-1].getRatePx());
           otra=zona[zonaDeSalida-1].getRutas(i);
           tiempoEsperaOtra=(zona[otra-1].getCosto())*(zona[otra-1].lugarUltimaAmbulanciaEnZona())*(zona[otra-1].getRatePx());
           if(tiempoEsperaOtra<tiempoEsperaMin){
               min=otra;
           }
           i++;
       }
        
        if(min!=zonaDeSalida){
             zona[zonaDeSalida-1].setAmbulanciaEnZona(zona[zonaDeSalida-1].lugarUltimaAmbulanciaEnZona()-1,0);
             zona[min-1].setAmbulanciaEnZona(zona[min-1].lugarUltimaAmbulanciaEnZona(),laAmbulancia.getNum());
        }
        return min;
   }  
    
    
      public int eventoConLlegada(double auxiliares[]){
          int resultado=0;
          double min=auxiliares[resultado];
          for(int i=1; i<17;i++){
              if(auxiliares[i]<min){
                  min=auxiliares[i];
                  resultado=i;
              }
          }
          return resultado;
   }   

    public int eventoSinLlegada(double auxiliares[]){
          int resultado=1;
          double min=auxiliares[resultado];
          for(int i=2; i<17;i++){
              if(auxiliares[i]<min){
                  min=auxiliares[i];
                  resultado=i;
              }
          }
        return resultado;  
        }
    
    public void steadyEquilibrium(zona zona[]){
        int aux=1;
        int min;
        double tiempoEsperaMin;
        double tiempoEsperaOtra;
        while (aux!=0){
            aux=0;
            for(int i=0; i<16; i++){
                min=i;
                if(zona[i].getContador()<2){
                    
                }else{
                    for(int e=0; e<16; e++){ 
                        tiempoEsperaMin=(zona[i].getCosto())*(zona[i].lugarUltimaAmbulanciaEnZona()-1)*(zona[i].getRatePx());
                        tiempoEsperaOtra=(zona[e].getCosto())*(zona[e].lugarUltimaAmbulanciaEnZona())*(zona[e].getRatePx());                        
                        if(tiempoEsperaOtra<tiempoEsperaMin){
                            min=e;
                        }
                    }
                    if(min!=i){
                        zona[min].setAmbulanciaEnZona(zona[min].lugarUltimaAmbulanciaEnZona(),zona[i].getAmbulanciaEnZona(zona[i].lugarUltimaAmbulanciaEnZona()-1));                        
                        zona[i].setAmbulanciaEnZona(zona[i].lugarUltimaAmbulanciaEnZona()-1,0);
                        zona[i].disminuirContador();
                        zona[min].aumentarContador(); 
                        aux++;
                    }
                    
                }
            }
        }
    }
    
    
    public void cambioEnCorto(zona zona[]){
                for(int i=0; i<16; i++){
                    if(zona[i].getContador()>1){
                        int e=0;
                        boolean salida=true;
                        while (salida && zona[i].getRutas(e)!=0){
                            if(zona[zona[i].getRutas(e)-1].getContador()==0){
                                zona[zona[i].getRutas(e)-1].setAmbulanciaEnZona(0, zona[i].getAmbulanciaEnZona(zona[i].lugarUltimaAmbulanciaEnZona()-1));
                                zona[zona[i].getRutas(e)-1].aumentarContador();
                                zona[i].setAmbulanciaEnZona(zona[i].lugarUltimaAmbulanciaEnZona()-1,0);
                                zona[i].disminuirContador();
                                salida=false;
                            }
                            e++;
                        }
                    }
                }         
    }
    
    public void steadyEquilibrium1(zona zona[]){
        int aux=1;
        int min;
        int n=0;
        int e;
        double tiempoEsperaMin;
        double tiempoEsperaOtra;
        while (aux!=0){
            aux=0;
            for(int i=0; i<16; i++){
                min=i;
                if(zona[i].getContador()<2){
                    
                }else{
                    n=0;
                    while(zona[i].getRutas(n)!=0){
                        e=zona[i].getRutas(n);
                        tiempoEsperaMin=(zona[i].getCosto())*(zona[i].lugarUltimaAmbulanciaEnZona()-1)*(zona[i].getRatePx());
                        tiempoEsperaOtra=(zona[e-1].getCosto())*(zona[e-1].lugarUltimaAmbulanciaEnZona())*(zona[e-1].getRatePx());                        
                        if(tiempoEsperaOtra<tiempoEsperaMin){
                            min=e-1;
                        }
                        n++;
                    }
                    if(min!=i){
                        zona[min].setAmbulanciaEnZona(zona[min].lugarUltimaAmbulanciaEnZona(),zona[i].getAmbulanciaEnZona(zona[i].lugarUltimaAmbulanciaEnZona()-1));                        
                        zona[i].setAmbulanciaEnZona(zona[i].lugarUltimaAmbulanciaEnZona()-1,0);
                        zona[i].disminuirContador();
                        zona[min].aumentarContador(); 
                        aux++;
                    }
                    
                }
            }
        }
    }    

}
