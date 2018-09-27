/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.pkgclass;

/**
 *
 * @author YannErv
 */
public class time1 {
    

   
    int hour;
    int min;
    int sec;
    
    // constructor
    time1()
    {
        hour = 0;
        min = 0;
        sec = 0;
    }
    time1( int h, int m, int s)
    {
        hour = h;
        min = m;
        sec = s;
    }
    
    public int getHour()
    {
        return hour;
    }
    public void setHour(int x)
    {
        hour = x;
    }
    public int getMin()
    {
        return min;
    }
    public void setMin(int x)
    {
        min = x;
    }
    public int getSec()
    {
        return sec;
    }
    public void setSec(int x)
    {
        sec = x;
    }
    public String ToString()
    {
         String str="";
        str = str + hour+":";
        if (hour < 10)
            str = "0"+ str;
        
        if ( min<10)
            str += "0"+min+":";
        else
            str += min+":";
        
        if( sec <10)
            str +="0"+sec;
        else
            str +=sec;
         return getHour() + ":" + getMin() + ":" + getSec();
    }
}
