package hechuandoan.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import hechuandoan.model.TrieuChung;

public class LuuTrieuChung {
	public static boolean luuTrieuChung(ArrayList<TrieuChung> dsTrieuChung,String path) {
		try {
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(dsTrieuChung);
			oos.close();
			fos.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean luuTC(ArrayList<TrieuChung> dsTC,String path) {
		try {
			FileOutputStream fos=new FileOutputStream(path);
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
			for (TrieuChung trieuChung : dsTC) {
				String line=trieuChung.getMaTC()+";"+trieuChung.getTenTC();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}
