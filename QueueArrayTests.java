import static org.junit.Assert.*;
import java.lang.IndexOutOfBoundsException;

import org.junit.Test;

public class QueueArrayTests {

    public static final double DELTA = .0001;

    @Test
    public void simpleTest() {

        QueueArray q = new QueueArray(5);
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

    }

    @Test
    public void complexTest() {

        QueueArray q = new QueueArray(6);
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(2, q.size());
        q.dequeue();
        assertEquals(1, q.size());
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        assertEquals(6, q.size());
        assertEquals(2, q.dequeue(), DELTA);
        assertEquals(2, q.dequeue(), DELTA);
        assertEquals(3, q.dequeue(), DELTA);
        assertEquals(4, q.dequeue(), DELTA);
        assertEquals(5, q.dequeue(), DELTA);
        assertEquals(6, q.dequeue(), DELTA);
        assertEquals(q.size(), 0);
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(q.size(), 2);

    }

    @Test
    public void testIsEmpty1() {

        QueueArray q = new QueueArray(0);
        assertTrue(q.isEmpty());

    }

    @Test
    public void testIsEmpty2() {

        QueueArray q = new QueueArray(7);
        q.enqueue(1);
        q.enqueue(2);
        assertFalse(q.isEmpty());

    }

    @Test
    public void testisFull1() {

        QueueArray q = new QueueArray(0);
        assertTrue(q.isFull());

    }

    @Test
    public void testisFull2() {

        QueueArray q = new QueueArray(3);
        q.enqueue(1);
        q.enqueue(2);
        assertFalse(q.isEmpty());

    }

    @Test
    public void testEnqueueRaise() {

        QueueArray q = new QueueArray(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        try {
            q.enqueue(4);
            fail();
        }
        catch (IndexOutOfBoundsException e) {
            assertEquals("Queue OverFlow", e.getMessage());
        }

    }

    @Test
    public void testDequeueRaise() {

        QueueArray q = new QueueArray(0);
        try {
            q.dequeue();
            fail();
        }
        catch (IndexOutOfBoundsException e) {
            assertEquals("Queue UnderFlow", e.getMessage());
        }

    }

}