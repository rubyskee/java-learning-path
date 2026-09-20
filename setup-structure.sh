#!/usr/bin/env bash
# =====================================================================
# setup-structure.sh
#
# Creates the full module / sub-topic folder structure, dummy practice
# files, note templates, and .gitignore rules for the
# "java-fundamental-learning" repository.
#
# Usage (run from the ROOT of your cloned repository):
#   bash setup-structure.sh
#
# Safe to re-run: existing files are NEVER overwritten.
# Your README.md and LICENSE are not touched.
# =====================================================================
set -eu

# ---------------------------------------------------------------------
# 0. Safety check: must be run from the repository root
# ---------------------------------------------------------------------
if [ ! -d ".git" ]; then
  echo "ERROR: run this script from the ROOT of your cloned repository" >&2
  echo "       (the folder that contains the hidden .git folder)." >&2
  exit 1
fi

CREATED=0
SKIPPED=0

# ---------------------------------------------------------------------
# 1. Helpers
# ---------------------------------------------------------------------

# write_file <path> <content>  -> creates the file only if it does not exist
write_file() {
  if [ -e "$1" ]; then
    SKIPPED=$((SKIPPED + 1))
  else
    mkdir -p "$(dirname "$1")"
    printf '%s\n' "$2" > "$1"
    CREATED=$((CREATED + 1))
  fi
}

# stub_content <module> <dir> <title> <file>  -> dummy practice file content
stub_content() {
  local module="$1" dir="$2" title="$3" file="$4"
  local name="${file%.*}" ext="${file##*.}"
  case "$ext" in
    java)
cat <<EOF
/**
 * Sub-topic : ${title}
 * Module    : ${module}
 * Run       : java ${dir}/${file}
 */
public class ${name} {
    public static void main(String[] args) {
        // TODO: write your practice code here
        System.out.println("${title} - practice file");
    }
}
EOF
      ;;
    sql)
cat <<EOF
-- Sub-topic : ${title}
-- Module    : ${module}
-- TODO: write your SQL practice queries here
EOF
      ;;
    html)
cat <<EOF
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>
  <!-- TODO: write your practice code here -->
</body>
</html>
EOF
      ;;
    js)
cat <<EOF
// Sub-topic : ${title}
// Module    : ${module}
// TODO: write your practice code here
console.log("${title} - practice file");
EOF
      ;;
    *)
cat <<EOF
Sub-topic : ${title}
Module    : ${module}
TODO: add your practice content here
EOF
      ;;
  esac
}

# Template: notes for one sub-topic (uses T_* variables)
topic_readme_content() {
cat <<EOF
# ${T_TITLE}

> Module: [${T_MODULE}](../README.md) · Status: 📅 Not started

## 🎯 Goal

_What should I be able to do after learning this topic?_

## 📝 Key Concepts

-

## 💻 Code

${T_CODE}

## ⚠️ Common Mistakes

-

## 🧪 Practice

- [ ] Exercise 1
- [ ] Exercise 2

## 📚 Resources

-
EOF
}

# Template: landing page for one module (uses M_* variables)
module_readme_content() {
cat <<EOF
# ${M_NUM} · ${M_TITLE}

> Part of the **java-fundamental-learning** roadmap. Back to the [main README](../README.md).

## 🎯 Goal

${M_GOAL}

## 📚 Sub-topics

| # | Sub-topic | Notes | Code | Status |
|---|-----------|-------|------|--------|
${M_ROWS}

## ✅ Progress

${M_CHECKS}

## 🧪 Exercises

Practice problems for this module are in [exercises](./exercises/README.md).
EOF
}

# Template: exercises page for one module (uses M_* variables)
exercises_readme_content() {
cat <<EOF
# Exercises · ${M_TITLE}

Practice problems for module **${M_NUM} · ${M_TITLE}**.

## 📋 To do

- [ ] Exercise 1:
- [ ] Exercise 2:
- [ ] Exercise 3:

## ✅ Done

_Move finished exercises here._
EOF
}

