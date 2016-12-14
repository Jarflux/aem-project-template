package be.xploregroup.component;

import be.xploregroup.core.mapper.NodeMapper;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;

/**
 * Developer: Ben Oeyen
 * Date: 14/12/2016
 */
public class ComponentNodeMapper implements NodeMapper<Component> {
    @Override
    public Component nodeToModel(Node node) throws RepositoryException {
        Component component = new Component();
        component.setNodeName(node.getName());
        component.setPath(node.getPath());
        PropertyIterator properties = node.getProperties();
        while (properties.hasNext()){
            Property property = properties.nextProperty();
            switch(property.getName()){
                case "jcr:title": component.setTitle(property.getString());break;
                case "jcr:description": component.setDescription(property.getString());break;
                case "componentGroup": component.setComponentGroup(property.getString());break;
            }
        }
        return component;
    }

    @Override
    public void modelToNode(Component model, Node node) throws RepositoryException {
        // NOT YET IMPLEMENTED;
    }
}
