package freelance.nunobrito.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import freelance.nunobrito.shared.User;


/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UserServiceAsync {
	
	public void registerUser(String authUrl, AsyncCallback<User> asyncCallback);
	
}
