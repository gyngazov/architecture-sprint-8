package ru.reporter;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/reports")
@ApplicationScoped
@Authenticated
public class ReportController {

	public static final String ROLE_ALLOWED = "prothetic_user";

	@GET
	@RolesAllowed(ROLE_ALLOWED)
	public Response getReports() {
		ReportService rs = new ReportService();
		return Response.ok().entity(rs.getReport()).build();
	}

}
