package armstrong;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

/**
 * Created by David Soroko on 29/02/2016.
 */
public final class Armstrong {

    public final static int MAX_LEVEL = 39;

    private Verifier verifier = new Verifier();

    public Set<String> level (int level) {
        final Stream<byte[]> byteStream =  Representatives.asStream(level,  true);
        return collectStringsToSet(byteStream.map(verifier::apply));
    }


    private Set<String> collectStringsToSet(Stream<String> stream) {
        final ConcurrentSkipListSet result = new ConcurrentSkipListSet();
        stream.filter(s -> s != null).collect(toCollection(() -> result));
        return result;
    }

}
