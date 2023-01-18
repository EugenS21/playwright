package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.PanelLinksDetails;
import org.eugens21.luma.web.pages.elements.Anchor;
import org.eugens21.luma.web.pages.elements.Span;
import org.eugens21.luma.web.pages.elements.interfaces.Element;
import org.eugens21.luma.web.pages.elements.interfaces.IAnchor;

import static io.vavr.API.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HeaderLinks implements Element {

    String selfLocator;
    @Getter
    Anchor signIn;
    @Getter
    Anchor signUp;
    Page page;
    @Getter
    Span welcomeMessage;

    public HeaderLinks(Page page, PanelLinksDetails panelLinksDetails) {
        this.page = page;
        this.selfLocator = panelLinksDetails.getSelf();
        this.signIn = new Anchor(page.locator(panelLinksDetails.getSignIn()));
        this.signUp = new Anchor(page.locator(panelLinksDetails.getSignUp()));
        this.welcomeMessage = new Span(page.locator(panelLinksDetails.getWelcomeMessage()));
    }

    @Override
    public Locator getLocator() {
        return page.locator(selfLocator);
    }

    public IAnchor getLinkByName(String linkName) {
        return Match(linkName).of(
                Case($("sign in"), () -> signIn),
                Case($(), () -> signUp)
        );
    }

}
