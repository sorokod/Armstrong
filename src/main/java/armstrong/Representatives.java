package armstrong;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Stream;

import static java.lang.System.arraycopy;
import static java.util.Spliterator.*;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.IntStream.range;
import static java.util.stream.StreamSupport.stream;

/**
 * Created by David Soroko on 29/02/2016.
 */
public class Representatives implements Iterator<byte[]> {

    private final int level;
    private final LinkedList<byte[]> queue = new LinkedList<>();

    /**
     * Convert an Iterator to Stream
     */
    public static Stream<byte[]> asStream(int level, boolean isParallel) {
        return stream(
                spliteratorUnknownSize(new Representatives(level), NONNULL | IMMUTABLE | DISTINCT | CONCURRENT),
                isParallel);
    }


    public Representatives(int level) {
        this.level = level;
        range(1, 10).forEach(i -> queue.add(addDigit(i)));
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public byte[] next() {
        byte[] value = queue.removeFirst();
        if (value.length < level) {
            for (int k = value[value.length-1]; k >= 0; k--) {
                queue.addFirst(addDigit(value, k));
            }
        }
        return value;
    }


    private byte[] addDigit(byte[] bytes, int digit) {
        final int len = bytes.length;
        final byte[] newBytes = new byte[len + 1];

        newBytes[len] = (byte) digit;
        arraycopy(bytes, 0, newBytes, 0, len);

        return newBytes;
    }

    private byte[] addDigit(int digit) {
        return new byte[] {(byte)digit};
    }

}
