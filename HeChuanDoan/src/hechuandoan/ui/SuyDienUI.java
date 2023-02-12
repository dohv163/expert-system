package hechuandoan.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import code.thuat.toan.SuyDienTienTest;
import code.thuat.toan.ThuatToan;

public class SuyDienUI extends JFrame{
	DefaultTableModel dtmSD;
	JTable tblSD;
	SuyDienTienTest sd=new SuyDienTienTest();
	public SuyDienUI(String title) {
		super(title);
		addControl();
	}

	private void addControl() {
		Container conn=getContentPane();
		conn.setLayout(new BorderLayout());
		JPanel pnSD=new JPanel();
		dtmSD=new DefaultTableModel();
		dtmSD.addColumn("Các bước suy diễn");
		tblSD=new JTable(dtmSD);
		JScrollPane scTblSD=new JScrollPane(tblSD, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
		conn.add(scTblSD,BorderLayout.CENTER);
		
		
	}

	public void addEvent() {
		// TODO Auto-generated method stub
		hienThiLuat();
	}
	private void hienThiLuat() {
		dtmSD.setRowCount(0);
		for (String string : sd.SD) {
			Vector<String> vec=new Vector<String>();
			vec.add(string);
			dtmSD.addRow(vec);
		}
	}

	public void showWindow() {
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
