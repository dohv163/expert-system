package hechuandoan.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import hechuandoan.model.TrieuChung;

public class DocFileTrieuChung {
	public static ArrayList<TrieuChung> trieuChung(String path){
		ArrayList<TrieuChung> dsTrieuChung=new ArrayList<TrieuChung>();
		try {
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			dsTrieuChung=(ArrayList<TrieuChung>) data;
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTrieuChung;
	}
	public static ArrayList<TrieuChung> docTrieuChung(String path){
		ArrayList<TrieuChung> dsTrieuChungs=new ArrayList<TrieuChung>();
		try {
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			String line=br.readLine();
			while (line !=null) {
				String arr[]=line.split(";");
				if (arr.length==2) {
					TrieuChung tc=new TrieuChung(arr[0], arr[1]);
					dsTrieuChungs.add(tc);
				}
				line=br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTrieuChungs;
	}
}
