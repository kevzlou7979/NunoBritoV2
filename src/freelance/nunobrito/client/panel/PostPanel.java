package freelance.nunobrito.client.panel;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import freelance.nunobrito.client.item.PostItem;
import freelance.nunobrito.client.page.MainPage;
import freelance.nunobrito.client.services.UserService;
import freelance.nunobrito.client.ui.MessageInfo;
import freelance.nunobrito.shared.Post;
import freelance.nunobrito.shared.User;

public class PostPanel extends Composite {

	private static PostPanelUiBinder uiBinder = GWT.create(PostPanelUiBinder.class);

	interface PostPanelUiBinder extends UiBinder<Widget, PostPanel> {
	}
	
	@UiField HTMLPanel postContentPanel;

	public PostPanel(MainPage mainPage) {
		initWidget(uiBinder.createAndBindUi(this));
		getAllUserPost(mainPage.getUser());
	}
	
	private void getAllUserPost(User user){
		postContentPanel.clear();
		UserService.Connect.getService().getAllUserPost(user.getId(), new AsyncCallback<List<Post>>() {
			
			@Override
			public void onSuccess(List<Post> result) {
				if(!result.isEmpty()){
					for(Post post : result){
						postContentPanel.add(new PostItem(post));
					}
				}else{
					postContentPanel.add(new MessageInfo("No Recent Post", "Please wait for the next post"));
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
