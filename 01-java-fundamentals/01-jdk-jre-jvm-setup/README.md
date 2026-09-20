# JDK, JRE, JVM and Setup

> Module: [01-java-fundamentals](../README.md) · Status: 🔄 In progress

## 🎯 Goal

After this topic, I can:

- Explain the difference between JDK, JRE, and JVM in simple words.
- Explain how a `.java` file becomes a running program.
- Install JDK 25 (LTS) on Windows.
- Check that Java works with `java -version` and `javac -version`.

## 📝 Key Concepts

### 1. What is Java?

Java is a programming language. You write code in a text file that ends with `.java`. A computer cannot run this file directly. It must be **compiled** first.

### 2. JVM (Java Virtual Machine)

The JVM is the "engine" that runs Java programs. It reads **bytecode** and runs it on your computer.

Analogy: bytecode is a book written in one universal language. The JVM is a translator that lives on each computer (Windows, macOS, Linux). Because of this, the same bytecode can run on any system that has a JVM. This idea is called *"write once, run anywhere"*.

### 3. JRE (Java Runtime Environment)

The JRE = JVM + standard libraries (ready-made code like `String`, `List`, `Scanner`). It has everything needed to **run** a Java program, but not the tools to **build** one.

### 4. JDK (Java Development Kit)

The JDK = JRE + development tools. The two most important tools:

| Tool | Job |
|------|-----|
| `javac` | Compiler. Turns `.java` (source code) into `.class` (bytecode). |
| `java` | Launcher. Starts the JVM and runs your program. |

Because I want to **write** Java programs, I install the **JDK**. Modern Java downloads are mainly JDK, so I do not need to install a separate JRE.

```text
JDK
└── JRE
    └── JVM
```

Analogy: JDK is a full workshop (tools + engine). JRE is just the engine room. JVM is the engine.

### 5. From code to running program

```text
HelloWorld.java  --(javac)-->  HelloWorld.class  --(java / JVM)-->  Output
  source code                     bytecode                        result
```

### 6. What is an LTS version?

LTS means **Long-Term Support**. An LTS version gets updates for a long time, so it is the safe choice for learning and for jobs. **JDK 25 is an LTS release.** JDK 21 is the previous LTS. Companies often use LTS versions.

## 💻 Code

This topic has no code file. These are the steps and commands.

### Install JDK 25 on Windows

1. Open the official Oracle page: <https://www.oracle.com/java/technologies/downloads/>
2. Choose the **JDK 25** tab (not the newest non-LTS version).
3. Under **Windows**, download the **x64 Installer** (`.exe`).
4. Double-click the file and follow the installer. Keep the default install folder. The default is `C:\Program Files\Java\jdk-25`.
5. Close all terminal windows, then open a **new** Command Prompt or PowerShell.

> If Oracle asks you to sign in, use the Microsoft Build of OpenJDK 25 instead: <https://learn.microsoft.com/en-us/java/openjdk/download>

### Check the installation

Run these commands in a new terminal:

```bash
java -version
javac -version
where.exe java
```

Expected result:

- `java -version` shows a version that starts with `25`.
- `javac -version` shows `javac 25...`.
- `where.exe java` shows the path of the `java` program.

What each command does:

- `java -version`: checks that the JVM/launcher is installed.
- `javac -version`: checks that the compiler is installed. This proves you have the **JDK**, not only a runtime.
- `where.exe java`: shows which `java` file Windows will use.

## ⚠️ Common Mistakes

- **Not reopening the terminal.** A terminal opened before the install does not know the new `java`. Close it and open a new one.
- **`javac` is not recognized, but `java` works.** You probably installed a runtime only, or another Java is first in `PATH`. Run `where.exe java` and check the path.
- **Wrong version shown (for example 8 or 17).** An old Java is earlier in `PATH`. Use `where.exe java` to find it, then uninstall it or fix `PATH`.
- **Confusing JDK and JRE.** To write and compile code, you need the JDK.
- **Downloading from unofficial websites.** Use official sources only.

## 🧪 Practice

- [ ] Install JDK 25 and run `java -version`. Write the output in a text file.
- [ ] Run `javac -version` and `where.exe java`. Write what each output means.
- [ ] Draw the flow from `.java` to output with your own words (no copy-paste).
- [ ] Explain JDK vs JRE vs JVM to an imaginary friend in 5 sentences.
- [ ] Find where the JDK folder is on your computer. Look inside the `bin` folder and name 3 tools.

## 📖 Glossary

| English term | Arti dalam Bahasa Indonesia |
|--------------|-----------------------------|
| JDK (Java Development Kit) | Paket lengkap untuk membuat program Java (compiler + tools + runtime) |
| JRE (Java Runtime Environment) | Lingkungan untuk menjalankan program Java |
| JVM (Java Virtual Machine) | Mesin yang menjalankan bytecode Java |
| Compiler | Program yang mengubah source code menjadi bytecode |
| Bytecode | Kode setengah jadi hasil compile (`.class`), dibaca oleh JVM |
| Source code | Kode yang kita tulis sendiri (`.java`) |
| LTS (Long-Term Support) | Versi dengan dukungan update jangka panjang |
| PATH | Daftar folder yang dicari Windows saat kita mengetik sebuah perintah |

## 📚 Resources

- [Oracle: Download the latest Java LTS](https://www.oracle.com/java/technologies/downloads/)
- [Oracle: Installation of the JDK on Microsoft Windows (JDK 25)](https://docs.oracle.com/en/java/javase/25/install/installation-jdk-microsoft-windows-platforms.html)
- [Microsoft Build of OpenJDK: Download](https://learn.microsoft.com/en-us/java/openjdk/download)