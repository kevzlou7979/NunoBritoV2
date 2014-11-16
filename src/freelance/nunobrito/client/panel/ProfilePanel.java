package freelance.nunobrito.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import freelance.nunobrito.client.resouces.DotClickResources;
import freelance.nunobrito.shared.User;

public class ProfilePanel extends Composite  {

	private static ProfilePanelUiBinder uiBinder = GWT
			.create(ProfilePanelUiBinder.class);

	interface ProfilePanelUiBinder extends UiBinder<Widget, ProfilePanel> {
	}

	@UiField Image imgProfilePic;
	@UiField Label lblName, lblEmail, lblGender, lblCountry;
	
	public ProfilePanel(User user) {
		initWidget(uiBinder.createAndBindUi(this));
		if(user.getProfilePic().isEmpty()){
			imgProfilePic.setResource(DotClickResources.INSTANCE.ic_profile());
		}else{
			imgProfilePic.setUrl(user.getProfilePic());
		}
		lblGender.setText(user.getGender());
		lblName.setText(user.getFirstName());
		lblEmail.setText(user.getEmail());
	}

	
}
