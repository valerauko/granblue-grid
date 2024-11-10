# GBF Grid Show

A convenient and hopefully safe Chrome extension that displays your active Granblue Fantasy grid (team, summons, skills, weapons), so you don't have to manually screenshot them all the time if you want to show it off in some video.

## How to use?

1. in Chrome, from the main menu go to More tools > Developer tools (or press `ctrl` + `shift` + `i`)
2. select GBF Grid Show from the tabs at the top
3. if it's not there, select it from ⋮ > More tools

Tip: before you start playing in earnest, make sure that recording on the Network tab is disabled (the Record network log button in the top left is _not_ red). Leaving that on for an extended time can cause problems.

### Install

Since the Chrome extension store is not free and I'm not willing to pay for this, for now you'll have to install it manually.

1. download `gbf-grid-release.zip` from [the Releases page](https://github.com/valerauko/granblue-grid/releases)
2. extract the zip to a folder wherever you like it
3. in Chrome, from the main menu go to Extensions > Manage extensions
4. enable Developer mode with the toggle on the top right
5. click "Load unpacked" and select the folder where you extracted the extension

## Levels and weapon skills don't show up?

Certain details about the grid aren't available when starting a quest or joining a raid. If you want to display more details, you'll have to open the Party (編成) page with the extension active.

## Is this safe to use?

It doesn't send any requests, doesn't use any resources not already available in the game, nor display any information that isn't readily available in-game. The purpose is just that streamers don't have to redo a bunch of screenshots every time they update their grid (which can happen quite often).

That said, GBF is famously strict about "tool use" so use only at your own risk.

## Development

Containerized setup using VSCode dev containers.

On the Chrome Extensions tab enable Developer mode and then Load unpacked the ext folder. The extension frame has to be reloaded to reflect changes.
