# WebAsGUI

WebAsGUI is a simple solution that helps you to make beautiful GUI in Java. This GUI can be made by using HTML, CSS and JS. 

> Before reading this i know i have a bad english, sorry for this.



## Index

* [Installation](#installation)
* [Documentation](https://monkeyandres.github.io/WebAsGUI)
* [Project Structure](#project-structure)
* [How does it work?](#how-does-it-work?)
* [Communicating JS and Java](#communicating-js-and-java)
  * [Upcalls from JS to Java](#upcalls-from-js-to-java)
  * [Call JS functions from Java](#call-js-functions-from-java)
* [Working with JSON](#working-with-json)



## Installation

Just clone this repository using:

```git
git clone https://github.com/MonkeyAndres/WebAsGUI.git
```



## Project Structure

```
WebAsGUI
├── README.md
├── src
│   └── frontend
│       ├── Bridge.java
│       ├── Controller.java
│       ├── Main.java
│       └── MainWindow.fxml
│   └── backend
│       ├── JSON.java
│       └── JsonObject.java
└── www
    └── index.html
```



## How does it work? 

It works using a simple JavaFX WebView. This WebView open the index.html file located in **/www folder**.



## Communicating JS and Java

I'm going to explain how to make upcalls from JS to Java and how to call JS from Java.

#### Upcalls from JS to Java

We provide a class called **Bridge.java** and as i explain in the project structure, all the methods written in this class are accessible from JavaScript. Let's see an example.

```java
// Bridge.java
public class Bridge {

    // Example method that print "Hello From JS :P" in the console.
    public void sayHello(){
        System.out.println("Hello From JS :P");
    }

}
```

```html
<!-- index.html -->
<script>
  	function init(){
    	app.sayHello();
  	}
</script>
```

This example will print in the console "Hello From JS :P"

> Note: if you want to run a script when the page loads you must put it into the init() function.

#### Call JS functions from Java

The app runs the `init()` funtion by default but you can call other js functions by adding this simple line of code.

```java
Controller.runJSFunction("init();");
```



## Working with JSON

As a good backend we offer a set of classes that allow you to send JSON objects from java to javascript. Let's see an example.

```java
// backend.Person.java

// This model must implement JsonObject.
public class Person implements JsonObject {	
    private String name;
    private int age;

    public Alumno(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override // A kind JSON builder
    public String toJSON() {
        String Json = "{" +
                "\"nombre\": \""+name+ "\"," +
                "\"edad\": "+age+
                "}";
        return Json;
    }
}
```

```java
// Bridge.java

public class Bridge{
  public String getJSON(){
        Person a1 = new Person("Juan", 34);
        Person a2 = new Person("Pedro", 24);
        Person a3 = new Person("Ignacio", 14);

        JSON people = new JSON();

        people.add(a1);
        people.add(a2);
        people.add(a3);

        return people.toJSON();
    }
}
```

Now from JS you can parse the result of `app.getJSON()`