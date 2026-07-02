# New Universe — Mindustry v8 Java Mod

> Project memory for AI coding assistants (OpenCode, Claude Code, Cursor, Copilot).
> This file is read automatically. Keep it under 300 lines — prune rules that no
> longer prevent real mistakes.

## Project Overview

New Universe is a Mindustry v8 Java mod that adds custom units, items, weapons, and
gameplay content. It started as a JSON/HJSON mod and is being migrated to a
full Java mod for access to the complete Mindustry API.

**Target**: Mindustry v8 (build 158+, stable)
**Mod ID**: `new-universe` (internal name used for sprite prefixing and content registration)

## Stack

- **Language**: Java 17 (source & target)
- **Build**: Gradle 8.x with `gradlew` wrapper, Kotlin DSL
- **Game API**: Mindustry v158 + Arc framework (`compileOnly` — never bundled)
- **Shadow plugin**: `com.gradleup.shadow` v9.2.2 for JAR packaging
- **Content format**: Programmatic Java registration via static `load()` methods
- **Distribution**: Single cross-platform JAR (Desktop + Android)

## Commands

> **Prerequisite**: JAVA_HOME must point to JDK 17 (`C:\Program Files\Java\jdk-17`).
> Already set permanently if the scaffold script was run.

```bash
# Build desktop JAR (shadowJar)
./gradlew shadowJar         # → build/libs/new-universe-desktop.jar

# Build cross-platform JAR (requires Android SDK)
./gradlew deploy            # → build/libs/new-universe.jar

# Build + install + launch game
./gradlew runGame           # builds, copies to Mindustry mods, launches

# Clean build artifacts
./gradlew clean
```

## Project Structure

```
new-universe/
├── mod.hjson               # Mod metadata: name, main class, minGameVersion, java:true
├── build.gradle.kts        # Gradle build (Kotlin DSL, shadow plugin)
├── settings.gradle.kts     # Root project name
├── gradle.properties       # JVM args (+ Jabel module exports)
├── AGENTS.md               # ← You are here
├── src/main/java/org/mindustrytool/NewUniverse/
│   ├── NewUniverseMod.java # Entry point — extends mindustry.mod.Mod
│   ├── content/            # Game content definitions (blocks/items/units/planets/tech)
│   └── planets/            # Planet generator (procedural terrain)
└── src/main/resources/
    ├── mod.hjson           # Mod metadata (also at root — keep both)
    ├── sprites/units/glacius/  # Organized unit sprites by category
    └── unsorted/            # Raw/unused sprite assets (archival)
```

## Key Architecture Rules

### Content Registration — Two Patterns

**Pattern A: Static field initializers (items, blocks, units, planets, tech tree)**
Content is created via double-brace initialization on static fields. Registration
happens automatically through the constructor. `load()` methods exist only to
force class loading:
```java
public static Item cryoCrystal = new Item("cryo-crystal", Color.valueOf("60a0ff")) {{
    hardness = 3;
    cost = 4;
}};
public static void load() { /* static init trigger */ }
```
Called from `NewUniverseMod.loadContent()`:
```java
NewUniverseItems.load();
NewUniverseBlocks.load();
NewUniverseUnitTypes.load();
NewUniversePlanets.load();
NewUniverseTechTree.load();
```

**Pattern B: Manual instantiation in PlanetGenerator**
The generator class creates its terrain array statically. Its sole `load()`
method is an empty stub for pattern consistency.

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
| Sprites in Java | `Core.atlas.find("new-universe-sprite-name")` (prefixed with mod name) |

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

- **Package**: `org.mindustrytool.NewUniverse` — keep everything under this namespace
- **Class naming**: PascalCase. Content holder classes: `NewUniverseItems`, `NewUniverseUnits`, `NewUniverseBlocks`
- **Content name**: kebab-case strings (`"my-unit-name"`) — must match sprite filenames
- **Java version**: Use Java 17 features freely (records, switch expressions, text blocks)
- **Imports**: No wildcard imports. Organize: `mindustry.*` → `arc.*` → `org.mindustrytool.NewUniverse.*`
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
- Use `shadowJar` for building (not the plain `jar` task)
- Check `!player.dead()` before accessing `player.unit()`

### ⚠️ Ask Before Doing
- Adding new Gradle dependencies (especially non-compileOnly)
- Modifying `build.gradle.kts` (affects cross-platform compatibility)
- Changing mod name in `mod.hjson` (breaks sprite prefixing)
- Upgrading `mindustryVersion` (API breakage risk)

### 🚫 Never Do
- Use `implementation` scope for Mindustry/Arc dependencies
- Use `@ts-ignore`, `@SuppressWarnings("all")`, or empty catch blocks
- Reference v7-only APIs (unit ammo, `Core.keybinds`, `itemWhitelist`)
- Delete `src/main/resources/` — it contains the bundled sprites and mod metadata
- Export the JAR without running `./gradlew shadowJar` or `./gradlew deploy`

## Research References

When agents need to understand Mindustry internals, search these sources:
- **Source of truth**: `Anuken/Mindustry` GitHub (core/src/mindustry/)
- **All registered types**: `core/src/mindustry/mod/ClassMap.java`
- **Mod API entry**: `core/src/mindustry/mod/Mod.java`
- **Official wiki**: https://mindustrygame.github.io/wiki/modding/
- **v8 migration**: https://mindustrygame.github.io/wiki/modding/8-migrationv8/
- **Javadoc**: https://mindustrygame.github.io/docs/
- **Real v8 mods**: Search GitHub for `mindustry-mod-v8` topic
