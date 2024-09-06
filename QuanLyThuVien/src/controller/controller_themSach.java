package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.view_thayDoiThongTinSach;
import view.view_themSach;

public class controller_themSach implements ActionListener{
	
	view_themSach view;
	
	public controller_themSach(view_themSach view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("HUỶ")) {
			this.view.dispose();
		} else if(action.equals("THÊM")) {
			this.view.themSach();
		}
	}

}
