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
public class LegoHouseCalculator
{

    private int total1x2;
    private int total2x2;
    private int total4x2;

    private int length;
    private int width;
    private int height;

    public LegoHouseCalculator(int length, int width, int height) throws IllegalArgumentException
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
        int modulus = 0;
        int tempLength = length - 4; //-4 to avoid counting corners twice
        int tempWidth = width;
        int length4x2;
        int length2x2;
        int length2x1;
        int width4x2;
        int width2x2;
        int width1x2;

        if (tempLength / 4 > 0)
        {
            length4x2 = tempLength / 4;
        }

        this.total1x2 = 0 * height;
        this.total2x2 = 0 * height;
        this.total4x2 = 0 * height;
    }

    public int getOnex2()
    {
        return total1x2;
    }

    public int getTwox2()
    {
        return total2x2;
    }

    public int getFourx2()
    {
        return total4x2;
    }

}
