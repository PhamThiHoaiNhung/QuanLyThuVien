package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import controller.controller_dangNhap;
import database.JDBCUtil;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class view_dangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tF_tenTaiKhoan;
	private JPasswordField tF_matKhau;
	private ImageIcon icon_x;
	private ImageIcon icon_ok;
	private view_trangChu View_trangChu;
	private ImageIcon dangKy;
	private JButton btn_hienMatKhau;
	private ImageIcon hienIcon;
	private ImageIcon anIcon;
	private boolean showPassword;

	public view_dangNhap() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(view_dangNhap.class.getResource("/icon/logo.png")));
		setTitle("QUẢN LÝ THƯ VIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 817);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pn_dangNhap = new JPanel();
		pn_dangNhap.setBackground(SystemColor.scrollbar);
		pn_dangNhap.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		pn_dangNhap.setBounds(347, 194, 497, 360);
		contentPane.add(pn_dangNhap);
		pn_dangNhap.setLayout(null);

		int x = (this.getWidth() - pn_dangNhap.getWidth()) / 2;
		int y = (this.getHeight() - pn_dangNhap.getHeight()) / 2;
		pn_dangNhap.setLocation(x, y);

		ActionListener action = new controller_dangNhap(this);

		JLabel lb_tenTaiKhoan = new JLabel("TÊN TÀI KHOẢN:");
		lb_tenTaiKhoan.setFont(new Font("Arial", Font.BOLD, 14));
		lb_tenTaiKhoan.setBounds(25, 62, 123, 47);
		pn_dangNhap.add(lb_tenTaiKhoan);

		JLabel lb_matKhau = new JLabel("MẬT KHẨU:");
		lb_matKhau.setFont(new Font("Arial", Font.BOLD, 14));
		lb_matKhau.setBounds(25, 120, 123, 47);
		pn_dangNhap.add(lb_matKhau);

		tF_tenTaiKhoan = new JTextField();
		tF_tenTaiKhoan.setBounds(174, 62, 282, 47);
		pn_dangNhap.add(tF_tenTaiKhoan);
		tF_tenTaiKhoan.setColumns(10);

		tF_matKhau = new JPasswordField();
		tF_matKhau.setColumns(10);
		tF_matKhau.setBounds(174, 120, 282, 47);
		pn_dangNhap.add(tF_matKhau);

		JButton btn_dangNhap = new JButton("ĐĂNG NHẬP");
		btn_dangNhap.setBackground(new Color(255, 255, 255));
		btn_dangNhap.setFont(new Font("Arial", Font.BOLD, 14));
		btn_dangNhap.setBounds(263, 188, 193, 47);
		btn_dangNhap.addActionListener(action);
		pn_dangNhap.add(btn_dangNhap);

		JButton btn_quenMatKhau = new JButton("QUÊN MẬT KHẨU");
		btn_quenMatKhau.setBackground(new Color(255, 255, 255));
		btn_quenMatKhau.setFont(new Font("Arial", Font.BOLD, 14));
		btn_quenMatKhau.setBounds(263, 283, 193, 47);
		btn_quenMatKhau.addActionListener(action);
		pn_dangNhap.add(btn_quenMatKhau);

		JButton btn_dangKy = new JButton("ĐĂNG KÝ");
		btn_dangKy.setBackground(new Color(255, 255, 255));
		btn_dangKy.setFont(new Font("Arial", Font.BOLD, 14));
		btn_dangKy.setBounds(25, 283, 193, 47);
		btn_dangKy.addActionListener(action);
		pn_dangNhap.add(btn_dangKy);

		hienIcon = new ImageIcon(view_dangNhap.class.getResource("/icon/hienMatKhau.png"));
		anIcon = new ImageIcon(view_dangNhap.class.getResource("/icon/anMatKhau.png"));
		btn_hienMatKhau = new JButton(anIcon);
		btn_hienMatKhau.setBounds(458, 133, 29, 23);
		btn_hienMatKhau.addActionListener(action);
		pn_dangNhap.add(btn_hienMatKhau);
		btn_hienMatKhau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showPassword = !showPassword;
				if (showPassword) {
					tF_matKhau.setEchoChar((char) 0); // Hiển thị mật khẩu
					btn_hienMatKhau.setIcon(hienIcon);
				} else {
					tF_matKhau.setEchoChar('•'); // Ẩn mật khẩu
					btn_hienMatKhau.setIcon(anIcon);
				}
			}
		});

		JPanel pn_logo = new JPanel();
		pn_logo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		pn_logo.setBounds(316, 63, 497, 127);
		contentPane.add(pn_logo);
		pn_logo.setLayout(new BorderLayout(0, 0));

		JLabel lb_logo = new JLabel("  QUẢN LÝ SÁCH HUSC");
		pn_logo.add(lb_logo);
		lb_logo.setIcon(new ImageIcon(view_dangNhap.class.getResource("/icon/logo_book.png")));
		lb_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_logo.setFont(new Font("Arial", Font.BOLD, 17));

		icon_x = new ImageIcon(view_dangNhap.class.getResource("/icon/x.png"));
		icon_ok = new ImageIcon(view_dangNhap.class.getResource("/icon/icon_ok.png"));
		dangKy = new ImageIcon(view_dangNhap.class.getResource("/icon/dangKy.png"));

		// Khởi tạo View_trangChu
		View_trangChu = new view_trangChu();
		View_trangChu.setVisible(false);
	}

	public void dangNhap() {
		String tenTaiKhoan = tF_tenTaiKhoan.getText();
		String matKhau = tF_matKhau.getText();
		String query = "SELECT EXISTS (SELECT 1 FROM taikhoan WHERE tenTaiKhoan = '" + tenTaiKhoan + "' AND matKhau = '"
				+ matKhau + "')";
		try (ResultSet rs = JDBCUtil.ketNoiCSDL(query)) {
			while (rs.next()) {
				boolean exists = rs.getBoolean(1);
				if ((tenTaiKhoan.isEmpty() || tenTaiKhoan.isEmpty()) && (tenTaiKhoan.isEmpty() && tenTaiKhoan.isEmpty())) {
					JOptionPane.showMessageDialog(this, "TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG ĐƯỢC ĐỂ TRỐNG!", "THÔNG BÁO!",
							JOptionPane.INFORMATION_MESSAGE, icon_x);
				} else if (exists) {
					JOptionPane.showMessageDialog(this, "ĐĂNG NHẬP THÀNH CÔNG!", "THÔNG BÁO",
							JOptionPane.INFORMATION_MESSAGE, icon_ok);
					this.setVisible(false);
					View_trangChu.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "TÀI KHOẢN HOẶC MẬT KHẨU SAI!", "THÔNG BÁO",
							JOptionPane.INFORMATION_MESSAGE, icon_x);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dangKy() {
		String input_taiKhoan = (String) JOptionPane.showInputDialog(this, "NHẬP TÊN TÀI KHOẢN: ", "ĐĂNG KÝ",
				JOptionPane.INFORMATION_MESSAGE, dangKy, null, null);
		String query = "SELECT EXISTS (SELECT 1 FROM taikhoan WHERE tenTaiKhoan = '" + input_taiKhoan + "')";
		try (ResultSet rs = JDBCUtil.ketNoiCSDL(query)) {
			while (rs.next()) {
				boolean exists = rs.getBoolean(1);
				if (exists) {
					JOptionPane.showMessageDialog(this, "TÀI KHOẢN ĐÃ TỒN TẠI!", "THÔNG BÁO!",
							JOptionPane.INFORMATION_MESSAGE, icon_x);
				} else if (input_taiKhoan == null) {
					JOptionPane.showMessageDialog(this, "TÀI KHOẢN KHÔNG ĐƯỢC ĐỂ TRỐNG!", "THÔNG BÁO!",
							JOptionPane.INFORMATION_MESSAGE, icon_x);
				} else {
					String input_matKhau = (String) JOptionPane.showInputDialog(this, "NHẬP MẬT KHẨU: ", "ĐĂNG KÝ",
							JOptionPane.INFORMATION_MESSAGE, dangKy, null, null);
					String query_insertTaiKhoan = "INSERT INTO taikhoan VALUES ('" + input_taiKhoan.trim() + "', '"
							+ input_matKhau + "')";
					try (Connection cn = JDBCUtil.getConnection();
							PreparedStatement stmt = cn.prepareStatement(query_insertTaiKhoan)) {
						int rowsInserted = stmt.executeUpdate();
						if (rowsInserted > 0) {
							JOptionPane.showMessageDialog(this, "ĐĂNG KÝ THÀNH CÔNG!", "THÔNG BÁO!",
									JOptionPane.INFORMATION_MESSAGE, icon_ok);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void quenMatKhau() {
		String input_taiKhoan = (String) JOptionPane.showInputDialog(this, "NHẬP TÊN TÀI KHOẢN: ", "ĐĂNG KÝ",
				JOptionPane.INFORMATION_MESSAGE, dangKy, null, null);
		String query = "SELECT EXISTS (SELECT 1 FROM taikhoan WHERE tenTaiKhoan = '" + input_taiKhoan + "')";
		try (ResultSet rs = JDBCUtil.ketNoiCSDL(query)) {
			while (rs.next()) {
				boolean exists = rs.getBoolean(1);
				if (input_taiKhoan == null) {
					JOptionPane.showMessageDialog(this, "TÀI KHOẢN KHÔNG ĐƯỢC ĐỂ TRỐNG!", "THÔNG BÁO!",
							JOptionPane.INFORMATION_MESSAGE, icon_x);
				} else if (!exists) {
					JOptionPane.showMessageDialog(this, "TÀI KHOẢN KHÔNG TỒN TẠI!", "THÔNG BÁO!",
							JOptionPane.INFORMATION_MESSAGE, icon_x);
				} else if (exists) {
					String input_matKhau = (String) JOptionPane.showInputDialog(this, "NHẬP MẬT KHẨU MỚI: ", "ĐĂNG KÝ",
							JOptionPane.INFORMATION_MESSAGE, dangKy, null, null);
					String query_thayDoiMatKhau = "UPDATE taikhoan set matKhau = '" + input_matKhau
							+ "' WHERE tenTaiKhoan = '" + input_taiKhoan + "'";
					try (Connection cn = JDBCUtil.getConnection();
							PreparedStatement stmt = cn.prepareStatement(query_thayDoiMatKhau)) {
						int rowsInserted = stmt.executeUpdate();
						if (rowsInserted > 0) {
							JOptionPane.showMessageDialog(this, "ĐỔI MẬT KHẨU THÀNH CÔNG!", "THÔNG BÁO!",
									JOptionPane.INFORMATION_MESSAGE, icon_ok);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
