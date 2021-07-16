package com.adobe.aem.guides.wknd.core.schedulers;

import com.adobe.aem.guides.wknd.core.services.SlingSchedulerConfiguration;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Modified;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true,service = CustomScheduler.class)
@Designate(ocd = SlingSchedulerConfiguration.class)
public class CustomScheduler implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(CustomScheduler.class);

    private String customParameter;

    private int schedulerId;

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate(SlingSchedulerConfiguration configuration){
        schedulerId = configuration.schedulerName().hashCode();
        customParameter = configuration.customParameter();
    }

    @Modified
    protected void modified(SlingSchedulerConfiguration configuration){
        schedulerId = configuration.schedulerName().hashCode();
    }
    @Override
    public void run() {
        log.info("Custom Scheduler is now running");

    }
}
