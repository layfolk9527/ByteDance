package tools;

public class CheckCode {
    public CheckCode() {
    }

    public int check(String userName, String password,String tCode, String vCode) {
        int nameLen=userName.length();
        int passwLen=password.length();
        if(passwLen<6||passwLen>16){
            return 2;
        }
        else if(tCode.equals(vCode)){
            return 0;
        }
        else
            return 1;
    }
}
