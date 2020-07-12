/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.io.File;
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
}
