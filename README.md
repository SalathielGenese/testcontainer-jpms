# testcontainer-jpms

How to use test containers with Java Platform Module System

## Requirements

+ Maven 3+
+ JDK 17+
+ Docker
+ Git

## Getting Started

```shell
# Clone this repository
git clone git@github.com:SalathielGenese/testcontainer-jpms.git

# Navigate to project root
cd testcontainer-jpms

# Run test
mvn clean test
```

## Working on Windows?

[TestContainer](https://www.testcontainers.org/) is a tool that help spin
Docker containers in our apps.

In this project, the image used is `httpd:alpine` and therefore, is a Linux-based container.

> **NOTE:** If your Windows' Docker Desktop is not set up to run **Linux Containers**,
> you have two options:
> 
> + [Change your Windows' Docker Desktop mode to **Linux Containers**](https://learn.microsoft.com/en-us/virtualization/windowscontainers/quick-start/quick-start-windows-10-linux#run-your-first-linux-container)
> + Edit the image used in the test within this project:
> 
>  `src/test/java/name/genese/salathiel/test/testcontainerjpms/HttpdTest.java`

## License

This project is under [MIT](./LICENSE) license.