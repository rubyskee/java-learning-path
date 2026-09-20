<!-- ============================================================
  README — java-learning-path
  How to use: put this file in the ROOT of the repository.
  Search for the word "USERNAME" and replace it with your GitHub username.
============================================================ -->

<!-- BANNER: auto-generated header (capsule-render). Change text= and desc= to edit it -->
<img src="https://capsule-render.vercel.app/api?type=waving&height=230&color=5382A1&section=header&text=Java%20Learning%20Path&fontSize=56&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=From%20Java%20fundamentals%20to%20Fullstack%20Java%20Developer&descSize=20&descAlignY=60" width="100%" alt="Java Learning Path banner" />

<div align="center">

<!-- TYPING TEXT: lines rotate automatically -->
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&pause=1200&color=ED8B00&center=true&vCenter=true&width=600&lines=Learning+Java+in+public;One+module+at+a+time;Notes+%2B+code+%2B+exercises;Building+toward+Fullstack+Java" alt="Typing animation" />

<br><br>

<!-- BADGES: quick facts about the repository -->
<img src="https://img.shields.io/badge/Java-25_LTS-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 25 LTS" />
<img src="https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven" />
<img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge" alt="MIT License" />
<img src="https://img.shields.io/badge/Status-Learning_in_progress-brightgreen?style=for-the-badge" alt="Status" />
<br>
<img src="https://img.shields.io/github/last-commit/USERNAME/java-learning-path?style=flat-square&color=5382A1" alt="Last commit" />
<img src="https://img.shields.io/github/repo-size/USERNAME/java-learning-path?style=flat-square&color=5382A1" alt="Repo size" />

<br><br>

