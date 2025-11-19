# GreenTask - Run Commands

## Compile (Linux/Mac)
```bash
javac --module-path "lib/javafx-sdk-25.0.1/lib" --add-modules javafx.controls,javafx.fxml -d bin -cp "lib/mysql-connector-j-9.5.0.jar" src/com/greenreminder/*.java
```

## Run (Linux/Mac)
```bash
java --module-path lib/javafx-sdk-25.0.1/lib --add-modules javafx.controls,javafx.fxml --enable-native-access=javafx.graphics -cp "bin:lib/mysql-connector-j-9.5.0.jar" com.greenreminder.MainApp
```

## Run (No Warnings - Linux/Mac)
```bash
java --module-path lib/javafx-sdk-25.0.1/lib --add-modules javafx.controls,javafx.fxml --enable-native-access=javafx.graphics -cp "bin:lib/mysql-connector-j-9.5.0.jar" com.greenreminder.MainApp 2>&1 | grep -v "WARNING"
```

## Windows (PowerShell)

Use these commands on Windows PowerShell. Key differences: Windows uses `;` as the classpath separator, and JavaFX jars must be provided on the module path when using modern JDKs.

### Database Setup (one-time)
```powershell
java -cp "lib/mysql-connector-j-9.5.0.jar;." com.greenreminder.DBSetup
```
This creates the `green_reminder` database and imports schema/sample data.

### Compile
```powershell
javac --module-path "lib/javafx-sdk-25.0.1/lib" --add-modules javafx.controls,javafx.fxml -d bin -cp "lib/mysql-connector-j-9.5.0.jar" src\com\greenreminder\*.java
```

### Run
```powershell
c
```

### Run (No Warnings)
```powershell
java --module-path "lib/javafx-sdk-25.0.1/lib" --add-modules javafx.controls,javafx.fxml --enable-native-access=javafx.graphics -cp "bin;lib/mysql-connector-j-9.5.0.jar" com.greenreminder.MainApp 2>&1 | Select-String -NotMatch "WARNING"
```

### Database Configuration
Edit `src\com\greenreminder\Config.java` if your MySQL credentials differ:
- **Host:** localhost
- **Port:** 3306
- **Database:** green_reminder
- **User:** root
- **Password:** 123456

