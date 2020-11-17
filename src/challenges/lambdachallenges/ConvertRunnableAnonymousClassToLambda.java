package challenges.lambdachallenges;

public class ConvertRunnableAnonymousClassToLambda {
    public static void main(String[] args) {

        // changing this below code into lambda
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this string into an array";
                String[] myStrArr = myString.split(" ");
                for(String word : myStrArr) {
                    System.out.println(word);
                }
            }
        };

        new Thread(runnable).start();
        System.out.println("============================");

        Runnable runnable1 = () -> {
            String myString = "Let's split this string into an array";
            String[] myStrArr = myString.split(" ");
            for(String word : myStrArr) {
                System.out.println(word);
            }
        };

        new Thread(runnable1).start();
    }
}
