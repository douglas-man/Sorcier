dman@41786VU ~/Documents/Sorcier $ git remote add origin https://github.com/douglas-man/Sorcier.git
fatal: Not a git repository (or any of the parent directories): .git
dman@41786VU ~/Documents/Sorcier $ echo "# Sorcier" >> README.md
dman@41786VU ~/Documents/Sorcier $ git init
Initialized empty Git repository in /home/dman/Documents/Sorcier/.git/
dman@41786VU ~/Documents/Sorcier $ git add README.md
dman@41786VU ~/Documents/Sorcier $ git commit -m "first commit"
[master (root-commit) 5c4dcf8] first commit
 1 file changed, 1 insertion(+)
 create mode 100644 README.md
dman@41786VU ~/Documents/Sorcier $ git add .
dman@41786VU ~/Documents/Sorcier $ git commit -m "Sorcier commit"
[master 0731a02] Sorcier commit
 18 files changed, 497 insertions(+)
 create mode 100644 pom.xml
 create mode 100644 src/main/java/sorcier/config/RootConfig.java
 create mode 100644 src/main/java/sorcier/config/SorcierWebInitializer.java
 create mode 100644 src/main/java/sorcier/config/WebConfig.java
 create mode 100644 src/main/java/sorcier/web/HomeController.java
 create mode 100644 src/main/webapp/WEB-INF/views/home.jsp
 create mode 100644 src/test/java/sorcier/web/HomeControllerTest.java
 create mode 100644 target/classes/sorcier/config/RootConfig.class
 create mode 100644 target/classes/sorcier/config/SorcierWebInitializer.class
 create mode 100644 target/classes/sorcier/config/WebConfig.class
 create mode 100644 target/classes/sorcier/web/HomeController.class
 create mode 100644 target/maven-status/maven-compiler-plugin/compile/default-compile/createdFiles.lst
 create mode 100644 target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst
 create mode 100644 target/maven-status/maven-compiler-plugin/testCompile/default-testCompile/createdFiles.lst
 create mode 100644 target/maven-status/maven-compiler-plugin/testCompile/default-testCompile/inputFiles.lst
 create mode 100644 target/surefire-reports/TEST-sorcier.config.HomeControllerTest.xml
 create mode 100644 target/surefire-reports/sorcier.config.HomeControllerTest.txt
 create mode 100644 target/test-classes/sorcier/config/HomeControllerTest.class
dman@41786VU ~/Documents/Sorcier $ git remote add origin https://github.com/douglas-man/Sorcier.git
dman@41786VU ~/Documents/Sorcier $ git remote -v
origin	https://github.com/douglas-man/Sorcier.git (fetch)
origin	https://github.com/douglas-man/Sorcier.git (push)
dman@41786VU ~/Documents/Sorcier $ git push origin master
Username for 'https://github.com': douglas.man@me.com
Password for 'https://douglas.man@me.com@github.com': 
Counting objects: 51, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (33/33), done.
Writing objects: 100% (51/51), 9.68 KiB | 0 bytes/s, done.
Total 51 (delta 0), reused 0 (delta 0)
To https://github.com/douglas-man/Sorcier.git
 * [new branch]      master -> master
dman@41786VU ~/Documents/Sorcier $ 



