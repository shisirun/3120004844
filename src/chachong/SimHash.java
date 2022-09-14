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
	            MessageDigest mg = MessageDigest.getInstance("MD5");
	            byte[] input=str.getBytes("UTF-8");//���ַ������byte����
	            byte[] puff=mg.digest(input);//��������ֽ�����
	            return new BigInteger(1, puff).toString(2);//ת�������Ĵ�����ת���ɶ�����
	        }catch(Exception e){
	            e.printStackTrace();
	            return str;
	        }
	    }

	public static String GetSimHash(String str) {
		/*System.out.println("���");
		System.out.println(HanLP.segment("��� hanlp"));*/
		// �������ʾ��������,ȡ128λ,�� 0 1 2 λ��ʼ��ʾ�Ӹ�λ����λ
		
        int[] m = new int[128];
       
        List<String> keywords = HanLP.extractKeyword(str, str.length());//ȡ�����йؼ���,�˴��Ĺؼ����Ѿ�����Ȩ�ظߵ����򣬳��ִ�����Ĺؼ���Ȩ�ظ�
        // hash
        int size = keywords.size();
        int i = 0;
        for(String keyword : keywords)//�ӵ�һ���ؼ��ʵ����һ���ؼ���
        {
            //��ȡÿ���ؼ��ʵ�hashֵ
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) 
            {
                
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) 
                {
                    keywordHash += "0";//����128λ
                }
            }
            for(int j=0;j<128;j++)
            {
            	if(keywordHash.charAt(j)=='1')
            	{
            		m[j]+=(100 - (i / (size / 100)));//������ǰ���˵�����ֵĴ����ߣ����Ը����Ȩ��Ҳ��
            	}
            	else
            	{
            		m[j]-=(100 - (i / (size / 100)));
            	}
            }
            i++;
	     }
        String Simhash="";
        for(int j=0;j<128;j++)
        {
        	if(m[j]<=0)
        		Simhash+='0';
        	else Simhash+='1';
        }
        System.out.println("��ϣ:"+Simhash);
        return Simhash;
	}
	public static double haiming(String a,String b){
		double m=0;
		for(int i=0;i<128;i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				m++;
		}
		System.out.println("��������:"+m);
		System.out.println("���ƶ�:"+(1 - m / 128));

	    return 0.01 * (100 - m * 100 / 128);
	}
}
