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
    private java.util.List<Character> abecedario;
    private Map<Character, Character> diccionario;
    
    //Metodo constructor de ControladorDeTexto

    public ControladorDeTexto() {
        
        abecedario = new ArrayList<>();
        diccionario = new HashMap<>();
        diccionario = crearDiccionario();
    }
    
    
    //metodo para crearDiccionario 
    public Map<Character, Character> crearDiccionario() {
        //Declaracion de nuevas varibles
        String abe = "abcdefghijklmnñopqrstuvwxyz";
        String num = "0123456789";
        String caritas = "☺☻♥♦♣♠•◘○◙♀";
        String espacio = " ";
        int aux = (abe.length() - 1);

        for (int i = 0; i < abe.length(); i++) {
            diccionario.put(abe.charAt(i), abe.charAt(aux));
            aux--;
        }

        diccionario.put(espacio.charAt(0), caritas.charAt(10));

        diccionario.put(num.charAt(0), caritas.charAt(0));
        diccionario.put(num.charAt(1), caritas.charAt(1));
        diccionario.put(num.charAt(2), caritas.charAt(2));
        diccionario.put(num.charAt(3), caritas.charAt(3));
        diccionario.put(num.charAt(4), caritas.charAt(4));
        diccionario.put(num.charAt(5), caritas.charAt(5));
        diccionario.put(num.charAt(6), caritas.charAt(6));
        diccionario.put(num.charAt(7), caritas.charAt(7));
        diccionario.put(num.charAt(8), caritas.charAt(8));
        diccionario.put(num.charAt(9), caritas.charAt(9));

        return diccionario;
    }
    
    
     /**
     * Este metodo resibe como parametro un dato de tipo String ruta, y
     * comprueba que la ruta ingresada sea correcta y exista en el comutador
     * huesped
     *
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
