package com.clinix.common.constant;

public class ApiRoutes {

    public static final String API = "/api";
    public static final String ID = "/{id}";

    private ApiRoutes() {}

    public static class Users {
        public static final String BASE = "/users";
        public static final String ROOT = API + BASE;
        public static final String BY_ID = ID;

        private Users() {}
    }
}
