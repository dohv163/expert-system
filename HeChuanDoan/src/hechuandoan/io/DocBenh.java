package hechuandoan.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hechuandoan.model.Benh;

public class DocBenh {
	public ArrayList<Benh> docBenh(String path) {
		ArrayList<Benh> dsBenh=new ArrayList<Benh>();
		try {
			
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			String line=br.readLine();
			
			while (line !=null) {
				String arr[]=line.split(";");
				dsBenh.add(new Benh(arr[0], arr[1]));
				line=br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsBenh;
	}
}
