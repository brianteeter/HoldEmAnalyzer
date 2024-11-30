# Hold Em Analyzer
---

The Hold Em Analyzer is a project that I created back in 2004-2006.  I initially created this to help me do hand analisys for Texas Hold Em games.  Back in that era I was playing a lot both online and in person and this helped me to learn the math odds of various situations.  

The app uses Monte Carlo simulation to simulate the outcome of a hand.  It does this by simulating the remaining cards in the deck and then running a number of iterations to determine the outcome of the hand.  The more iterations you run, the more accurate the results will be.  Back in 2006 the default settings on fast hardware would produce 10's of thousands of iterations - today its more like hundreds of thousands which produces pretty accurate outcome estimates.

I intentionally chose to do Monte Carlo simulation vs calculating outcomes because I wanted to have slight variance in output.  Why?  Because I intended to use this as the core of a bot and the slight randomness would make it harder to predict, detect and play against.  

## Tech Details:
---
This app is written in Java and was originally written in Java 1.4.  It uses the Java Swing UI toolkit which was created way back at the beginning of Java's life.

The UI is fairly simple and made to fit the 640x480 or 800x600 screens of the day.  

## Required Build and Execution Tools
---

### JDK 21
---
To build this project you will need to have a modern JDK installed.  I have updated and tested this with JDK 21.  You can download the JDK from Oracle's website or use OpenJDK.

### Maven:
---
You will also need to install maven, the widely used Java packaging, dependency and build tool.  


## To Build and Run
---

Clone this project to your local machine.  Then navigate to the root of the project and run the following command:

```
mvn clean install
```

Then after the build runs, you should be able to run the app with the following command:

```
java -jar target/HoldEmAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar
```

That will bring up the UI and the rest should be self explanitory.  


## Features:
---

This tool can do simple outcome analysis on a single hand or a it can compare two hands.  You can also set the board to whatever cards you like, including no cards, the flop, turn, and river.  

On the Settings screen you can adjust the "think" time of the simulation.  The default is enough now to do pretty hundreds of thousands of iterations - so its probably adequate on todays hardware.