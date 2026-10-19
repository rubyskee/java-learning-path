# Operators

> Module: [01-java-fundamentals](../README.md) · Status: 🔄 In progress

## 🎯 Goal

Setelah topik ini, saya bisa:

- Memakai operator aritmatika, unary, assignment, perbandingan, dan logika.
- Menjelaskan beda `++x` dan `x++`.
- Memakai ternary operator sebagai bentuk singkat `if-else`.
- Menjelaskan urutan pengerjaan operator (precedence) dan jebakan `+` pada String.

## 📝 Key Concepts

### 1. Arithmetic operators

| Operator | Arti | Contoh | Hasil |
|----------|------|--------|-------|
| `+` | Tambah | `10 + 3` | `13` |
| `-` | Kurang | `10 - 3` | `7` |
| `*` | Kali | `10 * 3` | `30` |
| `/` | Bagi | `10 / 3` | `3` (int / int dibulatkan ke bawah) |
| `%` | Modulus (sisa bagi) | `10 % 3` | `1` |

Pembagian `int / int` tidak error, tapi hasilnya dipotong. Jebakan ini sudah dibahas di topik `04-type-casting`.

### 2. Unary operators

Operator yang hanya butuh **satu** nilai.

| Operator | Arti |
|----------|------|
| `-x` | Negasi (membalik tanda) |
| `!x` | NOT (membalik `boolean`) |
| `x++` | Post-increment: nilai dipakai dulu, baru ditambah 1 |
| `++x` | Pre-increment: ditambah 1 dulu, baru dipakai |
| `x--` / `--x` | Sama seperti di atas, tapi dikurangi 1 |

```java
int n = 5;
n++;   // n menjadi 6, tapi nilai n++ ITU SENDIRI adalah 5
++n;   // nilai ++n itu sendiri adalah nilai setelah ditambah
```

Analogi: `x++` seperti mengambil nomor antrean dulu, baru nomornya bertambah untuk orang berikutnya. `++x` seperti nomornya bertambah dulu, baru diberikan ke kita.

### 3. Assignment operators

Bentuk singkat dari "ambil nilai lama, operasikan, simpan lagi".

| Operator | Sama dengan |
|----------|-------------|
| `x += 5` | `x = x + 5` |
| `x -= 5` | `x = x - 5` |
| `x *= 5` | `x = x * 5` |
| `x /= 5` | `x = x / 5` |
| `x %= 5` | `x = x % 5` |

### 4. Comparison (relational) operators

Hasilnya selalu `boolean` (`true` atau `false`).

| Operator | Arti |
|----------|------|
| `==` | Sama dengan |
| `!=` | Tidak sama dengan |
| `<` | Lebih kecil |
| `>` | Lebih besar |
| `<=` | Lebih kecil atau sama dengan |
| `>=` | Lebih besar atau sama dengan |

Catatan penting: `==` untuk angka desimal (`float`/`double`) bisa memberi hasil yang tidak terduga, karena desimal tidak selalu tepat (lihat topik `03-variables-data-types`).

### 5. Logical operators

Dipakai untuk menggabungkan beberapa kondisi `boolean`.

| Operator | Arti | Aturan |
|----------|------|--------|
| `&&` | AND | `true` hanya jika **kedua** sisi `true` |
| `\|\|` | OR | `true` jika **salah satu** sisi `true` |
| `!` | NOT | Membalik nilai |

**Short-circuit evaluation**: pada `&&`, kalau sisi kiri sudah `false`, sisi kanan **tidak dijalankan** (hasilnya pasti `false`). Pada `||`, kalau sisi kiri sudah `true`, sisi kanan tidak dijalankan. Ini sering dipakai untuk mencegah error, misalnya mengecek `array != null` sebelum mengecek isinya.

```java
if (numbers != null && numbers.length > 0) { ... }
// kalau numbers null, bagian "numbers.length" tidak pernah dicoba,
// jadi tidak terjadi error
```

### 6. Ternary operator

Bentuk singkat dari `if-else` yang menghasilkan sebuah nilai.

```java
kondisi ? nilaiJikaTrue : nilaiJikaFalse
```

```java
String status = (age >= 18) ? "dewasa" : "anak-anak";
```

Pembahasan `if-else` lengkap ada di topik `07-if-else-switch`.

### 7. Operator precedence (urutan pengerjaan)

Seperti matematika sekolah: `*` dan `/` dikerjakan sebelum `+` dan `-`. Kurung `()` selalu dikerjakan paling dulu.

```java
2 + 3 * 4     // = 14, bukan 20
(2 + 3) * 4   // = 20
```

