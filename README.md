# Luma Automation Framework 🚀

The "Luma Demo Store Automation Project" is a project utilizing the Playwright tool 💻 for automating tasks on a demo
e-commerce store. This project is built using the Java programming language 💻 and is designed to help improve the
efficiency and accuracy 🎯 of various tasks performed on the Luma Demo Store website. By automating these tasks, the
project aims to demonstrate the capabilities of Playwright 💪 and its use in real-world scenarios.
Playwright is a Node.js library 📚 to automate end-to-end web testing. It enables you to write scenario in Java 💻 that
run against real browsers, including Chrome 🌐, Firefox 🌐, and Safari 🌐, and provides APIs to interact with the page.

## Tech stack 🛠️

* Java 17 💻
* Maven 🔧
* AspectJ 🔧
* TestNG 🧪
* Cucumber 🥒
* Allure Report 📊
* RestAssured 💻

## How to play 🎮

1. Clone the repository by running git clone https://github.com/EugenS21/playwright.git
2. Navigate to the cloned repository cd playwright
3. Run **mvn -B clean compile install test**
4. To get the report of execution you need to run from the root path of the project: ``mvn allure:serve`` this command
   will automatically start a local server with the results.

PS: You can run different categories of test by specifying a tag: **mvn -B clean compile install test
-Dcucumber.filter.tags='@tag'**

## Documentation 📚

Check out the official Playwright documentation at https://playwright.dev/ for more information on how to use the
library and its features.
