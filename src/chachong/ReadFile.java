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
	public static String read() {
		Scanner sc = new Scanner(System.in);
		//String path = null;
		System.out.println("输入路径:");
		String path = sc.next();
		File file = new File(path);
		if(path==null)
		{
			System.out.println("   ");
			return null;
		}
		
        //result 用来存放读取到的内容
        StringBuilder result = new StringBuilder();
        try{
        	/*
            BufferedReader br = new BufferedReader(new FileReader(file));*/
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
        }
        System.out.println(result.toString());
		return result.toString();
		
	}
	public static void write(double number)
	{
		String str = Double.toString(number);
		String path = "D:/Study/eclipse/eclipse-workspace/ChaChong/testtxt/number.txt";
		File file = new File(path);
		try {
			FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));
            fileWriter.write("\r\n");
            // 关闭资源
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
