# Frogg — Mindustry v8 Java Mod

> Project memory for AI coding assistants (OpenCode, Claude Code, Cursor, Copilot).
> This file is read automatically. Keep it under 300 lines — prune rules that no
> longer prevent real mistakes.

## Project Overview

Frogg is a Mindustry v8 Java mod that adds custom units, items, weapons, and
gameplay content. It started as a JSON/HJSON mod and is being migrated to a
full Java mod for access to the complete Mindustry API.

**Target**: Mindustry v8 (build 158+, stable)
**Mod ID**: `frogg` (internal name used for sprite prefixing and content registration)

## Stack

- **Language**: Java 17 (source & target)
- **Build**: Gradle 8.x with `gradlew` wrapper
- **Game API**: Mindustry v158.1 + Arc framework (`compileOnly` — never bundled)
- **Content format**: HJSON files in `content/` (auto-loaded) + programmatic Java registration
- **Distribution**: Single cross-platform JAR (Desktop + Android)

## Commands

> **Prerequisite**: JAVA_HOME must point to JDK 17 (`C:\Program Files\Java\jdk-17`).
> Already set permanently if the scaffold script was run.

```bash
# Build desktop JAR
./gradlew jar              # → build/libs/froggDesktop.jar

# Build cross-platform JAR (requires Android SDK)
./gradlew deploy           # → build/libs/frogg.jar

# Clean build artifacts
./gradlew clean

# Test in Mindustry
# Copy build/libs/frogg.jar to your Mindustry mods folder and launch the game
```

## Project Structure

```
Frogg/
├── mod.hjson              # Mod metadata: name, main class, minGameVersion, java:true
├── build.gradle           # Gradle build config (compileOnly deps, jar/deploy tasks)
├── settings.gradle        # Root project name
├── AGENTS.md              # ← You are here
├── CLAUDE.md              # → @AGENTS.md (symlink target for Claude Code)
├── src/com/frogg/         # Java source
│   └── FroggMod.java      # Entry point — extends mindustry.mod.Mod
├── content/               # HJSON content definitions (AUTO-LOADED by game)
│   ├── items/             # Item type definitions (.hjson)
│   └── units/             # Unit type definitions (.hjson)
├── sprites/               # Sprite assets (auto-prefixed with "frogg-")
│   └── units/             # Unit sprites
└── assets/                # Static assets bundled into JAR
    └── sprites/           # Custom sprites referenced from Java code
```

## Key Architecture Rules

### Content Registration — Two Approaches

**Approach A: HJSON files (PREFERRED for existing content)**
Drop `.hjson` files into `content/{items,units,blocks,liquids,...}/`.
The game auto-loads them via `Mods.loadContent()` — NO Java code needed.

**Approach B: Programmatic (for custom logic)**
Register in `FroggMod.loadContent()` by calling static `load()` methods:
```java
@Override
public void loadContent() {
    FroggItems.load();   // Programmatic items
    FroggBlocks.load();  // Programmatic blocks
}
```
Create content by instantiating classes — registration is automatic via the
constructor name:
```java
public static Item myItem = new Item("my-item", Color.valueOf("ff0000")) {{
    hardness = 2;
    cost = 3;
}};
```

### Dependency Scope — CRITICAL RULE

- **Mindustry + Arc**: ALWAYS `compileOnly` — NEVER `implementation`
- **External libraries**: `implementation` ONLY if they must be bundled in the JAR
- Getting this wrong bundles the entire game into your mod (200MB+ JAR, instant crash)

### Mindustry API Essentials

| Reference | Location |
|-----------|----------|
| All HJSON-accessible types | `mindustry.mod.ClassMap.java` (master registry) |
| Mod entry point | `mindustry.mod.Mod` (extend this) |
| Global game state | `mindustry.Vars` (world, player, state, content, ui, net) |
| Event system | `mindustry.game.EventType.*` + `Events.on()` |
| Utility collections | `arc.struct.Seq<T>` (NOT `ArrayList`) |
| Sprites in Java | `Core.atlas.find("frogg-sprite-name")` (prefixed with mod name) |

