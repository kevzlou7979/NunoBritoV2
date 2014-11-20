package freelance.nunobrito.client.item;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import freelance.nunobrito.shared.Post;
import freelance.nunobrito.shared.TimeChecker;

public class PostItem extends Composite {

	private static PostItemUiBinder uiBinder = GWT
			.create(PostItemUiBinder.class);

	interface PostItemUiBinder extends UiBinder<Widget, PostItem> {
	}

	@UiField Label lblMessage, lblTime;
	
	public PostItem(Post post) {
		initWidget(uiBinder.createAndBindUi(this));
		lblMessage.setText(post.getMessage());
		lblTime.setText(new TimeChecker(post.getPostDate()).getTimePassed());
	}

}
