package be.xploregroup.component;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.felix.scr.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 14/12/2016
 */


@org.apache.felix.scr.annotations.Component
@Service(ComponentEndpoint.class)
@Path("/")
public class ComponentEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger("ComponentLibrary");

    @Reference
    private ComponentService componentService;

    @GET
    @Path("/public/library/components")
    @Produces(MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=utf-8")
    public Response getAllComponents() {
        try {
            List<Component> components = componentService.getAllComponents();
            return Response.status(Response.Status.OK).entity(components).build();
        } catch (Exception e) {
            LOG.error(ExceptionUtils.getStackTrace(e));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
