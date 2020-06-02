# SE--Practical Assignments

[![Build Status](https://travis-ci.com/pandeliskirpoglou/SE---Lab-Assignment-2.svg?token=sj2oqcqiqbuxzsYcRzSv&branch=master)](https://travis-ci.com/pandeliskirpoglou/SE---Lab-Assignment-2)
[![codecov](https://codecov.io/gh/pandeliskirpoglou/SE---Lab-Assignment-2/branch/master/graph/badge.svg?token=47G5K7Y1IH)](https://codecov.io/gh/pandeliskirpoglou/SE---Lab-Assignment-2)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Purpose of this Repository

The purpose of this repository is to complete and deliver certain functions of different assignments such as:

* Building a histogram of grades between 0-10
* Testing Arithmetic Operations
* Analyzing given source code

## Build Project

In order to build the project you will need to clone the repository and head to the main source folder.
Once you are there use the command :
```
mvn clean install jacoco:report
```
After this feel free to head to each module and experience it's usage. For the module that is being tested
this command will also let you generate a code coverage report which will be in the folder :
```
target/site/jacoco
```
For any further instructions head to the README file of each separate module

## Instructions for modules

* [Grades Histogram](seip2020_practical_assignments/gradeshistogram/README.md)
* [Testing of Arithmetic Operations](seip2020_practical_assignments/unittesting/README.md)
* [Source Code Analyzer](seip2020_practical_assignments/SourceCodeAnalyzer/README.md)

## Built With

* [Mockito](https://mvnrepository.com/artifact/org.mockito/mockito-all) - Repository used for mock testing
* [JUnit 4.12](https://mvnrepository.com/artifact/junit/junit/4.12) - Repository used for testing
* [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart) - Repository used for charts
* [Maven](https://maven.apache.org/) - Dependency Management


## How to

* Use Travis - [Travis Setup](https://docs.travis-ci.com/user/tutorial/)
* Setup Maven for Windows - [Maven Download](https://maven.apache.org/download.cgi)

## Authors

* **Antonis Gkortzis** - [AntonisGkortzis](https://github.com/AntonisGkortzis)
* **Pandelis Kirpoglou** - [pandeliskirpoglou](https://github.com/pandeliskirpoglou)

