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