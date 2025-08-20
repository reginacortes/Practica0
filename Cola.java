class Nodo<T> {
    private int val;
    private Nodo<T> next;
    private Nodo<T> prev;
    private final int id;
    private int contador = 0;

    public Nodo() {
        this.val = 0;
        this.next = null;
        this.prev = null;
        this.id = contador++;
        
    }
    public Nodo(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
        this.id = contador++;
    }
    public Nodo(int val, Nodo<T> next, Nodo<T> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
        this.id = contador++;
    }

    public int getId(){
        return id;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getPrev() {
        return prev;
    }

    public void setPrev(Nodo<T> prev) {
        this.prev = prev;
    }
}

public class Cola<T> {
    private final Nodo<T> cabeza;
    private final Nodo<T> cola;
    
    
    public Cola(){
        cabeza = new Nodo<>();
        cola = new Nodo<>();
        cabeza.setNext(cola);
        cola.setPrev(cabeza);
    }

    public boolean ColaVacia(){
        return cabeza.getNext() == cola;
    }

    public void Insertar(int val){
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setVal(val);

        if(ColaVacia()){
            cabeza.setNext(nuevo);
            nuevo.setPrev(cabeza);
            nuevo.setNext(cola);
            cola.setPrev(nuevo);
        }else{
            Nodo<T> ultimo = cola.getPrev();
            ultimo.setNext(nuevo);
            nuevo.setPrev(ultimo);
            nuevo.setNext(cola);
            cola.setPrev(nuevo);
        }
    }

    public int Busca(int id){
        Nodo<T> actual = cabeza.getNext();
        int index = 0;

        while(actual != cola){
            if(actual.getVal() == id){
                return index;
            }
            actual = actual.getNext();
            index++;
        }
        return -1; // Not found
    } 

    public void Elimina(int id){
        if(!ColaVacia()){
            int pos = this.Busca(id);
            if(pos != -1){
                Nodo<T> actual = cabeza.getNext();
                while(actual != cola){
                    if(actual.getVal() == id){
                        Nodo<T> anterior = actual.getPrev();
                        Nodo<T> siguiente = actual.getNext();
                        anterior.setNext(siguiente);
                        siguiente.setPrev(anterior);

                        actual.setNext(null);
                        actual.setPrev(null);
                        actual.setVal(0); // Clear value
                        break;
                    }else{
                        actual = actual.getNext();
                    }
                }
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cabeza.getNext();

        while(actual != cola){
            sb.append(actual.getVal()).append("-->");
            actual = actual.getNext();
        }

        sb.append("null");
        return sb.toString();
    }

    public void Ordenar(){
        Nodo<T> actual = cabeza.getNext();

        while(actual != null && actual != cola.getPrev()){
            Nodo<T> max = actual;
            Nodo<T> temp = actual.getNext();

            while(temp != null && temp != cola){
                if(temp.getVal() > max.getVal()){
                    max = temp;
                }
                temp = temp.getNext();
            }

            if(max != actual){
                int tempVal = actual.getVal();
                actual.setVal(max.getVal());
                max.setVal(tempVal);
            }
            actual = actual.getNext();
        }
    }
    
}

