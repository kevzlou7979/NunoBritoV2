package freelance.nunobrito.client.dialog;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ResultDialog extends PopupPanel{

	private static ResultDialogUiBinder uiBinder = GWT
			.create(ResultDialogUiBinder.class);

	interface ResultDialogUiBinder extends UiBinder<Widget, ResultDialog> {
	}
	
	@UiField Label lblMessage;
	@UiField Image imgLogo;
	
	public ResultDialog(boolean isSuccess, String message) {
		setWidget(uiBinder.createAndBindUi(this));
		this.setAnimationEnabled(true);
		this.setAutoHideEnabled(true);
		this.setGlassEnabled(true);
		this.center();
		this.show();
		if(isSuccess){
			onSetSuccess();
		}else{
			onSetError();
		}
		lblMessage.setText(message);
	}

	private void onSetError() {
		imgLogo.setUrl("images/ic_error.png");
	}

	private void onSetSuccess() {
		imgLogo.setUrl("images/ic_success.png");
	}

	@UiHandler("btnClose")
	void onClose(ClickEvent e){
		hide();
	}
	
}
