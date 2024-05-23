package ex4;

import ex3.MulticonjuntoArrayList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MulticonjuntoAdapter<T> implements Iterable<T> {
    private MulticonjuntoArrayList<T> multiconjunto;

    public MulticonjuntoAdapter(MulticonjuntoArrayList<T> multiconjunto) {
        this.multiconjunto = multiconjunto;
    }

    public Set<T> getConjunto() {
        return new HashSet<>(multiconjunto.getElementos());
    }

    @Override
    public Iterator<T> iterator() {
        return getConjunto().iterator();
    }
}
