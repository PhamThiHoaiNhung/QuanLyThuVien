package controller;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.view_thayDoiThongTinSach;

public class controller_thayDoiThongTinSach implements ActionListener{

	view_thayDoiThongTinSach view;
	
	public controller_thayDoiThongTinSach(view_thayDoiThongTinSach view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("HUỶ")) {
			this.view.dispose();
		} else if(action.equals("THAY ĐỔI THÔNG TIN")) {
			this.view.thayDoiThongTinSach();
		}
	}

}
