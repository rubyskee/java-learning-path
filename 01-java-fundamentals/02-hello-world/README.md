# Hello World

> Module: [01-java-fundamentals](../README.md) · Status: 🔄 In progress

## 🎯 Goal

Setelah topik ini, saya bisa:

- Menulis, menyimpan, dan menjalankan program Java pertama.
- Menjelaskan fungsi setiap bagian dari method `main`.
- Mencetak teks dengan `System.out.println` dan `System.out.print`.
- Membaca pesan error compiler sederhana dan memperbaikinya.

## 📝 Key Concepts

### 1. Program Java paling kecil

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### 2. Arti tiap bagian

| Bagian | Arti |
|--------|------|
| `public class HelloWorld` | Membuat class bernama `HelloWorld`. Class adalah wadah untuk kode. |
| `public static void main(String[] args)` | **Entry point** (titik masuk). JVM memulai program dari sini. |
| `System.out.println("...")` | Mencetak teks ke layar, lalu pindah ke baris baru. |
| `{ }` | Kurung kurawal menandai awal dan akhir sebuah blok kode. |
| `;` | Titik koma mengakhiri satu statement (seperti titik di akhir kalimat). |

Arti kata pada baris `main`:

- `public`: bisa dipanggil dari mana saja (JVM harus bisa memanggilnya).
- `static`: JVM bisa menjalankannya tanpa membuat object dulu. (Object dipelajari di modul OOP.)
- `void`: method ini tidak mengembalikan nilai apa pun.
- `String[] args`: daftar teks yang bisa diberikan saat program dimulai. Belum kita pakai sekarang.

Analogi: `main` adalah pintu depan rumah. JVM selalu masuk ke program lewat pintu ini.

### 3. Aturan penting

- Java bersifat **case-sensitive**: `System` dan `system` dianggap berbeda.
- Nama class `public` harus **sama dengan nama file**: `HelloWorld` → `HelloWorld.java`.
- Nama class memakai `PascalCase`. Nama method dan variabel memakai `camelCase`.

### 4. `println` vs `print`

- `System.out.println("Hi")` mencetak teks, lalu pindah baris.
- `System.out.print("Hi")` mencetak teks dan tetap di baris yang sama.

### 5. Escape characters

Beberapa karakter khusus perlu diawali backslash `\`.

| Kode | Hasil |
|------|-------|
| `\n` | Baris baru |
| `\t` | Tab |
| `\"` | Tanda kutip ganda |
| `\\` | Satu backslash |

### 6. Komentar

Komentar adalah catatan untuk manusia. Compiler mengabaikannya.

```java
// komentar satu baris
/* komentar
   beberapa baris */
```

## 💻 Code

File: [HelloWorld.java](HelloWorld.java)

Jalankan dari root repository:

```bash
java 01-java-fundamentals/02-hello-world/HelloWorld.java
```

Java menjalankan file ini langsung (single-file mode). Kode di-compile di memori, jadi tidak ada langkah `javac` terpisah. Cara ini berlaku di Java 11 ke atas.

Output yang diharapkan:

```text
Hello, World!
Line one
Line two
Same line
My name is Badru.
I am learning Java.
First	Second
Top
Bottom
She said "Hello"
C:\Users\Badru
2 + 3 = 5
```

Bagian penting dari kode:

- `main`: titik masuk. Semua kode di file ini ada di dalamnya.
- Step 2 menunjukkan beda `println` dan `print`.
- Step 4 menunjukkan escape characters.
- Step 5 memakai `+` untuk menggabungkan teks dan hasil hitungan. `(2 + 3)` diberi kurung supaya Java menghitung `5` lebih dulu.
- Di bagian bawah ada 4 kesalahan umum dalam bentuk komentar. Hapus `//` di depan satu baris, jalankan program, lalu baca error-nya. Kembalikan `//` sebelum mencoba yang berikutnya.

## ⚠️ Common Mistakes

| Kesalahan | Pesan error | Cara memperbaiki |
|-----------|-------------|------------------|
| Lupa `;` | `';' expected` | Tambahkan `;` di akhir statement |
| Menulis `system` bukan `System` | `package system does not exist` | Java case-sensitive: pakai `System` |
| Lupa tanda kutip penutup `"` | `unclosed string literal` | Tutup setiap string dengan `"` |
| Menulis `printline` bukan `println` | `cannot find symbol` | Periksa ejaan nama method |
| Nama file berbeda dari nama class | Error compile pada class `public` | Samakan nama file dan nama class |

Tips: baca error dari atas. Nomor baris menunjukkan tempat yang harus diperiksa. Kesalahan aslinya sering ada di baris itu atau baris sebelumnya.

## 🧪 Practice

- [ ] Ubah output agar mencetak nama lengkap dan kotamu (2 baris).
- [ ] Cetak kotak bintang setinggi 3 baris memakai `println`.
- [ ] Cetak persis ini: `Java is "fun"` (lengkap dengan tanda kutip).
- [ ] Cetak `Name<TAB>Age` di satu baris dan `Badru<TAB>23` di baris berikutnya, memakai `\t`.
- [ ] Buat `HelloWorldExercise.java` di `01-java-fundamentals/exercises/`. Cetak perkenalan diri singkat dalam bahasa Inggris, minimal 4 baris.

## 📖 Glossary

| English term | Arti dalam Bahasa Indonesia |
|--------------|-----------------------------|
| class | Wadah/cetakan untuk kode Java |
| method | Blok kode yang punya nama dan bisa dipanggil |
| `main` method | Titik awal program Java dijalankan |
| statement | Satu perintah lengkap, diakhiri `;` |
| syntax error | Kesalahan penulisan kode yang membuat kode tidak bisa di-compile |
| comment | Catatan dalam kode yang diabaikan compiler |
| escape character | Karakter khusus dengan `\` di depannya, misalnya `\n` |
| case-sensitive | Huruf besar dan kecil dianggap berbeda |

## 📚 Resources

- [Oracle Java Tutorials: Getting Started](https://docs.oracle.com/javase/tutorial/getStarted)