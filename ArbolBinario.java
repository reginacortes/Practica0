public class ArbolBinario<T>{
    private Nodo<T> raiz;
    private int cant;

    public ArbolBinario(){
        this.raiz = null;
    }

    public void Insertar(int dato){     //se agrega el nivel de urgencia 
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setVal(dato);

        if(raiz == null){
            raiz = nuevo;
            cant++; 
            return;
        }

        Nodo<T> actual = this.raiz;

        while(actual != null){
            if(actual.getVal() >= nuevo.getVal()){  //si es mayor
                if(actual.getPrev() == null){
                    actual.setPrev(nuevo);
                    cant++;
                    return;
                } else{
                    actual = actual.getPrev();
                    
                }
            } else{  //si es menor o igual
                if(actual.getNext() == null){
                    actual.setNext(nuevo);
                    cant++;
                    return;
                } else{
                    actual = actual.getNext();
                }
            }
        }
    }

    public void Borrar(int dato){
        raiz = BorrarRec(raiz, dato);
    }
    private Nodo<T> BorrarRec(Nodo<T> nodo, int dato){
        if(nodo == null){
            return null;
        }

        if(dato < nodo.getVal()){
            nodo.setPrev(BorrarRec(raiz.getPrev(), dato));
        } else {
            if(dato > nodo.getVal()){
                nodo.setNext(BorrarRec(raiz.getNext(), dato));
            } else {
                // Nodo encontrado
                if(nodo.getPrev() == null && nodo.getNext() == null){
                    return null; // Nodo hoja
                } else if(nodo.getPrev() == null){
                    return nodo.getNext(); // Solo tiene hijo derecho
                } else if(nodo.getNext() == null){
                    return nodo.getPrev(); // Solo tiene hijo izquierdo
                } else {
                    // Nodo con dos hijos, encontrar el sucesor
                    nodo.setVal(minVal(nodo.getNext()));
                    nodo.setNext(BorrarRec(nodo.getNext(), nodo.getVal()));
                }
            }
        }
        return raiz;
    }

    private int minVal(Nodo<T> nodo){
        int min = nodo.getVal();

        while(nodo.getPrev() != null){
            min = nodo.getPrev().getPrev().getVal();
            nodo = nodo.getPrev();
        }
        return min;
    }

    public void imprimirInorden(){
        imprimirInordenRec(raiz);
    }

    private void imprimirInordenRec(Nodo<T> nodo){
        if(nodo != null){
            imprimirInordenRec(nodo.getPrev());
            System.out.print(nodo.getVal() + " ");
            imprimirInordenRec(nodo.getNext());
        }
    }

}