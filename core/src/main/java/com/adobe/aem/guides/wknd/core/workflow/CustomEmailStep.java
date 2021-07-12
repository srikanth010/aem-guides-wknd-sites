package com.adobe.aem.guides.wknd.core.workflow;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;

@Component(service = WorkflowProcess.class, property = {"process.label=My Custom Email Step"})
public class CustomEmailStep implements WorkflowProcess {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Reference
    private MessageGatewayService messageGatewayService;

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {

        try {
            log.info("Here in execute method");    //ensure that the execute method is invoked

            //Declare a MessageGateway service
            MessageGateway<Email> messageGateway;

            //Set up the Email message
            Email email = new SimpleEmail();

            //Set the mail values
            String emailToRecipients = "kanthetisrikanth0@gmail.com";
            String emailCcRecipients = "kanthetisrikanth0@gmail.com";

            email.addTo(emailToRecipients);
            email.addCc(emailCcRecipients);
            email.setSubject("AEM Custom Step");
            email.setFrom("kantetisrikanth@gmail.com");
            email.setMsg("This message is to inform you that the AEM content has been deleted");

            //Inject a MessageGateway Service and send the message
            messageGateway = messageGatewayService.getGateway(Email.class);
            log.info("Email Sent");

            // Check the logs to see that messageGateway is not null
            messageGateway.send(email);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
