package Compresion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String texto = "programa";

        HuffmanCoding huffman = new HuffmanCoding();
        Map<Character, String> codigos = huffman.generarCodigos(texto);// Orden(n.log n)
        System.out.println("Códigos de Huffman: " + codigos);
        String textoCodificado = huffman.codificar(texto, codigos);//Orden(n)
        System.out.println("Texto codificado: " + textoCodificado);
        String textoDecodificado = huffman.decodificar(textoCodificado);//Orden(n)
        System.out.println("Texto decodificado: " + textoDecodificado);
    }
}
