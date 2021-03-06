/*
...@Author Hisham Maged
*/
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
public class CeaserCipher
{
	private File file;
	private String encryptedStr;
	private int[] key;
	public CeaserCipher(int... key)
	{
		this.key=new int[key.length];
		for(int i=0;i<key.length;i++)
		{
		this.key[i]=key[i];
		}
		this.encryptedStr=encrypt(getContent(),key);
	}
	public CeaserCipher(String str,int... key)
	{
		this.key=key;
		this.encryptedStr=encrypt(str,key);
	}	
	public CeaserCipher(File file,int... key)
	{
		this.key=key;
		this.encryptedStr=encrypt(getContent(file),key);
	}
	public CeaserCipher()
	{
	
	}
	public String getEncrypted()
	{
		return this.encryptedStr;
	}
	private File getFile()
	{
		JFileChooser chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		try{
		do
		{
			System.out.println("Please select a file to encrypt");
			chooser.showOpenDialog(null);	
		}while(chooser.getSelectedFile()==null);
		}catch(NullPointerException ex){System.out.println("Incorrect Respone"); return getFile();}
		return chooser.getSelectedFile();
	}
	private String getContent()
	{
		StringBuilder sb=null;
		try(BufferedReader input=new BufferedReader(new FileReader(getFile())))
		{
		sb=new StringBuilder();
		String line=null;
		while((line=input.readLine())!=null)
			sb.append(line);
		}catch(IOException ex){ex.printStackTrace();}
		return sb.toString();
	}
	private String getContent(File file)
	{
		StringBuilder sb=null;
		try(BufferedReader input=new BufferedReader(new FileReader(file)))
		{
		sb=new StringBuilder();
		String line=null;
		while((line=input.readLine())!=null)
			sb.append(line);
		}catch(IOException ex){ex.printStackTrace();}
		return sb.toString();
	}
	public String encrypt(String str, int... key)
	{
		if(key.length==0){key[0]=17;}
		StringBuilder sb=new StringBuilder(str);
		for(int i=0,n=sb.length(),j=0;i<n;i++,j=(j==0)?((key.length>1)?++j:0):--j)
		{
			if(Character.isAlphabetic(sb.charAt(i)))
			sb.setCharAt(i,((int)(Character.toUpperCase(sb.charAt(i)))+key[j]<91)?((char)(sb.charAt(i)+key[j])):((char)((sb.charAt(i)+key[j])-26)));
		}
		return sb.toString();
	}
	public String decrypt(String str)
	{
		if(key.length==0){key[0]=17;}
		StringBuilder sb=new StringBuilder(str);
		for(int i=0,n=sb.length(),j=0;i<n;i++,j=(j==0)?((key.length>1)?++j:0):--j)
		{
			if(Character.isAlphabetic(sb.charAt(i)))
			sb.setCharAt(i,((int)(Character.toUpperCase(sb.charAt(i)))-key[j]>=65)?((char)(sb.charAt(i)-key[j])):((char)((sb.charAt(i)-key[j])+26)));
		}
		return sb.toString();
	}
}