/**
 *
 * @author thomaz
 * @param <T>
 */
public class ListaOrdenadaInv<T extends Comparable<T>> {

    public ListaOrdenadaInv() {
        this.lista = (T[]) new Comparable[LENGTH];
    }
    
    public void inserir(T v){
        int i;
        for (i = elems; i > 0; i--) {
            if( lista[i-1].compareTo(v) > 0 ){
                break;
            } else {
                lista[i] = lista[i-1];
            }
        }
        lista[i] = v;
        elems++;
    }
    
    public int buscar(T v){
        int esq = 0, dir = elems;
        do {            
            int meio = (dir + esq) / 2;
            if( lista[meio].compareTo(v) == 0 ){
                return meio;
            } else if( lista[meio].compareTo(v) < 0 ){
                dir = meio + 1;
            } else {
                esq = meio;
            }
        } while (dir - esq > 0);
        return -1;
    }
    
    public T removerEm(int i){
        T removido = (T) lista[i];
        elems--;
        for (int j = 0; j < elems; j++) {
            lista[i] = lista[i+1];
        }
        lista[elems] = null;
        
        return removido;
    }
    
    public T recuperarEm(int i){
        return lista[i];
    }
    
    public int numElementos(){
        return elems;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        int i;
        for (i = 0; i < elems-1; i++) {
            sb.append(lista[i]).append(",");
        }
        sb.append(lista[i]).append("}");
        
        return sb.toString();
    }
    
    private static final int LENGTH = 100;
    private final T[] lista;
    private int elems;
    
}
