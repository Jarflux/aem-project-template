package be.cronos.core.resourceresolver;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

public class AutoClosableResourceResolver implements ResourceResolver, AutoCloseable {
    private ResourceResolver delegate;

    public AutoClosableResourceResolver() {
    }

    public AutoClosableResourceResolver(ResourceResolver resourceResolver) {
        this();
        this.delegate = resourceResolver;
    }

    @Override
    public Resource resolve(HttpServletRequest request, String absPath) {
        return delegate.resolve(request, absPath);
    }

    @Override
    public Resource resolve(String absPath) {
        return delegate.resolve(absPath);
    }

    @Override
    @Deprecated
    public Resource resolve(HttpServletRequest request) {
        return delegate.resolve(request);
    }

    @Override
    public String map(String resourcePath) {
        return delegate.map(resourcePath);
    }

    @Override
    public String map(HttpServletRequest request, String resourcePath) {
        return delegate.map(request, resourcePath);
    }

    @Override
    public Resource getResource(String path) {
        return delegate.getResource(path);
    }

    @Override
    public Resource getResource(Resource base, String path) {
        return delegate.getResource(base, path);
    }

    @Override
    public String[] getSearchPath() {
        return delegate.getSearchPath();
    }

    @Override
    public Iterator<Resource> listChildren(Resource parent) {
        return delegate.listChildren(parent);
    }

    @Override
    public Iterable<Resource> getChildren(Resource parent) {
        return delegate.getChildren(parent);
    }

    @Override
    public Iterator<Resource> findResources(String query, String language) {
        return delegate.findResources(query, language);
    }

    @Override
    public Iterator<Map<String, Object>> queryResources(String query, String language) {
        return delegate.queryResources(query, language);
    }

    @Override
    public boolean hasChildren(Resource resource) {
        return false;
    }

    @Override
    public ResourceResolver clone(Map<String, Object> authenticationInfo) throws LoginException {
        return delegate.clone(authenticationInfo);
    }

    @Override
    public boolean isLive() {
        return delegate.isLive();
    }

    @Override
    public void close() {
        delegate.close();
    }

    @Override
    public String getUserID() {
        return delegate.getUserID();
    }

    @Override
    public Iterator<String> getAttributeNames() {
        return delegate.getAttributeNames();
    }

    @Override
    public Object getAttribute(String name) {
        return delegate.getAttribute(name);
    }

    @Override
    public void delete(Resource resource) throws PersistenceException {
        delegate.delete(resource);
    }

    @Override
    public Resource create(Resource parent, String name, Map<String, Object> properties) throws PersistenceException {
        return delegate.create(parent, name, properties);
    }

    @Override
    public void revert() {
        delegate.revert();
    }

    @Override
    public void commit() throws PersistenceException {
        delegate.commit();
    }

    @Override
    public boolean hasChanges() {
        return delegate.hasChanges();
    }

    @Override
    public String getParentResourceType(Resource resource) {
        return delegate.getParentResourceType(resource);
    }

    @Override
    public String getParentResourceType(String s) {
        return delegate.getParentResourceType(s);
    }

    @Override
    public boolean isResourceType(Resource resource, String s) {
        return delegate.isResourceType(resource, s);
    }

    @Override
    public void refresh() {
        delegate.refresh();
    }

    @Override
    public <AdapterType> AdapterType adaptTo(Class<AdapterType> aClass) {
        return delegate.adaptTo(aClass);
    }
}
