/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelocomplejoconinf;
import static javafx.beans.binding.Bindings.or;
import psimjava.*;

public class ModeloComplejoConInf {
public static int T=1440; //Eventos MAX. es sólo una forma de generar espacio.  
public static int t=1; //Numero de eventos   
public static int a=27; //Numero de ambulancias
public static double data[];

    public static void programaComplejoConGuia() {
   // Creación de Ambulancias
        ambulancia ambulancias[];
    
        ambulancias=new ambulancia[a]; //Ambulancia en Indice 0 es la uno.
        for(int i=0; i<a/2; i++)
            ambulancias[i]= new ambulancia(i+1, 15);
        
    
        for(int i=a/2; i<a; i++)
            ambulancias[i]= new ambulancia(i+1, 12);
    //_____________________________________________________________________________________

    // Creación de Zonas}
       zona zona[]=new zona[16];
       zona[0]=new zona(1,60,10);
       zona[0].setRutas(new int[]{ 2, 3, 6,0});
       zona[1]=new zona(2,60,10);
       zona[1].setRutas(new int[]{ 1, 3, 4, 5, 6,0});       
       zona[2]=new zona(3,60,10);
       zona[2].setRutas(new int[]{ 1, 2, 4,0});         
       zona[3]=new zona(4,60,10);  
       zona[3].setRutas(new int[]{ 2, 3, 5, 9, 10,0});           
       zona[4]=new zona(5,60,10);
       zona[4].setRutas(new int[]{ 2, 4, 6, 7, 8, 9,0});        
       zona[5]=new zona(6,60,10);
       zona[5].setRutas(new int[]{ 1, 2, 5, 7, 8,0});        
       zona[6]=new zona(7,60,10);
       zona[6].setRutas(new int[]{ 6, 8, 16,0});         
       zona[7]=new zona(8,60,10);
       zona[7].setRutas(new int[]{ 5, 6,7, 9, 15, 16,0});       
       zona[8]=new zona(9,60,10);
       zona[8].setRutas(new int[]{ 4, 5, 8, 10,11, 12, 15,0});          
       zona[9]=new zona(10,60,10);
       zona[9].setRutas(new int[]{ 4, 9, 11, 12,0});           
       zona[10]=new zona(11,60,10);
       zona[10].setRutas(new int[]{ 10, 12, 13,0});        
       zona[11]=new zona(12,60,10);
       zona[11].setRutas(new int[]{ 9, 10, 11, 13, 14, 15,0});          
       zona[12]=new zona(13,60,10);
       zona[12].setRutas(new int[]{ 11, 12, 14,0});        
       zona[13]=new zona(14,60,10);
       zona[13].setRutas(new int[]{12, 13, 15,0});        
       zona[14]=new zona(15,60,10);
       zona[14].setRutas(new int[]{8, 9, 12, 14, 16,0});         
       zona[15]=new zona(16,60,10);   
       zona[15].setRutas(new int[]{7, 8, 15,0});          
    //_____________________________________________________________________________________
       //Creción sistema
       sistema primer_sistema;
       primer_sistema=new sistema("Primer Modelo Complejo toda la CDMX");
          
    //_____________________________________________________________________________________
      //Se Inicializan las listas
      for(int i=1; i<a+1;i++){
          int e=(i)%16;
          zona[e].setAmbulanciaEnZona(zona[e].lugarUltimaAmbulanciaEnZona(), i);
          zona[e].aumentarContador();
      }
      
      
      
      
      
       /* zona[11].setAmbulanciaEnZona(0, 1);
        zona[11].setAmbulanciaEnZona(1, 2);        
        zona[11].setAmbulanciaEnZona(2, 3);        
        zona[11].setContador(3);
        zona[10].setAmbulanciaEnZona(0, 4);
        zona[10].setAmbulanciaEnZona(1, 5);        
        zona[10].setAmbulanciaEnZona(2, 6);        
        zona[10].setContador(3);
        zona[14].setAmbulanciaEnZona(0, 7);
        zona[14].setAmbulanciaEnZona(1, 8);        
        zona[14].setAmbulanciaEnZona(2, 9);        
        zona[14].setContador(3);
        zona[3].setAmbulanciaEnZona(0, 10);
        zona[3].setAmbulanciaEnZona(1, 11);        
        zona[3].setAmbulanciaEnZona(2, 12);        
        zona[3].setContador(3);    
        zona[7].setAmbulanciaEnZona(0, 13);
        zona[7].setAmbulanciaEnZona(1, 14);        
        zona[7].setAmbulanciaEnZona(2, 15);        
        zona[7].setContador(3);   
        zona[4].setAmbulanciaEnZona(0, 16);        
        zona[4].setAmbulanciaEnZona(1, 17);        
        zona[4].setContador(2);  
        zona[8].setAmbulanciaEnZona(0, 18);        
        zona[8].setAmbulanciaEnZona(1, 19);        
        zona[8].setContador(2);    
        zona[9].setAmbulanciaEnZona(0, 20);        
        zona[9].setAmbulanciaEnZona(1, 21);        
        zona[9].setContador(2); 
        zona[13].setAmbulanciaEnZona(0, 22);        
        zona[13].setContador(1);
        zona[12].setAmbulanciaEnZona(0, 23);        
        zona[12].setContador(1);
        zona[15].setAmbulanciaEnZona(0, 24);        
        zona[15].setContador(1);   
        zona[0].setAmbulanciaEnZona(0, 25);        
        zona[0].setAmbulanciaEnZona(1, 26);        
        zona[0].setContador(2);        
        zona[1].setAmbulanciaEnZona(0, 27);        
        zona[1].setAmbulanciaEnZona(1, 28);        
        zona[1].setContador(2);
        zona[2].setAmbulanciaEnZona(0, 29);        
        zona[2].setAmbulanciaEnZona(1, 30);        
        zona[2].setContador(2);
        zona[5].setAmbulanciaEnZona(0, 31);        
        zona[5].setAmbulanciaEnZona(1, 32);        
        zona[5].setContador(2); */  
   //________________________________________________________________________________________


    //______________________________________________________________________________________
       //_______________________________________________________________________________________
    //Arreglo que guarda promedio registros
     data=new double[a+1];

    //_______________________________________________________________________________________
    // Declaracion de variables estocasticas.
    Erand variablesRandom[]=new Erand[17];
    variablesRandom[0]=new Erand (20);
    variablesRandom[1]=new Erand (90);
    variablesRandom[2]=new Erand (90);
    variablesRandom[3]=new Erand (90);
    variablesRandom[4]=new Erand (90);
    variablesRandom[5]=new Erand (90);
    variablesRandom[6]=new Erand (90);      
    variablesRandom[7]=new Erand (90);
    variablesRandom[8]=new Erand (90);
    variablesRandom[9]=new Erand (90);
    variablesRandom[10]=new Erand (90);
    variablesRandom[11]=new Erand (90);
    variablesRandom[12]=new Erand (90);      
    variablesRandom[13]=new Erand (90);
    variablesRandom[14]=new Erand (90);
    variablesRandom[15]=new Erand (90);      
    variablesRandom[16]=new Erand (90);
    double auxiliares[]=new double[17];
    for (int i=0; i<17; i++){
        auxiliares[i]=variablesRandom[i].fdraw();
    }
    double prob[]= new double [17];
    int min=0;
    double clock=0;
    double stop=T;
    int random = (int )(Math.random() * 16 + 1);
    int resultado;

    primer_sistema.steadyEquilibrium(zona);
    while(clock<stop){
        t++;
        if(primer_sistema.getAmbulanciaNoActiva(0)!=0){
            min=primer_sistema.eventoConLlegada(auxiliares);
            if(min==0){
                clock=auxiliares[0];
                random = (int )(Math.random() * 16 + 1);
                System.out.println(clock);
                ambulancias[primer_sistema.getAmbulanciaNoActiva(0)-1].aumentarContador();//Aumento la variable que cuenta las veces que esta ambulancia ha estado en el sistema.
                ambulancias[primer_sistema.getAmbulanciaNoActiva(0)-1].aumentarContadorZona(random);
                zona[random-1].aumentarContador();
                System.out.println("Ambulance arrive to zone.."+random+"..."+zona[random-1].getContador());  
                zona[random-1].setAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona(), primer_sistema.getAmbulanciaNoActiva(0)); //Asigno la ambulancia a la cola A.
                ambulancias[zona[random-1].getAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona()-1)-1].setEntraSal(0, clock); //Tomo registro de entrada.   
                primer_sistema.recorrerIzq(); //Borro ambulancia que se trasladó de la cola de no activas.
                //Una vez que llega tengo que hacer que decida si cambiarse o no.  
                resultado=primer_sistema.cambioDeZonaComplejo(random, zona,  ambulancias[zona[random-1].getAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona()-1)-1]);
                if(resultado!=random){
                            zona[random-1].disminuirContador();
                            zona[resultado-1].aumentarContador();                        
                            System.out.println("The ambulance change to..."+resultado+" "+zona[resultado-1].getContador()); 
                            ambulancias[(zona[resultado-1].getAmbulanciaEnZona(zona[resultado-1].lugarUltimaAmbulanciaEnZona()-1))-1].aumentarContadorZona(resultado);                       
                }else{
                            System.out.println("The ambulance didn't change");                    
                }
                
                
                //Ahora ajusto el reloj
                for(int i=0; i<16; i++)
                    System.out.print(" Zone"+(i+1)+" "+zona[i].getContador()+" ");
                System.out.print(primer_sistema.getContadorXpx());
                prob[0]=variablesRandom[0].fdraw();
                auxiliares[0]=clock+prob[0];  
                System.out.println(" ");
            }else{// Else de si el evento fue en cero en otra cosa
                clock=auxiliares[min];
                System.out.println(clock);                
                if(zona[min-1].getAmbulanciaEnZona(0)==0){
                    System.out.println("An emergency happens in zone"+min);                    
                    primer_sistema.aumentarContadorXpx();
                }else{//Este es el Else de la condición para ver si muere un px o no
                    zona[min-1].disminuirContador();                    
                    System.out.println(clock);
                    System.out.println("An emergency happens in zone"+min);
                    ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setEntraSal(1, clock);//Guardo la hora de salida.
                    ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setRegistro(ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getContador(), ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(1)-ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(0));//Registro el tiempo de espera en este turno.
                    primer_sistema.setAmbulanciaNoActiva(primer_sistema.lugarUltimaAmbulanciaEnZona(), zona[min-1].getAmbulanciaEnZona(0));//Pasas la ambulancia a la cola de No activas.
                    zona[min-1].recorrerIzq(); 
                }//Cierre de los eventos de salida en la condición de que no haya ninguno
                for(int i=0; i<16; i++)
                    System.out.print(" Zone"+(i+1)+" "+zona[i].getContador()+" ");
                System.out.print(primer_sistema.getContadorXpx());
                System.out.println(" ");                
                //Cambio de Zona a una con cero ambulancias
                System.out.println("Changes");                  
                primer_sistema.cambioEnCorto(zona); 
                primer_sistema.steadyEquilibrium1(zona);
                for(int i=0; i<16; i++)
                    System.out.print(" Zone"+(i+1)+" "+zona[i].getContador()+" ");
                System.out.print(primer_sistema.getContadorXpx());
                System.out.println(" ");                
                //Se ajusta el reloj
                prob[min]=variablesRandom[min].fdraw();    
                auxiliares[min]=clock+prob[min];

            }// Cierre de si el evento fue en cero o otro número
        }else{//Else de la condición si no hay ambulancias No activas
            min=primer_sistema.eventoSinLlegada(auxiliares);
            clock=auxiliares[min];
            System.out.println(clock);            
            if(zona[min-1].getAmbulanciaEnZona(0)==0){
                System.out.println("An emergency happens in zone..."+min);                
                primer_sistema.aumentarContadorXpx();
            }else{//Este es el Else de la condición para ver si muere un px o no
                zona[min-1].disminuirContador();                    
                System.out.println("An emergency happens in zone..."+min);
                ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setEntraSal(1, clock);//Guardo la hora de salida.
                 ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setRegistro(ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getContador(), ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(1)-ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(0));//Registro el tiempo de espera en este turno.
                primer_sistema.setAmbulanciaNoActiva(primer_sistema.lugarUltimaAmbulanciaEnZona(), zona[min-1].getAmbulanciaEnZona(0));//Pasas la ambulancia a la cola de No activas.
                zona[min-1].recorrerIzq(); 
             }//Cierre de los eventos de salida en la condición de que no haya ninguno
               for(int i=0; i<16; i++)
                    System.out.print(" Zone"+(i+1)+" "+zona[i].getContador()+" ");
                System.out.print(primer_sistema.getContadorXpx());
                System.out.println(" ");                
                //Cambio de Zona a una con cero ambulancias
                System.out.println("Changes");            
            primer_sistema.cambioEnCorto(zona);
            primer_sistema.steadyEquilibrium1(zona);            
            //Se ajusta el reloj
            prob[min]=variablesRandom[min].fdraw();    
            auxiliares[min]=clock+prob[min];
            for(int i=0; i<16; i++)
                System.out.print(" Zone"+(i+1)+" "+zona[i].getContador()+" ");
            System.out.print(primer_sistema.getContadorXpx());
            System.out.println(" ");        
        }//Cierre de la condición si no hay ambulancias No activas
    }//Cierra el while
    
    // obtener datos 
    double suma;
    double promedio;
      for(int i=0; i<a; i++){
        suma=0;
        promedio=0;
        for(int t=1; t<=ambulancias[i].getContador(); t++){
          suma=suma+ambulancias[i].getRegistro(t);
        }   
        promedio=suma/(ambulancias[i].getContador());
        data[i]=promedio;
      }
      data[a]=primer_sistema.getContadorXpx();
     

      System.out.print(data[a]);
        
    }//Cierre del Main
    
    public static double[] programaComplejoFinal(){

   // Creación de Ambulancias
        ambulancia ambulancias[];
    
        ambulancias=new ambulancia[a]; //Ambulancia en Indice 0 es la uno.
        for(int i=0; i<a/2; i++)
            ambulancias[i]= new ambulancia(i+1, 15);
        
    
        for(int i=a/2; i<a; i++)
            ambulancias[i]= new ambulancia(i+1, 12);
    //_____________________________________________________________________________________

    // Creación de Zonas}
       zona zona[]=new zona[16];
       zona[0]=new zona(1,60,10);
       zona[0].setRutas(new int[]{ 2, 3, 6,0});
       zona[1]=new zona(2,60,10);
       zona[1].setRutas(new int[]{ 1, 3, 4, 5, 6,0});       
       zona[2]=new zona(3,60,10);
       zona[2].setRutas(new int[]{ 1, 2, 4,0});         
       zona[3]=new zona(4,60,10);  
       zona[3].setRutas(new int[]{ 2, 3, 5, 9, 10,0});           
       zona[4]=new zona(5,60,10);
       zona[4].setRutas(new int[]{ 2, 4, 6, 7, 8, 9,0});        
       zona[5]=new zona(6,60,10);
       zona[5].setRutas(new int[]{ 1, 2, 5, 7, 8,0});        
       zona[6]=new zona(7,60,10);
       zona[6].setRutas(new int[]{ 6, 8, 16,0});         
       zona[7]=new zona(8,60,10);
       zona[7].setRutas(new int[]{ 5, 6,7, 9, 15, 16,0});       
       zona[8]=new zona(9,60,10);
       zona[8].setRutas(new int[]{ 4, 5, 8, 10,11, 12, 15,0});          
       zona[9]=new zona(10,60,10);
       zona[9].setRutas(new int[]{ 4, 9, 11, 12,0});           
       zona[10]=new zona(11,60,10);
       zona[10].setRutas(new int[]{ 10, 12, 13,0});        
       zona[11]=new zona(12,60,10);
       zona[11].setRutas(new int[]{ 9, 10, 11, 13, 14, 15,0});          
       zona[12]=new zona(13,60,10);
       zona[12].setRutas(new int[]{ 11, 12, 14,0});        
       zona[13]=new zona(14,60,10);
       zona[13].setRutas(new int[]{12, 13, 15,0});        
       zona[14]=new zona(15,60,10);
       zona[14].setRutas(new int[]{8, 9, 12, 14, 16,0});         
       zona[15]=new zona(16,60,10);   
       zona[15].setRutas(new int[]{7, 8, 15,0});          
    //_____________________________________________________________________________________
       //Creción sistema
       sistema primer_sistema;
       primer_sistema=new sistema("Primer Modelo Complejo toda la CDMX");
          
    //_____________________________________________________________________________________
      //Se Inicializan las listas 
       for(int i=1; i<a+1;i++){
          int e=(i)%16;
          zona[e].setAmbulanciaEnZona(zona[e].lugarUltimaAmbulanciaEnZona(), i);
          zona[e].aumentarContador();
      }      
      
      /* zona[11].setAmbulanciaEnZona(0, 1);
        zona[11].setAmbulanciaEnZona(1, 2);        
        zona[11].setAmbulanciaEnZona(2, 3);        
        zona[11].setContador(3);
        zona[10].setAmbulanciaEnZona(0, 4);
        zona[10].setAmbulanciaEnZona(1, 5);        
        zona[10].setAmbulanciaEnZona(2, 6);        
        zona[10].setContador(3);
        zona[14].setAmbulanciaEnZona(0, 7);
        zona[14].setAmbulanciaEnZona(1, 8);        
        zona[14].setAmbulanciaEnZona(2, 9);        
        zona[14].setContador(3);
        zona[3].setAmbulanciaEnZona(0, 10);
        zona[3].setAmbulanciaEnZona(1, 11);        
        zona[3].setAmbulanciaEnZona(2, 12);        
        zona[3].setContador(3);    
        zona[7].setAmbulanciaEnZona(0, 13);
        zona[7].setAmbulanciaEnZona(1, 14);        
        zona[7].setAmbulanciaEnZona(2, 15);        
        zona[7].setContador(3);   
        zona[4].setAmbulanciaEnZona(0, 16);        
        zona[4].setAmbulanciaEnZona(1, 17);        
        zona[4].setContador(2);  
        zona[8].setAmbulanciaEnZona(0, 18);        
        zona[8].setAmbulanciaEnZona(1, 19);        
        zona[8].setContador(2);    
        zona[9].setAmbulanciaEnZona(0, 20);        
        zona[9].setAmbulanciaEnZona(1, 21);        
        zona[9].setContador(2); 
        zona[13].setAmbulanciaEnZona(0, 22);        
        zona[13].setContador(1);
        zona[12].setAmbulanciaEnZona(0, 23);        
        zona[12].setContador(1);
        zona[15].setAmbulanciaEnZona(0, 24);        
        zona[15].setContador(1);   
        zona[0].setAmbulanciaEnZona(0, 25);        
        zona[0].setAmbulanciaEnZona(1, 26);        
        zona[0].setContador(2);        
        zona[1].setAmbulanciaEnZona(0, 27);        
        zona[1].setAmbulanciaEnZona(1, 28);        
        zona[1].setContador(2);
        zona[2].setAmbulanciaEnZona(0, 29);        
        zona[2].setAmbulanciaEnZona(1, 30);        
        zona[2].setContador(2);
        zona[5].setAmbulanciaEnZona(0, 31);        
        zona[5].setAmbulanciaEnZona(1, 32);        
        zona[5].setContador(2);  
        zona[6].setAmbulanciaEnZona(0, 33);        
        zona[6].setAmbulanciaEnZona(1, 34);        
        zona[6].setContador(2);*/         
   //________________________________________________________________________________________


    //______________________________________________________________________________________
       //_______________________________________________________________________________________
    //Arreglo que guarda promedio registros
     data=new double[a+1];

    //_______________________________________________________________________________________
    // Declaracion de variables estocasticas.
    Erand variablesRandom[]=new Erand[17];
    variablesRandom[0]=new Erand (20);
    variablesRandom[1]=new Erand (40);
    variablesRandom[2]=new Erand (60);
    variablesRandom[3]=new Erand (40);
    variablesRandom[4]=new Erand (60);
    variablesRandom[5]=new Erand (40);
    variablesRandom[6]=new Erand (60);      
    variablesRandom[7]=new Erand (40);
    variablesRandom[8]=new Erand (60);
    variablesRandom[9]=new Erand (40);
    variablesRandom[10]=new Erand (60);
    variablesRandom[11]=new Erand (40);
    variablesRandom[12]=new Erand (60);      
    variablesRandom[13]=new Erand (40);
    variablesRandom[14]=new Erand (60);
    variablesRandom[15]=new Erand (40);      
    variablesRandom[16]=new Erand (60);
    double auxiliares[]=new double[17];
    for (int i=0; i<17; i++){
        auxiliares[i]=variablesRandom[i].fdraw();
    }
    double prob[]= new double [17];
    int min=0;
    double clock=0;
    double stop=T;
    int random = (int )(Math.random() * 16 + 1);
    int resultado;
    t=0;
    primer_sistema.steadyEquilibrium(zona);
    
    while(clock<stop){
        t++;
        if(primer_sistema.getAmbulanciaNoActiva(0)!=0){
            min=primer_sistema.eventoConLlegada(auxiliares);
            if(min==0){
                clock=auxiliares[0];
                random = (int )(Math.random() * 16 + 1);

                ambulancias[primer_sistema.getAmbulanciaNoActiva(0)-1].aumentarContador();//Aumento la variable que cuenta las veces que esta ambulancia ha estado en el sistema.
                ambulancias[primer_sistema.getAmbulanciaNoActiva(0)-1].aumentarContadorZona(random);
                zona[random-1].aumentarContador();
  
                zona[random-1].setAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona(), primer_sistema.getAmbulanciaNoActiva(0)); //Asigno la ambulancia a la cola A.
                ambulancias[zona[random-1].getAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona()-1)-1].setEntraSal(0, clock); //Tomo registro de entrada.   
                primer_sistema.recorrerIzq(); //Borro ambulancia que se trasladó de la cola de no activas. 
                //Una vez que llega tengo que hacer que decida si cambiarse o no.  
                resultado=primer_sistema.cambioDeZonaComplejo(random, zona,  ambulancias[zona[random-1].getAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona()-1)-1]);
                if(resultado!=min){
                            zona[random-1].disminuirContador();
                            zona[resultado-1].aumentarContador();                        

                            ambulancias[(zona[resultado-1].getAmbulanciaEnZona(zona[resultado-1].lugarUltimaAmbulanciaEnZona()-1))-1].aumentarContadorZona(resultado);                       
                }
                
                
                //Ahora ajusto el reloj

                prob[0]=variablesRandom[0].fdraw();
                auxiliares[0]=clock+prob[0];  

            }else{// Else de si el evento fue en cero en otra cosa
                clock=auxiliares[min];
              
                if(zona[min-1].getAmbulanciaEnZona(0)==0){                
                    primer_sistema.aumentarContadorXpx();
                }else{//Este es el Else de la condición para ver si muere un px o no
                    zona[min-1].disminuirContador();                    

                    ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setEntraSal(1, clock);//Guardo la hora de salida.
                    ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setRegistro(ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getContador(), ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(1)-ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(0));//Registro el tiempo de espera en este turno.
                    primer_sistema.setAmbulanciaNoActiva(primer_sistema.lugarUltimaAmbulanciaEnZona(), zona[min-1].getAmbulanciaEnZona(0));//Pasas la ambulancia a la cola de No activas.
                    zona[min-1].recorrerIzq(); 
                }//Cierre de los eventos de salida en la condición de que no haya ninguno
                
                //Cambio de Zona a una con cero ambulancias                
                primer_sistema.cambioEnCorto(zona);
                primer_sistema.steadyEquilibrium1(zona); 
                //Se ajusta el reloj
                prob[min]=variablesRandom[min].fdraw();    
                auxiliares[min]=clock+prob[min];

            }// Cierre de si el evento fue en cero o otro número
        }else{//Else de la condición si no hay ambulancias No activas
            min=primer_sistema.eventoSinLlegada(auxiliares);
            clock=auxiliares[min];
            
            if(zona[min-1].getAmbulanciaEnZona(0)==0){
                
                primer_sistema.aumentarContadorXpx();
            }else{//Este es el Else de la condición para ver si muere un px o no
                zona[min-1].disminuirContador();                    

                ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setEntraSal(1, clock);//Guardo la hora de salida.
                ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setRegistro(ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getContador(), ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(1)-ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(0));//Registro el tiempo de espera en este turno.
                primer_sistema.setAmbulanciaNoActiva(primer_sistema.lugarUltimaAmbulanciaEnZona(), zona[min-1].getAmbulanciaEnZona(0));//Pasas la ambulancia a la cola de No activas.
                zona[min-1].recorrerIzq(); 
             }//Cierre de los eventos de salida en la condición de que no haya ninguno
              
                //Cambio de Zona a una con cero ambulancias
                primer_sistema.cambioEnCorto(zona);
                primer_sistema.steadyEquilibrium1(zona); 
            //Se ajusta el reloj
            prob[min]=variablesRandom[min].fdraw();    
            auxiliares[min]=clock+prob[min];
       
        }//Cierre de la condición si no hay ambulancias No activas
    }//Cierra el while
    
    // obtener datos 
    double suma;
    double promedio;
      for(int i=0; i<a; i++){
        suma=0;
        promedio=0;
        for(int t=1; t<=ambulancias[i].getContador(); t++){
          suma=suma+ambulancias[i].getRegistro(t);
        }   
        promedio=suma/(ambulancias[i].getContador());
        data[i]=promedio;
      }
      data[a]=primer_sistema.getContadorXpx();
     

      
      return data;
        
    }//Cierre programa complejo final
    
    public static double[] CDMX(){

   // Creación de Ambulancias
        ambulancia ambulancias[];
    
        ambulancias=new ambulancia[a]; //Ambulancia en Indice 0 es la uno.
        for(int i=0; i<a/2; i++)
            ambulancias[i]= new ambulancia(i+1, 15);
        
    
        for(int i=a/2; i<a; i++)
            ambulancias[i]= new ambulancia(i+1, 12);
    //_____________________________________________________________________________________

    // Creación de Zonas}
       zona zona[]=new zona[16];
       zona[0]=new zona(1,60,10);
       zona[0].setRutas(new int[]{ 2, 3, 6,0});
       zona[1]=new zona(2,60,10);
       zona[1].setRutas(new int[]{ 1, 3, 4, 5, 6,0});       
       zona[2]=new zona(3,60,10);
       zona[2].setRutas(new int[]{ 1, 2, 4,0});         
       zona[3]=new zona(4,60,10);  
       zona[3].setRutas(new int[]{ 2, 3, 5, 9, 10,0});           
       zona[4]=new zona(5,60,10);
       zona[4].setRutas(new int[]{ 2, 4, 6, 7, 8, 9,0});        
       zona[5]=new zona(6,60,10);
       zona[5].setRutas(new int[]{ 1, 2, 5, 7, 8,0});        
       zona[6]=new zona(7,60,10);
       zona[6].setRutas(new int[]{ 6, 8, 16,0});         
       zona[7]=new zona(8,60,10);
       zona[7].setRutas(new int[]{ 5, 6,7, 9, 15, 16,0});       
       zona[8]=new zona(9,60,10);
       zona[8].setRutas(new int[]{ 4, 5, 8, 10,11, 12, 15,0});          
       zona[9]=new zona(10,60,10);
       zona[9].setRutas(new int[]{ 4, 9, 11, 12,0});           
       zona[10]=new zona(11,60,10);
       zona[10].setRutas(new int[]{ 10, 12, 13,0});        
       zona[11]=new zona(12,60,10);
       zona[11].setRutas(new int[]{ 9, 10, 11, 13, 14, 15,0});          
       zona[12]=new zona(13,60,10);
       zona[12].setRutas(new int[]{ 11, 12, 14,0});        
       zona[13]=new zona(14,60,10);
       zona[13].setRutas(new int[]{12, 13, 15,0});        
       zona[14]=new zona(15,60,10);
       zona[14].setRutas(new int[]{8, 9, 12, 14, 16,0});         
       zona[15]=new zona(16,60,10);   
       zona[15].setRutas(new int[]{7, 8, 15,0});          
    //_____________________________________________________________________________________
       //Creción sistema
       sistema primer_sistema;
       primer_sistema=new sistema("Primer Modelo Complejo toda la CDMX");
          
    //_____________________________________________________________________________________
      //Se Inicializan las listas 
       for(int i=1; i<a+1;i++){
          int e=(i)%16;
          zona[e].setAmbulanciaEnZona(zona[e].lugarUltimaAmbulanciaEnZona(), i);
          zona[e].aumentarContador();
      }      
      
      /* zona[11].setAmbulanciaEnZona(0, 1);
        zona[11].setAmbulanciaEnZona(1, 2);        
        zona[11].setAmbulanciaEnZona(2, 3);        
        zona[11].setContador(3);
        zona[10].setAmbulanciaEnZona(0, 4);
        zona[10].setAmbulanciaEnZona(1, 5);        
        zona[10].setAmbulanciaEnZona(2, 6);        
        zona[10].setContador(3);
        zona[14].setAmbulanciaEnZona(0, 7);
        zona[14].setAmbulanciaEnZona(1, 8);        
        zona[14].setAmbulanciaEnZona(2, 9);        
        zona[14].setContador(3);
        zona[3].setAmbulanciaEnZona(0, 10);
        zona[3].setAmbulanciaEnZona(1, 11);        
        zona[3].setAmbulanciaEnZona(2, 12);        
        zona[3].setContador(3);    
        zona[7].setAmbulanciaEnZona(0, 13);
        zona[7].setAmbulanciaEnZona(1, 14);        
        zona[7].setAmbulanciaEnZona(2, 15);        
        zona[7].setContador(3);   
        zona[4].setAmbulanciaEnZona(0, 16);        
        zona[4].setAmbulanciaEnZona(1, 17);        
        zona[4].setContador(2);  
        zona[8].setAmbulanciaEnZona(0, 18);        
        zona[8].setAmbulanciaEnZona(1, 19);        
        zona[8].setContador(2);    
        zona[9].setAmbulanciaEnZona(0, 20);        
        zona[9].setAmbulanciaEnZona(1, 21);        
        zona[9].setContador(2); 
        zona[13].setAmbulanciaEnZona(0, 22);        
        zona[13].setContador(1);
        zona[12].setAmbulanciaEnZona(0, 23);        
        zona[12].setContador(1);
        zona[15].setAmbulanciaEnZona(0, 24);        
        zona[15].setContador(1);   
        zona[0].setAmbulanciaEnZona(0, 25);        
        zona[0].setAmbulanciaEnZona(1, 26);        
        zona[0].setContador(2);        
        zona[1].setAmbulanciaEnZona(0, 27);        
        zona[1].setAmbulanciaEnZona(1, 28);        
        zona[1].setContador(2);
        zona[2].setAmbulanciaEnZona(0, 29);        
        zona[2].setAmbulanciaEnZona(1, 30);        
        zona[2].setContador(2);
        zona[5].setAmbulanciaEnZona(0, 31);        
        zona[5].setAmbulanciaEnZona(1, 32);        
        zona[5].setContador(2);  
        zona[6].setAmbulanciaEnZona(0, 33);        
        zona[6].setAmbulanciaEnZona(1, 34);        
        zona[6].setContador(2);*/         
   //________________________________________________________________________________________


    //______________________________________________________________________________________
       //_______________________________________________________________________________________
    //Arreglo que guarda promedio registros
     data=new double[a+1];

    //_______________________________________________________________________________________
    // Declaracion de variables estocasticas.
    Erand variablesRandom[]=new Erand[17];
    variablesRandom[0]=new Erand (60);
    variablesRandom[1]=new Erand (631.302);
    variablesRandom[2]=new Erand (185.519);
    variablesRandom[3]=new Erand (197.368);
    variablesRandom[4]=new Erand (36.926);
    variablesRandom[5]=new Erand (75.235);
    variablesRandom[6]=new Erand (120.876);      
    variablesRandom[7]=new Erand (234.11);
    variablesRandom[8]=new Erand (77.842);
    variablesRandom[9]=new Erand (70.205);
    variablesRandom[10]=new Erand (77.78);
    variablesRandom[11]=new Erand (46.765);
    variablesRandom[12]=new Erand (22);      
    variablesRandom[13]=new Erand (36.133);
    variablesRandom[14]=new Erand (75.74);
    variablesRandom[15]=new Erand (55.3889);      
    variablesRandom[16]=new Erand (253.298);
    
    double auxiliares[]=new double[17];
    for (int i=0; i<17; i++){
        auxiliares[i]=variablesRandom[i].fdraw();
    }
    double prob[]= new double [17];
    int min=0;
    double clock=0;
    double stop=T;
    int random = (int )(Math.random() * 16 + 1);
    int resultado;
    t=0;
    primer_sistema.steadyEquilibrium(zona);
    
    while(clock<stop){
        t++;
        if(primer_sistema.getAmbulanciaNoActiva(0)!=0){
            min=primer_sistema.eventoConLlegada(auxiliares);
            if(min==0){
                clock=auxiliares[0];
                random = (int )(Math.random() * 16 + 1);

                ambulancias[primer_sistema.getAmbulanciaNoActiva(0)-1].aumentarContador();//Aumento la variable que cuenta las veces que esta ambulancia ha estado en el sistema.
                ambulancias[primer_sistema.getAmbulanciaNoActiva(0)-1].aumentarContadorZona(random);
                zona[random-1].aumentarContador();
  
                zona[random-1].setAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona(), primer_sistema.getAmbulanciaNoActiva(0)); //Asigno la ambulancia a la cola A.
                ambulancias[zona[random-1].getAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona()-1)-1].setEntraSal(0, clock); //Tomo registro de entrada.   
                primer_sistema.recorrerIzq(); //Borro ambulancia que se trasladó de la cola de no activas. 
                //Una vez que llega tengo que hacer que decida si cambiarse o no.  
                resultado=primer_sistema.cambioDeZonaComplejo(random, zona,  ambulancias[zona[random-1].getAmbulanciaEnZona(zona[random-1].lugarUltimaAmbulanciaEnZona()-1)-1]);
                if(resultado!=min){
                            zona[random-1].disminuirContador();
                            zona[resultado-1].aumentarContador();                        

                            ambulancias[(zona[resultado-1].getAmbulanciaEnZona(zona[resultado-1].lugarUltimaAmbulanciaEnZona()-1))-1].aumentarContadorZona(resultado);                       
                }
                
                
                //Ahora ajusto el reloj

                prob[0]=variablesRandom[0].fdraw();
                auxiliares[0]=clock+prob[0];  

            }else{// Else de si el evento fue en cero en otra cosa
                clock=auxiliares[min];
              
                if(zona[min-1].getAmbulanciaEnZona(0)==0){                
                    primer_sistema.aumentarContadorXpx();
                }else{//Este es el Else de la condición para ver si muere un px o no
                    zona[min-1].disminuirContador();                    

                    ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setEntraSal(1, clock);//Guardo la hora de salida.
                    ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setRegistro(ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getContador(), ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(1)-ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(0));//Registro el tiempo de espera en este turno.
                    primer_sistema.setAmbulanciaNoActiva(primer_sistema.lugarUltimaAmbulanciaEnZona(), zona[min-1].getAmbulanciaEnZona(0));//Pasas la ambulancia a la cola de No activas.
                    zona[min-1].recorrerIzq(); 
                }//Cierre de los eventos de salida en la condición de que no haya ninguno
                
                //Cambio de Zona a una con cero ambulancias                
                primer_sistema.cambioEnCorto(zona);
                primer_sistema.steadyEquilibrium1(zona); 
                //Se ajusta el reloj
                prob[min]=variablesRandom[min].fdraw();    
                auxiliares[min]=clock+prob[min];

            }// Cierre de si el evento fue en cero o otro número
        }else{//Else de la condición si no hay ambulancias No activas
            min=primer_sistema.eventoSinLlegada(auxiliares);
            clock=auxiliares[min];
            
            if(zona[min-1].getAmbulanciaEnZona(0)==0){
                
                primer_sistema.aumentarContadorXpx();
            }else{//Este es el Else de la condición para ver si muere un px o no
                zona[min-1].disminuirContador();                    

                ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setEntraSal(1, clock);//Guardo la hora de salida.
                ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].setRegistro(ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getContador(), ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(1)-ambulancias[zona[min-1].getAmbulanciaEnZona(0)-1].getEntraSal(0));//Registro el tiempo de espera en este turno.
                primer_sistema.setAmbulanciaNoActiva(primer_sistema.lugarUltimaAmbulanciaEnZona(), zona[min-1].getAmbulanciaEnZona(0));//Pasas la ambulancia a la cola de No activas.
                zona[min-1].recorrerIzq(); 
             }//Cierre de los eventos de salida en la condición de que no haya ninguno
              
                //Cambio de Zona a una con cero ambulancias
                primer_sistema.cambioEnCorto(zona);
                primer_sistema.steadyEquilibrium1(zona); 
            //Se ajusta el reloj
            prob[min]=variablesRandom[min].fdraw();    
            auxiliares[min]=clock+prob[min];
       
        }//Cierre de la condición si no hay ambulancias No activas
    }//Cierra el while
    
    // obtener datos 
    double suma;
    double promedio;
      for(int i=0; i<a; i++){
        suma=0;
        promedio=0;
        for(int t=1; t<=ambulancias[i].getContador(); t++){
          suma=suma+ambulancias[i].getRegistro(t);
        }   
        promedio=suma/(ambulancias[i].getContador());
        data[i]=promedio;
      }
      data[a]=primer_sistema.getContadorXpx();
     

      
      return data;
        
    }//Cierre programa complejo final 

    
    public static void main(String[] args){
      

    //____________________________________________________________________________________
    // Pasar datos a matriz
    
       double matrix[][];
       matrix=new double[1000][a+1];
    
       for (int g=0; g<1000; g++){   
            for(int f=0; f<a+1; f++){
                matrix[g][f]=programaComplejoFinal()[f];         
            }
        } 
//_____________________________________________________________________________________________
// Imprimir Matriz
        /*for (int g=0; g<1000; g++){   
            for(int f=0; f<a+1; f++){
                System.out.print(matrix[g][f]+" ");         
            }
        System.out.println(" ");
        } */
        
   //___________________________________________________________________________________________________________________________________
   //Resultado_promedio
        double resultado_promedios [];
        resultado_promedios=new double [a+1];
        double suma;
             for(int f=0; f<a+1; f++){
                 suma=0;
                 for (int g=0; g<1000; g++){ 
                    suma=suma+matrix[g][f];
                    resultado_promedios[f]=suma/1000; 
                 }
            } 
      System.out.print("Average waiting time"+" ");
     for(int f=0; f<a+1; f++)
      System.out.print(resultado_promedios[f]+" ");
      System.out.print("\n");     
 //_______________________________________________________________________________________________________________________________________
     //Resultado desviación estandar
    double desv [];
    desv=new double [a+1];
    double dv; 
    double dm;
    
      for(int f=0; f<a+1; f++){
        dv=0;
        dm=0;
        for (int g=0; g<1000; g++){ 
            dm=matrix[g][f]-resultado_promedios[f];
            dv=dv+dm*dm; 
        }
        desv[f]=Math.sqrt(dv / 1000);
    } 
     
    System.out.print("STD "+" ");
     for(int f=0; f<a+1; f++)
      System.out.print(desv[f]+" ");    
         System.out.print("\n");   
 //________________________________________________________________________________________________________________________________________
     //CotaSuperior
     double csp[];
     csp=new double[a+1];
        for(int f=0; f<a+1; f++){
            csp[f]=(resultado_promedios[f]+1.96*(desv[f]/Math.sqrt(1000)));
        }
        
     System.out.print("CIH(.05) "+" ");
     for(int f=0; f<a+1; f++)
      System.out.print(csp[f]+" ");
    System.out.print("\n");   
 //________________________________________________________________________________________________________________________________________
     //CotaInferior
     double ci[];
     ci=new double[a+1];
        for(int f=0; f<a+1; f++){
            ci[f]=(resultado_promedios[f]-1.96*(desv[f]/Math.sqrt(1000)));
        }
        
     System.out.print("CIL(.05) "+" ");
     for(int f=0; f<a+1; f++)
      System.out.print(ci[f]+" "); 
//_______________________________________________________________________________________________
    
    /* double matrix[][];
       matrix=new double[1000][1];
       double desv;
    double dv=0; 
    double dm;
    double resultado_promedios [];
    resultado_promedios=new double [3];
    double suma; 

    while(a<350){
            for (int g=0; g<1000; g++)   
                matrix[g][0]=CDMX()[a];         
      
            suma=0;
            for (int g=0; g<1000; g++){ 
                suma=suma+matrix[g][0];
                resultado_promedios[0]=suma/1000; 
            }
    
            
            dm=0;
            for (int g=0; g<1000; g++){ 
                dm=matrix[g][0]-resultado_promedios[0];
                dv=dv+dm*dm; 
            }
            desv=Math.sqrt(dv / 1000);

            resultado_promedios[1]=(resultado_promedios[0]+1.96*(desv/Math.sqrt(1000)));
            resultado_promedios[2]=(resultado_promedios[0]-1.96*(desv/Math.sqrt(1000)));
            
        System.out.println(a+" "+resultado_promedios[0]+" "+resultado_promedios[1]+" "+resultado_promedios[2]); 
    a=a+5;
    }*/
                   
            
        
    }//fin del main
    
}//Fin del programa
