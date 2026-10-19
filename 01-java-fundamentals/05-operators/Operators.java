public class Operators {

    public static void main(String[] args) {

        // ===================== 1. ARITHMETIC OPERATORS =====================
        int a = 10;
        int b = 3;
        System.out.println("a + b = " + (a + b));   // 13
        System.out.println("a - b = " + (a - b));   // 7
        System.out.println("a * b = " + (a * b));   // 30
        System.out.println("a / b = " + (a / b));   // 3  (int / int dibulatkan ke bawah, bukan error)
        System.out.println("a % b = " + (a % b));   // 1  (sisa bagi / modulus)

        double x = 10.0;
        double y = 3.0;
        System.out.println("x / y = " + (x / y));   // 3.3333333333333335

        // ===================== 2. UNARY OPERATORS =====================
        int count = 5;
        System.out.println("-count = " + (-count));      // -5 (negasi)

        int plusPlus = 5;
        System.out.println("plusPlus++ = " + (plusPlus++)); // 5 (nilai dipakai DULU, baru ditambah)
        System.out.println("after: " + plusPlus);            // 6

        int plusPlus2 = 5;
        System.out.println("++plusPlus2 = " + (++plusPlus2)); // 6 (ditambah DULU, baru dipakai)
        System.out.println("after: " + plusPlus2);             // 6

        boolean isReady = false;
        System.out.println("!isReady = " + (!isReady));  // true (kebalikan)

        // ===================== 3. ASSIGNMENT OPERATORS =====================
        int total = 10;
        total += 5;   // sama dengan: total = total + 5;
        System.out.println("total += 5 -> " + total);    // 15
        total -= 3;   // total = total - 3;
        System.out.println("total -= 3 -> " + total);    // 12
        total *= 2;   // total = total * 2;
        System.out.println("total *= 2 -> " + total);    // 24
        total /= 4;   // total = total / 4;
        System.out.println("total /= 4 -> " + total);    // 6
        total %= 4;   // total = total % 4;
        System.out.println("total %= 4 -> " + total);    // 2

        // ===================== 4. COMPARISON OPERATORS =====================
        int p = 10;
        int q = 20;
        System.out.println("p == q : " + (p == q));  // false
        System.out.println("p != q : " + (p != q));  // true
        System.out.println("p < q  : " + (p < q));   // true
        System.out.println("p > q  : " + (p > q));   // false
        System.out.println("p <= 10: " + (p <= 10)); // true
        System.out.println("p >= 20: " + (p >= 20)); // false

        // ===================== 5. LOGICAL OPERATORS =====================
        boolean hasKtp = true;
        boolean hasMoney = false;
        System.out.println("hasKtp && hasMoney : " + (hasKtp && hasMoney)); // false (AND: semua harus true)
        System.out.println("hasKtp || hasMoney : " + (hasKtp || hasMoney)); // true  (OR: salah satu true)
        System.out.println("!hasMoney          : " + (!hasMoney));          // true  (NOT: membalik)

        // Short-circuit: bagian kanan && tidak dijalankan kalau kiri sudah false
        int[] numbers = null;
        if (numbers != null && numbers.length > 0) {
            System.out.println("array has data");
        } else {
            System.out.println("short-circuit prevents NullPointerException"); // ini yang tercetak
        }

        // ===================== 6. TERNARY OPERATOR =====================
        int age = 17;
        String status = (age >= 18) ? "dewasa" : "anak-anak"; // condition ? ifTrue : ifFalse
        System.out.println("status: " + status);

        // ===================== 7. OPERATOR PRECEDENCE (urutan pengerjaan) =====================
        int result1 = 2 + 3 * 4;        // * dikerjakan dulu: 2 + 12 = 14
        int result2 = (2 + 3) * 4;      // kurung dikerjakan dulu: 5 * 4 = 20
        System.out.println("2 + 3 * 4 = " + result1);
        System.out.println("(2 + 3) * 4 = " + result2);

        // ===================== 8. STRING CONCATENATION dengan + =====================
        System.out.println("1 + 2 = " + 1 + 2);        // "12" (dari kiri ke kanan: "1+2"+"2" -> salah duga)
        System.out.println("1 + 2 = " + (1 + 2));       // "3" (kurung memaksa dihitung dulu)

        // ---------------------------------------------------------------
        // COMMON MISTAKES: hapus // di depan SATU baris untuk melihat hasilnya.
        // Kembalikan // sebelum mencoba baris berikutnya.
        // ---------------------------------------------------------------

        // 1. Memakai = (assignment) padahal maksudnya == (comparison)
        // int n = 5;
        // if (n = 10) { System.out.println("salah"); }   // error: incompatible types: int cannot be converted to boolean

        // 2. Membandingkan desimal dengan == (hasilnya sering tidak sesuai dugaan)
        // System.out.println(0.1 + 0.2 == 0.3);          // false, bukan true (lihat topik 03)

        // 3. Lupa urutan + pada String
        // System.out.println("Total: " + 2 + 3);         // "Total: 23", bukan "Total: 5"

        // 4. Pembagian dengan nol untuk int (error saat program jalan)
        // System.out.println(10 / 0);                    // ArithmeticException: / by zero

        // 5. Pembagian dengan nol untuk double (tidak error, tapi Infinity)
        // System.out.println(10.0 / 0);                  // Infinity
    }
}