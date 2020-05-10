import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLTest {

    @Test
    public void test() {
        dataLoader l = new dataLoader();
        List list = l.loadData("./src/test/resources/IPL2019FactsheetMostRuns.csv", IPLClass.class);
        Assert.assertEquals(100,list.size());
    }
}
