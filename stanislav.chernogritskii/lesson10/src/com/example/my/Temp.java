package com.example.my;

/**
 * Created by stanislav on 13.08.15.
 */
public class Temp {

    private final int maxTemp;
    private final int minTemp;
    private final int currTemp;
    private final int avgTemp;

    public Temp(int maxTemp, int minTemp, int currTemp, int avgTemp) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.currTemp = currTemp;
        this.avgTemp = avgTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getCurrTemp() {
        return currTemp;
    }

    public int getAvgTemp() {
        return avgTemp;
    }

    public static Temp updateTempStat(Temp oldStat, int currTemp) {
        int maxStat = Math.max(oldStat.getMaxTemp(), currTemp);
        //...
        return new Temp(maxStat, 0, currTemp, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Temp temp = (Temp) o;

        if (maxTemp != temp.maxTemp) return false;
        if (minTemp != temp.minTemp) return false;
        if (currTemp != temp.currTemp) return false;
        return avgTemp == temp.avgTemp;

    }

    @Override
    public int hashCode() {
        int result = maxTemp;
        result = 31 * result + minTemp;
        result = 31 * result + currTemp;
        result = 31 * result + avgTemp;
        return result;
    }
}
