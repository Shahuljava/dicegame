# DiceGame Project For FCC/ FCA

## Overview

This project contains a simulation of a dice game where the objective is to obtain the lowest possible score by following specific game rules. The game is played with five dice, and the rules dictate that any rolled threes are not scored, while the lowest other die is scored if no threes are rolled. The dice are thrown repeatedly until no dice are left. This simulation runs the game 10,000 times to record and analyze the distribution of possible scores.

## Technical Approach

The implementation of the `DiceGame` is done in Java. The game logic involves:

- Initializing the dice rolls.
- Processing each roll to apply the game rules.
- Keeping track of scores and the state of dice across multiple rounds until all dice are removed.
- Using Java Streams for handling dice operations for better readability and efficiency.

The code is structured to be modular with methods handling specific parts of the game logic, making it easy to understand and modify.

## Requirements

To run this simulation, you will need:

- Java JDK 8 or higher
- An IDE such as IntelliJ IDEA, Eclipse, VScode or simply a command line setup

## Installation

Clone the repository to your local machine using the following command:

````bash
git clone https://github.com/Shahuljava/dicegame.git
cd yourrepository

## Running the Simulation

To run the simulation directly from the source file, use the following command:
```bash
java DiceGame.java

````
