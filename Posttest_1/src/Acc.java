public class Acc {
    private String Username;
    private String Password;

    Acc(String user, String pw){
        this.Username = user;
        this.Password = pw;
    }

    public String getusername(){
        return Username;
    }

    public String getPass(){
        return Password;
    }
}