Kalau ragu urutannya, selalu aman memakai kurung.

### 8. `+` untuk String

`+` dipakai untuk penjumlahan angka, tapi juga untuk menggabungkan teks (concatenation). Java membaca dari **kiri ke kanan**.

```java
"Total: " + 2 + 3     // "Total: 23"  (String + 2 jadi "Total: 2", lalu + 3 jadi "Total: 23")
"Total: " + (2 + 3)   // "Total: 5"   (kurung memaksa 2 + 3 dihitung dulu)
```

## 💻 Code

File: [Operators.java](Operators.java)

Jalankan dari root repository:

```bash
java 01-java-fundamentals/05-operators/Operators.java
```

Output yang diharapkan (ringkas):

```text
a + b = 13
a % b = 1
x / y = 3.3333333333333335
plusPlus++ = 5
after: 6
++plusPlus2 = 6
total %= 4 -> 2
p < q  : true
hasKtp && hasMoney : false
short-circuit prevents NullPointerException
status: anak-anak
2 + 3 * 4 = 14
(2 + 3) * 4 = 20
1 + 2 = 12
1 + 2 = 3
```

Bagian penting dari kode:

- Section 2: perbandingan langsung `plusPlus++` vs `++plusPlus2` memakai variabel terpisah supaya hasilnya jelas.
- Section 5: contoh short-circuit dengan array `null`, supaya terlihat kenapa urutan `&&` penting.
- Section 8: dua baris terakhir menunjukkan jebakan `+` pada String dengan dan tanpa kurung.
- Di bagian bawah ada 5 kesalahan umum dalam bentuk komentar. Hapus `//` di depan satu baris, jalankan, dan baca hasilnya. Kembalikan `//` sebelum mencoba yang berikutnya.

## ⚠️ Common Mistakes

| Kesalahan | Hasil | Cara memperbaiki |
|-----------|-------|-------------------|
| `if (n = 10)` | `error: incompatible types: int cannot be converted to boolean` | Pakai `==` untuk membandingkan, `=` hanya untuk mengisi nilai |
| `0.1 + 0.2 == 0.3` | `false`, bukan `true` | Jangan bandingkan desimal dengan `==`. Bandingkan selisihnya dengan nilai sangat kecil (dibahas lebih lanjut nanti) |
| `"Total: " + 2 + 3` | `"Total: 23"`, bukan `"Total: 5"` | Beri kurung: `"Total: " + (2 + 3)` |
| `10 / 0` | `ArithmeticException: / by zero` | Cek pembagi tidak nol sebelum membagi (`int`) |
| `10.0 / 0` | `Infinity` (tidak error) | Pembagian `double` dengan nol tidak melempar error, tapi hasilnya `Infinity` atau `NaN` |

## 🧪 Practice

- [ ] Buat `int stok = 10;`. Kurangi dengan `-=` sebanyak `3`, lalu cetak hasilnya.
- [ ] Buat dua variabel `int`, cetak hasil `%` (modulus), lalu jelaskan dalam satu kalimat kegunaan `%` (misalnya mengecek angka genap/ganjil).
- [ ] Buat `boolean umur18 = true;` dan `boolean punyaKTP = false;`. Cetak hasil `&&` dan `||` keduanya.
- [ ] Buat ternary operator yang mencetak `"lulus"` jika `nilai >= 75`, atau `"tidak lulus"` jika tidak.
- [ ] Prediksi dulu di kertas, baru buktikan dengan kode: berapa hasil `10 + 20 / 2 - 5 * 2`?

Simpan jawabanmu di `01-java-fundamentals/exercises/` dengan nama `OperatorsExercise.java`.

## 📖 Glossary

| English term | Arti dalam Bahasa Indonesia |
|--------------|-------------------------------|
| operator | Simbol untuk melakukan operasi (`+`, `-`, `==`, dll.) |
| operand | Nilai yang dioperasikan oleh operator |
| modulus | Sisa hasil bagi (`%`) |
| increment / decrement | Menambah / mengurangi nilai sebanyak 1 |
| short-circuit evaluation | Java berhenti mengevaluasi lebih awal kalau hasilnya sudah pasti |
| ternary operator | Operator tiga bagian (`? :`) sebagai bentuk singkat `if-else` |
| precedence | Urutan operator mana yang dikerjakan lebih dulu |
| concatenation | Menggabungkan teks dengan `+` |

## 📚 Resources

- [Oracle Java Tutorials: Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Oracle Java Tutorials: Assignment, Arithmetic, and Unary Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html)
- [Oracle Java Tutorials: Equality, Relational, and Conditional Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html)