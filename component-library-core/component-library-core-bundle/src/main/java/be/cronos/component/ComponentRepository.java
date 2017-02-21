package be.cronos.component;

import be.cronos.constants.BundleConstants;
import be.cronos.core.resourceresolver.AutoClosableResourceResolver;
import be.cronos.core.resourceresolver.AutoClosableResourceResolverFactory;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 14/12/2016
 */

@org.apache.felix.scr.annotations.Component(immediate = true, metatype = false)
@Service(ComponentRepository.class)
@Properties({
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "Component Repository"),
        @Property(name = Constants.SERVICE_VENDOR, value = BundleConstants.SERVICE_VENDOR)
})
public class ComponentRepository {

    private static final Logger LOG = LoggerFactory.getLogger("ComponentLibrary");

    @Reference
    private AutoClosableResourceResolverFactory resolverFactory;

    public List<Component> getAllComponents() {
        List<Component> components = new ArrayList<>();
        try (AutoClosableResourceResolver resourceResolver = resolverFactory.getServiceResourceResolver()) {
            Session session = resourceResolver.adaptTo(Session.class);

            javax.jcr.query.QueryManager queryManager = session.getWorkspace().getQueryManager();

            // Create a query object ...
            String expression = createQueryFindComponentsInApps();
            LOG.info("[Executing Query] " + expression);
            Query query = queryManager.createQuery(expression, Query.JCR_SQL2);
            QueryResult queryResult = query.execute();

            javax.jcr.NodeIterator nodeIter = queryResult.getNodes();
            ComponentNodeMapper componentNodeMapper = new ComponentNodeMapper();
            while (nodeIter.hasNext()) {
                javax.jcr.Node node = nodeIter.nextNode();
                components.add(componentNodeMapper.nodeToModel(node));
            }
        } catch (Exception e) {
            LOG.error("Error occured in repository " + ExceptionUtils.getMessage(e));
        }
        return components;
    }

    private String createQueryFindComponentsInApps() {
        return "SELECT * FROM ["+BundleConstants.COMPONENT_LIBRARY_NODE_TYPE +"] WHERE ISDESCENDANTNODE('/apps')";
    }


}
