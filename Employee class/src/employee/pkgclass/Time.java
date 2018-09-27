package employee.pkgclass;

public class Time
{    
    int hour;
    int min;
    int sec;
    
    // constructor
    Time()
    {
        hour = 0;
        min = 0;
        sec = 0;
    }
    Time( int h, int m, int s)
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
    public void increment()
    {
        sec++;
        if( sec == 60)
        {
            sec = 0;
            min++;
            if( min == 60)
            {
                min = 0;
                hour++;
                if ( hour ==24)
                    hour = 0;
            }
        }
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
    public boolean Equals(Time t)
    {
        if( hour == t.hour && min ==t.min && sec == t.sec)
            return true;
        else return false;
    }
    public boolean greater(Time t)
    {
        if (hour > t.hour)
            return true;
        else if( hour == t.hour )
            if( min> t.min)
                 return true;
            else if( min == t.min && sec > t.sec)
                 return true;
        return false;
    }
}