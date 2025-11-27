import java.util.Arrays;

public class CircularBufferSimulation {
    private final int[] buffer;
    private final int capacity;
    private int head = 0; // index of oldest element
    private int tail = 0; // index to write next
    private int size = 0;

    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    // insert (enqueue). If full, overwrite oldest and advance head.
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            // buffer full: overwrite oldest -> move head forward
            head = (head + 1) % capacity;
        }
    }

    // optional: remove oldest element
    public int remove() {
        if (size == 0) throw new RuntimeException("Buffer is empty");
        int val = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return val;
    }

    public int[] toArray() {
        int[] out = new int[size];
        for (int i = 0; i < size; i++) {
            out[i] = buffer[(head + i) % capacity];
        }
        return out;
    }

    public static void main(String[] args) {
        CircularBufferSimulation buf = new CircularBufferSimulation(3);
        buf.insert(1);
        buf.insert(2);
        buf.insert(3);
        System.out.println("Buffer: " + Arrays.toString(buf.toArray())); // [1, 2, 3]

        buf.insert(4); // overwrites the oldest (1)
        System.out.println("Buffer after insert 4: " + Arrays.toString(buf.toArray())); // [2, 3, 4]
    }
}
