public class OperatorsExercise {
    public static void main(String[] args) {
        //1
        int stok = 10;
        stok -= 3;
        System.out.println("stok = " + stok);

        //2
        int a = 10;
        int b = 3;
        int result = a % b;
        System.out.println("result = " + result);
        // hasil dari modulus di atas adalah 1 karena sisa pembagian dari 10 dibagi 3 adalah 1

        //3
        boolean umur18 = true;
        boolean punyaKTP = false;
        if (umur18 && punyaKTP){
            System.out.println("diterima");
        } else {
            System.out.println("tidak diterima");
        }

        if (umur18 || punyaKTP){
            System.out.println("diterima");
        } else {
            System.out.println("tidak diterima");
        }

        //4
        int nilai = 75;
        String lulus = (nilai >= 75) ? "lulus" : "tidak lulus";
        System.out.println("lulus = " + lulus);

        //5
        //Jika di catat pada kertas terlebih dahulu hasil dari 10 + 20 / 2 - 5 * 2 adalah 10
        // perkalian dan pembagian di dahulukan
        int hasilNilai = 10 + 20 / 2 - 5 * 2;
        System.out.println("hasilNilai = " + hasilNilai);
    }
}
