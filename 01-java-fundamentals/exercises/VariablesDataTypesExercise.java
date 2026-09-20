public class VariablesDataTypesExercise {
    public static void main(String[] args) {
        // 1
        String name = "Muhamad Badru Kamal";
        int age = 23;
        String city = "Kota Bogor";
        boolean isLearning = true;

        System.out.println("Name " + name);
        System.out.println("Age " + age);
        System.out.println("City " + city);
        System.out.println("Is Learning " + isLearning);

        // 2
        double price = 19.99;
        int quantity = 3;

        System.out.println("Price " + price);
        System.out.println("Quantity " + quantity);

        // 3

        long value = 4000000000L;
        System.out.println("Value " + value);

        // 4
        final int DAYS_IN_WEEK = 7;
        // DAYS_IN_WEEK = 10; (Error : value tidak bisa di ubah karena menggunakan final yang dimana nilai sudah di tetapkan di awal)
        System.out.println("DAYS_IN_WEEK " + DAYS_IN_WEEK);

        // 5

        int maxValue = Integer.MAX_VALUE + 1;
        System.out.println("maxValue " + maxValue);
        // hasilnya negatif karena melebihi kapasitas int (overflow) nilai akan berputar


    }
}
