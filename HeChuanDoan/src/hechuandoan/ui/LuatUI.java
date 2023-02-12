package hechuandoan.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import code.thuat.toan.ThuatToan;
import hechuandoan.io.DocLuat;
import hechuandoan.model.Luat;

public class LuatUI extends JFrame{
	DefaultTableModel dtmLuat;
	JTable tblLuat;
	JTextField txtVePhai,txtVeTrai;
	JButton btnThem,btnLuu,btnXoa;
	DocLuat dl=new DocLuat();
	ArrayList<Luat> RULE=new ArrayList<Luat>();
	public LuatUI(String title) {
		super(title);
		addControl();
		addEvent();
	}

	private void addControl() {
		Container conn=getContentPane();
		conn.setLayout(new BorderLayout());
		dtmLuat=new DefaultTableModel();
		dtmLuat.addColumn("Vế trái");
		dtmLuat.addColumn("Vế phải");
		tblLuat=new JTable(dtmLuat);
		JScrollPane scTblSD=new JScrollPane(tblLuat, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		conn.add(scTblSD,BorderLayout.NORTH);
		
		
		JPanel pnCenter=new JPanel();
		pnCenter.setLayout(new BorderLayout());
		
		JPanel pnThongTin_1=new JPanel();
		JLabel lblVePhai=new JLabel("Vế Phải");
		JLabel lblVeTrai=new JLabel("Vế Trái");
		pnThongTin_1.add(lblVePhai);
		txtVePhai=new JTextField(10);
		pnThongTin_1.add(txtVePhai);
		pnThongTin_1.add(lblVeTrai);
		txtVeTrai=new JTextField(10);
		pnThongTin_1.add(txtVeTrai);

	
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.Y_AXIS));
		btnLuu=new JButton("Lưu  ");
		btnThem=new JButton("Thêm");
		btnXoa=new JButton("Xóa  ");
		
		btnLuu.setIcon(new ImageIcon("Icon/save.png"));
		btnThem.setIcon(new ImageIcon("Icon/add.png"));
		btnXoa.setIcon(new ImageIcon("Icon/delete.png"));
		
		pnButton.add(btnLuu);
		pnButton.add(btnThem);
		pnButton.add(btnXoa);

		
		pnCenter.add(pnThongTin_1,BorderLayout.WEST);
		pnCenter.add(pnButton,BorderLayout.EAST);
		
		conn.add(pnCenter,BorderLayout.CENTER);
	}

	public void addEvent() {
		// TODO Auto-generated method stub
		hienThiSD();
	}
	private void hienThiSD() {
		RULE=dl.docLuat("Data/luat.txt");
		dtmLuat.setRowCount(0);
		for (Luat luat : RULE) {
			Vector<String> vec=new Vector<String>();
			vec.add(luat.getVeTrai());
			vec.add(luat.getVePhai());
			dtmLuat.addRow(vec);
		}
		
	}

	public void showWindow() {
		this.setSize(600, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
