package Huffman.ComprimirString;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        String texto = "Programa";
        HuffmanCoding huffman = new HuffmanCoding();
        Map<Character, String> codigos = huffman.generarCodigos(texto);
        System.out.println("Codigos de Huffman: " + codigos);
        String textoCodificado = huffman.codificar(texto, codigos);
        System.out.println("Texto codificado: " + textoCodificado);
        String textoDecodificado = huffman.decodificar(textoCodificado);
        System.out.println("Texto decodificado: " + textoDecodificado);
    }
}