**[About](#-about-this-repository)** ·
**[Curriculum](#-curriculum)** ·
**[Folder Structure](#-folder-structure)** ·
**[Getting Started](#-getting-started)** ·
**[Git Standards](#-git-standards)** ·
**[Projects](#-related-projects)** ·
**[License](#-license)**

</div>

---

## 🎯 About This Repository

This is my structured learning path to become a **Fullstack Java Developer**, one step at a time. Every topic I study is documented here with notes, working code, and exercises, so my progress is visible and verifiable.

**What you will find here**

- 📝 Short notes in each module's `README.md`
- 💻 Runnable Java code for every sub-topic
- 🧪 Exercises after each module
- 📈 A commit history that shows consistent daily progress

**Why one repository?**
All learning material lives in this single repository, split by numbered folders. Real projects live in separate repositories (see [Related Projects](#-related-projects)), so this repository stays organized and my profile stays clean.

**Who is this for?**
Recruiters who want to see how I learn, and anyone who wants a clear Java roadmap to follow.

---

## 📚 Curriculum

Status legend: 🔄 In progress · 📅 Planned · ✅ Done

| # | Module (folder) | Sub-topics | Status |
|---|-----------------|------------|--------|
| 01 | [`01-java-fundamentals`](./01-java-fundamentals) | JDK/JRE/JVM & setup · Hello World · Variables & data types · Type casting · Operators · User input (`Scanner`) · `if`/`else` & `switch` · Loops (`for`, `while`, `do-while`) · Methods · Arrays · `String` & `StringBuilder` | 🔄 |
| 02 | [`02-java-oop`](./02-java-oop) | Class & object · Constructor · `this` keyword · Encapsulation · Inheritance · Polymorphism (overloading & overriding) · Abstract class · Interface · `static` & `final` · Enum · Record · Packages | 📅 |
| 03 | [`03-java-core`](./03-java-core) | Collections (`List`, `Set`, `Map`, `Queue`) · Generics · Exception handling · File I/O (NIO) · Lambda & functional interfaces · Stream API · `Optional` · Date & Time API · Modern Java (`var`, text blocks, switch expressions, sealed classes) · Multithreading basics | 📅 |
| 04 | [`04-tools-testing`](./04-tools-testing) | Git & GitHub workflow · Maven (`pom.xml`, dependencies, lifecycle) · JUnit 5 · Mockito · Logging (SLF4J) | 📅 |
| 05 | [`05-sql-postgresql`](./05-sql-postgresql) | Relational database concepts · SQL CRUD · `JOIN` · `GROUP BY` & aggregates · Constraints & normalization · Index · Transaction (ACID) · JDBC | 📅 |
| 06 | [`06-spring-boot`](./06-spring-boot) | Project structure (Spring Initializr) · IoC & Dependency Injection · REST controller (CRUD) · Layered architecture (controller, service, repository) · Spring Data JPA & Hibernate · Bean validation · Global exception handling · DTO · Spring Security & JWT · OpenAPI/Swagger · API testing | 📅 |
| 07 | [`07-docker-cicd`](./07-docker-cicd) | Docker concepts · `Dockerfile` for Spring Boot · Docker Compose (app + PostgreSQL) · Environment variables · GitHub Actions (build & test) | 📅 |
| 08 | [`08-redis-messaging`](./08-redis-messaging) | Redis basics · Spring Cache with Redis · Message queue concepts · Kafka basics (topic, producer, consumer) | 📅 |
| 09 | [`09-cloud-system-design`](./09-cloud-system-design) | AWS basics (EC2, S3, RDS, IAM) · Deployment · REST API design best practices · System design basics (scalability, load balancer, caching, database design) | 📅 |
| 10 | [`10-ai-integration`](./10-ai-integration) | LLM API concepts · Calling an LLM API from Spring Boot · Prompt basics · Spring AI introduction | 📅 |
| 11 | [`11-frontend-basics`](./11-frontend-basics) | HTML & CSS · JavaScript basics · Consuming a REST API with `fetch` · Frontend framework (to be decided) | 📅 |

---

## 📁 Folder Structure

```text
java-learning-path/
├── 01-java-fundamentals/
│   ├── README.md          # notes, sub-topic list, key takeaways
│   ├── src/               # runnable Java code, one file per sub-topic
│   └── exercises/         # practice problems and solutions
├── 02-java-oop/
├── 03-java-core/
├── 04-tools-testing/
├── 05-sql-postgresql/
├── 06-spring-boot/
├── 07-docker-cicd/
├── 08-redis-messaging/
├── 09-cloud-system-design/
├── 10-ai-integration/
├── 11-frontend-basics/
├── .gitignore
├── LICENSE
└── README.md              # this file
```

Every module folder follows the same layout: `README.md` for notes, `src/` for code, and `exercises/` for practice.

**Rules for files and folders**

| Item | Rule | Example |
|------|------|---------|
| Module folder | Number prefix + lowercase + hyphens | `02-java-oop` |
| Java class | `PascalCase`, one public class per file | `BankAccount.java` |
| Java method & variable | `camelCase` | `calculateTotal` |
| Non-Java file | Lowercase + hyphens | `study-notes.md` |

---

## 🚀 Getting Started

**Requirements**

| Tool | Version | Purpose |
|------|---------|---------|
| JDK | 25 (LTS) | Compile and run Java code |
| Maven | 3.9+ | Build tool (from module 04) |
| Git | Latest | Version control |
| IDE | IntelliJ IDEA Community or VS Code | Code editor |

**Clone and run**

```bash
# 1. Clone the repository
git clone https://github.com/USERNAME/java-learning-path.git
cd java-learning-path

# 2. Check your Java version
java -version

# 3. Run a single-file example (Java runs the file directly, no separate compile step)
java 01-java-fundamentals/src/HelloWorld.java
```

**First-time Git setup** (only once per computer)

```bash
git config --global user.name "Your Full Name"
git config --global user.email "email-used-on-github@example.com"
```

The email must match your GitHub account, otherwise your commits will not appear on your contribution graph.

---

## 🔀 Git Standards

These rules keep the commit history clean, readable, and professional.

### 1. Branch strategy

| Branch | Use | Rule |
|--------|-----|------|
| `main` | Learning notes and exercises | Small, frequent commits directly to `main` |
| `feat/<name>` | Larger work (used in project repositories) | Merge into `main` through a Pull Request |

`main` must always contain working code.

### 2. Commit message format

This repository follows **Conventional Commits**, a common standard for writing commit messages:

```text
<type>(<scope>): <short description>
```

- **type**: what kind of change it is (see table below)
- **scope**: the module you worked on, e.g. `fundamentals`, `oop`, `core`, `spring`
- **description**: what you did, in the imperative mood, lowercase, no period, max 72 characters

| Type | Use for | Example |
|------|---------|---------|
| `feat` | New code or new topic | `feat(oop): add inheritance examples` |
| `docs` | Notes or README changes | `docs(core): add notes for Stream API` |
| `fix` | Fixing a bug or mistake | `fix(fundamentals): correct loop condition in sum example` |
| `refactor` | Improving code without changing behavior | `refactor(oop): extract shared logic to base class` |
| `test` | Adding or updating tests | `test(tools): add JUnit tests for calculator` |
| `chore` | Config, dependencies, cleanup | `chore: update .gitignore` |
| `style` | Formatting only (spaces, line breaks) | `style(core): format collections examples` |

**Good vs bad commit messages**

| ❌ Bad | ✅ Good |
|--------|---------|
| `update` | `docs(fundamentals): add notes for arrays` |
| `fix bug` | `fix(oop): correct constructor parameter order` |
| `add many files` | `feat(core): add List and Map examples` |

**Commit rules**

1. One commit = one logical change. Do not mix unrelated work.
2. Commit small and often (at least once per study session).
3. Never commit code that does not compile.
4. Never commit secrets (passwords, API keys, `.env` files).

### 3. Daily workflow

```bash
# 1. Get the latest changes (needed if you edited files on github.com)
git pull origin main

# 2. Check what changed
git status

# 3. Stage the files you want to commit
git add 02-java-oop/

# 4. Commit with a proper message
git commit -m "feat(oop): add polymorphism examples"

# 5. Push to GitHub
git push origin main
```

### 4. What not to commit

Use GitHub's **Java** `.gitignore` template when creating the repository. It already ignores build output and IDE files:

| Ignore | Reason |
|--------|--------|
| `target/` | Maven build output |
| `*.class` | Compiled files |
| `.idea/`, `*.iml` | IntelliJ settings |
| `.env` | Secrets |

---

## 🏆 Related Projects

Real projects live in their own repositories:

| Repository | Description | Tech | Status |
|------------|-------------|------|--------|
| [library-cli-app](https://github.com/USERNAME/library-cli-app) | Library management app that runs in the terminal | Java, OOP, Collections, File I/O | 📅 Planned |
| [task-manager-api](https://github.com/USERNAME/task-manager-api) | REST API for managing tasks | Spring Boot, PostgreSQL, JPA, Docker | 📅 Planned |
| [order-management-system](https://github.com/USERNAME/order-management-system) | Final project: order management backend | Spring Boot, PostgreSQL, Redis, Docker, CI/CD | 📅 Planned |

---

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](./LICENSE) file for details.

---

<div align="center">

**⭐ If this roadmap helps you, consider giving the repository a star.**

</div>

<!-- FOOTER: closing image -->
<img src="https://capsule-render.vercel.app/api?type=waving&height=120&color=5382A1&section=footer" width="100%" alt="Footer" />
