package freelance.nunobrito.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import freelance.nunobrito.shared.Post;
import freelance.nunobrito.shared.User;


/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UserServiceAsync {
	
	public void registerUser(String authUrl, AsyncCallback<User> asyncCallback);
	
	public void updateUser(User user, AsyncCallback<Void> callback);
	
	public void savePost(Post post, AsyncCallback<User> asyncCallback) ;
	
	public void getAllUserPost(Long userId, AsyncCallback<List<Post>> callback);
	
}
