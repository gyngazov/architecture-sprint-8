package ru.backend;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
class ReportsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportsController.class);
    private static final String ROLE = "prothetic_user";

    @PreAuthorize("hasRole('" + ROLE + "')")
    @GetMapping("/reports")
    public String getReport(HttpServletRequest request) {

        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal=(KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();

        LOGGER.info("username: {}", accessToken.getPreferredUsername());
        LOGGER.info("emailId: {}", accessToken.getEmail());
        LOGGER.info("lastname: {}",accessToken.getFamilyName());
        LOGGER.info("firstname: {}", accessToken.getGivenName());
        LOGGER.info("realmName: {}", accessToken.getIssuer());

        return "data";
    }
}
