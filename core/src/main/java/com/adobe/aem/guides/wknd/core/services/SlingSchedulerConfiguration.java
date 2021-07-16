package com.adobe.aem.guides.wknd.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "SlingSchedulerConfiguration", description = "Sling Scheduler Configuration")
public @interface SlingSchedulerConfiguration {

    @AttributeDefinition(name = "Scheduler Name", description = "Name Of Scheduler", type = AttributeType.STRING)
    public String schedulerName() default "Custom Sling Scheduler Configuration";

    @AttributeDefinition(name = "Corn Expression", description = "Corn Expresion used by Scheduler", type = AttributeType.STRING)
    public String cornExpression() default "0 * * * *?";

    @AttributeDefinition(name = "Custom Parameter", description = "Custom Parameter to be displayed", type = AttributeType.STRING)
    public String customParameter() default "AEM Scheduler Demo";
}
