package chachong;

public class main {
	public static void main(String[] args) {
		String str0=ReadFile.read(args[0]);     //��ȡԭ��
		String str1=ReadFile.read(args[1]);     //��ȡ��Ϯ�ĵ�
	    //int i=54;
	    //ReadFile.write(i);
	    String str2=SimHash.GetSimHash(str0);   //��ȡԭ��hashֵ
	    String str3=SimHash.GetSimHash(str1);   //��ȡ��Ϯ�ı�hashֵ
	    //SimHash.haiming(str2, str3);
	    ReadFile.write(SimHash.haiming(str2, str3),args[2]);   //������hashֵ�ȶԺ������ı���
	    System.out.println("ִ����ϡ�");
	}
}
