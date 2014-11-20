package freelance.nunobrito.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PostPanel extends Composite {

	private static PostPanelUiBinder uiBinder = GWT.create(PostPanelUiBinder.class);

	interface PostPanelUiBinder extends UiBinder<Widget, PostPanel> {
	}

	public PostPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
}
