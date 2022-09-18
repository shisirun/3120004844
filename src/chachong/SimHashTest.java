package chachong;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class SimHashTest {

	@Test
	public void testGetHash() {//��ȡĳ���ʵ�hashֵ
		String str0="�������";
		System.out.println(SimHash.getHash(str0));
	}

	@Test
	public void testGetSimHash() {
		String str1=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig.txt");
		String str2=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig_0.8_add.txt");
		System.out.println("�ı�1��"+SimHash.GetSimHash(str1));
		System.out.println("�ı�2��"+SimHash.GetSimHash(str2));
	}

	@Test
	public void testHaiming() {
		String str1=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig.txt");
		String str2=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig_0.8_add.txt");
		System.out.println(SimHash.haiming(SimHash.GetSimHash(str1),SimHash.GetSimHash(str2) ));
	}

}
