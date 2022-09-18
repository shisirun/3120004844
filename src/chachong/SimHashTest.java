package chachong;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class SimHashTest {

	@Test
	public void testGetHash() {//获取某个词的hash值
		String str0="软件工程";
		System.out.println(SimHash.getHash(str0));
	}

	@Test
	public void testGetSimHash() {
		String str1=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig.txt");
		String str2=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig_0.8_add.txt");
		System.out.println("文本1："+SimHash.GetSimHash(str1));
		System.out.println("文本2："+SimHash.GetSimHash(str2));
	}

	@Test
	public void testHaiming() {
		String str1=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig.txt");
		String str2=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig_0.8_add.txt");
		System.out.println(SimHash.haiming(SimHash.GetSimHash(str1),SimHash.GetSimHash(str2) ));
	}

}
