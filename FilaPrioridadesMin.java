import java.util.Arrays;

/**
 * Não se esqueça de escrever um Javadoc adequado para cada método, e para a classe como um todo.
 * 
 * @author Marcos Thomaz
 * @version 2015-09-08
 */
public class FilaPrioridadesMin<T extends Comparable<T>>
{

	/**
	 * Cria a fila de prioridades mínima vazia.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public FilaPrioridadesMin(int capacidade) {
		minHeap = new Comparable[capacidade];
	}
	
	/**
	 * Cria a fila de prioridades mínima contendo todos as entradas do arranjo.
	 * 
	 */
	public FilaPrioridadesMin(T[] arranjoEntradas){
		this(arranjoEntradas.length);
		
		for (T t : arranjoEntradas) {
			inserir(t);			
		}
	}

	/** 
	 * @param entrada
	 */
	public void inserir(T e) {
        if (numElems >= minHeap.length - 1) {
            minHeap = dobrar();
        }        
        numElems++;
        minHeap[numElems] = e;
        
        criarSup();
	}

	/**
	 * Retorna o item com maior prioridade
	 * 
	 * @return 
	 */
	public Comparable<T> minimo() {

		if ( !this.isEmpty() ) {
			return minHeap[1];
		}
		return null;
	}

	/**
	 * Remove e retorna o item com maior prioridade
	 * 
	 * @return
	 */
	public Comparable<T> extrairMinimo() {

    	Comparable<T> result = minimo();
    	
    	minHeap[1] = minHeap[numElems];
    	minHeap[numElems] = null;
    	numElems--;
    	
    	criarInf();
    	
    	return result;
	}
	
	/**
	 * @param e
	 * @return
	 */
	public Comparable<T> buscar(T e) {
		return e;
	}
	
	/**
	 * @param e
	 * @return
	 */
	public Comparable<T> remover(T e) {
		return null;
	}
	
    /**
     * Sempre compara e troca os valores, jogando os menores pra cima
     * 
     */
    @SuppressWarnings("unchecked")
	protected void criarSup() {
        int i = this.numElems;
        
        while (temPai(i) && ( getPai(i).compareTo((T) minHeap[i]) > 0) ) {
        	troca(i, iPai(i));
            i = iPai(i);
        }        
    }
	
    @SuppressWarnings("unchecked")
	protected void criarInf() {
        int i = 1;
        
        while (iEsquerdo(i) <= numElems) {
            int menorFilho = iEsquerdo(i);
            
            if ((iDireito(i) <= numElems) && minHeap[iEsquerdo(i)].compareTo((T) minHeap[iDireito(i)]) > 0) {
            	menorFilho = iDireito(i);
            } 
            
            if (minHeap[i].compareTo((T) minHeap[menorFilho]) > 0) {
            	troca(i, menorFilho);
            } else {
                break;
            }
            
            i = menorFilho;
        }        
    }

	/**
	 * 
	 * @return
	 */
    private boolean isEmpty() {
        return numElems == 0;
    }
	
    /**
     * @param i
     * @return
     */
    private boolean temPai(int i) {
        return i > 1;
    }
    
    /**
     * @param i
     * @return
     */
    private int iEsquerdo(int i) {
        return i * 2;
    }
    
    /**
     * @param i
     * @return
     */
    private int iDireito(int i) {
        return i * 2 + 1;
    }
        
    /**
     * Retorna o valor contido no pai
     * 
     * @param i
     * @return
     */
    private Comparable<T> getPai(int i) {
        return minHeap[iPai(i)];
    }
    
    /**
     * Acha o pai
     * 
     * @param i
     * @return
     */
    private int iPai(int i) {
        return i / 2;
    }
    
    /**
     * @return
     */
    private Comparable<T>[] dobrar() {
        return Arrays.copyOf(minHeap, minHeap.length * 2);
    }
	
    /**
     * @param index1
     * @param index2
     */
    private void troca(int i1, int i2) {
        Comparable<T> tmp = minHeap[i1];
        minHeap[i1] = minHeap[i2];
        minHeap[i2] = tmp;        
    }
    
	// Somente esses atributos são permitidos, não é necessário nada mais.
	private Comparable<T>[] minHeap;
	private int numElems;
}
