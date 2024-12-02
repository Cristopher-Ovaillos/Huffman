## ALGORITMO Huffman(texto)

1. Calcular frecuencias de cada caracter en el texto.
2. Construir una cola de prioridad con los caracteres y sus frecuencias.
3. Mientras haya mas de un nodo en la cola:
    - Extraer los dos nodos con menor frecuencia.
    - Crear un nuevo nodo combinando ambos nodos.
    - Insertar el nuevo nodo en la cola.
4. El nodo restante es la raiz del arbol de Huffman.
5. Generar codigos recorriendo el arbol:
    - Asignar "0" al hijo izquierdo y "1" al derecho.
6. Codificar el texto original usando los codigos generados.
7. Para decodificar:
    - Recorrer el arbol segun los bits del texto codificado.
    - Al llegar a una hoja, registrar el caracter y reiniciar el recorrido.

