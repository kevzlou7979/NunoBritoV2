package freelance.nunobrito.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MessageInfo extends Composite {

	private static MessageInfoUiBinder uiBinder = GWT.create(MessageInfoUiBinder.class);

	interface MessageInfoUiBinder extends UiBinder<Widget, MessageInfo> {
	}

	@UiField Label lblTitle, lblDescription;
	
	public MessageInfo(String title, String description) {
		initWidget(uiBinder.createAndBindUi(this));
		lblTitle.setText(title);
		lblDescription.setText(description);
	}


}
