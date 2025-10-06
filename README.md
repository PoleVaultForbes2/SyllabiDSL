<!-- Markdeep README for SSC_DSL -->
<meta charset="utf-8">
<link rel="stylesheet" href="https://casual-effects.com/markdeep/latest/markdeep.min.css?">

# 📘 SSC_DSL — Syllabus to Semester Calendar DSL

**SSC_DSL** is a custom **domain-specific language (DSL)** designed to transform structured course syllabi into interactive semester calendars.  
The DSL enables instructors and students to define courses, assignments, exams, and holidays using an intuitive, human-readable syntax.  
The compiler then validates the input, checks for conflicts, and generates a clear, formatted semester calendar.

---

## 🚀 Overview

This project explores how **domain-specific languages** can simplify repetitive and domain-focused workflows — in this case, academic scheduling.  
Instead of maintaining spreadsheets or static documents, users can describe their entire semester through simple DSL constructs like `course`, `assignment`, and `holiday`.  

Using **ANTLR** and **Java**, the project parses these DSL scripts, builds an **Abstract Syntax Tree (AST)**, and outputs a structured, validated semester schedule.

---

## 🧩 Features

- **Custom Grammar:** Designed from scratch and implemented using ANTLR.  
- **Lexer & Parser Generation:** Automatically produced from grammar definitions.  
- **AST Construction:** Represents the full structure of user-defined syllabi.  
- **Semantic Validation:** Detects duplicate dates, overlapping exams, and undefined references.  
- **Calendar Generation:** Converts parsed data into a human-readable semester calendar.  
- **Error Handling:** Highlights semantic and logical conflicts.  
- **Extensible Design:** Easily add new constructs like `lab`, `quiz`, or `office_hours`.

---

## 🧠 DSL Design

The syntax emphasizes readability and ease of use.  
Here’s an example input script:

```dsl
course "CS101" {
  instructor: "Dr. Smith"
  start_date: "2025-01-08"
  end_date: "2025-05-10"

  topics {
    week1: "Introduction to Programming"
    week2: "Control Structures"
  }

  assignment "Project 1" due "2025-02-15"
  exam "Midterm" date "2025-03-12"
}

holiday "Spring Break" from "2025-03-23" to "2025-03-30"
```

### Corresponding Output

```text
📅 Semester Calendar: Spring 2025

Course: CS101 (Dr. Smith)
-----------------------------------
01/08 - Week 1: Introduction to Programming
01/15 - Week 2: Control Structures
02/15 - Assignment: Project 1 Due
03/12 - Exam: Midterm
03/23–03/30 - Holiday: Spring Break
```

---

## ⚙️ Implementation Details

The compiler is implemented in **Java** using **ANTLR** for parsing.  
The workflow:

1. **Grammar Definition:**  
   A `.g4` file defines the DSL’s syntax (keywords, structure, and rules).

2. **Lexer and Parser Generation:**  
   ANTLR automatically generates the `Lexer` and `Parser` classes based on the grammar.

3. **AST Construction:**  
   The parser builds an **Abstract Syntax Tree (AST)** to represent the DSL structure.

4. **Semantic Validation:**  
   Custom Java classes traverse the AST to enforce rules (e.g., no duplicate dates or missing attributes).

5. **Calendar Generation:**  
   The validated AST is converted into a text-based semester calendar.

---

## 🧪 Error Handling Example

Example of semantic validation:
```dsl
exam "Midterm" date "2025-03-12"
exam "Final" date "2025-03-12"
```

Output:
```
❌ Error: Conflicting exams detected on 2025-03-12.
```

---

## 💡 Future Enhancements

- Export schedules to **Google Calendar** or `.ics` format.  
- Add recurring events (e.g., weekly labs or lectures).  
- Provide a **GUI editor** with live syntax validation.  
- Integrate with **LMS platforms** such as Canvas or Moodle.

---

## 🧰 Tech Stack

| Component | Technology |
|------------|-------------|
| Language | Java |
| IDE | IntelliJ IDEA |
| Parser Generator | ANTLR |
| Output | Text / JSON (future `.ics` support) |

---

## 📄 License

MIT License — free to use and modify for educational or personal projects.

---

## 👥 Authors

Developed by the **Josh Forbes & Matthew Saxby**  
Created as a demonstration of compiler design, DSL creation, and academic scheduling automation.

---

<script src="https://casual-effects.com/markdeep/latest/markdeep.min.js?"></script>
<style class="fallback">body{visibility:hidden;white-space:pre;font-family:monospace}</style>

