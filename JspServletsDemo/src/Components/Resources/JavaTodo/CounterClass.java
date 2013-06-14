package Components.Resources.JavaTodo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CounterClass
{
	public int  getCount()
	{
		FileReader fileReader = null ; 
		FileWriter fileWriter = null ;   
		BufferedReader bufferedReader = null ; 
		PrintWriter printWriter = null ; 
		int count =0 ; 
		try{
			File file=new File("C:\\Users\\galernik\\Desktop\\Java Oracle Tutorial Code Snipsets\\Files\\nostra.txt");
			if(!file.exists())
			{
				file.createNewFile() ; 
				fileWriter = new FileWriter(file); 
				printWriter = new PrintWriter(fileWriter) ; 
				printWriter.println(0) ; 
				fileWriter.close() ; 
				printWriter.close()  ; 
			}
			bufferedReader = new BufferedReader(new FileReader(file)) ; 
			count = Integer.parseInt(bufferedReader.readLine()); 
		}catch(Exception e){
			System.out.println(e);
			if(!(bufferedReader==null)){
				try {
					bufferedReader.close() ;
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
			 
		}
		return count ; 
	}
	
	public void save(int count) throws Exception{
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		fileWriter = new FileWriter("FileCounter.initial");
		printWriter = new PrintWriter(fileWriter);
		printWriter.println(count);
		if(printWriter != null) {
			printWriter.close();
		}
	}
	
}

