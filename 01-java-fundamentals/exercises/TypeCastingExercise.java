public class TypeCastingExercise {
    public static void main(String[] args){
        //1
        double temperature = 36.8;
        int castTemprature = (int) temperature;
        System.out.println("The temperature is : " + castTemprature);

        //2
        double grade = 36.8;
        int castGrade = (int) Math.round(grade);
        System.out.println("The grade is : " + castGrade);

        //3
        String year = "2026";
        int castYear = Integer.parseInt(year);
        System.out.println("The year is : " + castYear);

        //4
        int a = 7;
        int b = 2;
        int result = a + b;
        System.out.println("result is : " + (double) result / 2);

        //5
        int code = 'A';
        char letter = 69;
        System.out.println(code);
        System.out.println(letter);
        int castChar = code + 4;
        System.out.println((char) castChar);

    }
}
