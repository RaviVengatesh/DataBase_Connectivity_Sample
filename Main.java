package TreeSet;

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;


public class Main
{

	public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        FileReader fi=new FileReader("calllog.txt");
        BufferedReader br=new BufferedReader(fi);
        CallLog cal=new CallLog();
        TreeSet<String> li=new TreeSet<String>();
        String line1=null,line2=br.readLine().trim();
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        while(line1!=line2)
        {
        	li.add(line2);
        	line2=br.readLine();
        }
        Iterator it=li.iterator();
        String st1[]=new String[100];
        String st2[]=new String[100];
        String st3[][]=new String[100][2];
        int c1=0,c2=0,c3=0,count=1;
        while(it.hasNext())
        {
        	String str1[]=(it.next().toString()).split("[ ,]");
        	st1[c1]=str1[0];c1++;
        	st2[c2]=str1[1];c2++;
        }
        for(int i=0;i<c1;i++)
        {
        	if(i<c1-1&&st1[i].equals(st1[i+1]))
        	{
        		count++;
        	}
        	else
        	{
        		st3[c3][0]=st1[i];
        		st3[c3][1]=st2[i]+"("+count+")";
        		c3++;
        		count=1;
        	}
        }
        while(true)
        {
        	System.out.printf("%s\n%s\n%s\n","1)Call Log","2)Call Details","3)Exit");
        	System.out.println("Enter your choice");
        	int choice=sc.nextInt();
        	switch(choice)
        	{
        	case 1:
        	{
        		Iterator it1=li.iterator();
        		String s1="";
        		System.out.printf("%-20s %-20s %-20s %-20s\n","Contact Name","Contact Number","Call Starts","Call Ends");
    			while(it1.hasNext())
        		{
        			String str2[]=(it1.next().toString()).split("[ ,]");
        			if(s1.equals(str2[0])==true){}
        			else
        			{
        				s1=str2[0];
        				cal.setContactName(str2[0]);
        				cal.setPhoneNumber(str2[1]);
        				Date time=sf.parse(str2[2]+" "+str2[3]);
        				cal.setStartTime(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(time)));
        			    Date time2=sdf.parse(str2[4]+" "+str2[5]);
        			    cal.setEndTime(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(time2)));
        				System.out.printf("%-20s %-20s %-20s %-20s\n",cal.getContactName(),cal.getPhoneNumber(),new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(cal.getStartTime()),new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(cal.getEndTime()));
            		}
        		}
        		break;
        	}
        	case 2:
        	{
        		System.out.printf("%-20s%-20s","Contact Name","Contact Number");
        		for(int i=0;i<c3;i++)
        		{
        			cal.setContactName(st3[i][0]);
        			cal.setPhoneNumber(st3[i][1]);
        			System.out.printf("\n%-20s%-20s",cal.getContactName(),cal.getPhoneNumber());
        		}
        		System.out.println();
        		break;
        	}
        	case 3:
        	{
        		System.exit(0);
        	}
        	}
        }
    }
}

