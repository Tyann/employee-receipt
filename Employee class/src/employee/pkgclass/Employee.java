package employee.pkgclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Employee
{
	private String name = "";
	private int idNumber = 0;
	private String dept = "";
	private double rate = 0;
	
	public Employee()
	{}

	public Employee(String name, int id)
	{
		this.name = name;
		this.idNumber = id;
	}

	public Employee(String name, int id, String dept, double rate)
	{
		this.name = name;
		this.idNumber = id;
		this.dept = dept;
		this.rate = rate;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getIdNumber()
	{
		return idNumber;
	}

	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
	}

	public String getDept()
	{
		return dept;
	}

	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public double getRate()
	{
		return rate;
	}

	public void setRate(double rate)
	{
		this.rate = rate;
	}
	
	public double calculatePay(double hoursWorked)
	{
		return hoursWorked * rate;
	}

	public String printRecord()
	{
		return name + "\t" + idNumber + "\t" + dept + "\t" + rate;
	}

	public static void main(String[] args) throws IOException
	{
		File employeeList = new File("Employees.txt");
		Scanner content = new Scanner(employeeList);
		
		while(content.hasNextLine())
		{
			String line = content.nextLine();
			String[] spaces = line.split("\t");
			String name = spaces[0];
			int idNumber = Integer.parseInt(spaces[1]);
			String dept = spaces[2];
			double rate = Double.parseDouble(spaces[3]);
			
			Employee employee = new Employee(name, idNumber, dept, rate);
			
			String startString = JOptionPane.showInputDialog("Enter when " + name + " had started working.");
                        String endString = JOptionPane.showInputDialog("Enter when " + name + " had ended working.");
                        
                        // 2PM, 8AM, 9AM, 10AM, 12PM, 5PM
			int hourStarted = timeToHours(startString);
			int hourEnded = timeToHours(endString);

                        Time start = new Time(hourStarted, 0, 0);
                        Time end = new Time(hourEnded, 0, 0);
                        Time temp = new Time();
                        
                        while(!start.Equals(end))
                        {
                            start.increment();
                            temp.increment();
                        }
                        System.out.println(temp.ToString());
			JOptionPane.showMessageDialog(null, name + " has earned " + NumberFormat.getCurrencyInstance().format(employee.calculatePay(temp.hour)));
		}
		
		content.close();
	}
        
        public static int timeToHours(String s)
        {
            s = s.toLowerCase();
            if(s.endsWith("am"))
            {
                return Integer.parseInt(s.substring(0, s.length() - 2));
            }
            else if(s.endsWith("pm"))
            {
                int h = Integer.parseInt(s.substring(0, s.length() - 2));
                if(h != 12)
                {
                    return h + 12;
                }
                else
                {
                    return h;
                }
            }
            return -1;
        }
}