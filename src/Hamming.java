import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hamming {
    public static void main(String[] args) {
        try
        {
            BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the number of bits: ");
            int n=Integer.parseInt(buf.readLine()); String str=buf.readLine(); if(str.length()<=n)
        {
            char [] s=str.toCharArray();
            int i;
            System.out.print("The Input is: ");
            for(i=0;i<s.length;i++)
            {
                System.out.print(s[i]); }
            System.out.println();
            int j=1,r,m=1,m1=1;
            r=str.length(); r=r+1; m=1;
            while(m<=m1)
            {
                m1=r+j;
                m=m*2;
                j++; } int red=j-1,l;
            System.out.println(" bits to be added: "+red); int m9=s.length+red+1; char[]s1=new char[m9];
            for(i=0;i<s1.length;i++)
            {
                s1[i]='3';
            }
            System.out.println("total length"+s1.length);
            s1[1]='2'; l=1;
            for(i=1;i<red;i++)
            {
                l=2*l;
                s1[l]='2';
            } for(i=s1.length-1;i>0;i--)
        {
            System.out.print(s1[i]); }
            System.out.println();
            for(i=s1.length-1,j=0;i>0;i--)
            {
                if(s1[i]!='2')
                {
                    s1[i]=s[j]; j++;
                }
            }
            System.out.println("The output is: "); for(i=s1.length-1;i>0;i--)
        {
            System.out.print(s1[i]); }
            System.out.println(); int odd=0,even=0;
            l=1;
            for(i=1;i<=red;i++)
            {
                odd=0;
                for(j=1;j<s1.length;j++)
                {
                    if(s1[j]!='2')
                    {
                        int c; c=j&i;

                        if(c!=0)
                        {
                            char c1=s1[j]; if(c1=='1')
                            odd++;
                        }
                    }
                }
                if(odd%2==0) s1[l]='0';
                else
                    s1[l]='1';
                l=l*2;
            }

            System.out.println("The output is: ");
            for(i=s1.length-1;i>0;i--)
            {
                System.out.print(s1[i]); }
            System.out.println();
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
