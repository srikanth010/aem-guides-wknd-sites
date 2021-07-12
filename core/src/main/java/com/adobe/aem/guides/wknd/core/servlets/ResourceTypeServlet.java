package com.adobe.aem.guides.wknd.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

/* _jcr_content.greek.txt*/
@Component(service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "wknd/components/page",
        selectors = {"greek","main"},
        extensions = {"txt","xml"}
        )
public class ResourceTypeServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest request,
                         final SlingHttpServletResponse response) throws ServletException, IOException {
        final Resource resource = request.getResource();
        response.setContentType("text/plain");
        response.getWriter().write("Page Called From Servlet :" + resource.getValueMap().get(JcrConstants.JCR_TITLE));
    }
}
