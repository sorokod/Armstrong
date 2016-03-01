package armstrong;

import java.math.BigInteger;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static java.lang.System.nanoTime;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by David Soroko on 29/02/2016.
 */
public class Runner {

    private Armstrong armstrong = new Armstrong();


    public void exec(int level) {
        long start = nanoTime();

        Set<String> aNumbers = armstrong.level(level);

        long duration = SECONDS.convert(nanoTime() - start, NANOSECONDS);
        print(aNumbers, duration);

    }

    private void print(Set<String> set, long duration) {
        set.stream().map(BigInteger::new).sorted().forEach(System.out::println);
        System.out.printf(">> Found %d numbers in  %d sec\n", set.size(), duration);
    }


    public static void main(String[] args) throws Exception {

        final Runner runner = new Runner();

        if (args.length > 0) {
            int level = parseInt(args[0]);
            System.out.printf("Level-%d Armstrong numbers:\n", level);
            runner.exec(level);
        } else {

//            runner.exec(15); //  0 sec. 41
//            runner.exec(18); // 2 sec. 46
//        runner.exec(20); // 6 sec. 51
//        runner.exec(21); // 10 sec. 53
//        runner.exec(22); // 15 sec 53
//        runner.exec(23); // 22 sec. 58
//        runner.exec(25); // 67 48 sec 66
//            runner.exec(39); // 3518 sec. 58 min 88  java -Xmx5g -Xms5g -cp target\armstrong-1.0-SNAPSHOT.jar armstrong.Runner
            // 3480 sec.
        }
    }
}
