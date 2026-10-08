package src; 

public class CatalogoArreglo<T> implements Catalogo<T> {
 
    private final T[] elementos;
    private int cantidad;
 
    @SuppressWarnings("unchecked")
    public CatalogoArreglo(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0, se recibió: " + capacidad);
        }
        this.elementos = (T[]) new Object[capacidad];
        this.cantidad = 0;
    }
 
    @Override
    public void agregar(T elemento) {
        if (cantidad == elementos.length) {
            throw new IllegalStateException("El catálogo está lleno (capacidad máxima: " + elementos.length + ")");
        }
        elementos[cantidad++] = elemento;
    }
 
    @Override
    public T obtener(int indice) {
        validarIndice(indice);
        return elementos[indice];
    }
 
    @Override
    public void eliminar(int indice) {
        validarIndice(indice);
        for (int i = indice; i < cantidad - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--cantidad] = null;
    }
 
    @Override
    public int buscar(T elemento) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == null ? elemento == null : elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }
 
    @Override
    public int tamanio() {
        return cantidad;
    }
 
    private void validarIndice(int indice) {
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException(
                "Índice inválido: " + indice + " (el catálogo tiene " + cantidad + " elementos)");
        }
    }
}