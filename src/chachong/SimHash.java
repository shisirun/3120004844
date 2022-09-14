package chachong;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import com.hankcs.hanlp.HanLP;

public class SimHash {
	 public static String getHash(String str){
	        try
	        {
	            // 这里使用了MD5获得hash值
	            MessageDigest mg = MessageDigest.getInstance("MD5");
	            byte[] input=str.getBytes("UTF-8");//将字符串变成byte数组
	            byte[] puff=mg.digest(input);//计算后获得字节数组
	            return new BigInteger(1, puff).toString(2);//转换成正的大数再转换成二进制
	        }catch(Exception e){
	            e.printStackTrace();
	            return str;
	        }
	    }

	public static String GetSimHash(String str) {
		/*System.out.println("检测");
		System.out.println(HanLP.segment("检测 hanlp"));*/
		// 用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
		
        int[] m = new int[128];
       
        List<String> keywords = HanLP.extractKeyword(str, str.length());//取出所有关键词,此处的关键词已经按照权重高低排序，出现次数多的关键词权重高
        // hash
        int size = keywords.size();
        int i = 0;
        for(String keyword : keywords)//从第一个关键词到最后一个关键词
        {
            //获取每个关键词的hash值
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) 
            {
                
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) 
                {
                    keywordHash += "0";//补齐128位
                }
            }
            for(int j=0;j<128;j++)
            {
            	if(keywordHash.charAt(j)=='1')
            	{
            		m[j]+=(100 - (i / (size / 100)));//排序在前面的说明出现的次数高，所以赋予的权重也高
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
        System.out.println("哈希:"+Simhash);
        return Simhash;
	}
	public static double haiming(String a,String b){
		double m=0;
		for(int i=0;i<128;i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				m++;
		}
		System.out.println("海明距离:"+m);
		System.out.println("相似度:"+(1 - m / 128));

	    return 0.01 * (100 - m * 100 / 128);
	}
}
