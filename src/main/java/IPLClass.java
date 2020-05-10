import com.opencsv.bean.CsvBindByName;

public class IPLClass {

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Avg", required = true)
    public float avg;

    @CsvBindByName(column = "SR", required = true)
    public float sr;

    @CsvBindByName(column = "4s", required = true)
    public int four;

    @CsvBindByName(column = "6s", required = true)
    public int six;
}