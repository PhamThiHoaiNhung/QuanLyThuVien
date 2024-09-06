package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.controller_thayDoiThongTinSach;
import controller.controller_themSach;
import database.JDBCUtil;

public class view_thayDoiThongTinSach extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tF_tenSach;
	public JTextField tF_tacGia;
	public JTextField tF_theLoai;
	private controller_themSach controller_themSach;
	private view_trangChu viewTrangChu;
	private int maSach;


	public view_thayDoiThongTinSach(int maSach, String tenSach, String tacGia, String theLoai) {
        this(); // Gọi constructor mặc định để thiết lập giao diện

        tF_tenSach.setText(tenSach);
        tF_tacGia.setText(tacGia);
        tF_theLoai.setText(theLoai);
        this.maSach = maSach;
    }

	public view_thayDoiThongTinSach() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(view_dangNhap.class.getResource("/icon/logo.png")));
		setTitle("QUẢN LÝ THƯ VIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 428);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setLayout(null);
		
		ActionListener action = new controller_thayDoiThongTinSach(this);
		
		JPanel panel_themSach = new JPanel();
		panel_themSach.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_themSach.setBounds(10, 11, 529, 367);
		contentPane.add(panel_themSach);
		panel_themSach.setLayout(null);
		
		JLabel lb_tenSach = new JLabel("TÊN SÁCH:");
		lb_tenSach.setFont(new Font("Arial", Font.BOLD, 14));
		lb_tenSach.setBounds(45, 80, 146, 41);
		panel_themSach.add(lb_tenSach);
		
		JLabel lb_tacGia = new JLabel("TÁC GIẢ:");
		lb_tacGia.setFont(new Font("Arial", Font.BOLD, 14));
		lb_tacGia.setBounds(45, 160, 118, 41);
		panel_themSach.add(lb_tacGia);
		
		JLabel lb_logo = new JLabel("THAY ĐỔI THÔNG TIN SÁCH");
		lb_logo.setIcon(new ImageIcon(view_thayDoiThongTinSach.class.getResource("/icon/change_book.png")));
		lb_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_logo.setFont(new Font("Arial", Font.BOLD, 17));
		lb_logo.setBounds(10, 11, 509, 61);
		panel_themSach.add(lb_logo);
		
		JLabel lb_theLoai = new JLabel("THỂ LOẠI:");
		lb_theLoai.setFont(new Font("Arial", Font.BOLD, 14));
		lb_theLoai.setBounds(45, 240, 118, 41);
		panel_themSach.add(lb_theLoai);
		
		JButton btn_them = new JButton("THAY ĐỔI THÔNG TIN");
		btn_them.setIcon(new ImageIcon(view_thayDoiThongTinSach.class.getResource("/icon/icon_ok.png")));
		btn_them.setFont(new Font("Arial", Font.BOLD, 14));
		btn_them.setBounds(103, 305, 227, 41);
		btn_them.addActionListener(action);
		panel_themSach.add(btn_them);
		
		JButton btn_huy = new JButton("HUỶ");
		btn_huy.setIcon(new ImageIcon(view_thayDoiThongTinSach.class.getResource("/icon/x.png")));
		btn_huy.setFont(new Font("Arial", Font.BOLD, 14));
		btn_huy.setBounds(352, 305, 146, 41);
		btn_huy.addActionListener(action);
		panel_themSach.add(btn_huy);
		
		tF_tenSach = new JTextField();
		tF_tenSach.setBounds(151, 80, 347, 41);
		panel_themSach.add(tF_tenSach);
		tF_tenSach.setColumns(10);
		
		tF_tacGia = new JTextField();
		tF_tacGia.setColumns(10);
		tF_tacGia.setBounds(151, 160, 347, 41);
		panel_themSach.add(tF_tacGia);
		
		tF_theLoai = new JTextField();
		tF_theLoai.setColumns(10);
		tF_theLoai.setBounds(151, 240, 347, 41);
		panel_themSach.add(tF_theLoai);
	}

	public void thayDoiThongTinSach() {
		DefaultTableModel modelTable = (DefaultTableModel) viewTrangChu.table.getModel();
		int row = viewTrangChu.table.getSelectedRow();
		String query = "UPDATE sach SET tenSach = '"+tF_tenSach.getText()+"', tacGia = '"+tF_tacGia.getText()+"', theLoai = '"+tF_theLoai.getText()+"' WHERE maSach = "+maSach;
		try(Connection cn = JDBCUtil.getConnection(); PreparedStatement stmt = cn.prepareStatement(query)) {
			int rowUpdate = stmt.executeUpdate();
			if(rowUpdate > 0) {
				JOptionPane.showMessageDialog(this, "THAY ĐỔI THÔNG TIN SÁCH THÀNH CÔNG!", "THÔNG BÁO!",
						JOptionPane.INFORMATION_MESSAGE, (new ImageIcon(view_thayDoiThongTinSach.class.getResource("/icon/icon_ok.png"))));
				while(viewTrangChu.modelTable.getRowCount()!=0) {
					viewTrangChu.modelTable.removeRow(0);
				}
				viewTrangChu.themSachVaoBang();
				this.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
