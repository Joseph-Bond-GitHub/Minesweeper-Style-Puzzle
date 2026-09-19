# Minesweeper (Java Swing)

A Java Swing implementation of Minesweeper. The goal as a part of my A level project was to design an educational logic game for school-age students, based on client requirements gathered from technical department staff who wanted a simple, distraction-free way to practise critical thinking and systematic deduction.

## Overview

Minesweeper was chosen because its core loop — clearing a grid of tiles while avoiding hidden mines, using the numbers revealed to deduce safe moves — teaches systematic, logical reasoning without needing prior subject knowledge. The client's brief called for three things: a login system so student's progress persists between sessions, a statistics tracker, and a simple UI that doesn't distract from the logic of the game itself.

## Features

- **Three difficulty levels** (Easy / Medium / Hard), each with its own grid size and mine density
- **Safe first click** — mines are placed only after the first tile is chosen, and never in that tile's 3×3 neighbourhood, so it's impossible to lose on move one
- **Recursive flood-fill reveal** — clicking an empty tile propogates outward, auto-clearing every connected zero-adjacency tile 
- **Flagging and question-marking** — right-click cycles a tile through blank → flag → question mark, with a live counter of flags remaining
- **Persistent accounts** — users create a username/password to log in; each account persists across sessions
- **Password validation** — enforced via regex, requiring a minimum length, at least one digit and one special character
- **Per-user statistics** — games played and games won are tracked and written back to the user's file after every game, with a win/loss ratio shown on a dedicated statistics page
- **In-game timer and flag counter**, help page, and dedicated win/loss screens

## Requirements (from the project brief)

| # | Requirement | Priority | Notes |
|---|---|---|---|
| 1.1 | Simple, minimal UI aimed at younger students | Necessary | Core panels only; other screens reached via buttons |
| 1.2–1.3 | Bright colour scheme with strong contrast between tiles, flags and question marks | Necessary | |
| 1.4–1.8 | In-app description of rules, login page, statistics page, help page/button | Necessary | |
| 2.1–2.6 | Clear/legible font, mine density indicator, icon-based counters, low-contrast text fields | Preferred | Partially implemented — see Limitations |
| 3.1 | Three difficulty settings with manageable jumps in mine density | Necessary | Implemented (Easy/Medium/Hard) |
| 3.2 | Secure login with unique usernames and a strong password policy | Necessary | Implemented via regex validation |
| 3.3–3.5 | Persistent statistics tracker, timer, flag counter | Necessary | Implemented |
| 3.6–3.7 | Flagging and question-marking tiles | Necessary / Preferred | Implemented |
| 3.9 | Custom grid size | Preferred | Not implemented — see Limitations |
| 4.0 | Non-fail first click | Preferred | Implemented |
| 4.1 | Flagged/question-marked tiles become disabled (can't be misclicked) | Preferred | Not implemented |
| 4.2 | Sufficient area cleared on first/subsequent clicks with no adjacent mines | Preferred | Implemented via recursive flood-fill |
| 4.3 | Manageable steps between difficulty levels (≤7.5% mine density jump) | Necessary | Implemented |

### System requirements (as specified in the brief)

- Java Virtual Machine — built and tested against JDK 8
- Windows 10 or newer (developed and tested on Windows; not verified elsewhere)
- Keyboard and mouse
- Display resolution of at least 1280×800
- 2GB RAM, 256GB free disk space, Intel i5 or newer recommended

## Known limitations

- **Text-file storage, not a database.** Each user's data lives in its own flat text file (username as filename, password on line 1, stats on the following lines). This was a deliberate  decision to reduce implementation complexity, but it doesn't scale well — every login/statistics lookup is a linear scan of the `User Files` folder, and there's no encryption on stored passwords. A database and password hashing would be the next step
- **No custom difficulty/grid size** — only the three preset difficulties are available.
- **Flagged tiles aren't disabled** — a flagged tile can still be clicked and accidentally revealed.
- **No master/teacher login** to view multiple students' statistics — considered but dropped due to the added complexity within time contraint 
- **No game seeds** — grids can't be regenerated or shared between players.

## Project structure

```
Project Files/
├── ProjectTest/              # NetBeans project (Ant build)
│   ├── src/
│   │   ├── Accounts/         # Login window
│   │   ├── CompleteProject/  # Main application — game logic, accounts, statistics
│   │   ├── MainGame/         # Early grid prototypes
│   │   └── TextFiles/        # File-loading utilities
│   └── User Files/           # Per-user account/stats files (see ExampleUser.txt for the format)
```

## Building and running

This is a NetBeans project using Ant. With the JDK installed:

```
cd "Project Files to Submit/ProjectTest"
ant run
```

or open the project folder directly in NetBeans and run it from there.

## Author

Repo owner