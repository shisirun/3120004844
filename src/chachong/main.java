package chachong;

public class main {
	public static void main(String[] args) {
		String str0=ReadFile.read();
		String str1=ReadFile.read();
	    //int i=54;
	    //ReadFile.write(i);
	    SimHash.GetSimHash(str0);
	    SimHash.GetSimHash(str1);
	}
}
