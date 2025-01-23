public class TheCode {
    public static boolean IsItPrime =true;
    public static void primeDetector(long number){
        if(number == 1 | number == 0| number == -1){
            IsItPrime = false;
        } else if(number == 2 | number == -2) {
            IsItPrime=true;
        }else if(number>2){
            for(long i=2;i*i<=number; i++){
                if(number % i == 0){
                    IsItPrime = false;
                    break;
                }
                IsItPrime=true;
            }
        }else {
            for(long i = 2; i*i <=-number ; i++) {
                if(-number%i == 0){
                    IsItPrime=false;
                    break;
                }
                IsItPrime=true;
            }
        }
    }

}