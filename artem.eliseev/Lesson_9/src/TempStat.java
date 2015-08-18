/**
 * Created by Anry on 13.08.2015.
 */
public class TempStat {
    private final int maxTemp;
    private final int minTemp;
    private final int currTemp;
    private final int avgTemp;

    public TempStat(int maxTemp, int minTemp, int currTemp, int avgTemp) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.currTemp = currTemp;
        this.avgTemp = avgTemp;
    }
    public int getMaxTemp () {
        return maxTemp;
    }




}
