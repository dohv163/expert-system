package hechuandoan.controller;

import java.util.ArrayList;
import java.util.Arrays;

import hechuandoan.io.DocBenh;
import hechuandoan.model.Benh;

public class LayBenhTheoMa {
	DocBenh docBenh=new DocBenh();
	ArrayList<Benh> dsBenhTheoMa=new ArrayList<Benh>();
	ArrayList<Benh> dsBenh=new ArrayList<Benh>();
	public ArrayList<Benh> layBenhTheoMa(ArrayList<String> dsMa){
		dsBenh=docBenh.docBenh("Data/Benh.txt");
		try {
				for (int i = 0; i < dsBenh.size(); i++) {
					for (int j = 0; j < dsMa.size(); j++) {
						if (dsBenh.get(i).getMaBenh().equalsIgnoreCase(dsMa.get(j))) {
							dsBenhTheoMa.add(new Benh(dsBenh.get(i).getMaBenh(), dsBenh.get(i).getTenBenh()));
						}
					}
				}
				return dsBenhTheoMa;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
