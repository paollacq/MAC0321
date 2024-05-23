package ex3;

import java.util.LinkedList;

public class MulticonjuntoLinkedList<T> {
    private LinkedList<T> elementos;

    public MulticonjuntoLinkedList() {
        this.elementos = new LinkedList<>();
    }

    public void add(T element) {
        elementos.add(element);
    }

    public boolean equals(MulticonjuntoLinkedList<T> m) {
        return this.elementos.equals(m.elementos);
    }

    public void addAll(MulticonjuntoLinkedList<T> m) {
        this.elementos.addAll(m.elementos);
    }

    public LinkedList<T> getElementos() {
        return elementos;
    }

    @Override
    public String toString() {
        return "MulticonjuntoLinkedList{" +
                "elementos=" + elementos +
                '}';
    }
}


