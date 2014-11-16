package freelance.nunobrito.client.page;

import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.api.gwt.oauth2.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import freelance.nunobrito.client.services.UserService;
import freelance.nunobrito.shared.DotClickConstants;
import freelance.nunobrito.shared.User;

@SuppressWarnings("deprecation")
public class LoginPage extends Composite {

	private static LoginPageUiBinder uiBinder = GWT
			.create(LoginPageUiBinder.class);

	interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
	}

	public LoginPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnFBLogin")
	void onLoginFB(ClickEvent e){
		AuthRequest req = new AuthRequest(DotClickConstants.FACEBOOK_AUTH_URL, DotClickConstants.FACEBOOK_CLIENT_ID).withScopes(DotClickConstants.FACEBOOK_EMAIL_SCOPE, DotClickConstants.FACEBOOK_BIRTHDAY_SCOPE, DotClickConstants.FACEBOOK_HOMETOWN, DotClickConstants.FACEBOOK_PUBLIC_PROFILE).withScopeDelimiter(",");
		onOauth(req, DotClickConstants.FACEBOOK_TOKEN);
	}
	
	private void onOauth(AuthRequest req, final String oauthUrl) {

		Auth.get().login(req, new Callback<String, Throwable>() {
			@Override
			public void onSuccess(final String token) {
				UserService.Connect.getService().registerUser(oauthUrl + token, new AsyncCallback<User>() {

							@Override
							public void onSuccess(User user) {
								loadLoginPage(user);
							}

							@Override
							public void onFailure(Throwable caught) {
								Window.alert(caught.getMessage());
							}
						});
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}
	
	private void loadLoginPage(User user){
		RootPanel.get().clear();
		RootPanel.get().add(new MainPage(user));
	}
}
