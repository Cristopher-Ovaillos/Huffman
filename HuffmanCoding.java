package Compresion;

import java.util.*;

public class HuffmanCoding {
    private ArbolHuffman arbol;


    public Map<Character, String> generarCodigos(String texto) {
        arbol = new ArbolHuffman(texto);
        return arbol.generarCodigos();
    }

    public String codificar(String texto, Map<Character, String> codigos) {
        StringBuilder resultado = new StringBuilder();
        for (char ch : texto.toCharArray()) {
            resultado.append(codigos.get(ch));
        }
        return resultado.toString();
    }

    // Decodifica un texto codificado utilizando el arbol de Huffman.
    public String decodificar(String textoCodificado) {
        StringBuilder resultado = new StringBuilder();
        NodoHuffman nodoActual = arbol.getRoot();

        for (char bit : textoCodificado.toCharArray()) {
            nodoActual = (bit == '1') ? nodoActual.right : nodoActual.left;

            if (nodoActual.left == null && nodoActual.right == null) { // Es una hoja
                resultado.append(nodoActual.ch);
                nodoActual = arbol.getRoot();
            }
        }

        return resultado.toString();
    }
}
