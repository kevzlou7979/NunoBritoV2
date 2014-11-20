package freelance.nunobrito.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.ibm.icu.util.Calendar;

import freelance.nunobrito.client.services.UserService;
import freelance.nunobrito.shared.Post;
import freelance.nunobrito.shared.User;

@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements UserService {
	
	private Objectify ofy = OfyService.ofy();
	
	@Override
	public User registerUser(String oauthToken) throws Exception {
		final StringBuffer r = new StringBuffer();
		try {
			final URL u = new URL(oauthToken);
			final URLConnection uc = u.openConnection();
			final int end = 1000;
			InputStreamReader isr = null;
			BufferedReader br = null;
			try {
				isr = new InputStreamReader(uc.getInputStream());
				br = new BufferedReader(isr);
				final int chk = 0;
				while ((oauthToken = br.readLine()) != null) {
					if ((chk >= 0) && ((chk < end))) {
						r.append(oauthToken).append('\n');
					}
				}
			} catch (final java.net.ConnectException cex) {
				r.append(cex.getMessage());
			} catch (final Exception e) {
				throw e;
			} finally {
				try {
					br.close();
				} catch (final Exception e) {
					throw e;
				}
			}
		} catch (final Exception e) {
			throw e;
		}

		final User user = new User();
		try {
			final JsonFactory f = new JsonFactory();
			JsonParser jp;
			jp = f.createJsonParser(r.toString());
			jp.nextToken();
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				final String fieldName = jp.getCurrentName();
				jp.nextToken();
				switch (fieldName) {
				case "picture":
					user.setProfilePic(jp.getText());
					break;
				case "first_name":
					user.setFirstName(jp.getText());
					break;
				case "last_name":
					user.setLastName(jp.getText());
					break;
				case "email":
					user.setEmail(jp.getText());
					break;
				case "gender":
					user.setGender(jp.getText());
					break;
				case "hometown":
					user.setCountry(jp.getText());
					break;
				default:
					break;
				}
			}
			User existingUser = ofy.query(User.class).filter("email", user.getEmail()).get();
			if(existingUser!=null){
				return existingUser;
			}else{
				Calendar c = Calendar.getInstance(); 
				c.setTime(new Date()); 
				c.add(Calendar.DATE, 30);
				user.setPostingDate(c.getTime());
				ofy.put(user);
				return user;
			}
		} catch (final JsonParseException e) {
			throw e;
		} catch (final IOException e) {
			throw e;
		}
	}
	
	@Override
	public void updateUser(User user) throws Exception {
		ofy.put(user);
	}

	@Override
	public void savePost(Post post) throws Exception {
		ofy.put(post);
	}

	@Override
	public List<Post> getAllUserPost(Long userId) throws Exception {
		List<Post> posts = new ArrayList<>();
		for (Post p : ofy.query(Post.class).filter("userId", userId).order("postDate")) {
			posts.add(p);
		}

		return posts;
	}

	

}
