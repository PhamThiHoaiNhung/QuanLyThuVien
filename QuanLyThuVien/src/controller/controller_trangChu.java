package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.view_trangChu;

public class controller_trangChu implements ActionListener{
	
	view_trangChu view_TrangChu;
	
	public controller_trangChu(view_trangChu view_TrangChu) {
		this.view_TrangChu = view_TrangChu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("ĐĂNG XUẤT")) {
			this.view_TrangChu.dangXuat();
		} else if(action.equals("THÊM SÁCH")) {
			this.view_TrangChu.themSach();
		} else if(action.equals("XOÁ SÁCH")) {
			this.view_TrangChu.xoaSach();
		} else if(action.equals("THAY ĐỔI THÔNG TIN SÁCH")) {
			this.view_TrangChu.thayDoiThongTinSach();
		} else if(action.equals("TÌM KIẾM")) {
			this.view_TrangChu.timKiem();
		} else if(action.equals("HUỶ TÌM KIẾM")) {
			this.view_TrangChu.huyTimKiem();
		} else if(action.equals("MƯỢN SÁCH")) {
			this.view_TrangChu.muonSach();
		} else if(action.equals("TRẢ SÁCH")) {
			this.view_TrangChu.traSach();
		}
	}
	
}
