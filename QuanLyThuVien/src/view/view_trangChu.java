package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.controller_dangNhap;
import controller.controller_trangChu;
import database.JDBCUtil;

public class view_trangChu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tF_nhapTenSachTimKiem;
	private JTextField tF_nhapTenTacGiaTimKiem;
	public static JTable table;
	private view_dangNhap view_DangNhap;
	public static DefaultTableModel modelTable;
	private view_themSach view_ThemSach;
	private ImageIcon icon_x;
	private ImageIcon icon_ok;
	private view_thayDoiThongTinSach viewThayDoiThongTinSach;

	public view_trangChu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(view_dangNhap.class.getResource("/icon/logo.png")));
		setTitle("QUẢN LÝ THƯ VIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 817);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ActionListener action = new controller_trangChu(this);

		JPanel panel_nouth = new JPanel();
		panel_nouth.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_nouth.setBounds(10, 11, 1092, 71);
		contentPane.add(panel_nouth);
		panel_nouth.setLayout(null);

		JButton btn_themSach = new JButton("THÊM SÁCH");
		btn_themSach.setBackground(SystemColor.controlHighlight);
		btn_themSach.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/add_book.png")));
		btn_themSach.setFont(new Font("Arial", Font.BOLD, 14));
		btn_themSach.setBounds(10, 11, 260, 49);
		btn_themSach.addActionListener(action);
		panel_nouth.add(btn_themSach);

		JButton btn_xoaSach = new JButton("XOÁ SÁCH");
		btn_xoaSach.setBackground(SystemColor.controlHighlight);
		btn_xoaSach.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/del_book.png")));
		btn_xoaSach.setFont(new Font("Arial", Font.BOLD, 14));
		btn_xoaSach.setBounds(280, 11, 260, 49);
		btn_xoaSach.addActionListener(action);
		panel_nouth.add(btn_xoaSach);

		JButton btn_thayDoiThongTinSach = new JButton("THAY ĐỔI THÔNG TIN SÁCH");
		btn_thayDoiThongTinSach.setBackground(SystemColor.controlHighlight);
		btn_thayDoiThongTinSach.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/change_book.png")));
		btn_thayDoiThongTinSach.setFont(new Font("Arial", Font.BOLD, 14));
		btn_thayDoiThongTinSach.setBounds(550, 11, 260, 49);
		btn_thayDoiThongTinSach.addActionListener(action);
		panel_nouth.add(btn_thayDoiThongTinSach);

		JButton btn_dangXuat = new JButton("ĐĂNG XUẤT");
		btn_dangXuat.setBackground(SystemColor.controlHighlight);
		btn_dangXuat.setBounds(822, 11, 260, 49);
		panel_nouth.add(btn_dangXuat);
		btn_dangXuat.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/logout.png")));
		btn_dangXuat.setFont(new Font("Arial", Font.BOLD, 14));
		btn_dangXuat.addActionListener(action);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(10, 93, 1092, 2);
		contentPane.add(separator);

		JPanel panel_timKiem = new JPanel();
		panel_timKiem.setBounds(10, 118, 1092, 115);
		contentPane.add(panel_timKiem);
		panel_timKiem.setLayout(null);

		JLabel lb_nhapTenSachTimKiem = new JLabel("TÊN SÁCH:");
		lb_nhapTenSachTimKiem.setHorizontalAlignment(SwingConstants.LEFT);
		lb_nhapTenSachTimKiem.setFont(new Font("Arial", Font.BOLD, 14));
		lb_nhapTenSachTimKiem.setBounds(417, 11, 142, 37);
		panel_timKiem.add(lb_nhapTenSachTimKiem);

		JLabel lb_nhapTenTacGiaTimKiem = new JLabel("TÊN TÁC GIẢ:");
		lb_nhapTenTacGiaTimKiem.setHorizontalAlignment(SwingConstants.LEFT);
		lb_nhapTenTacGiaTimKiem.setFont(new Font("Arial", Font.BOLD, 14));
		lb_nhapTenTacGiaTimKiem.setBounds(417, 67, 142, 37);
		panel_timKiem.add(lb_nhapTenTacGiaTimKiem);

		tF_nhapTenSachTimKiem = new JTextField();
		tF_nhapTenSachTimKiem.setBounds(569, 11, 250, 37);
		panel_timKiem.add(tF_nhapTenSachTimKiem);
		tF_nhapTenSachTimKiem.setColumns(10);

		tF_nhapTenTacGiaTimKiem = new JTextField();
		tF_nhapTenTacGiaTimKiem.setColumns(10);
		tF_nhapTenTacGiaTimKiem.setBounds(569, 67, 250, 37);
		panel_timKiem.add(tF_nhapTenTacGiaTimKiem);

		JButton btn_timKiem = new JButton("TÌM KIẾM");
		btn_timKiem.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/find.png")));
		btn_timKiem.setFont(new Font("Arial", Font.BOLD, 14));
		btn_timKiem.setBounds(856, 11, 226, 37);
		btn_timKiem.addActionListener(action);
		panel_timKiem.add(btn_timKiem);

		JLabel lb_logo = new JLabel("  QUẢN LÝ SÁCH HUSC");
		lb_logo.setFont(new Font("Arial", Font.BOLD, 17));
		lb_logo.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/logo_book.png")));
		lb_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_logo.setBounds(10, 11, 320, 93);
		panel_timKiem.add(lb_logo);
		
		JButton btn_huyTim = new JButton("HUỶ TÌM KIẾM");
		btn_huyTim.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/cancel_find.png")));
		btn_huyTim.setFont(new Font("Arial", Font.BOLD, 14));
		btn_huyTim.setBounds(856, 67, 226, 37);
		btn_huyTim.addActionListener(action);
		panel_timKiem.add(btn_huyTim);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setBounds(10, 252, 1092, 2);
		contentPane.add(separator_1);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 S\u00C1CH", "T\u00CAN S\u00C1CH", "T\u00C1C GI\u1EA2", "TH\u1EC2 LO\u1EA0I", "T\u00CCNH TR\u1EA0NG"
			}
		));
		table.setRowHeight(35);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 276, 1092, 401);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		contentPane.add(scrollPane);

		modelTable = (DefaultTableModel) table.getModel();

		JButton btn_traSach = new JButton("TRẢ SÁCH");
		btn_traSach.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/muon_sach.png")));
		btn_traSach.setFont(new Font("Arial", Font.BOLD, 14));
		btn_traSach.setBounds(811, 688, 291, 79);
		btn_traSach.addActionListener(action);
		contentPane.add(btn_traSach);

		JButton btn_muonSach = new JButton("MƯỢN SÁCH");
		btn_muonSach.setIcon(new ImageIcon(view_trangChu.class.getResource("/icon/borrow_book.png")));
		btn_muonSach.setFont(new Font("Arial", Font.BOLD, 14));
		btn_muonSach.setBounds(484, 688, 291, 79);
		btn_muonSach.addActionListener(action);
		contentPane.add(btn_muonSach);

		themSachVaoBang();

		// Icon
		icon_x = new ImageIcon(view_trangChu.class.getResource("/icon/x.png"));
		icon_ok = new ImageIcon(view_trangChu.class.getResource("/icon/icon_ok.png"));
	}

	public void dangXuat() {
		view_DangNhap = new view_dangNhap();
		view_DangNhap.setVisible(true);
		this.setVisible(false);
	}

	public static void themSachVaoBang() {
		String query = "SELECT maSach, tenSach, tacGia, theLoai, tinhTrang FROM sach";
		try (ResultSet rs = JDBCUtil.ketNoiCSDL(query)) {
			while (rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String tacGia = rs.getString("tacGia");
				String theLoai = rs.getString("theLoai");
				int tinhTrang = rs.getInt("tinhTrang");
				String tinhTrangStr = (tinhTrang == 0) ? "Chưa được mượn" : "Đang được mượn";
				modelTable.addRow(new Object[] { maSach, tenSach, tacGia, theLoai, tinhTrangStr });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void themSach() {
		view_ThemSach = new view_themSach();
		view_ThemSach.setVisible(true);
		view_ThemSach.setLocationRelativeTo(contentPane);
	}

	public void xoaSach() {
		int row = table.getSelectedRow();
		if (row != -1) { // Kiểm tra có hàng nào được chọn không
			int luaChon = JOptionPane.showConfirmDialog(this, "BẠN CÓ MUỐN XOÁ SÁCH ĐÃ CHỌN KHÔNG?", "THÔNG BÁO!",
					JOptionPane.YES_NO_OPTION);
			if (luaChon == JOptionPane.YES_OPTION) {
				String maSach = table.getValueAt(row, 0).toString();
				String queryXoaSach = "DELETE FROM sach WHERE maSach = " + maSach;
				try (Connection cn = JDBCUtil.getConnection();
						PreparedStatement stmt = cn.prepareStatement(queryXoaSach)) {
					int rowDel = stmt.executeUpdate();
					if (rowDel > 0) {
						JOptionPane.showMessageDialog(this, "XOÁ SÁCH THÀNH CÔNG!", "THÔNG BÁO!",
								JOptionPane.INFORMATION_MESSAGE, icon_ok);
						while (modelTable.getRowCount() != 0) {
							modelTable.removeRow(0);
						}
						themSachVaoBang();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MỘT SÁCH MÀ BẠN MUỐN XOÁ!", "THÔNG BÁO!",
					JOptionPane.ERROR_MESSAGE, icon_x);
		}
	}

	public void thayDoiThongTinSach() {
		int row = table.getSelectedRow();
		if(row != -1) {
			int luaChon = JOptionPane.showConfirmDialog(this, "BẠN CÓ MUỐN THAY ĐỔI THÔNG TIN SÁCH ĐÃ CHỌN KHÔNG?", "THÔNG BÁO!",
					JOptionPane.YES_NO_OPTION);
			if(luaChon == JOptionPane.YES_OPTION) {
	            int maSach = Integer.valueOf((String) modelTable.getValueAt(row, 0));
	            String tenSach = modelTable.getValueAt(row, 1) + "";
	            String tacGia = (String) modelTable.getValueAt(row, 2);
	            String theLoai = (String) modelTable.getValueAt(row, 3);
	            
				viewThayDoiThongTinSach = new view_thayDoiThongTinSach(maSach, tenSach, tacGia, theLoai);
				viewThayDoiThongTinSach.setVisible(true);
				viewThayDoiThongTinSach.setLocationRelativeTo(contentPane);
			}
		} else {
			JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MỘT SÁCH MÀ BẠN MUỐN THAY ĐỔI THÔNG TIN!", "THÔNG BÁO!",
					JOptionPane.ERROR_MESSAGE, icon_x);
		}
	}

	public void timKiem() {
		String tenSachTimKiem = tF_nhapTenSachTimKiem.getText();
		String tacGiaTimKiem = tF_nhapTenTacGiaTimKiem.getText();
		while (modelTable.getRowCount() != 0) {
			modelTable.removeRow(0);
		}
		String query = "SELECT maSach, tenSach, tacGia, theLoai, tinhTrang FROM sach WHERE tenSach = '"+tenSachTimKiem+"' AND tacGia = '"+tacGiaTimKiem+"'";
		try (ResultSet rs = JDBCUtil.ketNoiCSDL(query)) {
			while (rs.next()) {
				String maSach = rs.getString("maSach");
				String tenSach = rs.getString("tenSach");
				String tacGia = rs.getString("tacGia");
				String theLoai = rs.getString("theLoai");
				int tinhTrang = rs.getInt("tinhTrang");
				String tinhTrangStr = (tinhTrang == 0) ? "Chưa được mượn" : "Đang được mượn";
				modelTable.addRow(new Object[] { maSach, tenSach, tacGia, theLoai, tinhTrangStr });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTimKiem() {
		while (modelTable.getRowCount() != 0) {
			modelTable.removeRow(0);
		}
		themSachVaoBang();
	}

	public void muonSach() {
		int row = table.getSelectedRow();
		if(row != -1) {
			int maSach = Integer.valueOf((String) modelTable.getValueAt(row, 0));
			String tinhTrang = (String) modelTable.getValueAt(row, 4);
			if(tinhTrang.equals("Đang được mượn")) {
				JOptionPane.showMessageDialog(this, "SÁCH ĐANG ĐƯỢC MƯỢN!", "THÔNG BÁO!",
						JOptionPane.ERROR_MESSAGE, icon_x);
			} else {
				String query = "UPDATE sach SET tinhTrang = 1 WHERE maSach = "+maSach;
				try(Connection cn = JDBCUtil.getConnection(); PreparedStatement stmt = cn.prepareStatement(query)) {
					int rowUpdate = stmt.executeUpdate();
					if(rowUpdate > 0) {
						JOptionPane.showMessageDialog(this, "MƯỢN SÁCH THÀNH CÔNG!", "THÔNG BÁO!",
								JOptionPane.ERROR_MESSAGE, icon_ok);
						while (modelTable.getRowCount() != 0) {
							modelTable.removeRow(0);
						}
						themSachVaoBang();
					} else {
						JOptionPane.showMessageDialog(this, "MƯỢN SÁCH THẤT BẠI!", "THÔNG BÁO!",
								JOptionPane.ERROR_MESSAGE, icon_x);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MỘT SÁCH MÀ BẠN MUỐN MƯỢN!", "THÔNG BÁO!",
					JOptionPane.ERROR_MESSAGE, icon_x);
		}
	}

	public void traSach() {
		int row = table.getSelectedRow();
		if(row != -1) {
			int maSach = Integer.valueOf((String) modelTable.getValueAt(row, 0));
			String tinhTrang = (String) modelTable.getValueAt(row, 4);
			if(tinhTrang.equals("Chưa được mượn")) {
				JOptionPane.showMessageDialog(this, "SÁCH CHƯA ĐƯỢC MƯỢN!", "THÔNG BÁO!",
						JOptionPane.ERROR_MESSAGE, icon_x);
			} else {
				String query = "UPDATE sach SET tinhTrang = 0 WHERE maSach = "+maSach;
				try(Connection cn = JDBCUtil.getConnection(); PreparedStatement stmt = cn.prepareStatement(query)) {
					int rowUpdate = stmt.executeUpdate();
					if(rowUpdate > 0) {
						JOptionPane.showMessageDialog(this, "TRẢ SÁCH THÀNH CÔNG!", "THÔNG BÁO!",
								JOptionPane.ERROR_MESSAGE, icon_ok);
						while (modelTable.getRowCount() != 0) {
							modelTable.removeRow(0);
						}
						themSachVaoBang();
					} else {
						JOptionPane.showMessageDialog(this, "TRẢ SÁCH THẤT BẠI!", "THÔNG BÁO!",
								JOptionPane.ERROR_MESSAGE, icon_x);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MỘT SÁCH MÀ BẠN MUỐN TRẢ!", "THÔNG BÁO!",
					JOptionPane.ERROR_MESSAGE, icon_x);
		}
	}
}
