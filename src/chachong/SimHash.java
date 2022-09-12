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
	            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
	        }catch(Exception e){
	            e.printStackTrace();
	            return str;
	        }
	    }

	public static String GetSimHash(String str) {
		/*System.out.println("检测");
		System.out.println(HanLP.segment("检测 hanlp"));*/
		// 用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
		
        int[] v = new int[128];
        // 1、分词（使用了外部依赖hankcs包提供的接口）
        List<String> keywords = HanLP.extractKeyword(str, str.length());//取出所有关键词
        // hash
        int size = keywords.size();
        int i = 0;//以i做外层循环
        for(String keyword : keywords)
        {
            // 2、获取hash值
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) 
            {
                // hash值可能少于128位，在低位以0补齐
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
        System.out.println("哈希:"+Simhash);
        return Simhash;
	}
}
