package com.aadgroup.aadgroupwork;

public class Counter {
    private int minutes = 0;
    private int seconds = 0;

    public String getTimeString()
    {
        String fullTime = Integer.toString(minutes) + ":";
        if (seconds < 10)
        {
            fullTime += "0";
        }
        fullTime += Integer.toString(seconds);
        return fullTime;
    }

    public void increaseTime()
    {
        seconds++;
        if (seconds >= 60) {
            minutes++;
            seconds = 0;
        }
    }

    public int getSeconds()
    {
        int totalTime = (60 * minutes) + seconds;
        return totalTime;
    }
}
