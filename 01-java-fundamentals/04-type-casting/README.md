# Type Casting

> Module: [01-java-fundamentals](../README.md) · Status: 🔄 In progress

## 🎯 Goal

Setelah topik ini, saya bisa:

- Menjelaskan beda widening (otomatis) dan narrowing (manual).
- Mengubah `double` ke `int` dan sebaliknya dengan aman.
- Mengubah `String` ke angka dengan `Integer.parseInt` dan `Double.parseDouble`.
- Menghindari jebakan pembagian `int / int`.

## 📝 Key Concepts

### 1. Apa itu type casting?

Type casting adalah mengubah nilai dari satu data type ke data type lain.

Analogi: menuang air dari gelas kecil ke ember besar selalu muat. Menuang dari ember besar ke gelas kecil bisa tumpah.

### 2. Widening (kecil → besar): otomatis

Java melakukannya sendiri karena aman.

```text
byte → short → int → long → float → double
                ↑
              char
```

```java
int myInt = 100;
long myLong = myInt;        // otomatis
double myDouble = myLong;   // otomatis
```

Catatan: `int` atau `long` ke `float`, dan `long` ke `double`, boleh otomatis tetapi presisinya bisa berkurang (menurut Java Language Specification).

### 3. Narrowing (besar → kecil): manual

Java meminta kita menulis cast sendiri dengan `(type)` karena ada risiko data hilang.

```java
double price = 19.99;
int wholePrice = (int) price;   // 19
```

Aturan penting:

- **Cast memotong, tidak membulatkan.** `(int) 3.99` menjadi `3`, dan `(int) -3.99` menjadi `-3`.
- Kalau nilai terlalu besar untuk type tujuan, hasilnya "berputar" (overflow) tanpa error: `(byte) 130` menjadi `-126`.

### 4. Membulatkan dengan `Math.round`

Kalau yang dibutuhkan pembulatan, pakai `Math.round`. Untuk `double`, hasilnya `long`, jadi perlu cast ke `int`.

```java
double grade = 7.6;
(int) grade;                     // 7 (dipotong)
Math.round(grade);               // 8 (dibulatkan)
(int) Math.round(grade);         // 8 sebagai int
```

### 5. `char` dan `int`

Setiap `char` punya nomor kode. Huruf `'A'` bernilai 65.

```java
int code = 'A';                  // 65
char letter = (char) 66;         // 'B'
'A' + 1;                         // 66 (hasilnya int, bukan char)
(char) ('A' + 1);                // 'B'
```

### 6. Campuran type dalam perhitungan

Hasil perhitungan memakai type yang lebih "besar".

- `int * double` → `double`
- `byte + byte` → `int` (bukan `byte`)

### 7. Jebakan pembagian `int / int`

Kalau kedua angka `int`, hasilnya juga `int` (desimalnya dibuang).

```java
7 / 2;                 // 3
(double) 7 / 2;        // 3.5  → 7 di-cast dulu, baru dibagi
(double) (7 / 2);      // 3.0  → dibagi dulu jadi 3, baru di-cast (terlambat)
```

Cast harus dilakukan **sebelum** pembagian. Operator dibahas lebih lengkap di topik `05-operators`.

### 8. `String` ↔ angka

`String` tidak bisa di-cast dengan `(int)`. Pakai method khusus:

| Tujuan | Cara |
|--------|------|
| `String` → `int` | `Integer.parseInt("123")` |
| `String` → `double` | `Double.parseDouble("3.14")` |
| angka → `String` | `String.valueOf(456)` |

Kalau teks bukan angka (misalnya `"abc"`), program berhenti saat dijalankan dengan `NumberFormatException`. Cara menangani error seperti ini dibahas di topik `03-java-core/03-exception-handling`.

## 💻 Code

File: [TypeCasting.java](TypeCasting.java)

Jalankan dari root repository:

```bash
java 01-java-fundamentals/04-type-casting/TypeCasting.java
```

Output yang diharapkan:

