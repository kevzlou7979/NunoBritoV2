package freelance.nunobrito.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import freelance.nunobrito.client.panel.ProfilePanel;
import freelance.nunobrito.client.resouces.DotClickResources;
import freelance.nunobrito.shared.User;

public class MainPage extends Composite  {

	private static MainPageUiBinder uiBinder = GWT
			.create(MainPageUiBinder.class);

	interface MainPageUiBinder extends UiBinder<Widget, MainPage> {
	}

	@UiField Image imgProfilePic;
	@UiField Label lblEmail;
	@UiField HTMLPanel bodyPanel;
	private User user;
	
	public MainPage(User user) {
		initWidget(uiBinder.createAndBindUi(this));
		this.user = user;
		if(user.getProfilePic().isEmpty()){
			imgProfilePic.setResource(DotClickResources.INSTANCE.ic_profile());
		}else{
			imgProfilePic.setUrl(user.getProfilePic());
		}
		
		lblEmail.setText(user.getEmail());
		loadProfilePanel();
	}
	
	private void loadProfilePanel() {
		bodyPanel.clear();
		bodyPanel.add(new ProfilePanel(user));
	}

	@UiHandler("lblEmail")
	void onSeeProfile(ClickEvent e){
		loadProfilePanel();
	}

	@UiHandler("btnLogout")
	void onLogout(ClickEvent e){
		RootPanel.get().clear();
		RootPanel.get().add(new LoginPage());
	}
	
	

}
