# Mobile Engineering Journey

A progressive code repository documenting my 4-month mobile software engineering curriculum.

This repository serves as a personal engineering portfolio containing source code, architectural exercises, and full IDE projects (Android Studio, IntelliJ, Flutter) covering everything from core language semantics to advanced app deployment.

> **Philosophy:** This repository grows organically throughout the course. Folders are created only when they are actually needed. No placeholder directories or unnecessary files are maintained.

## 🏗️ Repository Architecture

The repository is organized by domain rather than a chronological timeline, reflecting standard engineering practices.

```text
.
├── android/
│   ├── xml/
│   ├── jetpack-compose/
│   ├── sqlite/
│   ├── networking/
│   ├── firebase/
│   ├── notifications/
│   ├── app-monetization/
│   └── publishing/
├── flutter/
│   ├── dart-basics/
│   ├── dart-oop/
│   ├── widgets/
│   ├── state-management/
│   ├── networking/
│   ├── firebase/
│   └── deployment/
├── kotlin/
│   ├── basics/
│   ├── oop/
│   ├── collections/
│   ├── coroutines/
│   └── kotlin-multiplatform/
├── software-engineering/
│   ├── clean-architecture/
│   ├── solid/
│   ├── design-patterns/
│   ├── data-structures/
│   ├── application-performance/
│   ├── git-github/
│   ├── ai-assisted-development/
│   ├── interview-preparation/
│   └── freelancing/
├── projects/
│   ├── course/
│   ├── personal/
│   └── capstone/
├── playground/           # Quick experiments, temporary prototypes, and testing
└── .gitignore            # IDE and build ignore rules
```

*(Note: The structure above grows organically. Sub-directories like `examples/`, `trainings/`, or `missions/` are created dynamically inside these topics only when needed.)*

## 🗺️ Engineering Roadmap

Throughout the 4 months, the following domains are covered:

- **Languages:** Kotlin, Dart
- **Frameworks:** Android (XML & Jetpack Compose), Flutter
- **Data & Network:** SQLite, REST APIs, Firebase
- **Architecture:** SOLID, Clean Architecture, Design Patterns, Data Structures, Performance tuning
- **DevOps & Tools:** Git/GitHub workflows, AI-assisted development, App Monetization, App Publishing

## ✅ Progress Tracking

- [ ] Kotlin
- [ ] Android
- [ ] Flutter
- [ ] Software Engineering
- [ ] Projects

## 🌿 Version Control Conventions

This repository follows a clean and minimal Git workflow.

### Commit Messages
Standard [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) format:
- `feat: implement clean architecture for user login`
- `fix: resolve race condition in network retry policy`
- `chore: update gradle dependencies`
- `docs: add setup instructions for the weather project`

### Branching Strategy
- `main`: Stable portfolio-ready code.
- `feat/feature-name`: For new topics, missions, or projects.
- `chore/topic-setup`: For boilerplate and configuration.

---
*Created as a scalable, code-first engineering portfolio.*
