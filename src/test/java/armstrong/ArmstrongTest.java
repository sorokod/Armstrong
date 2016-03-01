package armstrong;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by David Soroko on 29/02/2016.
 */
public class ArmstrongTest {


    private final static String[] LEVEL_3 = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "153", "370", "371", "407"
    };

    private final static String[] LEVEL_8 = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "153", "370", "371", "407", "1634", "8208",
            "9474", "54748", "92727", "93084", "548834",
            "1741725", "4210818", "9800817", "9926315",
            "24678050", "24678051", "88593477"
    };

    private final static String[] LEVEL_15 = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "153", "370", "371", "407",
            "1634", "8208", "9474",
            "54748", "92727", "93084",
            "548834",
            "1741725", "4210818", "9800817", "9926315",
            "24678050", "24678051", "88593477",
            "146511208", "472335975", "534494836", "912985153",
            "4679307774",
            "32164049650", "32164049651", "40028394225", "42678290603", "44708635679", "49388550606", "82693916578", "94204591914",
            "28116440335967"
    };


    Set<String> level3;
    Set<String> level8;
    Set<String> level15;

    private Armstrong armstrong;

    @Before
    public void before() {
        armstrong = new Armstrong();

        level3 = new HashSet<>(asList(LEVEL_3));
        level8 = new HashSet<>(asList(LEVEL_8));
        level15 = new HashSet<>(asList(LEVEL_15));
    }


    @Test
    public void testLevel() throws Exception {
        assertThat(armstrong.level(3), is(level3));
        assertThat(armstrong.level(8), is(level8));
        assertThat(armstrong.level(15), is(level15));
    }
}