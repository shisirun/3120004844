package chachong;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class shortstring {
	//用于短文本异常的测试
	@Test
	void testGetSimHash() {
		String str1="今天是星期天，天气晴，今天晚上我要去看电影";
		String str2="今天是周天，天气晴朗，我晚上要去看电影";
		SimHash.GetSimHash(str1);
		
	}

}
