
int maxdistance=-1;
for(int i=0;i<s.length();i++)
{
    for(int j=i+1;j<s.length();j++)
    {
        if(s.charAt(i)==s.charAt(j))
        maxdistance=Math.max(maxdistance,j-i-1);
    }
}
return maxdistance;
