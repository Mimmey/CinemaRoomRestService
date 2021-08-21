package cinema.wrappers;

public class TokenWrapper {
    private String token;

    public TokenWrapper() {
        this.token = "";
    }

    public TokenWrapper(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
