/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xpacheco
 */
public class ControladorDeTexto {
    
    //Declarcion de los atributos 
    private String ruta;
    private File fichero;
    private java.util.List<Character> Abecedario;
    private Map<Character, Character> Diccionario;
    
    //Metodo constructor de ControladorDeTexto

    public ControladorDeTexto() {
        
        Abecedario = new ArrayList<>();
        Diccionario = new HashMap<>();
        Diccionario = nuevoDiccionario();
    }
    
    
    //metodo para crearDiccionario 
    public Map<Character, Character> nuevoDiccionario() {
        //Declaracion de nuevas varibles
        String abe = "abcdefghijklmnñopqrstuvwxyz";
        String num = "0123456789";
        String caritas = "☺☻♥♦♣♠•◘○◙♀";
        String espacio = " ";
        int aux = (abe.length() - 1);

        for (int i = 0; i < abe.length(); i++) {
            Diccionario.put(abe.charAt(i), abe.charAt(aux));
            aux--;
        }

        Diccionario.put(espacio.charAt(0), caritas.charAt(10));

        Diccionario.put(num.charAt(0), caritas.charAt(0));
        Diccionario.put(num.charAt(1), caritas.charAt(1));
        Diccionario.put(num.charAt(2), caritas.charAt(2));
        Diccionario.put(num.charAt(3), caritas.charAt(3));
        Diccionario.put(num.charAt(4), caritas.charAt(4));
        Diccionario.put(num.charAt(5), caritas.charAt(5));
        Diccionario.put(num.charAt(6), caritas.charAt(6));
        Diccionario.put(num.charAt(7), caritas.charAt(7));
        Diccionario.put(num.charAt(8), caritas.charAt(8));
        Diccionario.put(num.charAt(9), caritas.charAt(9));

        return Diccionario;
    }
    
    
     /**
     *metodo para comprobar si la ruta establecida es valida o no
     * @param ruta de tipo String ara que compruebe la existencia de la ruta
     * @return Boolean si la ruta existe nos retornara un true y caso contrario
     * false
     */
    public boolean comprobarRuta(String ruta) {
    fichero = new File(ruta);

        if (fichero.exists() && fichero.isFile()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    //metodo encargado de desencriptar un archivo de texto
    
    public String desencriptar(String rutaFinal) throws IOException {
        String texto = "";
        try {

            FileReader ficheroOrigen = new FileReader(rutaFinal);
            BufferedReader archivoLectura = new BufferedReader(ficheroOrigen);

            int valor = archivoLectura.read();

            while (valor != -1) {
                char aux = (char) valor;
                texto = texto.concat(Character.toString(aux));
                valor = archivoLectura.read();
            }

            archivoLectura.close();

        } catch (FileNotFoundException ex2) {
            System.out.println("El archivo no ha sido encontrado");
        }

        String desencriptar = "";

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            String le = String.valueOf(letra);
            for (Map.Entry<Character, Character> letra2 : Diccionario.entrySet()) {
                String le2 = String.valueOf(letra2.getValue());

                if (le.equalsIgnoreCase(le2)) {
                    // si la varibale le asignida el dato de tipo String letra es mayuscula nos devolvera un true
                    if (Character.isUpperCase(letra)) {
                        desencriptar = desencriptar.concat(String.valueOf(letra2.getKey()).toUpperCase());
                        System.out.println(desencriptar);
                    } else {
                        desencriptar = desencriptar.concat(String.valueOf(letra2.getKey()));
                        System.out.println(desencriptar);
                    }
                }
            }
        }

        return desencriptar;
    }
}
