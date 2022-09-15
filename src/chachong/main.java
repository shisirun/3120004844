package chachong;

public class main {
	public static void main(String[] args) {
		String str0=ReadFile.read(args[0]);
		String str1=ReadFile.read(args[1]);
	    //int i=54;
	    //ReadFile.write(i);
	    String str2=SimHash.GetSimHash(str0);
	    String str3=SimHash.GetSimHash(str1);
	    //SimHash.haiming(str2, str3);
	    ReadFile.write(SimHash.haiming(str2, str3),args[2]);
	}
}