### Key Classes for Modding

```
UnitType (mindustry.type)          — Base unit type
├── TankUnitType, ErekirUnitType   — Unit subtypes
Weapon (mindustry.type)            — Weapon mount on unit
BulletType (mindustry.entities.bullet)
├── BasicBulletType, MissileBulletType, LaserBulletType
├── BombBulletType, LightningBulletType, RailBulletType
├── PointLaserBulletType, ShrapnelBulletType, ...(~25 types)
Ability (mindustry.entities.abilities)
├── ForceFieldAbility, RegenAbility, ShieldRegenFieldAbility
├── RepairFieldAbility, StatusFieldAbility, SpawnDeathAbility
├── ArmorPlateAbility, MoveEffectAbility, ...(~15 types)
StatusEffect (mindustry.type)      — Status effects (burning, freezing, custom)
Block (mindustry.world.blocks)     — Block base class with 50+ subclasses
```

Full class hierarchy: https://github.com/Anuken/Mindustry/blob/master/core/src/mindustry/mod/ClassMap.java

## Coding Conventions

- **Package**: `com.frogg` — keep everything under this namespace
- **Class naming**: PascalCase. Content holder classes: `FroggItems`, `FroggUnits`, `FroggBlocks`
- **Content name**: kebab-case strings (`"my-unit-name"`) — must match sprite filenames
- **Java version**: Use Java 17 features freely (records, switch expressions, text blocks)
- **Imports**: No wildcard imports. Organize: `mindustry.*` → `arc.*` → `com.frogg.*`
- **Logging**: Use `arc.util.Log.info/warn/err` — NOT `System.out.println`

## v8-Specific Gotchas

- `Player.unit()` can be null — always check `!player.dead()` first
- Unit ammo system was REMOVED in v8 — don't reference `UnitType.ammoType`
- `Core.keybinds` removed — use `arc.input.KeyBind` class
- Commands are now `Seq<UnitCommand>`, NOT arrays (`UnitCommand.all` removed)
- `itemWhitelist` / `hiddenItems` removed — use `shownPlanets` field
- `emitLight` must be `true` for `drawLight()` to work on blocks
- `loopSound` removed — manage sound loops manually in `Building`

## Boundaries

### ✅ Always Do
- Use `compileOnly` for Mindustry/Arc dependencies
- Name content in kebab-case matching sprite filenames
- Use `Seq<T>` for collections, not `ArrayList`
- Log with `arc.util.Log`, not `System.out`
- Check `!player.dead()` before accessing `player.unit()`

### ⚠️ Ask Before Doing
- Adding new Gradle dependencies (especially non-compileOnly)
- Modifying `build.gradle` (affects cross-platform compatibility)
- Changing mod name in `mod.hjson` (breaks sprite prefixing)
- Upgrading `mindustryVersion` (API breakage risk)

### 🚫 Never Do
- Use `implementation` scope for Mindustry/Arc dependencies
- Use `@ts-ignore`, `@SuppressWarnings("all")`, or empty catch blocks
- Reference v7-only APIs (unit ammo, `Core.keybinds`, `itemWhitelist`)
- Delete the `content/` or `sprites/` directories — they're bundled into the JAR
- Export the JAR without running `./gradlew jar` or `./gradlew deploy`

## Research References

When agents need to understand Mindustry internals, search these sources:
- **Source of truth**: `Anuken/Mindustry` GitHub (core/src/mindustry/)
- **All registered types**: `core/src/mindustry/mod/ClassMap.java`
- **Mod API entry**: `core/src/mindustry/mod/Mod.java`
- **Official wiki**: https://mindustrygame.github.io/wiki/modding/
- **v8 migration**: https://mindustrygame.github.io/wiki/modding/8-migrationv8/
- **Javadoc**: https://mindustrygame.github.io/docs/
- **Real v8 mods**: Search GitHub for `mindustry-mod-v8` topic
