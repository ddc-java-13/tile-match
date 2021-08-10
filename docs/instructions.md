---
title: Instructions
menu: Instructions
order: 100
---

## Build Instructions

In order to use the App follow these instructions
* Follow this [link](https://github.com/ddc-java-13/tile-match) to the github project page.
* Click the CODE button and with your preferred method of authorization (SSH recommended) selected click the clipboard icon to copy the link.
* From the welcome menu of IntelliJ click the "get from vcs" button and paste the link you copied from github into the URL field.
* You MUST create a properties file on your local machine with the following fields
  * base_url = https://pixabay.com/
  * client_id = 
    * You MUST navigate to [pixabay](https://pixabay.com/api/docs/) and obtain an api. the api must be copied EXACTLY into the client id field.
  * You must then navigate to the default config section of the build.gradle app file and edit the following fields so they point to your local properties file.
    * buildConfigField "String", "BASE_URL",
    * buildConfigField "String", "API_KEY",
  * You can now run the app in your preferred emulator so long as it meets the specifications set forth in the [technical documentation](technical.md).
  
## Game Instructions

Game Navigation is very simple. there are clearly labeled buttons from the home screen of the app leading to the other screens in the app.

Each screen has a back button located in the lower left corner which will return you to the home screen.

Gameplay is also quite simple. once you click the start game you will navigate to a screen with a series of numbered tiles. Clicking on a tile will reveal a picture. Try to remember where the picture is located and find its match. Once you have matched all tiles you win. Simply click the back button to return to the home screen.

* Important - clicking the back button before a game is complete will abandon the current game.