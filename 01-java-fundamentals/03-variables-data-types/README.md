# Variables dan Data Types

> Module: [01-java-fundamentals](../README.md) · Status: 🔄 In progress

## 🎯 Goal

Setelah topik ini, saya bisa:

- Membuat variabel dan mengisi nilainya.
- Memilih data type yang tepat: `int`, `long`, `double`, `char`, `boolean`, dan `String`.
- Menjelaskan apa itu overflow dan kenapa angka desimal tidak selalu tepat.
- Memberi nama variabel yang jelas dengan aturan `camelCase`.

## 📝 Key Concepts

### 1. Apa itu variabel?

Variabel adalah "kotak" bernama di memori untuk menyimpan sebuah nilai. Setiap kotak punya:

- **Type**: jenis isi yang boleh disimpan (angka, teks, dll.).
- **Name**: nama kotak.
- **Value**: isi kotak.

```java
int age = 23;
//  ^    ^    ^
// type name value
```

Ada dua langkah yang bisa digabung atau dipisah:

```java
int score;      // declaration (deklarasi): membuat kotak
score = 80;     // assignment (pengisian): mengisi nilai
score = 95;     // nilai boleh diganti, tetapi type-nya tetap int
```

### 2. Delapan primitive types

Primitive type adalah tipe dasar bawaan Java. Isinya langsung berupa nilai.

| Type | Ukuran | Isi | Contoh |
|------|--------|-----|--------|
| `byte` | 8 bit | Bilangan bulat kecil (-128 sampai 127) | `byte b = 100;` |
| `short` | 16 bit | Bilangan bulat (-32.768 sampai 32.767) | `short s = 30000;` |
| `int` | 32 bit | Bilangan bulat (sekitar -2,1 miliar sampai 2,1 miliar) | `int n = 23;` |
| `long` | 64 bit | Bilangan bulat sangat besar | `long l = 9000000000L;` |
| `float` | 32 bit | Desimal (presisi rendah) | `float f = 3.14f;` |
| `double` | 64 bit | Desimal (pilihan default) | `double d = 3.14;` |
| `char` | 16 bit | **Satu** karakter, tanda kutip tunggal | `char c = 'B';` |
| `boolean` | - | Hanya `true` atau `false` | `boolean ok = true;` |

Panduan cepat memilih:

- Bilangan bulat biasa → `int`. Kalau melebihi sekitar 2,1 miliar → `long`.
- Desimal → `double`.
- Satu huruf → `char`. Teks → `String`.
- Ya/tidak → `boolean`.

Catatan: `long` wajib diakhiri `L` dan `float` wajib diakhiri `f` pada angka literalnya.

### 3. String bukan primitive

`String` adalah teks, ditulis dengan huruf besar `S` dan tanda kutip ganda. `String` termasuk *reference type* (bukan primitive). Pembahasan lengkapnya ada di topik `11-string-stringbuilder`.

```java
String name = "Badru";   // teks: kutip ganda
char letter = 'B';       // satu karakter: kutip tunggal
```

### 4. Overflow

Setiap type punya batas. Kalau nilai melewati batas, nilainya "berputar" ke sisi lain, tanpa error.

```java
int maxInt = Integer.MAX_VALUE;   // 2147483647
System.out.println(maxInt + 1);   // -2147483648 (bukan 2147483648)
```

Analogi: odometer (penghitung jarak) mobil yang kembali ke 0 setelah angka maksimum.

### 5. Desimal tidak selalu tepat

Komputer menyimpan `float` dan `double` dalam bentuk biner, jadi sebagian angka desimal hanya perkiraan.

```java
System.out.println(0.1 + 0.2);    // 0.30000000000000004
```

Dokumentasi Oracle menyebut `double` tidak boleh dipakai untuk nilai yang harus tepat, seperti uang. Untuk itu ada class `BigDecimal` (dibahas nanti, bukan di topik ini).

### 6. Constant dengan `final`

`final` membuat nilai tidak bisa diubah setelah diisi. Nama constant biasanya `UPPER_SNAKE_CASE`.

```java
final double PI = 3.14159;
// PI = 3.14;  // error: cannot assign a value to final variable PI
```

Pembahasan `final` lebih lengkap ada di topik `09-static-final` (modul OOP).

### 7. `var`

`var` membuat Java menebak type dari nilainya. Hanya untuk variabel lokal (di dalam method) dan wajib langsung diberi nilai.

```java
var city = "Bogor";   // Java melihat String
var year = 2026;      // Java melihat int
```

Type-nya tetap: `city` tidak bisa tiba-tiba diisi angka.

