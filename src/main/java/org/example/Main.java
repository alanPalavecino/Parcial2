package org.example;

import Excepciones.ExcepcionFiebre;
import Excepciones.SinReactivos;
import Models.Persona;
import Models.Registro;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Hello world!");

        Persona p1 = new Persona("jorge", "rivas", 40, "Los pinares", "25437666", "plomero");
        Persona p2 = new Persona("roberto", "rios", 41, "Malvinas", "24437666", "plomero");
        Persona p3 = new Persona("agustin", "martinez", 42, "Libertad", "23437666", "plomero");
        Persona p4 = new Persona("miguel", "gutierrez", 43, "autodromo", "22437666", "plomero");
        Persona p5 = new Persona("Ana", "rivolta", 45, "Los robles", "20137666", "contadora");

        /// hago hasmap para validar que no puede ingresar con el mismo dni
        HashMap <String, Persona>  personas = new HashMap<>();
        personas.put(p1.getDNI(), p1);
        personas.put(p2.getDNI(), p2);
        personas.put(p3.getDNI(), p3);
        personas.put(p4.getDNI(), p4);
        personas.put(p5.getDNI(), p5);


        LinkedHashSet <Persona> filaPerdonas = new LinkedHashSet<>();

        /// recorro el haspMap y paso los datos a una fila
      for (Map.Entry<String, Persona> entry : personas.entrySet()){
          filaPerdonas.add(personas.get(entry));
      }


        /// creo la table de registros
        Hashtable <Integer, Registro> registros = new Hashtable<>();

        Integer cantReactivos = 4;

        try{
            testear(filaPerdonas, cantReactivos, registros);
        }catch (SinReactivos e){
            System.out.println("NO HAY REACTIVOS");
        }

        try{
            aislar(registros);
        }catch (ExcepcionFiebre e){
            System.out.println("Ested tiene fiebre");
            try
            {
                ObjectOutputStream escribirEnArchivo = new ObjectOutputStream(new FileOutputStream("C:/Users/Alan/OneDrive - UTN FRMDP/Cursada 2023/Primer Cuatrimestre/Prog y lab lll/PalavecinoParcial2/urgente.dat"));
                escribirEnArchivo.writeObject(e);
                escribirEnArchivo.close();
            }catch (Exception r ){
                System.out.println("Algo salio mal");
            }


        }



    }


    /// evaluaremos la temperatura de cada una de las personas. Con cada evaluación generamos
    //una tabla donde la clave será el número de kit y el valor contendrá un registro que
    //contendrá el DNI y la temperatura (generada de manera random entre 36 y 39 grados).


    // Este metodo testea a todas las personas de la fila, si no hay reeactivos, lanza la exception
    public static void testear (LinkedHashSet <Persona> filaPersonas, Integer cantReactivos, Hashtable <Integer, Registro>registros ) throws SinReactivos {
        Integer numTesteo = 4000;
        int i = 1;
        Double t;
        for (Persona p : filaPersonas) {

            if(i<cantReactivos) {
                t = testeo(registros, p, numTesteo);
            }else{
                throw  new SinReactivos();
            }

            i++;
        }

    }

    /// este metodo es el que testea persona por persona, aca ve la tempreratura de la fiebre  y lo carga en la tabla
    public static Double testeo(Hashtable <Integer, Registro> temperaturas, Persona p, Integer testeo) {

     Double t = dameTemperatura();
     Integer kit = dameNumKit();
     Registro r = new Registro(t, p.getDNI(),testeo, p.getBarrio() );
      temperaturas.put(kit,r);

      return t;
    }

    public static Integer dameNumKit (){
        Random r = new Random();
        Integer kit = r.nextInt();
        return kit;
    }
    public static Double dameTemperatura(){
        Random r = new Random();
        Double temperatura = r.nextDouble(36, 39);
        return temperatura;
    }


    //étodo llamado “aislar” donde si la
    //temperatura supera los 38 grados (inclusive) lanzaremos una excepción que contendrá el
    //número de test y el barrio

    /// recorro la tabla, en caso de que supuero los 38 grados, lanza la exception fiebre
    public static void aislar ( Hashtable <Integer, Registro> registros)  throws ExcepcionFiebre {

       while(registros.elements().hasMoreElements()){

           if(registros.elements().nextElement().getTemp() >=38) {
               throw new ExcepcionFiebre(registros.elements().nextElement().getNumeroTesteo(), registros.elements().nextElement().getBarrio());
           }

       }


    }



}
