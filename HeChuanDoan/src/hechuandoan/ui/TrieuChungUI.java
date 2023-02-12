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
import hechuandoan.io.DocFileTrieuChung;
import hechuandoan.io.DocLuat;
import hechuandoan.model.Luat;
import hechuandoan.model.TrieuChung;

public class TrieuChungUI extends JFrame{
	DefaultTableModel dtmTC;
	JTable tblTC;
	JTextField txtMaTC,txtTenTC;
	JButton btnThem,btnLuu,btnXoa;
	DocFileTrieuChung doc=new DocFileTrieuChung();
	ArrayList<TrieuChung> dsTC=new ArrayList<TrieuChung>();
	public TrieuChungUI(String title) {
		super(title);
		addControl();
		addEvent();
	}

	private void addControl() {
		Container conn=getContentPane();
		conn.setLayout(new BorderLayout());
		dtmTC=new DefaultTableModel();
		dtmTC.addColumn("Mã Triệu Chứng");
		dtmTC.addColumn("Tên Triệu Chứng");
		tblTC=new JTable(dtmTC);
		JScrollPane scTblSD=new JScrollPane(tblTC, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tblTC.setPreferredSize(new Dimension(600, 400));
		conn.add(scTblSD,BorderLayout.NORTH);
		
		
		JPanel pnCenter=new JPanel();
		pnCenter.setLayout(new BorderLayout());
		
		JPanel pnThongTin_1=new JPanel();
		JLabel lblVePhai=new JLabel("Mã Triệu Chứng");
		JLabel lblVeTrai=new JLabel("Tên Triệu Chứng");
		pnThongTin_1.add(lblVePhai);
		txtMaTC=new JTextField(10);
		pnThongTin_1.add(txtMaTC);
		pnThongTin_1.add(lblVeTrai);
		txtTenTC=new JTextField(10);
		pnThongTin_1.add(txtTenTC);

	
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.Y_AXIS));
		btnLuu=new JButton("Lưu   ");
		btnThem=new JButton("Thêm ");
		btnXoa=new JButton("Xóa   ");
		
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
		
		hienThiTrieuchung();
	}
	protected void hienThiTrieuchung() {
		dtmTC.setRowCount(0);
		dsTC=doc.docTrieuChung("Data/TrieuChung.txt");
		for (TrieuChung trieuChung : dsTC) {
			Vector<String> vec=new Vector<String>();
			vec.add(trieuChung.getMaTC());
			vec.add(trieuChung.getTenTC());
			dtmTC.addRow(vec);
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
