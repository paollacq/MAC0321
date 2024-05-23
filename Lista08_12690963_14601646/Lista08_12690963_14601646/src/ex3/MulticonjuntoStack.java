package ex3;

import java.util.Stack;

public class MulticonjuntoStack<T> {
    private Stack<T> elementos;

    public MulticonjuntoStack() {
        this.elementos = new Stack<>();
    }

    public void add(T element) {
        elementos.add(element);
    }

    public boolean equals(MulticonjuntoStack<T> m) {
        return this.elementos.equals(m.elementos);
    }

    public void addAll(MulticonjuntoStack<T> m) {
        this.elementos.addAll(m.elementos);
    }

    public Stack<T> getElementos() {
        return elementos;
    }

    @Override
    public String toString() {
        return "MulticonjuntoStack{" +
                "elementos=" + elementos +
                '}';
    }
}

