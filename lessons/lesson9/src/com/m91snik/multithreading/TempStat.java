package com.m91snik.multithreading;

/**
 * Created by Valentin on 13.08.2015.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TempStat tempStat = (TempStat) o;

        if (maxTemp != tempStat.maxTemp) return false;
        if (minTemp != tempStat.minTemp) return false;
        if (currTemp != tempStat.currTemp) return false;
        return avgTemp == tempStat.avgTemp;

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
