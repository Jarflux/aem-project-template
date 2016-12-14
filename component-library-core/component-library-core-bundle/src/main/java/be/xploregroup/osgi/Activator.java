package be.xploregroup.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {
    private static final Logger LOG = LoggerFactory.getLogger("ComponentLibrary");

    private ServiceRegistration cacheManagerFactoryRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        LOG.debug("Activating Component Library Core bundle.");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        LOG.debug("Deactivating Component Library Core bundle.");
    }
}