dman@41786VU ~/Documents/Sorcier $ git branch -u origin/master master
Branch master set up to track remote branch master from origin.
dman@41786VU ~/Documents/Sorcier $ git pull
Updating 0731a02..2e0fbe9
Fast-forward
 .gitignore                                                                          |  49 ++++++++++++++++++++++++++
 src/main/java/sorcier/Sorcerer.java                                                 |  76 ++++++++++++++++++++++++++++++++++++++++
 src/main/java/sorcier/Sorcier.java                                                  |  59 +++++++++++++++++++++++++++++++
 src/main/java/sorcier/data/SorcererRepository.java                                  |   7 ++++
 src/main/java/sorcier/data/SorcierRepository.java                                   |  10 ++++++
 src/main/java/sorcier/web/SorcererController.java                                   |  37 +++++++++++++++++++
 src/main/java/sorcier/web/SorcierController.java                                    |  57 ++++++++++++++++++++++++++++++
 src/main/resources/log4j2.xml                                                       |  29 +++++++++++++++
 src/main/webapp/WEB-INF/views/home.jsp                                              |   2 +-
 src/main/webapp/WEB-INF/views/registerForm.jsp                                      |  26 ++++++++++++++
 src/main/webapp/WEB-INF/views/sorcier.jsp                                           |   8 +++++
 src/main/webapp/WEB-INF/views/sorciers.jsp                                          |  46 ++++++++++++++++++++++++
 src/test/java/sorcier/web/SorcererControllerTest.java                               |  54 ++++++++++++++++++++++++++++
 src/test/java/sorcier/web/SorcierControllerTest.java                                |  68 +++++++++++++++++++++++++++++++++++
 src/test/resources/log4j2-test.xml                                                  |  15 ++++++++
 target/classes/sorcier/config/RootConfig.class                                      | Bin 894 -> 0 bytes
 target/classes/sorcier/config/SorcierWebInitializer.class                           | Bin 874 -> 0 bytes
 target/classes/sorcier/config/WebConfig.class                                       | Bin 1483 -> 0 bytes
 target/classes/sorcier/web/HomeController.class                                     | Bin 647 -> 0 bytes
 target/maven-status/maven-compiler-plugin/compile/default-compile/createdFiles.lst  |   4 ---
 target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst    |   4 ---
 .../maven-compiler-plugin/testCompile/default-testCompile/createdFiles.lst          |   1 -
 .../maven-compiler-plugin/testCompile/default-testCompile/inputFiles.lst            |   1 -
 target/surefire-reports/TEST-sorcier.config.HomeControllerTest.xml                  |  64 ---------------------------------
 target/surefire-reports/sorcier.config.HomeControllerTest.txt                       |   4 ---
 target/test-classes/sorcier/config/HomeControllerTest.class                         | Bin 1949 -> 0 bytes
 26 files changed, 542 insertions(+), 79 deletions(-)
 create mode 100644 .gitignore
 create mode 100644 src/main/java/sorcier/Sorcerer.java
 create mode 100644 src/main/java/sorcier/Sorcier.java
 create mode 100644 src/main/java/sorcier/data/SorcererRepository.java
 create mode 100644 src/main/java/sorcier/data/SorcierRepository.java
 create mode 100644 src/main/java/sorcier/web/SorcererController.java
 create mode 100644 src/main/java/sorcier/web/SorcierController.java
 create mode 100644 src/main/resources/log4j2.xml
 create mode 100644 src/main/webapp/WEB-INF/views/registerForm.jsp
 create mode 100644 src/main/webapp/WEB-INF/views/sorcier.jsp
 create mode 100644 src/main/webapp/WEB-INF/views/sorciers.jsp
 create mode 100644 src/test/java/sorcier/web/SorcererControllerTest.java
 create mode 100644 src/test/java/sorcier/web/SorcierControllerTest.java
 create mode 100644 src/test/resources/log4j2-test.xml
 delete mode 100644 target/classes/sorcier/config/RootConfig.class
 delete mode 100644 target/classes/sorcier/config/SorcierWebInitializer.class
 delete mode 100644 target/classes/sorcier/config/WebConfig.class
 delete mode 100644 target/classes/sorcier/web/HomeController.class
 delete mode 100644 target/maven-status/maven-compiler-plugin/compile/default-compile/createdFiles.lst
 delete mode 100644 target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst
 delete mode 100644 target/maven-status/maven-compiler-plugin/testCompile/default-testCompile/createdFiles.lst
 delete mode 100644 target/maven-status/maven-compiler-plugin/testCompile/default-testCompile/inputFiles.lst
 delete mode 100644 target/surefire-reports/TEST-sorcier.config.HomeControllerTest.xml
 delete mode 100644 target/surefire-reports/sorcier.config.HomeControllerTest.txt
 delete mode 100644 target/test-classes/sorcier/config/HomeControllerTest.class
dman@41786VU ~/Documents/Sorcier $ 

