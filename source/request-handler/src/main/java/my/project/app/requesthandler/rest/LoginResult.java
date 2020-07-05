package my.project.app.requesthandler.rest;

public class LoginResult {

    private String success;

    private String id;


    public LoginResult() {

    }

    public LoginResult(final String success, final String id) {
        this.success = success;
        this.id = id;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
