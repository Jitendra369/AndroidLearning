# Android Java — Practice-First Learning Path

## Goal

Learn Android development using **Java + XML** through hands-on practice rather than theory alone.

### Learning Rule

> **Learn 20% → Code 60% → Practice/Challenge 20%**

For every topic:
1. Learn the core concept.
2. Build a small example.
3. Complete a small task yourself.
4. Share your code for review.
5. Solve a slightly harder challenge.
6. Move to the next topic.

---

# Phase 1 — Android Basics

## Topics

- Android Studio
- Android project structure
- Activity
- `onCreate()`
- XML layouts
- `TextView`
- `EditText`
- `Button`
- `findViewById()`
- `setOnClickListener()`

## Task 1 — Hello User

Build:

```text
-------------------------
        My App

Name: [____________]

       [ Say Hello ]

Hello, Jitendra!
-------------------------
```

Requirements:

- Use `EditText` for name.
- Use `Button`.
- Use `TextView`.
- Read the name entered by the user.
- Display `Hello, <name>!`.
- Do not hard-code the user's name.

---

# Phase 2 — Input & Event Handling

## Topics

- `EditText`
- `Button`
- `TextView`
- `CheckBox`
- `RadioButton`
- `Switch`
- `Spinner`
- `Toast`
- `setOnClickListener()`
- `setOnCheckedChangeListener()`
- `setOnItemSelectedListener()`

## Task 2 — Registration Form

Build:

```text
Name       [____________]

Age        [____________]

Gender     ○ Male  ○ Female

Country    [ India ▼ ]

Subscribe  [ ON ]

             [Submit]

-------------------------
Result:
Name: ...
Age: ...
Gender: ...
Country: ...
Subscribed: Yes
```

Requirements:

- Fetch every view using its ID.
- Keep view initialization in `initViews()`.
- Keep event registration in `setListeners()`.
- Keep business logic in separate methods.
- Use resources for static Spinner values.

---

# Phase 3 — Input Validation

## Topics

- `EditText.getText()`
- `TextUtils.isEmpty()`
- `setError()`
- `Toast`
- Basic validation
- Input handling

## Task 3 — Registration Validation

Create a registration form with:

```text
Name       [____________]
Email      [____________]
Password   [____________]

          [Register]
```

Rules:

- Name cannot be empty.
- Email cannot be empty.
- Password must contain at least 6 characters.
- Show an error on the invalid field.
- Show `Registration successful` when valid.

### Challenge

Add email-format validation.

---

# Phase 4 — Android Layouts & UI

## Topics

- `LinearLayout`
- `ConstraintLayout`
- `FrameLayout`
- `ScrollView`
- `dp`
- `sp`
- `margin`
- `padding`
- `gravity`
- `layout_weight`
- `match_parent`
- `wrap_content`

## Task 4 — Profile Screen

Build:

```text
       Profile

      [ Image ]

Name
John

Email
john@gmail.com

Phone
9876543210

       [Edit]
```

Requirements:

- Use proper margins and padding.
- Make the screen scrollable.
- Use `dp` for dimensions.
- Use `sp` for text sizes.

---

# Phase 5 — Multiple Screens

## Topics

- Multiple Activities
- `Intent`
- Explicit Intent
- Passing data between Activities
- `putExtra()`
- `getStringExtra()`
- Activity lifecycle basics

## Task 5 — Login → Home

Login screen:

```text
Email
[____________]

Password
[____________]

[ Login ]
```

After login:

```text
Home

Welcome John!
```

Requirements:

- Read the username/email.
- Open the Home Activity.
- Pass the username using `Intent`.
- Display it on the Home screen.

---

# Phase 6 — Fragments

## Topics

- What is a Fragment?
- Fragment lifecycle
- Fragment container
- `FragmentManager`
- Fragment transactions
- Activity ↔ Fragment communication
- Passing data

## Task 6 — Two Fragment App

Build:

```text
-------------------------
 Home | Profile
-------------------------

       Fragment
       content

-------------------------
```

Requirements:

- Home button/tab displays `HomeFragment`.
- Profile button/tab displays `ProfileFragment`.
- Understand how Fragment transactions work.

---

# Phase 7 — RecyclerView

## Topics

- RecyclerView
- Adapter
- ViewHolder
- Item XML
- Model class
- `ArrayList`
- Item click handling

Architecture:

