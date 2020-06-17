package my.project.app.requesthandler.databaseobjects;

public class TestObject {

    private int att1;

    private int att2;

    private String att3;

    private boolean att4;

    public TestObject ( int att1, int att2, String att3, boolean att4) {
        this.att1 = att1;
        this.att2 = att2;
        this.att3 = att3;
        this.att4 = att4;
    }

    public int getAtt1() {
        return att1;
    }

    public void setAtt1(int att1) {
        this.att1 = att1;
    }

    public int getAtt2() {
        return att2;
    }

    public void setAtt2(int att2) {
        this.att2 = att2;
    }

    public String getAtt3() {
        return att3;
    }

    public void setAtt3(String att3) {
        this.att3 = att3;
    }

    public boolean isAtt4() {
        return att4;
    }

    public void setAtt4(boolean att4) {
        this.att4 = att4;
    }
}
