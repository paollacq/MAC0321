package ex3;

import java.util.ArrayList;

public class MulticonjuntoArrayList<T> {
    private ArrayList<T> elementos;

    public MulticonjuntoArrayList() {
        this.elementos = new ArrayList<>();
    }

    public void add(T element) {
        elementos.add(element);
    }

    public boolean equals(MulticonjuntoArrayList<T> m) {
        return this.elementos.equals(m.elementos);
    }

    public void addAll(MulticonjuntoArrayList<T> m) {
        this.elementos.addAll(m.elementos);
    }

    public ArrayList<T> getElementos() {
        return elementos;
    }

    @Override
    public String toString() {
        return "MulticonjuntoArrayList{" +
                "elementos=" + elementos +
                '}';
    }
}


