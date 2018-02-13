package com.aadgroup.aadgroupwork;

import java.io.Serializable;

public class TestResults implements Serializable {
    private int dotCancellation_timeTaken = 0;
    private int dotCancellation_missedFourDots = 0;
    private int dotCancellation_cancelledNonFourDots = 0;

    public void setDotCancellationResults(int time, int missed, int incorrect)
    {
        dotCancellation_timeTaken = time;
        dotCancellation_missedFourDots = missed;
        dotCancellation_cancelledNonFourDots = incorrect;
    }

    public int getTime()
    {
        return dotCancellation_timeTaken;
    }

    public int getMissed()
    {
        return dotCancellation_missedFourDots;
    }

    public int getIncorrect()
    {
        return dotCancellation_cancelledNonFourDots;
    }
}
