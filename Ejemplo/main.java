package Huffman.Ejemplo;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import Huffman.ComprimirString.HuffmanCoding;


import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            // Ruta del archivo de texto en windows
            String path =   System.getProperty("user.dir") + "\\Huffman\\Libros\\HarryPotter.txt"; 
            // Leer el archivo y convertirlo a String
            String content = Files.readString(Paths.get(path));
            HuffmanCoding huffman = new HuffmanCoding();
            // Imprimir el contenido
            // System.out.println("Mensaje al inicio:" + content);
            Map<Character, String> codeMap = huffman.generarCodigos(content);
            // System.out.println("Códigos Huffman: " + codeMap);

            // Codificar el mensaje
            String encoded = huffman.codificar(content, codeMap);
            // System.out.println("Mensaje codificado: " + encoded);

            // Decodificar el mensaje
            String decoded = huffman.decodificar(encoded);
            // System.out.println("Mensaje decodificado: " + decoded);
            int tamañoOriginal = content.getBytes().length;
            System.out.println("Tamaño antes de descomprimir:" + tamañoOriginal);
            int tamCompresion= (int)Math.ceil(encoded.length()/ 8);
            int bytesFrecuencia = 2;
            int tamañoTabla = (codeMap.size() * Character.BYTES) + codeMap.size() * 2;
            int tamCompresionTotal = tamCompresion + tamañoTabla;
            // asumo que la tabla tiene 2bytes asignados para cada frecuencia
            System.out.println("tamaño tabla : " + tamañoTabla);
            System.out
                    .println("Tamaño compresion con tabla y texto comprimido  " + tamCompresionTotal);
            System.out
                    .println("Mejora de espacio en bytes  " + (tamañoOriginal - tamCompresionTotal));
            int porcentajeDeCompresion = (int) (((tamañoOriginal - tamCompresionTotal) / (double) tamañoOriginal)
                    * 100);
            System.out.println("Porcentaje de la compresion :" + porcentajeDeCompresion + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}