# add_module <folder> <title> <goal>   (sub-topics are read from stdin)
# stdin line format:  folder-slug|Sub-topic title|OptionalFile.ext
add_module() {
  local module="$1" title="$2" goal="$3"
  local i=0 slug ttl file idx folder dir code_cell

  M_NUM="${module%%-*}"
  M_TITLE="$title"
  M_GOAL="$goal"
  M_ROWS=""
  M_CHECKS=""

  while IFS='|' read -r slug ttl file; do
    if [ -z "$slug" ]; then
      continue
    fi

    i=$((i + 1))
    idx=$(printf '%02d' "$i")
    folder="${idx}-${slug}"
    dir="${module}/${folder}"

    if [ -n "$file" ]; then
      write_file "${dir}/${file}" "$(stub_content "$module" "$dir" "$ttl" "$file")"
      code_cell="[\`${file}\`](./${folder}/${file})"
      T_CODE="[\`${file}\`](./${file})"
    else
      code_cell="-"
      T_CODE="No code file for this topic yet. Add notes, commands, or screenshots here."
    fi

    T_TITLE="$ttl"
    T_MODULE="$module"
    write_file "${dir}/README.md" "$(topic_readme_content)"

    M_ROWS="${M_ROWS}| ${idx} | ${ttl} | [notes](./${folder}/README.md) | ${code_cell} | 📅 |"$'\n'
    M_CHECKS="${M_CHECKS}- [ ] ${idx} · ${ttl}"$'\n'
  done

  write_file "${module}/README.md" "$(module_readme_content)"
  write_file "${module}/exercises/README.md" "$(exercises_readme_content)"
  echo "  ✔ ${module}  (${i} sub-topics)"
}

# ---------------------------------------------------------------------
# 2. .gitignore (appended once; existing rules are kept)
# ---------------------------------------------------------------------
add_gitignore() {
  local marker="java-fundamental-learning ignore rules"

  if [ -f .gitignore ] && grep -qF "$marker" .gitignore; then
    echo "  • .gitignore already contains the rules, skipped"
    return
  fi

  local action="created"
  if [ -f .gitignore ]; then
    action="updated"
  fi

  cat >> .gitignore <<'EOF'

# >>> java-fundamental-learning ignore rules >>>

# Build output (Java / Maven / Gradle)
target/
build/
out/
*.class
hs_err_pid*
replay_pid*

# Logs
*.log

# IntelliJ IDEA
.idea/
*.iml
*.iws

# VS Code
.vscode/

# Eclipse
.classpath
.project
.settings/

# Node.js (frontend module)
node_modules/

# Secrets and local configuration
.env
.env.*
!.env.example
application-local.properties
application-local.yml

# OS files
.DS_Store
Thumbs.db

# <<< java-fundamental-learning ignore rules <<<
EOF

  echo "  ✔ .gitignore ${action}"
}

# ---------------------------------------------------------------------
# 3. Modules and sub-topics
# ---------------------------------------------------------------------
echo "Creating structure..."

add_module "01-java-fundamentals" "Java Fundamentals" \
  "Learn the core Java syntax and write small programs from scratch." <<'EOF'
jdk-jre-jvm-setup|JDK, JRE, JVM & Setup|
hello-world|Hello World|HelloWorld.java
variables-data-types|Variables & Data Types|VariablesDataTypes.java
type-casting|Type Casting|TypeCasting.java
operators|Operators|Operators.java
user-input-scanner|User Input (Scanner)|UserInput.java
if-else-switch|if/else & switch|IfElseSwitch.java
loops|Loops (for, while, do-while)|Loops.java
methods|Methods|Methods.java
arrays|Arrays|ArrayBasics.java
string-stringbuilder|String & StringBuilder|StringBasics.java
EOF

add_module "02-java-oop" "Java OOP" \
  "Model real-world problems with classes, objects, and the four OOP pillars." <<'EOF'
class-object|Class & Object|ClassObjectDemo.java
constructor|Constructor|ConstructorDemo.java
this-keyword|this Keyword|ThisKeywordDemo.java
encapsulation|Encapsulation|EncapsulationDemo.java
inheritance|Inheritance|InheritanceDemo.java
polymorphism|Polymorphism (Overloading & Overriding)|PolymorphismDemo.java
abstract-class|Abstract Class|AbstractClassDemo.java
interface|Interface|InterfaceDemo.java
static-final|static & final|StaticFinalDemo.java
enum|Enum|EnumDemo.java
record|Record|RecordDemo.java
packages|Packages|
EOF

add_module "03-java-core" "Java Core" \
  "Use the standard library and modern Java features to write cleaner, safer code." <<'EOF'
