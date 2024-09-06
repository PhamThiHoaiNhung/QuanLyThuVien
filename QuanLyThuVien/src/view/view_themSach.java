package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.controller_themSach;
import database.JDBCUtil;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class view_themSach extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tF_tenSach;
	private JTextField tF_tacGia;
	private JTextField tF_theLoai;
	private view_trangChu view_TrangChu;

	public view_themSach() {
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
		
		ActionListener action = new controller_themSach(this);
		
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
		
		JLabel lb_logo = new JLabel("THÊM SÁCH");
		lb_logo.setIcon(new ImageIcon(view_themSach.class.getResource("/icon/add_book.png")));
		lb_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_logo.setFont(new Font("Arial", Font.BOLD, 17));
		lb_logo.setBounds(10, 11, 509, 61);
		panel_themSach.add(lb_logo);
		
		JLabel lb_theLoai = new JLabel("THỂ LOẠI:");
		lb_theLoai.setFont(new Font("Arial", Font.BOLD, 14));
		lb_theLoai.setBounds(45, 240, 118, 41);
		panel_themSach.add(lb_theLoai);
		
		JButton btn_them = new JButton("THÊM");
		btn_them.setIcon(new ImageIcon(view_themSach.class.getResource("/icon/icon_ok.png")));
		btn_them.setFont(new Font("Arial", Font.BOLD, 14));
		btn_them.setBounds(184, 305, 146, 41);
		btn_them.addActionListener(action);
		panel_themSach.add(btn_them);
		
		JButton btn_huy = new JButton("HUỶ");
		btn_huy.setIcon(new ImageIcon(view_themSach.class.getResource("/icon/x.png")));
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

	public void themSach() {
		String tenSach = tF_tenSach.getText();
		String tacGia = tF_tacGia.getText();
		String theLoai = tF_theLoai.getText();
		String queryCheck = "SELECT EXISTS (SELECT 1 FROM sach WHERE tenSach = '"+tenSach+"' AND tacGia = '"+tacGia+"' AND theLoai = '"+theLoai+"')";
		if(tenSach!=null && tacGia!=null && theLoai!=null && tacGia.matches("[\\p{L}\\s]+") && theLoai.matches("[\\p{L}\\s]+")) {
			try(ResultSet rs = JDBCUtil.ketNoiCSDL(queryCheck)) {
				while(rs.next()) {
					boolean exists = rs.getBoolean(1);
					if(exists) {
						JOptionPane.showMessageDialog(this, "SÁCH ĐÃ CÓ TRONG THƯ VIỆN!", "THÔNG BÁO!",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(view_themSach.class.getResource("/icon/x.png")));
					} else {
						String query_themSach = "INSERT INTO sach(tenSach, tacGia, theLoai, tinhTrang) VALUES ('"+tenSach+"', '"+tacGia+"', '"+theLoai+"', 0)";
						try(Connection cn = JDBCUtil.getConnection(); PreparedStatement stmt = cn.prepareStatement(query_themSach)) {
							int rowInserted = stmt.executeUpdate();
							if(rowInserted > 0) {
								JOptionPane.showMessageDialog(this, "THÊM SÁCH THÀNH CÔNG!", "THÔNG BÁO!",
										JOptionPane.INFORMATION_MESSAGE, new ImageIcon(view_themSach.class.getResource("/icon/icon_ok.png")));
								tF_tenSach.setText("");
								tF_tacGia.setText("");
								tF_theLoai.setText("");
								while(view_TrangChu.modelTable.getRowCount()!=0) {
									view_TrangChu.modelTable.removeRow(0);
								}
								view_TrangChu.themSachVaoBang();
							} else {
								JOptionPane.showMessageDialog(this, "THÊM SÁCH KHÔNG THÀNH CÔNG!", "THÔNG BÁO!",
										JOptionPane.INFORMATION_MESSAGE, new ImageIcon(view_themSach.class.getResource("/icon/x.png")));
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(!tacGia.matches("[\\p{L}\\s]+") && !theLoai.matches("[\\p{L}\\s]+")) {
			JOptionPane.showMessageDialog(this, "THÔNG TIN NHẬP VÀO KHÔNG HỢP LỆ!", "THÔNG BÁO!",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(view_themSach.class.getResource("/icon/x.png")));
		}
		
		
	}

}
