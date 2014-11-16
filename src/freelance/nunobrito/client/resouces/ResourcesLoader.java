package freelance.nunobrito.client.resouces;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.CssResource;

public class ResourcesLoader {
    private static final int MOBILE_MAX_WIDTH = 600;
    private static final String MOBILE_MEDIA = "@media only screen and (max-width: " + MOBILE_MAX_WIDTH + "px), " +
            "only screen and (max-device-width: " + MOBILE_MAX_WIDTH + "px) {";
    private static final String CLOSING_BRACKET = "}";

    public ResourcesLoader(DotClickResources resources) {
        resources.dotclickcss().ensureInjected();
        injectMediaCss(resources);
    }
 
    private void injectMediaCss(DotClickResources resources) {
        injectMobileStylesheet(resources.dotclickmobilecss());
    }
 
    private void injectMobileStylesheet(CssResource cssResource) {
        String mobileCss = wrapMobileStylesheet(cssResource.getText());
        StyleInjector.injectAtEnd(mobileCss);
    }
 
    private String wrapMobileStylesheet(String content) {
        return MOBILE_MEDIA + content + CLOSING_BRACKET;
    }
}
