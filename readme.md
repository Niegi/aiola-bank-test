# RUNNING THE TEST

1. Install JDK (v20.0.1 in my case).
2. Download Gradle (v8.1.1 in my case) and set proper environment variables according to below instruction:
<https://docs.gradle.org/current/userguide/installation.html>
3. Install favourite IDE for Java (Intellij in my case).
4. Download the project to your local repository.
5. Open the project in IDE.
6. Go to File / Settings / Build, Execution, Deployment / Build Tools / Gradle
- set gradle user home to '.gradle' directory
- set both build and run using 'Intellij IDEA'
7. Go to File / Project Structure / Project and set installed SDK.
8. You should notice that in the meantime gradle dependencies are installed. If not, go to gradle tab at the right panel and choose "Reload" button.
9. Now everything should be ready.
10. Go to XYZBankTest.java file and run test by simply clicking the visible green arrow on the left to class name.
11. Watch the show :)