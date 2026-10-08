package src;

public interface Catalogo<T> {
 
    void agregar(T elemento);
 
    T obtener(int indice);
 
    void eliminar(int indice);
 
    int buscar(T elemento);
 
    int tamanio();
}
 