# FairPlay

FairPlay is a Minecraft server plugin focused on lightweight server-side balance and rule enforcement. It is designed for Paper/Spigot servers and keeps a small, clear feature set centered on combat and brewing restrictions.

- wind charge cooldown control
- brewing restrictions for selected potions
- enchantment restrictions for flame-related enchantments

## Features

- configurable Wind Charge cooldown per server
- blocks selected potion outcomes during brewing
- removes selected enchantment offers and outcomes
- uses a simple YAML config for fast server-side tuning

## Configuration

Default settings are stored in `src/main/resources/config.yml`.

```yml
configuration:
  WindCharge-Cooldown: 10
```

Example messages:

```yml
messages:
  WindCharge-Cooldown: "&cYou must wait %time% seconds to use the Wind Charge again."
  WindCharge-Used: "&aYou used the Wind Charge!"
```

## Requirements

- Java 8
- Spigot or Paper 1.21
- Maven for building from source

## Build

```bash
mvn clean package
```

The final plugin jar is generated in `target/`.

## Installation

1. Build the project.
2. Copy the generated jar into your server's `plugins/` folder.
3. Start or restart the server.
4. Adjust `config.yml` if you want to change cooldown values or messages.
