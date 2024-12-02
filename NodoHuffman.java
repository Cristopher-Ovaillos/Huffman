package Compresion;

/**
 * Representa un nodo en el árbol de Huffman.
 */
public class NodoHuffman {
    public char ch;              // Carácter representado
    public int frequency;        // Frecuencia del carácter
    public NodoHuffman left;     // Hijo izquierdo
    public NodoHuffman right;    // Hijo derecho

    public NodoHuffman(char ch, int frequency, NodoHuffman left, NodoHuffman right) {
        this.ch = ch;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + (ch == '\0' ? "Interno" : ch) + ", " + frequency + ")";
    }
}
