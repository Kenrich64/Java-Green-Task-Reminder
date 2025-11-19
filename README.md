# Green Task Reminder

A simple JavaFX desktop application for tracking climate action tasks and SDG goals with MySQL backend.

## Features

- Add and manage users
- Create SDG (Sustainable Development Goals)
- Define climate action tasks linked to SDG goals
- Mark tasks as complete for users with date/time tracking
- View task completion history per user

## Prerequisites

- Java 17 or higher
- JavaFX SDK 17 or higher
- MySQL Server 8.0 or higher
- MySQL Connector/J (JDBC driver)

## Project Structure

```
green-task-reminder/
├── src/com/greenreminder/
│   ├── Config.java           # Database configuration
│   ├── DBHelper.java         # Database operations
│   ├── MainApp.java          # JavaFX UI application
│   ├── User.java             # User model
│   ├── SdgGoal.java          # SDG Goal model
│   ├── Task.java             # Task model
│   └── UserTaskHistory.java  # User task history model
├── lib/
│   └── mysql-connector-j-8.x.x.jar  # MySQL JDBC driver (add this)
├── schema.sql                # Database schema
├── sample_data.sql           # Sample data
└── README.md
```

## Setup Instructions

### 1. Database Setup

Start MySQL server and run the schema:

```bash
mysql -u root -p < schema.sql
```

Optionally, load sample data:

```bash
mysql -u root -p < sample_data.sql
```

### 2. Configure Database Connection

Edit `src/com/greenreminder/Config.java` and update:

```java
public static final String DB_URL = "jdbc:mysql://localhost:3306/green_reminder";
public static final String DB_USER = "root";
public static final String DB_PASSWORD = "your_password_here";
```

### 3. Download MySQL Connector

Download MySQL Connector/J from:
https://dev.mysql.com/downloads/connector/j/

Extract and place `mysql-connector-j-8.x.x.jar` in the `lib/` folder.

### 4. Download JavaFX SDK

Download JavaFX SDK from:
https://gluonhq.com/products/javafx/

Extract to a location (e.g., `/path/to/javafx-sdk-17`)

## Running the Application

### Option 1: Command Line (Terminal)

**Compile:**

```bash
javac --module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls -cp "lib/*" -d bin src/com/greenreminder/*.java
```

**Run:**

```bash
java --module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls -cp "bin:lib/*" com.greenreminder.MainApp
```

**On Windows, use semicolons instead of colons:**

```cmd
javac --module-path C:\path\to\javafx-sdk-17\lib --add-modules javafx.controls -cp "lib\*" -d bin src\com\greenreminder\*.java

java --module-path C:\path\to\javafx-sdk-17\lib --add-modules javafx.controls -cp "bin;lib\*" com.greenreminder.MainApp
```

### Option 2: IntelliJ IDEA

1. Open project in IntelliJ
2. Go to File → Project Structure → Libraries
3. Add JavaFX SDK: Click + → Java → select JavaFX lib folder
4. Add MySQL Connector: Click + → Java → select `lib/mysql-connector-j-8.x.x.jar`
5. Go to Run → Edit Configurations
6. Add VM options: `--module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls`
7. Run `MainApp.java`

### Option 3: Eclipse

1. Import project as Java project
2. Right-click project → Build Path → Configure Build Path
3. Add External JARs: Add JavaFX jars from SDK lib folder
4. Add External JARs: Add `lib/mysql-connector-j-8.x.x.jar`
5. Right-click `MainApp.java` → Run As → Run Configurations
6. Arguments tab → VM arguments: `--module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls`
7. Run

## Usage

### Add User
1. Go to "Add User" tab
2. Fill in first name, middle name (optional), last name, date of birth, and username
3. Click "Add User"

### Add SDG Goal
1. Go to "Add SDG Goal" tab
2. Enter SDG name, description, and target year
3. Click "Add SDG Goal"

### Add Task
1. Go to "Add Task" tab
2. Enter task name, type, climate action goal
3. Select an SDG goal from dropdown (optional)
4. Click "Add Task"

### Mark Task Complete
1. Go to "Mark Complete" tab
2. Select a user and task from dropdowns
3. Set date and time (defaults to now)
4. Add optional notes
5. Click "Mark Task Complete"

### View History
1. Go to "View History" tab
2. Select a user from dropdown
3. Click "Load History"
4. View completed tasks in the table

## Database Schema

- **users**: User information (name, DOB, username)
- **sdg_goals**: Sustainable Development Goals
- **tasks**: Climate action tasks linked to SDG goals
- **user_tasks**: Task completion records with date/time

## Troubleshooting

**Error: ClassNotFoundException: com.mysql.cj.jdbc.Driver**
- Ensure MySQL Connector JAR is in lib/ folder and added to classpath

**Error: Access denied for user**
- Check database credentials in Config.java

**Error: JavaFX runtime components are missing**
- Ensure JavaFX SDK is properly configured with --module-path

**Error: Unknown database 'green_reminder'**
- Run schema.sql to create the database

## Notes

- This is a minimal educational project using plain Java and JavaFX
- No build tools (Maven/Gradle) required
- All UI is created programmatically (no FXML)
- Code includes line-by-line comments for teaching purposes
