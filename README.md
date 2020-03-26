# SE--Practical Assignments

## Purpose of this Repository

The purpose of this repository is to complete and deliver certain functions of different assignments such as:

* Building a histogram of grades between 0-10

## Getting Started

First you need to clone the repository in a folder of your preference. Then through the command line head to the root directory of your project and 
execute the command:
```
mvn package
```
This command provides the corresponding jar file in each module's target directory. 

### Grades Histogram

The current module uses a JFreeChart dependency
```
	<dependency>
		<groupId>org.jfree</groupId>
		<artifactId>jfreechart</artifactId>
		<version>1.5.0</version>
	</dependency>
```

and the plugin of the definition class

```
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-assembly-plugin</artifactId>
			<configuration>
				<archive>
					<manifest>
						<addClasspath>true</addClasspath>
						<mainClass>seip2020_practical_assignments.HistogramGenerator</mainClass>						
					</manifest>
				</archive>
				<descriptorRefs>
					<descriptorRef>jar-with-dependencies</descriptorRef>
				</descriptorRefs>
			</configuration>
			<executions>
				<execution>
					<id>make-assembly</id>
					<phase>package</phase>
					<goals>
						<goal>single</goal>
					</goals>
				</execution>
			</executions>
	</plugin>
```

In order for the execution to work you need to enter the path of the existing file after the name of the executable jar. Please take into consideration that only grades 
between 0-10 will be counted. Don't forget to use double \\ between the files of the path so the string is inputed aproprietly. 
For example a path such: C:\\Users\\user1\\githubRepos\\grades.txt shall be changed to C:\\\Users\\\user1\\\githubRepos\\\grades.txt
So the command for the execution will look like this:

```
java -jar gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar C:\\Users\\user1\\githubRepos\\grades.txt
```

## Built With

* [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart) - Repository used for charts
* [Maven](https://maven.apache.org/) - Dependency Management


## How to

* Setup Maven for Windows - [Maven Download](https://maven.apache.org/download.cgi)

## Authors

* **Antonis Gkortzis** - [AntonisGkortzis](https://github.com/AntonisGkortzis)
* **Pandelis Kirpoglou** - [pandeliskirpoglou](https://github.com/pandeliskirpoglou)

