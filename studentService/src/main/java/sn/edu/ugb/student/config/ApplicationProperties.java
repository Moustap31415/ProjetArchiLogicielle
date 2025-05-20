package sn.edu.ugb.student.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Liquibase liquibase = new Liquibase();
    private final UserService userService = new UserService();
    private final Microservices microservices = new Microservices();

    public Liquibase getLiquibase() {
        return liquibase;
    }

    public UserService getUserService() {
        return userService;
    }

    public Microservices getMicroservices() {
        return microservices;
    }

    public static class Liquibase {
        private Boolean asyncStart = true;

        public Boolean getAsyncStart() {
            return asyncStart;
        }

        public void setAsyncStart(Boolean asyncStart) {
            this.asyncStart = asyncStart;
        }
    }

    public static class UserService {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Microservices {
        private String cursusServiceUrl;

        public String getCursusServiceUrl() {
            return cursusServiceUrl;
        }

        public void setCursusServiceUrl(String cursusServiceUrl) {
            this.cursusServiceUrl = cursusServiceUrl;
        }
    }
}
