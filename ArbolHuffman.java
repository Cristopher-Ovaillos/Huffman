package Compresion;

import java.util.*;

//Maneja la construcción del arbol de Huffman y la generación de codigos.
public class ArbolHuffman {
    private NodoHuffman root;


    public ArbolHuffman(String texto) {
        Map<Character, Integer> frecuencias = calcularFrecuencias(texto);
        PriorityQueue<NodoHuffman> cola = construirColaPrioridad(frecuencias);
        this.root = construirArbol(cola);
    }

    //Calcula las frecuencias de cada caracter en el texto.
  
    private Map<Character, Integer> calcularFrecuencias(String texto) {
        Map<Character, Integer> frecuencias = new HashMap<>();
        for (char ch : texto.toCharArray()) {
            frecuencias.put(ch, frecuencias.getOrDefault(ch, 0) + 1);
        }
        return frecuencias;
    }

    //Construye una cola de prioridad basada en las frecuencias.
    
    private PriorityQueue<NodoHuffman> construirColaPrioridad(Map<Character, Integer> frecuencias) {
        PriorityQueue<NodoHuffman> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));
        for (Map.Entry<Character, Integer> entrada : frecuencias.entrySet()) {
            cola.add(new NodoHuffman(entrada.getKey(), entrada.getValue(), null, null));
        }
        return cola;
    }

    // Construye el arbol de Huffman.
   
    private NodoHuffman construirArbol(PriorityQueue<NodoHuffman> cola) {
        while (cola.size() > 1) {
            NodoHuffman izquierdo = cola.poll();
            NodoHuffman derecho = cola.poll();
            NodoHuffman padre = new NodoHuffman('\0', izquierdo.frequency + derecho.frequency, izquierdo, derecho);
            cola.add(padre);
        }
        return cola.poll();
    }

    // Genera el mapa de codigos de Huffman a partir del arbol.
 
    public Map<Character, String> generarCodigos() {
        Map<Character, String> codigos = new HashMap<>();
        generarCodigosRecursivo(root, "", codigos);
        return codigos;
    }

    private void generarCodigosRecursivo(NodoHuffman nodo, String codigo, Map<Character, String> codigos) {
        if (nodo == null) return;

        if (nodo.left == null && nodo.right == null) { // Es una hoja
            codigos.put(nodo.ch, codigo);
        }

        generarCodigosRecursivo(nodo.left, codigo + "0", codigos);
        generarCodigosRecursivo(nodo.right, codigo + "1", codigos);
    }

    //devuelve la raiz del arbol
    public NodoHuffman getRoot() {
        return root;
    }
}
