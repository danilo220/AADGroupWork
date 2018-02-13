package com.aadgroup.aadgroupwork;

import java.io.Serializable;

public class TestResults implements Serializable {
    private int dotCancellation_timeTaken = 0;
    private int dotCancellation_missedFourDots = 0;
    private int dotCancellation_falsePositives = 0;
    private int squareMatriciesDirectionScore = 0; //maximum of 32
    private int squareMatriciesCompassScore = 0; //maximum of 32
    private int roadSignRecognitionScore = 0; //maximum of 32

    public void setDotCancellationResults(int time, int missed, int incorrect)
    {
        dotCancellation_timeTaken = time;
        dotCancellation_missedFourDots = missed;
        dotCancellation_falsePositives = incorrect;
    }

    public void setSquareMatriciesDirectionScore(int score)
    {
        squareMatriciesDirectionScore = score;
    }

    public void setSquareMatriciesCompassScore(int score)
    {
        squareMatriciesCompassScore = score;
    }

    public void setRoadSignRecognitionScore(int score)
    {
        roadSignRecognitionScore = score;
    }

    private Float passEquation()
    {
        return (dotCancellation_timeTaken * 0.012F) + (dotCancellation_falsePositives * 0.216F)
                + (squareMatriciesCompassScore * 0.409F) + (roadSignRecognitionScore * 1.168F) - 13.79F;
    }

    private Float failEquation()
    {
        return (dotCancellation_timeTaken * 0.017F) + (dotCancellation_falsePositives * 0.035F)
                + (squareMatriciesCompassScore * 0.185F) + (roadSignRecognitionScore * 0.813F) - 10.042F;
    }

    public Boolean passTests()
    {
        return (passEquation() > failEquation());
    }

    public int getTime()
    {
        return dotCancellation_timeTaken;
    }

    public int getMissed()
    {
        return dotCancellation_missedFourDots;
    }

    public int getFalsePositives()
    {
        return dotCancellation_falsePositives;
    }
}
