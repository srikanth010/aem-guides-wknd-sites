package com.adobe.aem.guides.wknd.core.models.header;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/* http://localhost:4504/content/macbook/us/en/demo/jcr:content/root/container/container/header.srikanth.json */

@Model(
        adaptables = {SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = Header.RESOURCE_TYPE
)
@Exporter(name="jackson", selector = "srikanth", extensions = "json")
public class Header {

    static final String RESOURCE_TYPE = "wknd/components/header";

    @ValueMapValue
    @Optional
    private String whiteLogo;

    @ValueMapValue
    @Optional
    private String logoLink;

    @ValueMapValue
    @Optional
    private String logoLinkTitle;

    @ValueMapValue
    @Optional
    private Boolean logoLinkNewTab;

    @ValueMapValue
    @Optional
    private String logInText;

    @ValueMapValue
    @Optional
    private String logInlink;

    @ValueMapValue
    @Optional
    private Boolean logInNewTab;

    @ValueMapValue
    @Optional
    private String logInlinkTitle;

    @ValueMapValue
    @Optional
    private String signUpText;

    @ValueMapValue
    @Optional
    private String signUplink;

    @ValueMapValue
    @Optional
    private Boolean signUpNewTab;

    @ValueMapValue
    @Optional
    private String signUplinkTitle;

    @ChildResource
    private List<HeaderListModel> headerLinks;


    public String getWhiteLogo() {
        return whiteLogo;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public String getLogoLinkTitle() {
        return logoLinkTitle;
    }

    public Boolean getLogoLinkNewTab() {
        return logoLinkNewTab;
    }

    public String getLogInText() {
        return logInText;
    }

    public String getLogInlink() {
        return logInlink;
    }

    public Boolean getLogInNewTab() {
        return logInNewTab;
    }

    public String getLogInlinkTitle() {
        return logInlinkTitle;
    }

    public String getSignUpText() {
        return signUpText;
    }

    public String getSignUpLink() {
        return signUplink;
    }

    public Boolean getSignUpNewTab() {
        return signUpNewTab;
    }

    public String getSignUplinkTitle() {
        return signUplinkTitle;
    }

    public List<HeaderListModel> getHeaderLinks() {
        return headerLinks;
    }
}
