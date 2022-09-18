package chachong;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//用于测试所有方法
class mainTest {

	@Test
	public void testMain() {
		String str1=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig.txt");
		String str2=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig_0.8_add.txt");
		ReadFile.write((SimHash.haiming(SimHash.GetSimHash(str1),SimHash.GetSimHash(str2))),"D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/answer.txt");
	}

}