collections|Collections (List, Set, Map, Queue)|CollectionsDemo.java
generics|Generics|GenericsDemo.java
exception-handling|Exception Handling|ExceptionHandlingDemo.java
file-io-nio|File I/O (NIO)|FileIoDemo.java
lambda-functional-interfaces|Lambda & Functional Interfaces|LambdaDemo.java
stream-api|Stream API|StreamApiDemo.java
optional|Optional|OptionalDemo.java
date-time-api|Date & Time API|DateTimeDemo.java
modern-java-features|Modern Java (var, text blocks, switch expressions, sealed classes)|ModernJavaDemo.java
multithreading-basics|Multithreading Basics|MultithreadingDemo.java
EOF

add_module "04-tools-testing" "Tools & Testing" \
  "Work like a professional developer: version control, build tools, and automated tests." <<'EOF'
git-github-workflow|Git & GitHub Workflow|
maven|Maven (pom.xml, dependencies, lifecycle)|
junit-5|JUnit 5|
mockito|Mockito|
logging-slf4j|Logging (SLF4J)|
EOF

add_module "05-sql-postgresql" "SQL & PostgreSQL" \
  "Design relational databases and query them confidently with SQL." <<'EOF'
relational-database-concepts|Relational Database Concepts|
sql-crud|SQL CRUD|sql-crud.sql
join|JOIN|join.sql
group-by-aggregates|GROUP BY & Aggregates|group-by-aggregates.sql
constraints-normalization|Constraints & Normalization|constraints-normalization.sql
index|Index|index.sql
transaction-acid|Transaction (ACID)|transaction-acid.sql
jdbc|JDBC|
EOF

add_module "06-spring-boot" "Spring Boot" \
  "Build secure, well-structured REST APIs with Spring Boot." <<'EOF'
project-structure-initializr|Project Structure (Spring Initializr)|
ioc-dependency-injection|IoC & Dependency Injection|
rest-controller-crud|REST Controller (CRUD)|
layered-architecture|Layered Architecture (Controller, Service, Repository)|
spring-data-jpa-hibernate|Spring Data JPA & Hibernate|
bean-validation|Bean Validation|
global-exception-handling|Global Exception Handling|
dto|DTO|
spring-security-jwt|Spring Security & JWT|
openapi-swagger|OpenAPI / Swagger|
api-testing|API Testing|
EOF

add_module "07-docker-cicd" "Docker & CI/CD" \
  "Package applications with Docker and automate build and test with GitHub Actions." <<'EOF'
docker-concepts|Docker Concepts|
dockerfile-spring-boot|Dockerfile for Spring Boot|
docker-compose|Docker Compose (App + PostgreSQL)|
environment-variables|Environment Variables|
github-actions|GitHub Actions (Build & Test)|
EOF

add_module "08-redis-messaging" "Redis & Messaging" \
  "Speed up applications with caching and decouple services with messaging." <<'EOF'
redis-basics|Redis Basics|
spring-cache-redis|Spring Cache with Redis|
message-queue-concepts|Message Queue Concepts|
kafka-basics|Kafka Basics (Topic, Producer, Consumer)|
EOF

add_module "09-cloud-system-design" "Cloud & System Design" \
  "Deploy to the cloud and reason about scalable system design." <<'EOF'
aws-basics|AWS Basics (EC2, S3, RDS, IAM)|
deployment|Deployment|
rest-api-design|REST API Design Best Practices|
system-design-basics|System Design Basics|
EOF

add_module "10-ai-integration" "AI Integration" \
  "Integrate LLM APIs into a Java backend." <<'EOF'
llm-api-concepts|LLM API Concepts|
llm-api-spring-boot|Calling an LLM API from Spring Boot|
prompt-basics|Prompt Basics|
spring-ai-intro|Spring AI Introduction|
EOF

add_module "11-frontend-basics" "Frontend Basics" \
  "Learn enough frontend to build a simple UI that consumes my own REST API." <<'EOF'
html-css|HTML & CSS|index.html
javascript-basics|JavaScript Basics|script.js
consuming-rest-api-fetch|Consuming a REST API with fetch|fetch-demo.js
frontend-framework|Frontend Framework (to be decided)|
EOF

add_gitignore

# ---------------------------------------------------------------------
# 4. Summary
# ---------------------------------------------------------------------
echo ""
echo "Done. Files created: ${CREATED} | already existed (skipped): ${SKIPPED}"
echo ""
echo "Next steps:"
echo "  1. Test a file:  java 01-java-fundamentals/02-hello-world/HelloWorld.java"
echo "  2. Commit and push:"
echo "       git add ."
echo "       git commit -m \"chore: scaffold module folders and templates\""
echo "       git push origin main"
echo "  3. You can delete this script afterwards:  rm setup-structure.sh"
