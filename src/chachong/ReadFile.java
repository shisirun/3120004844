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
		//System.out.println("输入路径:");
		//String path = sc.next();
		File file = new File(path);
		/*
		if(path==null)
		{
			System.out.println("路径有误");
			return null;
		}*/
		
        //result 用来存放读取到的内容
        StringBuilder result = new StringBuilder();
        try{
        	/*
            BufferedReader br = new BufferedReader(new FileReader(file));*/
        	if(path.length()==0)
        	{
        		System.out.println("路径有误！");
        		return null;
        	}
        	FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            String s = null;
            //readLine()表示一行一行的读取内容
            while ((s = br.readLine())!=null){
            //将内容放入result中
                result.append(System.lineSeparator()+s);
            }
            //关闭资源
            br.close();
        }catch (Exception e){
            e.printStackTrace();
            //System.out.println("路径有误！");
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
        		System.out.println("路径有误！");
        	}
			else
			{
				FileWriter fileWriter = new FileWriter(file, true);
				fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));      //写入字符串四位，否则就是字符串自身长度
				fileWriter.write("\n");
				// 关闭资源
				fileWriter.close();
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
