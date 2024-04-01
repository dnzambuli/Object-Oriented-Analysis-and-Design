package Control;



public class Control {
    /*
     * uses the expanded if statement to display the if, else if and else 
     */
    public static void longIf(int time){
        if (time < 12){
            System.out.println("It is morning");
        }else if (time > 12 && time < 18){
            System.out.println("It is afternoon");
        }else{
            System.out.println("goodnight");
        }
    }

    /*
     * using the short if, else statement
     */
    public static void shortIf(int time){
        String result = (time < 12)? "Good moring": "Good Evening";
        System.out.println(result);
    }

    

    public static void main(String[] args){
        int time = 18;
        longIf(time);
        shortIf(time);

    }

}
