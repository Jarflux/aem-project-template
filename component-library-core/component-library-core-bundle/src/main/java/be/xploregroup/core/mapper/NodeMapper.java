package be.xploregroup.core.mapper;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface NodeMapper<T> {
    T nodeToModel(Node node) throws RepositoryException;

    void modelToNode(T model, Node node) throws RepositoryException;
}
