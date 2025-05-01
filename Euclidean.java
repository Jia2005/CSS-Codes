//Extended Euclidean Algorithm to find Multiplicative inverse of a number
import java.util.*;
public class Euclidean {
	public static void Inverse(int a, int b)
	{
		int q,r,r1,r2,t1=0,t2=1,t;
		if(a>b)
		{
			r1=a; r2=b;
		}
		else
		{
			r1=b; r2=a;
		}
		System.out.print("Q \t R1 \t R2 \t R \t T1 \t T2 \t T\n");
		while (r2>0)
		{
			q=r1/r2;
			r=r1-q*r2;
			t=t1-q*t2;
		    System.out.print(q+"\t "+r1+"\t\t "+r2+"\t\t "+r+"\t "+t1+"\t\t "+t2+"\t\t "+t);	
		    r1=r2;r2=r;
		    t1=t2;t2=t;
		System.out.println();
		}
		if(t1<0)
		{
		    t1=t1+26;
		}
		if(r1==1)
		{
			System.out.println("The multiplicative inverse of "+a+" is "+t1);
		}
		else
		{
		    System.out.println("The GCD of "+a+" and "+b+" is "+r1);
			System.out.println("We cannot find multiplicative index for this number");
		}		
	}
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value to find the multiplicative inverse of ");
		int r1 = sc.nextInt();
		System.out.println("Enter the 2nd number ");
		int r2 = sc.nextInt();
		Inverse(r1,r2);
	}
}
