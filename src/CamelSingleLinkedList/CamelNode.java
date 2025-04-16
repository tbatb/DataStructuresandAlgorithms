package CamelSingleLinkedList;

public class CamelNode {
    private final Camel camel;
    private CamelNode next;

    public CamelNode(Camel camel){
        this.camel = camel;
    }

    public Camel getCamel(){
        return camel;
    }

    public CamelNode getNext() {
        return next;
    }

    public void setNext(CamelNode next) {
        this.next = next;
    }
}