```text
RecyclerView
     |
     v
  Adapter
     |
     v
 ViewHolder
     |
     v
 Item Layout
     |
     v
   Data
```

## Task 7 — Contact List

Create:

```text
Contacts

John       9876543210
Rahul      9876543211
Amit       9876543212
Priya      9876543213
```

Requirements:

- Use RecyclerView.
- Create a `Contact` model.
- Create an Adapter.
- Create a ViewHolder.
- Display contacts.
- On item click, show contact details.

---

# Phase 8 — Java Models & Collections

## Topics

- POJO/model classes
- Constructors
- Getters/setters
- `List`
- `ArrayList`
- Objects inside objects
- Enums

## Task 8 — Todo Model

Create:

```text
Task
 ├── id
 ├── title
 ├── description
 ├── dueDate
 ├── priority
 └── completed
```

Then:

- Create multiple `Task` objects.
- Store them in an `ArrayList`.
- Display them using RecyclerView.
- Add different priority values.

---

# Phase 9 — Navigation

## Topics

- Single Activity architecture
- Navigation Component
- Navigation Graph
- Fragment destinations
- Actions
- Back navigation
- Passing data

## Task 9 — Todo Navigation

Build:

```text
        Todo App

   ----------------
   Task List

   Buy milk
   Learn Android
   Read book

        [+ Add Task]
   ----------------
```

Navigation:

```text
Task List
   |
   +----> Task Details
   |
   +----> Add Task
```

---

# Phase 10 — Local Database

## Topics

- Database concepts
- SQLite basics
- Room Database
- Entity
- DAO
- Database
- CRUD

CRUD:

```text
Create
Read
Update
Delete
```

## Task 10 — Todo CRUD

Implement:

```text
Add Task
   ↓
Save to DB

Task List
   ↓
Read from DB

Click Task
   ↓
Edit

Delete
   ↓
Remove from DB
```

Goal:

Build a fully working Todo application using Room.

---

# Phase 11 — REST API & Networking

This phase connects Android with your Spring Boot knowledge.

## Topics

- HTTP
- GET
- POST
- PUT
- DELETE
- JSON
- REST API
- Retrofit
- API error handling

Architecture:

```text
Android
   |
   | HTTP
   v
Spring Boot
   |
   v
Database
```

## Task 11 — Todo + Spring Boot

Create/use APIs:

```text
GET    /tasks
POST   /tasks
PUT    /tasks/{id}
DELETE /tasks/{id}
```

Android should:

- Fetch tasks.
- Add a task.
- Update a task.
- Delete a task.
- Display server data in RecyclerView.

---

# Phase 12 — Authentication & Authorization

## Topics

- Login API
- Registration API
- JWT
- Access token
- Authentication
- Authorization
- Secure token storage

## Task 12 — Secure Todo App

Flow:

```text
Login
  ↓
JWT
  ↓
Todo Home
  ↓
GET /tasks
  ↓
Only logged-in user's tasks
```

Requirements:

- User registration.
- User login.
- Receive JWT.
- Store token securely.
- Send token with API requests.
- Backend identifies the logged-in user.

---

# Phase 13 — Android Architecture

## Topics

- MVVM
- View
- ViewModel
- Repository
- Data source
- LiveData / StateFlow
- Dependency Injection
- Hilt

Architecture:

```text
Activity / Fragment
        |
        v
    ViewModel
        |
        v
   Repository
      /   \
     /     \
  API      Room
```

## Task 13 — Refactor Todo App

Take the Todo application and restructure it into:

```text
Activity / Fragment
        ↓
    ViewModel
        ↓
    Repository
        ↓
 API / Room
```

Goal:

The Activity/Fragment should not contain database or API business logic.

---

# Phase 14 — UI & Material Design

## Topics

- Material Components
- Toolbar
- Menu
- Dialog
- Snackbar
- Bottom Sheet
- Themes
- Dark mode
- Cards
- FloatingActionButton

## Task 14 — Improve Todo UI

Improve the Todo application:

```text
        Todo
-------------------------
[ Search tasks       ]

☐ Learn Android
  High Priority

☑ Read book
  Completed

              [+]
-------------------------
```

Add:

- Material UI.
- FAB.
- Search.
- Task cards.
- Dialog for adding a task.
- Dark mode.

---

# Phase 15 — Storage

## Topics

- SharedPreferences
- DataStore
- Room
- When to use each

## Task 15 — Remember Login

After successful login:

