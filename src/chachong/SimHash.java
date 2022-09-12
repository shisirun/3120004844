package chachong;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import com.hankcs.hanlp.HanLP;

public class SimHash {
	 public static String getHash(String str){
	        try
	        {
	            // ����ʹ����MD5���hashֵ
	            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
	        }catch(Exception e){
	            e.printStackTrace();
	            return str;
	        }
	    }

	public static String GetSimHash(String str) {
		/*System.out.println("���");
		System.out.println(HanLP.segment("��� hanlp"));*/
		// �������ʾ��������,ȡ128λ,�� 0 1 2 λ��ʼ��ʾ�Ӹ�λ����λ
		
        int[] v = new int[128];
        // 1���ִʣ�ʹ�����ⲿ����hankcs���ṩ�Ľӿڣ�
        List<String> keywords = HanLP.extractKeyword(str, str.length());//ȡ�����йؼ���
        // hash
        int size = keywords.size();
        int i = 0;//��i�����ѭ��
        for(String keyword : keywords)
        {
            // 2����ȡhashֵ
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) 
            {
                // hashֵ��������128λ���ڵ�λ��0����
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) 
                {
                    keywordHash += "0";
                }
            }
            for(int j=0;j<v.length;j++)
            {
            	if(keywordHash.charAt(j)=='1')
            	{
            		v[j]+=1;
            	}
            	else
            	{
            		v[j]-=1;
            	}
            }
            i++;
	     }
        String Simhash="";
        for(int j=0;j<v.length;j++)
        {
        	if(v[j]<=0)
        		Simhash+='0';
        	else Simhash+='1';
        }
        System.out.println("��ϣ:"+Simhash);
        return Simhash;
	}
}
