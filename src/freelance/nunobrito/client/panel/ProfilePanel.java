package freelance.nunobrito.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

import freelance.nunobrito.client.resouces.DotClickResources;
import freelance.nunobrito.client.services.UserService;
import freelance.nunobrito.shared.User;

public class ProfilePanel extends Composite  {

	private static ProfilePanelUiBinder uiBinder = GWT
			.create(ProfilePanelUiBinder.class);

	interface ProfilePanelUiBinder extends UiBinder<Widget, ProfilePanel> {
	}

	@UiField Image imgProfilePic;
	@UiField Label lblName, lblEmail, lblCountry, lblPostingDate;
	@UiField DatePicker datePickerAds;
	@UiField HTMLPanel postingDatePanel;
	
	private User user;
	
	public ProfilePanel(User user) {
		initWidget(uiBinder.createAndBindUi(this));
		this.user = user;
		postingDatePanel.setVisible(false);
		lblPostingDate.setText(DateTimeFormat.getFormat("MMMM dd, yyyy").format(user.getPostingDate()));
		datePickerAds.setValue(user.getPostingDate());
		datePickerAds.setCurrentMonth(user.getPostingDate());
		
		if(user.getProfilePic().isEmpty()){
			imgProfilePic.setResource(DotClickResources.INSTANCE.ic_profile());
		}else{
			imgProfilePic.setUrl(user.getProfilePic());
		}
		lblName.setText(user.getFirstName());
		lblEmail.setText(user.getEmail());
	}
	
	@UiHandler("btnEdit")
	void onEdit(ClickEvent e){
		postingDatePanel.setVisible(true);
	}

	@UiHandler("btnCancelPostingDate")
	void onCancelPostingDate(ClickEvent e){
		postingDatePanel.setVisible(false);
	}
	
	@UiHandler("btnUpdatePostingDate")
	void onUpdatePostingDate(ClickEvent e){
		user.setPostingDate(datePickerAds.getValue());
		UserService.Connect.getService().updateUser(user, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				postingDatePanel.setVisible(false);
				lblPostingDate.setText(DateTimeFormat.getFormat("MMMM dd, yyyy").format(user.getPostingDate()));
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}
	
}
