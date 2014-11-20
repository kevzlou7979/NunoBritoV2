package freelance.nunobrito.server;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import freelance.nunobrito.shared.Post;
import freelance.nunobrito.shared.User;

public class OfyService {
	static {
		ObjectifyService.register(Post.class);
		ObjectifyService.register(User.class);
	}

	public static Objectify ofy() {
		return ObjectifyService.begin();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}

}
