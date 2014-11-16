package freelance.nunobrito.client.resouces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface DotClickResources extends ClientBundle {
	public static final DotClickResources INSTANCE = GWT
			.create(DotClickResources.class);

	ImageResource bg_login();
	
	ImageResource ic_logout();
	
	ImageResource ic_profile();
	
	ImageResource ic_facebook();
	
	DotClickCSS dotclickcss();

	DotClickMobileCSS dotclickmobilecss();
}
