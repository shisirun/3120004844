package chachong;

public class main {
	public static void main(String[] args) {
		String str0=ReadFile.read();
		String str1=ReadFile.read();
	    //int i=54;
	    //ReadFile.write(i);
	    String str2=SimHash.GetSimHash(str0);
	    String str3=SimHash.GetSimHash(str1);
	    SimHash.haiming(str2, str3);
	}
}
