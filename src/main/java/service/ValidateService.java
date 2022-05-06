package service;

public class ValidateService implements ValidateServiceInterface{

    @Override
    public boolean checkIntegerNumber(String number) {
        boolean flag = true;
        for (int i = 0; i<number.length(); i++){
            char c = number.charAt(i);
            if(c<'0' || c>'9'){
                return false;
            }
        }
        return flag;
    }

    @Override
    public boolean checkDoubleNumber(String number) {
        boolean flag = true;
        for (int i = 0; i<number.length(); i++){
            char c = number.charAt(i);
            if(c == '.') continue;
            if(c<'0' || c>'9'){
                return false;
            }
        }
        return flag;
    }
}
