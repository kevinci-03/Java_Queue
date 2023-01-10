
import static org.junit.Assert.*;

import org.junit.Test;

public class QueueNodeListTests {

    public static final double DELTA = .0001;

    @Test
    public void simpleTest() {

        QueueNodeList<Integer> q = new QueueNodeList<>();
        q.enqueue(1);
        assertEquals(1, q.size());
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        assertEquals(5, q.size());
        assertEquals(1, q.dequeue(), DELTA);
        assertEquals(2, q.dequeue(), DELTA);
        assertEquals(3, q.dequeue(), DELTA);
        assertEquals(4, q.dequeue(), DELTA);
        assertEquals(1, q.size());
        assertEquals(5, q.dequeue(), DELTA);

    }

    @Test
    public void testIsEmpty1() {

        QueueNodeList<Integer> q = new QueueNodeList<>();
        assertTrue(q.isEmpty());

    }

    @Test
    public void testIsEmpty2() {

        QueueArray q = new QueueArray(7);
        q.enqueue(1);
        q.enqueue(2);
        assertFalse(q.isEmpty());

    }

}