package chachong;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class shortstring {
	//���ڶ��ı��쳣�Ĳ���
	@Test
	void testGetSimHash() {
		String str1="�����������죬�����磬����������Ҫȥ����Ӱ";
		String str2="���������죬�������ʣ�������Ҫȥ����Ӱ";
		SimHash.GetSimHash(str1);
		
	}

}
