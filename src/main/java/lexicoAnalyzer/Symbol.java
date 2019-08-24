package lexicoAnalyzer;

public class Symbol {

    private Integer id;
    private String token;
    private String description;

    public Symbol(Integer id, String token, String description) {
        this.id = id;
        this.token = token;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}