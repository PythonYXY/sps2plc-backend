package sps2plc.security;

public class SecurityConstants {
    public static final String SECRET = "MapsSecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 86_400_000; // 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String[] AUTH_WHITELIST = {
            "/api/user/sign-up",
            "/api/login",
            "/login*",
            "/*.js",
            "/fontawesome*",
            "/favicon.ico",
            "/"
    };
}
