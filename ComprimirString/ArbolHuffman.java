package Huffman.ComprimirString;

import java.util.*;

public class ArbolHuffman {
    private NodoHuffman root;


    public ArbolHuffman(String texto) {

        Map<Character, Integer> frecuencias = calcularFrecuencias(texto);
        System.out.println("Mapeo "+frecuencias.toString());


        PriorityQueue<NodoHuffman> cola = construirColaPrioridad(frecuencias);
        System.out.println("Cola de prioridad "+cola.toString());
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
        System.out.println("Cola "+cola.toString());
        while (cola.size() > 1) {

            NodoHuffman izquierdo = cola.poll();//O(1)
            NodoHuffman derecho = cola.poll();//O(1)

            NodoHuffman padre = new NodoHuffman('\0', izquierdo.frequency + derecho.frequency, izquierdo, derecho);
            cola.add(padre);// insertar, y el inserta tiene complejidad Log k (siendo k la longitud la longitud actual de la cola)
            System.out.println("Cola "+cola.toString());
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
