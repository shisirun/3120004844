package chachong;
//用于正常读取写入文件的测试
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class ReadFileTest {

	@Test
	void testRead() {
		
		String str0=ReadFile.read("D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/orig.txt");
		System.out.println(str0);
	}

	@Test
	void testWrite() {
		ReadFile.write(0.11,"D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/answer.txt");
	}

}
