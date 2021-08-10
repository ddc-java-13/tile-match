---
title: Summary
subtitle: "A memory game where players attempt to find matching images by flipping tiles."
menu: Summary
order: 10
---

## [Introduction](introduction.md)

## [Current State](current-state.md)

## Summary

Construct tile sets from artwork images retrieved by querying one of several publicly accessible art-oriented repositories by keyword. Generate random tile arrangements from a selected tile set. In each turn, flip a pair of tiles: if the tiles match, the tiles are removed from the playing surface and the score increases; otherwise, the tiles are flipped face-down again. The time and the number of pair selections required to clear all tiles are recorded for display in a score summary screen.
## Intended users
* Professionals interested in a quick easily accessible gaming experience.
  > As someone who works long hours and needs to relax I want a simple game that helps me find focus and enjoyment.
* Parents looking for productive distractions for young children.  
  > As a parent of active elementary school-aged children, I am looking for a calming game I can feel good about my children playing that aids in developing fine motor skills.

## Functionality

* A new game will generate random tile arrangements from one of several art oriented repositories by keyword. Players will attempt to get a match by selecting pairs of tiles. Matching tiles are removed from the playing surface. Play continues until all tiles have been removed.

* The game will track the number of matching attempts a player makes in a given game as well as the total amount of time it takes to clear all tiles. The score will be recorded as well as the date the game was played to allow players to save their best records as well as track their improvements.

* The game will support customizable difficulty settings for beginner to advanced players.

## Persistent data

* Difficulty settings
* Game length
* matching attempts
* Image schemes
* User preferences

## Device/external services

[Pixabay](https://pixabay.com/service/about/api/) Image source for images used on tiles for matching. 

## Stretch goals/possible enhancements

* Record Games and save them for later playback
* Submit high scores to compare with other players
* Add escalating difficulty options that create moving tiles and/or endless modes that add more tiles as the game progresses.

## [Wireframe](wireframe.md)

## [ERD](erd.md)

## [Data Model](data-model.md)

## [Technical Requirements](technical.md)

## [License Information](license.md)