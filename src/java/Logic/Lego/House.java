/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Lego;

/**
 *
 * @author Martin Brandstrup
 */
public class House
{
    private int onex2;
    private int twox2;
    private int fourx2;
    
    private int length;
    private int width;
    private int height;

    public House(int length, int width, int height) throws IllegalArgumentException
    {
        if(height < 1 || length < 5 || width < 5)
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
        this.onex2 = 0*height;
        this.twox2 = 0*height;
        this.fourx2 = 0*height;
    }
}