```text
Login
  ↓
Save login state
  ↓
Close app
  ↓
Open app
  ↓
Go directly to Home
```

Add logout functionality.

---

# Phase 16 — Background Work & Notifications

## Topics

- WorkManager
- Notifications
- Background tasks
- Scheduling work

## Task 16 — Todo Reminder

For a task with a due date:

```text
Task
 ↓
Due date/time
 ↓
Scheduled background work
 ↓
Notification
 ↓
"Task is due"
```

---

# Phase 17 — Permissions & Device Features

## Topics

- Runtime permissions
- Camera
- File handling
- Location
- Notifications
- Activity Result APIs

## Task 17 — Task Attachment

Allow a Todo task to have an attachment/image.

Example:

```text
Task: Submit report

Description: Monthly report

Attachment:
[ report.pdf ]

[Save]
```

---

# Phase 18 — Firebase & Push Notifications

Learn:

- Firebase basics
- Firebase Authentication
- Firebase Cloud Messaging
- Push notifications
- Crash reporting

## Task 18 — Todo Notification

Send a notification when:

- A task is assigned.
- A task is due.
- A task is updated.

---

# 🏗️ Main Project — Todo Application

Instead of creating many unrelated applications, continuously improve one project.

## Version 1 — Basic UI

```text
XML
 ↓
Java
 ↓
Activity
 ↓
EditText
 ↓
Spinner
 ↓
Button
```

## Version 2 — Multiple Screens

```text
Activities
 ↓
Fragments
 ↓
RecyclerView
```

## Version 3 — Local Data

```text
Room
 ↓
CRUD
```

## Version 4 — Backend

```text
Android
 ↓
Retrofit
 ↓
Spring Boot
 ↓
MySQL
```

## Version 5 — Security

```text
Login
 ↓
JWT
 ↓
Authentication
 ↓
Authorization
```

## Version 6 — Production Architecture

```text
MVVM
 ↓
ViewModel
 ↓
Repository
 ↓
API / Room
 ↓
Hilt
```

---

# 🧪 Practice Strategy

For every topic, follow this cycle:

## Step 1 — Learn

Understand only the important concepts.

## Step 2 — Copy Once

Build one simple example while learning.

## Step 3 — Close the Example

Try to implement it again without looking.

## Step 4 — Small Task

Solve the assigned task independently.

## Step 5 — Code Review

Share your code.

Review will focus on:

- Correctness
- Java practices
- Android practices
- Naming
- XML structure
- Event handling
- Separation of logic
- Possible bugs
- Improvements

## Step 6 — Challenge

Solve a slightly harder problem without the solution first.

---

# 📌 Recommended Code Structure

For Activities, initially use:

```java
public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonSubmit;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();
        setListeners();
    }

    private void initViews() {
        editTextName = findViewById(R.id.editTextName);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResult = findViewById(R.id.textViewResult);
    }

    private void setListeners() {
        buttonSubmit.setOnClickListener(view -> {
            handleSubmit();
        });
    }

    private void handleSubmit() {
        // Business logic
    }
}
```

Use this structure while learning basic Android.

Later, when learning MVVM, we will move business logic out of the Activity.

---

# 🎯 Current Starting Point

You already know/have started using:

- `EditText`
- `Spinner`
- `Button`
- `TextView`
- `findViewById()`
- Event listeners
- `strings.xml`

Therefore, start with:

## Mini Project 1 — Currency Converter

UI:

```text
Amount in Rupees
[______________]

Currency
[ Dollar ▼ ]

[ Convert ]

Result:
$ 100.00
```

### Requirements

1. Fetch all views using IDs.
2. Use `initViews()`.
3. Use `setListeners()`.
4. Store Spinner values in `strings.xml`.
5. Validate the amount.
6. Get the selected currency.
7. Convert the amount.
8. Display the result.

### Challenge

After completing it, add:

- Pound
- Yen
- Error handling
- Clear button

Do **not** look for the complete solution immediately. Try implementing it yourself first.

---

# 🏁 Final Goal

By completing this path, you should be able to build:

```text
                 Android App
                      |
        +-------------+-------------+
        |             |             |
       UI          Navigation      Data
        |             |             |
       XML         Fragments       Room
        |             |             |
     Java          RecyclerView    Retrofit
                                      |
                                  Spring Boot
                                      |
                                    MySQL
                                      |
                                    JWT
```

The focus is not:

> "I have learned Android topics."

The goal is:

> **"I can build an Android application from scratch."**
