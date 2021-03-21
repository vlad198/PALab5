# Advanced Programming - Lab 5

This repository contains all the problems proposed for the fifth laboratory in Advanced Programming course
solved by me.

## Essential tools

You need to have Java RE or JDK >= 8 installed on your computer.

## How to run it?

1. Open project with IntelliJ IDEA

Clone this repository and open it with IntelliJ IDEA. Build this project
(shortcut Ctrl+F9) then go to Run->Run...(shortcut Alt+Shift+F10) and select
the file you want to run.

2. Compile and run the programs using CMD

Go to the folder where the file is located. Open a new terminal here.

If you want to compile the file Main.java you must type the command.

```bash
javac -d . Main.java
```

After you compiled it, if you want to start the program you can type the
following command

```bash
java packageName.Main
```

where to packageName is the name of the package which includes the file Main.java.

## Problem

### Media Catalog

Write an application that can manage a catalog of multimedia items. An entry in this catalog might be a song, a movie, a book, an image or any item that has at least a name and a path in the local file system. (We may also consider specifying a release year, a rating and other additional data, for example the author of the book, etc.)

## Tasks

### Compulsory

- [x] Create an object-oriented model of the problem. You should have at least the following classes: Catalog and two item classes at your choice. Consider using an interface or an abstract class in order to describe the items in a catalog.
- [x] Implement the following methods representing commands that will manage the content of the catalog:
    - add: adds a new entry into the catalog;
    - list: prints the content of the catalog on the screen; 
    - play: playback using the native operating system application (see the Desktop class);
    - save: saves the catalog to an external file (either as a text or binary, using object serialization);
    - load: loads the catalog from an external file.
- [x] The application will signal invalid data (year, path, etc.) using a custom exception.

![](readme_images/compulsory_example_1_instance.png)
![](readme_images/compulsory_example_1_result.png)

### Optional
To be continued...
### Bonus
To be continued...

