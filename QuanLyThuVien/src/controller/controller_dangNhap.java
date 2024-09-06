package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.view_dangNhap;

public class controller_dangNhap implements ActionListener {
	view_dangNhap view;
	
	
	public controller_dangNhap(view_dangNhap view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("ĐĂNG NHẬP")) {
			this.view.dangNhap();
		} else if(action.equals("ĐĂNG KÝ")) {
			this.view.dangKy();
		} else if(action.equals("QUÊN MẬT KHẨU")) {
			this.view.quenMatKhau();
		}
	}

}