### 8. Aturan dan konvensi nama variabel

Aturan (wajib):

- Boleh berisi huruf, angka, `_`, dan `$`. Tidak boleh diawali angka.
- Tidak boleh memakai keyword Java (misalnya `class`, `int`).
- Huruf besar dan kecil dianggap berbeda (`age` ≠ `Age`).

Konvensi (kebiasaan profesional):

- Pakai `camelCase`: `studentAge`, `totalPrice`.
- Pakai nama yang jelas: `studentAge` lebih baik daripada `a`.

## 💻 Code

File: [VariablesDataTypes.java](VariablesDataTypes.java)

Jalankan dari root repository:

```bash
java 01-java-fundamentals/03-variables-data-types/VariablesDataTypes.java
```

Output yang diharapkan:

```text
Age: 23
Score: 80
New score: 95
byte:    100
short:   30000
int:     2000000000
long:    9000000000
float:   3.14
double:  3.14159265359
char:    B
boolean: true
Name: Badru
byte range:  -128 to 127
short range: -32768 to 32767
int range:   -2147483648 to 2147483647
long range:  -9223372036854775808 to 9223372036854775807
maxInt + 1 = -2147483648
0.1 + 0.2 = 0.30000000000000004
PI: 3.14159
City: Bogor, Year: 2026
studentAge = 17, a = 17
```

Bagian penting dari kode:

- Step 1 sampai 3: deklarasi, inisialisasi, dan mengubah nilai.
- Step 4: contoh delapan primitive types.
- Step 6: `Byte.MIN_VALUE`, `Integer.MAX_VALUE`, dan sejenisnya adalah constant bawaan Java yang berisi batas tiap type.
- Step 7 dan 8: overflow dan ketidaktepatan desimal.
- Di bagian bawah ada 7 kesalahan umum dalam bentuk komentar. Hapus `//` di depan satu baris, jalankan, dan baca error-nya. Kembalikan `//` sebelum mencoba yang berikutnya.

## ⚠️ Common Mistakes

| Kesalahan | Pesan error | Cara memperbaiki |
|-----------|-------------|------------------|
| Memakai variabel sebelum diisi | `variable total might not have been initialized` | Beri nilai awal: `int total = 0;` |
| `int wrong = 3.14;` | `possible lossy conversion from double to int` | Pakai `double`, atau lakukan casting (topik berikutnya) |
| `long tooBig = 3000000000;` | `integer number too large` | Tambahkan `L`: `3000000000L` |
| `float price = 19.99;` | `possible lossy conversion from double to float` | Tambahkan `f`: `19.99f`, atau pakai `double` |
| `char grade = "A";` | `String cannot be converted to char` | `char` pakai kutip tunggal: `'A'` |
| Nama variabel dideklarasikan dua kali | `variable age is already defined` | Pakai nama lain, atau cukup ubah nilainya tanpa menulis type lagi |
| `int number = "10";` | `String cannot be converted to int` | Angka ditulis tanpa kutip: `10` |

## 🧪 Practice

- [ ] Buat variabel `name` (String), `age` (int), `city` (String), dan `isLearning` (boolean). Cetak dalam satu kalimat, misalnya: `Badru, 23, Bogor, learning: true`.
- [ ] Buat variabel `price` (double) berisi `19.99` dan `quantity` (int) berisi `3`. Cetak keduanya dengan label.
- [ ] Simpan `4000000000` di sebuah variabel dengan type yang tepat, lalu cetak.
- [ ] Buat constant `final int DAYS_IN_WEEK = 7;`. Coba ubah nilainya, baca error-nya, lalu kembalikan.
- [ ] Cetak `Integer.MAX_VALUE + 1` dan tulis dengan kata-katamu sendiri kenapa hasilnya negatif.

Simpan jawabanmu di `01-java-fundamentals/exercises/` dengan nama `VariablesDataTypesExercise.java`.

## 📖 Glossary

| English term | Arti dalam Bahasa Indonesia |
|--------------|-----------------------------|
| variable | Wadah bernama untuk menyimpan nilai |
| data type | Jenis data yang boleh disimpan di variabel |
| declaration | Membuat variabel (menyebut type dan nama) |
| initialization | Mengisi nilai awal variabel |
| assignment | Mengisi atau mengganti nilai variabel |
| primitive type | Tipe dasar bawaan Java (`int`, `double`, `boolean`, dll.) |
| overflow | Nilai melewati batas type sehingga "berputar" ke sisi lain |
| constant | Variabel yang nilainya tidak bisa diubah (`final`) |

## 📚 Resources

- [Oracle Java Tutorials: Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)