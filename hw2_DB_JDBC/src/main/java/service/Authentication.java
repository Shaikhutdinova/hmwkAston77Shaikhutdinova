package service;

public interface Authentication {
    boolean isAuthenticated(String username, String inputPassword);
}
