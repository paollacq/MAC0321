package ex4;

import ex3.MulticonjuntoArrayList;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TesteMulticonjuntoAdapter {
    @Test
    public void testAdaptador() {
        MulticonjuntoArrayList<Integer> multiconjunto = new MulticonjuntoArrayList<>();
        multiconjunto.add(1);
        multiconjunto.add(2);
        multiconjunto.add(2);
        multiconjunto.add(3);

        MulticonjuntoAdapter<Integer> adapter = new MulticonjuntoAdapter<>(multiconjunto);

        Set<Integer> conjunto = adapter.getConjunto();
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(1);
        expectedSet.add(2);
        expectedSet.add(3);

        assertEquals(expectedSet, conjunto, "O conjunto deve conter os elementos únicos do multiconjunto");

        Iterator<Integer> iterator = adapter.iterator();
        assertTrue(iterator.hasNext(), "O iterador deve ter elementos");
        assertEquals(Integer.valueOf(1), iterator.next(), "O primeiro elemento deve ser 1");
        assertEquals(Integer.valueOf(2), iterator.next(), "O segundo elemento deve ser 2");
        assertEquals(Integer.valueOf(3), iterator.next(), "O terceiro elemento deve ser 3");
        assertFalse(iterator.hasNext(), "O iterador não deve ter mais elementos");
    }
}

