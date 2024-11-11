# :coffee: Java Code Katas :coffee:

> [!NOTE]
> All these katas are solved using Java. Most of the katas are configured in a similar way
> using Gradle, JUnit 5, and Mockito. Those katas that need extra or different configurations
> will have specific instructions in their README files.

[![Java](https://img.shields.io/badge/Java-23-red?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=101010)](https://www.oracle.com/java/)

## Standard Configuration

Every kata should have its own dependencies, but all of them will be implemented using Java 23. With IDEs like
IntelliJ IDEA, you can easily switch between Java versions, if not, make sure to have installed the correct version.

If Gradle is not already installed, you can do it following the instructions in the [Gradle Installation Guide](https://gradle.org/install/).

Once you have Gradle installed, you can go to any kata and build it using the following command:

```shell
gradle build
```

## Running the Tests

To run the tests, you can use the following command:

```shell
gradle test
```

To run a specific test from a specific class, you can use the following command:

```shell
gradle test --tests "com.dimanu.katas.kataName.className.methodName"
```

## Katas

- [x] [Deploy Service](deployservice/docs/README.md)

## Visit my GitHub profile for more projects 🚀

[![Web](https://img.shields.io/badge/GitHub-Dimanu.py-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/dimanu-py)