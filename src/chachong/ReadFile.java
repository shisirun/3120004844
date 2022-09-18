package chachong;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFile {
	public static String read(String path) {
		//Scanner sc = new Scanner(System.in);
		//String path = null;
		//System.out.println("����·��:");
		//String path = sc.next();
		File file = new File(path);
		/*
		if(path==null)
		{
			System.out.println("·������");
			return null;
		}*/
		
        //result ������Ŷ�ȡ��������
        StringBuilder result = new StringBuilder();
        try{
        	/*
            BufferedReader br = new BufferedReader(new FileReader(file));*/
        	if(path.length()==0)
        	{
        		System.out.println("·������");
        		return null;
        	}
        	FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            String s = null;
            //readLine()��ʾһ��һ�еĶ�ȡ����
            while ((s = br.readLine())!=null){
            //�����ݷ���result��
                result.append(System.lineSeparator()+s);
            }
            //�ر���Դ
            br.close();
        }catch (Exception e){
            e.printStackTrace();
            //System.out.println("·������");
        }
        //System.out.println(result.toString());
		return result.toString();
		
	}
	public static void write(double number,String path) 
	{
		String str = Double.toString(number);
		//String path = "D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/number.txt";
		File file = new File(path);
		try {
			if(path.length()==0)
        	{
        		System.out.println("·������");
        	}
			else
			{
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));      //д���ַ�����λ����������ַ���������
				fileWriter.write("\n");
				// �ر���Դ
				fileWriter.close();
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
