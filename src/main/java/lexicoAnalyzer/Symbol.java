package lexicoAnalyzer;

public class Symbol {

    private Integer id;
    private String token;
    private String description;
    private int row;
    private int col;

    public Symbol(Integer id, String token, String description, int row, int col) {
        this.id = id;
        this.token = token;
        this.description = description;
        this.row = row;
        this.col = col;
    }

    public Symbol(Integer id, String token, String description) {
        this.id = id;
        this.token = token;
        this.description = description;
        this.row = 0;
        this.col = 0;
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}