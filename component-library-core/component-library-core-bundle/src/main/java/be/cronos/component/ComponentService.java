package be.cronos.component;

import be.cronos.constants.BundleConstants;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;

import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 14/12/2016
 */

@org.apache.felix.scr.annotations.Component(immediate = true, metatype = false)
@Service(ComponentService.class)
@Properties({
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "Component Service"),
        @Property(name = Constants.SERVICE_VENDOR, value = BundleConstants.SERVICE_VENDOR)
})
public class ComponentService {

    @Reference
    private ComponentRepository componentRepository;

    public List<Component> getAllComponents() {
        return componentRepository.getAllComponents();
    }
}