```text
int -> long -> double: 100 -> 100 -> 100.0
(int) 19.99 = 19
(int) 3.99  = 3
(int) -3.99 = -3
(byte) 130 = -126
(int) 3000000000L = -1294967296
cast:  7
round: 8
round as int: 8
'A' as number: 65
66 as char: B
'A' + 1 = 66
(char) ('A' + 1) = B
int * double = 7.5
byte + byte = 30
7 / 2 = 3
(double) 7 / 2 = 3.5
(double) (7 / 2) = 3.0
parseInt: 124
parseDouble: 6.28
valueOf: 4567
```

Bagian penting dari kode:

- Step 1: widening otomatis.
- Step 2 dan 3: narrowing dan data yang hilang atau berputar.
- Step 4: beda cast dan `Math.round`.
- Step 7: jebakan pembagian `int / int`.
- Step 8: mengubah teks dan angka. Perhatikan `valueOf: 4567`: hasilnya teks, jadi `"456" + "7"` digabung, bukan dijumlahkan.
- Di bagian bawah ada 6 kesalahan umum dalam bentuk komentar. Hapus `//` di depan satu baris, jalankan, dan baca hasilnya. Kembalikan `//` sebelum mencoba yang berikutnya.

## ⚠️ Common Mistakes

| Kesalahan | Hasil | Cara memperbaiki |
|-----------|-------|------------------|
| `int x = 3.99;` | `possible lossy conversion from double to int` | Tulis cast: `(int) 3.99` |
| `byte c = a + b;` | `possible lossy conversion from int to byte` | `byte + byte` menghasilkan `int`. Simpan di `int`, atau cast: `(byte) (a + b)` |
| `(int) "123"` | `String cannot be converted to int` | Pakai `Integer.parseInt("123")` |
| `(int) true` | `boolean cannot be converted to int` | `boolean` tidak bisa diubah ke angka |
| `Integer.parseInt("abc")` | `NumberFormatException` saat program berjalan | Pastikan teks berisi angka valid |
| `double avg = 7 / 2;` | Tidak error, tetapi hasilnya `3.0` | Cast sebelum bagi: `(double) 7 / 2` |

Kesalahan terakhir paling berbahaya karena tidak ada pesan error. Hasilnya salah tanpa peringatan.

## 🧪 Practice

- [ ] Ubah `double temperature = 36.8;` menjadi `int` dengan cast, lalu cetak. Tulis kenapa hasilnya `36`.
- [ ] Bulatkan `36.8` menjadi `37` dengan `Math.round` dan simpan di variabel `int`.
- [ ] Ubah teks `"2026"` menjadi `int`, tambahkan `1`, lalu cetak hasilnya.
- [ ] Hitung rata-rata dari `int a = 7` dan `int b = 2`. Hasil harus `4.5`.
- [ ] Cetak huruf `'E'` dengan menambahkan angka ke `'A'` dan memakai cast ke `char`.

Simpan jawabanmu di `01-java-fundamentals/exercises/` dengan nama `TypeCastingExercise.java`.

## 📖 Glossary

| English term | Arti dalam Bahasa Indonesia |
|--------------|-----------------------------|
| type casting | Mengubah nilai dari satu type ke type lain |
| widening | Mengubah type kecil ke type besar (otomatis) |
| narrowing | Mengubah type besar ke type kecil (manual) |
| explicit cast | Cast yang ditulis sendiri, misalnya `(int)` |
| truncation | Pemotongan bagian desimal tanpa pembulatan |
| parse | Membaca teks lalu mengubahnya menjadi angka |
| lossy conversion | Konversi yang bisa menghilangkan data |
| runtime error | Error yang muncul saat program berjalan, bukan saat compile |

## 📚 Resources

- [Java Language Specification, Chapter 5: Conversions and Contexts (Java SE 24)](https://docs.oracle.com/javase/specs/jls/se24/html/jls-5.html)
- [Oracle Java Tutorials: Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)