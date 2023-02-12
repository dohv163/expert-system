package hechuandoan.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hechuandoan.model.Luat;

public class DocLuat {
	ArrayList<Luat> RULE=new ArrayList<Luat>();
	public ArrayList<Luat> docLuat(String path) {
		try {
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			String line=br.readLine();
			String arr[];
			while ( line !=null) {
	            arr=line.split("->");
	            RULE.add(new Luat(arr[0],arr[1]));
	            line=br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RULE;
	}
	public ArrayList<Luat> dsLuat(String path){
		ArrayList<Luat> dsLuat=new ArrayList<Luat>();
		try {
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			String line = br.readLine();
			String arr[];
			while (line != null) {
				arr=line.split("->");
				dsLuat.add(new Luat(arr[0], arr[1]));
				line=br.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLuat;
	}
}
