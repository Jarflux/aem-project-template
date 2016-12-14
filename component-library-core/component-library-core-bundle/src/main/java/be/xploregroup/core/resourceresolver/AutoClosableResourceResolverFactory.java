package be.xploregroup.core.resourceresolver;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.framework.Constants;

import java.util.Map;

@Component(
        name = "org.apache.system.jcr.resource.internal.LegacyJcrResourceResolverFactoryImpl"
)
@Service({AutoClosableResourceResolverFactory.class})
@Properties({
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "AutoClosableResourceResolverFactory Implementation"),
        @Property(name = Constants.SERVICE_VENDOR, value = "The Apache Software Foundation")
})
public class AutoClosableResourceResolverFactory {

    @Reference
    private ResourceResolverFactory delegate;

    public AutoClosableResourceResolver getResourceResolver(Map<String, Object> authenticationInfo) throws LoginException {
        return new AutoClosableResourceResolver(delegate.getResourceResolver(authenticationInfo));
    }

    public AutoClosableResourceResolver getServiceResourceResolver() throws LoginException {
//        Map<String, Object> credentials = new HashMap<>();
//        credentials.put(ResourceResolverFactory.USER, "admin");
//        credentials.put(ResourceResolverFactory.PASSWORD, "admin");
        return new AutoClosableResourceResolver(delegate.getAdministrativeResourceResolver(null));
    }
}
