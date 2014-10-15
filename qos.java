import java.io.*;
import java.util.Scanner;
public class qos {	
	static double Req[]=new double[2];
	static double AlphabetSafe[][]=new double[14][500];
	static double AlphabetPrice[][]=new double[14][500];	
	static int depth;
	
	public static void main(String[] args)throws Exception
	{
		File fs=new File("D://eclipse javaworkspace/lab 1/src/SERVICE.txt");
		FileInputStream fins=new FileInputStream(fs);
		InputStreamReader inrs=new InputStreamReader(fins);
		BufferedReader bfrs=new BufferedReader(inrs);
		FileOutputStream fout=new FileOutputStream("D://eclipse javaworkspace/lab 1/src/RESULT.txt");
		OutputStreamWriter outw=new OutputStreamWriter(fout);
		BufferedWriter bfw=new BufferedWriter(outw);
		int i=0;
		int i4=0;		
		String temp="";//临时行数据。
		String[] tempArr={};
		String tempSafe="";
		String tempPrice="";		
		double Safe[]=new double[7000];
		double Price[]=new double[7000];			
		while((temp=bfrs.readLine())!=null)
		{
			tempArr=temp.split("[ ]+");
			tempSafe=tempArr[2];
			Double dsafe  = Double.parseDouble(tempSafe);
			Safe[i]=dsafe;
			tempPrice=tempArr[4];
			Double dprice = Double.parseDouble(tempPrice);
			Price[i]=dprice;
			i=i+1;
		}
		for(int i2=0;i2<14;i2++)
		{
			for(int i3=0;i3<500;i3++)
			{
				AlphabetSafe[i2][i3]=Safe[i4+i3];
				AlphabetPrice[i2][i3]=Price[i4+i3];
			}
			i4=i4+500;
		}//以二维数组AlphabetSafe[][] AlphabetPrice[][]形式保存数据 前面代表字母 后面代表序号
		//System.out.println(AlphabetPrice[8][135]);		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//System.out.print("请输入DAG形式的服务流程：");
		//Scanner sc = new Scanner(System.in);
		//temp = sc.nextLine();
		temp="(A,B),(A,C),(C,D),(C,E),(C,F),(B,G),(D,G),(E,H),(F,I),(F,J),(G,K),(H,K),(K,L),(I,L),(J,L),(G,M),(I,M),(M,N),(L,N)";
		temp=temp.replaceAll("\\(","");
		temp=temp.replaceAll("\\,","");
		temp=temp.replaceAll("\\)","");
	    //去除重复
		temp = new StringBuffer(new StringBuffer(temp).reverse().toString().replaceAll( "(.)(?=.*\\1)", "")).reverse().toString(); 
		char[] c=temp.toCharArray();
		int Node[]=new int[c.length];		
		//以数字Node形式存储节点
		depth=c.length-1;
		for(i=0;i<c.length;i++)
		{
			Node[i] =(int)c[i]-65;
		System.out.print("节点列表："+Node[i]);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//System.out.print("请输入客户的QoS需求: ");
		//temp=sc.nextLine();
		temp="(0.4,80)";
		temp=temp.replaceAll("\\(","");
		temp=temp.replaceAll("\\,"," ");
		temp=temp.replaceAll("\\)","");
		tempArr=temp.split("[ ]+");
		Req[0]= Double.parseDouble(tempArr[0]);
		Req[1]= Double.parseDouble(tempArr[1]);
		System.out.print("您输入的QoS: "+Req[0]);
		System.out.println("  "+Req[1]);
		qos q=new qos();
		//以数组Req形式储存客户qos
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println(q.solve(Node,depth));  
		//sc.close();
	}	
	

	double Q=0,temp=0.5;
	int num=0;
	double Tp=0;
	double Tr=1;
	double find(int Num)
	{	double temp2=0;
		for(int ii=0;ii<500;ii++)
		{			
			if(AlphabetSafe[Num][ii]>Req[0]&&AlphabetPrice[Num][ii]<Req[1])
			{
				 Tr=Tr*AlphabetSafe[Num][ii];
				 Tp=(Tp+AlphabetPrice[Num][ii])/100;
				double temp=Tr-Tp/100;
			if (Q<temp)
				Q=temp;
			else 
			{
				Tr=Tr/AlphabetSafe[Num][ii];
				Tp=((Tp+AlphabetPrice[Num][ii])*100-AlphabetPrice[Num][ii])/100;
				temp=Tr-Tp/100;
			}
			}else continue;
		}return Q;
	}
	
	double solve(int Node[],int dep)
	{qos q2=new qos();
		for (int i = 0; i <= dep; i++)
		{
		System.out.println(q2.find(Node[i]));
		
	}return Q;
	}
	}
