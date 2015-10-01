# How to run: #

Number of draw combinations for 2 Queens, 2 Kings, 2 Rooks, 2 Bishops and 1 Knight and 7x7 board:
```
#!bash

Oleksiis-MBP:chess-challenge kelebra$ sbt "; project challenge; solution" -J-Xmx4G -J-Xms4G
[info] Loading project definition from /Users/kelebra/Documents/IdeaProjects/chess-challenge/project
[info] Set current project to chess-challenge (in build file:/Users/kelebra/Documents/IdeaProjects/chess-challenge/)
[info] Set current project to challenge (in build file:/Users/kelebra/Documents/IdeaProjects/chess-challenge/)
[info] Running com.tkachuko.chess.challenge.Challenge 
Number of draw positions in challenge: 3063828
Time spent: 37306
[success] Total time: 38 s, completed Sep 30, 2015 10:56:33 PM
Oleksiis-MBP:chess-challenge kelebra$ 
```

Usage sample to run some custom layout:


```
#!bash

Oleksiis-MBP:chess-challenge kelebra$ sbt
[info] Loading project definition from /Users/kelebra/Documents/IdeaProjects/chess-challenge/project
[info] Set current project to chess-challenge (in build file:/Users/kelebra/Documents/IdeaProjects/chess-challenge/)
> re-start
[info] Compiling 1 Scala source to /Users/kelebra/Documents/IdeaProjects/chess-challenge/frontend/target/scala-2.11/classes...
[info] Fast optimizing /Users/kelebra/Documents/IdeaProjects/chess-challenge/frontend/target/scala-2.11/frontend-fastopt.js
[info] Application web not yet started
[info] Starting application web in the background ...
web Starting com.tkachuko.chess.web.Server.main()
[success] Total time: 12 s, completed Sep 30, 2015 11:01:17 PM
```

After that open your browser at http://localhost:8000. Sample screen below:
![Screen Shot 2015-09-30 at 11.03.06 PM.png](https://bitbucket.org/repo/eexnX5/images/2486653687-Screen%20Shot%202015-09-30%20at%2011.03.06%20PM.png)

And specify some layout:
![Screen Shot 2015-09-30 at 11.05.20 PM.png](https://bitbucket.org/repo/eexnX5/images/302778401-Screen%20Shot%202015-09-30%20at%2011.05.20%20PM.png)

See the result after clicking the button in the bottom of the form:
![Screen Shot 2015-09-30 at 11.06.22 PM.png](https://bitbucket.org/repo/eexnX5/images/599180456-Screen%20Shot%202015-09-30%20at%2011.06.22%20PM.png)

# Technology stack: #

* sbt
* akka-http
* scala.js
* scalatest
* scalacheck

# Project structure: #
* challenge - implementation of algorithm
* domain - entities needed for abstraction and design
* frontend - scala.js module used for representation of boards and providing UI to specify input data for challenge such as figures layout and board size
* messages - case classes to interact with web server from fronted module
* web - simple web server in aka-http

# General comments: #
It is kind of shame that challenge is completed with usage of 4G of RAM, however this is necessary given the amount of boards algorithm has to store all the time. Moreover I should mention that algorithm is approximately 3 methods long and its maintainability and readability is on top level. We could make use of akka to do things in parallel however it would involve more metrics and problems down the road. Moreover it is not a trivial task to parallel heuristic algorithm and also I was not sure that this was expected from me during the exercise. I am pretty much proud of the testing framework for behavior of figures, have a look at it too :)