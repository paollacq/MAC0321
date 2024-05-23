package ex3;

import java.util.HashSet;

public class MulticonjuntoSet<T> {
    private HashSet<T> elementos;

    public MulticonjuntoSet() {
        this.elementos = new HashSet<>();
    }

    public void add(T element) {
        elementos.add(element);
    }

    public boolean equals(MulticonjuntoSet<T> m) {
        return this.elementos.equals(m.elementos);
    }

    public void addAll(MulticonjuntoSet<T> m) {
        this.elementos.addAll(m.elementos);
    }

    public HashSet<T> getElementos() {
        return elementos;
    }

    @Override
    public String toString() {
        return "MulticonjuntoSet{" +
                "elementos=" + elementos +
                '}';
    }
}

