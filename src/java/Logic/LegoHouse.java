/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Martin Brandstrup
 */
public class LegoHouse
{

    private int total1x2;
    private int total2x2;
    private int total4x2;

    private int length;
    private int width;
    private int height;

    public LegoHouse(int length, int width, int height) throws IllegalArgumentException
    {
        if (height < 1 || length < 5 || width < 5)
        {
            throw new IllegalArgumentException();
        }
        this.length = length;
        this.width = width;
        this.height = height;

        calculateBill();
    }

    private void calculateBill()
    {
        int tempLength = length - 4; //-4 to avoid counting corners twice
        int tempWidth = width;

        int length1x2 = -1;
        int length2x2 = -1;
        int length4x2 = -1;

        int width1x2 = -1;
        int width2x2 = -1;
        int width4x2 = -1;

        if (tempLength / 4 > 0)
        {
            length4x2 = tempLength / 4;
            tempLength = tempLength % 4;
        }

        if (tempLength / 2 > 0)
        {
            length2x2 = tempLength / 2;
            tempLength = tempLength % 2;
            length1x2 = tempLength;
        }

        if (tempWidth / 4 > 0)
        {
            width4x2 = tempWidth / 4;
            tempWidth = tempWidth % 4;
        }

        if (tempWidth / 2 > 0)
        {
            width2x2 = tempWidth / 2;
            tempWidth = tempWidth % 2;
            width1x2 = tempWidth;
        }

        this.total1x2 = (width1x2 + length1x2) * height;
        this.total2x2 = (width2x2 + length2x2) * height;
        this.total4x2 = (width4x2 + length4x2) * height;
    }

    public int getTotal1x2()
    {
        return total1x2;
    }

    public int getTotal2x2()
    {
        return total2x2;
    }

    public int getTotal4x2()
    {
        return total4x2;
    }

}
