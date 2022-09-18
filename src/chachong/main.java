package chachong;

public class main {
	public static void main(String[] args) {
		String str0=ReadFile.read(args[0]);     //读取原文
		String str1=ReadFile.read(args[1]);     //读取抄袭文档
	    //int i=54;
	    //ReadFile.write(i);
	    String str2=SimHash.GetSimHash(str0);   //获取原本hash值
	    String str3=SimHash.GetSimHash(str1);   //获取抄袭文本hash值
	    //SimHash.haiming(str2, str3);
	    ReadFile.write(SimHash.haiming(str2, str3),args[2]);   //将两个hash值比对后输入文本中
	    System.out.println("执行完毕。");
	}
}
