package freelance.nunobrito.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import freelance.nunobrito.client.page.LoginPage;
import freelance.nunobrito.client.resouces.DotClickResources;
import freelance.nunobrito.client.resouces.ResourcesLoader;

public class Freelance_nunobrito implements EntryPoint {

	public void onModuleLoad() {
		new ResourcesLoader(DotClickResources.INSTANCE);
		RootPanel.get().clear();
		RootPanel.get().add(new LoginPage());
	}
}
