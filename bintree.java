void Math(char Letter, double TR, double TP)
{
Find find = new Find();
//System.out.println();
//System.out.println(Letter + " begin ");
if (Letter == 'K')////////////////////////////////
{
for (int i = find.FindStartPosition(Letter); i <= find.FindEndPosition(Letter); i++)
{
TR *= find.FindTR(i);
TP += find.FindTP(i);
if (TR >= 0.8 & TP <= 15)////////////////////
{
if (Q < TR - TP/100)
{
Q = TR - TP/100.0;
}
TR /= find.FindTR(i);//恢复当前值
TP -= find.FindTP(i);
System.out.println(TR + " " + TP + " "+ Q);
}
}
return;
}
for (int i = find.FindStartPosition(Letter); i <= find.FindEndPosition(Letter); i++)
{
TR *= find.FindTR(i);
TP += find.FindTP(i);

if (TR >= 0.8 & TP <= 15)//////////////////////
{
Math(find.FindNextLetter(Letter),TR,TP);
TR /= find.FindTR(i);//恢复当前值
TP -= find.FindTP(i);
}
else
{
TR /= find.FindTR(i);//恢复当前值
TP -= find.FindTP(i);
}
}
//System.out.println(TR + " " + TP + " " + Q);
return;
