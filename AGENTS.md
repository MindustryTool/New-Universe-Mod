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

```bash
./gradlew shadowJar         # → build/libs/new-universe-desktop.jar
./gradlew deploy            # Build cross-platform JAR (requires Android SDK)
./gradlew runGame           # Build + install + launch game
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
    ├── sprites/
    │   ├── pack.json       # Atlas config: flattenPaths, combineSubdirectories
    │   ├── blocks/environment/  # → PageType.environment (Floors, Walls, Ores bắt buộc)
    │   ├── boarelis/       # → PageType.main (Units, Turrets, Items, Props, Cores)
    │   └── sprites-override/ # Override vanilla sprites (không prefix mod name)
    └── bundles/            # I18N bundle files
```

## 🚨 SPRITE RULES — Không thể thương lượng

### Atlas Page Routing (CRITICAL)

`Mods.getPage()` trong Mindustry source:

```java
path.contains("sprites/blocks/environment") ? PageType.environment :
path.contains("sprites/rubble") ? PageType.rubble :
path.contains("sprites/ui") ? PageType.ui :
PageType.main;
```

- **Floor, Wall, OreBlock** → PHẢI ở đường dẫn chứa `blocks/environment`
- **Prop, Item, Unit, Turret, Core** → có thể ở bất kỳ đâu (page `main`)
- Sai page → environment tiles không render (lỗi như cũ)

### Sprite Organization (per-block folder)

Mỗi block content có folder riêng chứa tất cả variant + phụ kiện:

```
blocks/environment/borealis/floor/ice-floor/
  ice-floor1.png         # variant 1 (variant files = {name}{N}.png)
  ice-floor2.png         # variant 2
  ice-floor3.png         # variant 3
  # KHÔNG có ice-floor.png (base sprite useless khi có variants)

blocks/environment/borealis/wall/red-wall/
  red-wall1.png           # variant 1
  red-wall1-2x2.png       # 2x2 variant 1 (suffix: -2x2)
  red-wall2.png           # variant 2
  red-wall2-2x2.png       # 2x2 variant 2
  red-wall3.png           # variant 3
  red-wall3-2x2.png       # 2x2 variant 3

blocks/environment/borealis/props/red-crystal-cluster/
  red-crystal-cluster.png           # base sprite (props cần base cho icon)
  red-crystal-cluster1.png          # variant 1
  red-crystal-cluster-shadow1.png   # shadow overlay (KHÔNG tạo folder riêng)
```

### Naming Conventions (TUYỆT ĐỐI)

| Rule | ✅ Đúng | ❌ Sai |
|------|---------|--------|
| Case | `ice-floor1.png` | `Ice-Floor1.png` |
| Extension | `.png` | `.PNG`, `.Png` |
| Spaces | `red-wall1-2x2.png` | `Red-Wall1 2x2.png` |
| Backup markers | (không có) | `Barbavior(b?).png` |
| Variant numbering | `floor{N}.png` | `floor-{N}.png` |

### Atlas Config (`pack.json`)

```json
{ "flattenPaths": true, "combineSubdirectories": true }
```

- `flattenPaths: true` → Chỉ filename quyết định region name. Folder structure
  chỉ ảnh hưởng page routing, KHÔNG ảnh hưởng region name.
- Region name = `{mod-name}-{filename-without-extension}` (thêm prefix `new-universe-`)

## 📁 Sprite Directory Quy Chuẩn

```
sprites/
├── blocks/environment/borealis/     # PageType.environment
│   ├── floor/{name}/                # Floor blocks
│   ├── wall/{name}/                 # StaticWall blocks
│   ├── ore/{name}/                  # OreBlock blocks
│   └── props/{name}/                # Prop blocks
├── boarelis/                        # PageType.main
│   ├── item/item/{name}.png         # Item sprites (32x32)
│   ├── item/gas/{name}.png          # Liquid/gas sprites
│   ├── unit/{line}/{name}-t{N}/     # Unit sprites
│   ├── building/turrets/{name}/     # Turret sprites (base, side-l/r, mid, blade, barrel, preview)
│   ├── building/cores/{name}/       # Core sprites (base, team, thruster-1, thruster-2)
│   └── building/{category}/         # Other blocks (ducts, conduits, etc.)
├── sprites-override/                # Override vanilla (không prefix mod name)
│   └── team-blue.png                # Team color override
└── pack.json
```

### Core Sprite Requirements

CoreBlock cần các region auto-loaded qua @Load annotation:
- `{name}.png` — base region
- `{name}-team.png` — team-colored overlay
- `{name}-thruster-1.png` — thruster frame 1
- `{name}-thruster-2.png` — thruster frame 2

## Content Registration Pattern

### Feather DI Pattern (dùng cho toàn bộ content mới)

Mỗi content group là 1 `@Singleton` class với `@Inject` constructor.
`BorealisContents` inject tất cả và expose public fields.

```java
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BorealisItems {
    public Item barbavior;

    public void loadContent() {
        barbavior = new Item("barbavior", color) {{ /* props */ }};
    }
}
```

**KHÔNG dùng static field initializers** như project cũ. Pattern này
không dùng được với Feather DI.

### Load Order (trong BorealisManager)

1. Items
2. Liquids
3. Units (core → attacker → supporter → air → ground → naval)
4. Blocks (building → distribution → power → production → turret → environment)
5. Planets
6. TechTree

## Key Architecture Rules

### Dependency Scope — CRITICAL

- **Mindustry + Arc**: ALWAYS `compileOnly` — NEVER `implementation`
- Getting this wrong bundles the entire game (200MB+ JAR, instant crash)

### Mindustry v8 Gotchas

- `Player.unit()` can be null — always check `!player.dead()` first
- Unit ammo system REMOVED in v8 — don't reference `UnitType.ammoType`
- Commands are `Seq<UnitCommand>`, NOT arrays
- `itemWhitelist` / `hiddenItems` removed — use `shownPlanets`
- `emitLight` must be `true` for `drawLight()` to work

## Boundaries

### ✅ Always Do
- `compileOnly` for Mindustry/Arc — never `implementation`
- Run `./gradlew shadowJar` sau mọi thay đổi
- Sprite files **all lowercase kebab-case**
- Floor/Wall/OreBlock sprites in `sprites/blocks/environment/`
- Per-block subfolder cho mọi env sprites
- Bỏ base sprite nếu đã có variants (trừ Prop)
- Check `git status` / `git diff` trước khi xóa file
- Log với `arc.util.Log`, không `System.out`

### ⚠️ Ask Before Doing
- Adding new Gradle dependencies
- Modifying `build.gradle.kts`
- Changing mod name in `mod.hjson`
- Upgrading `mindustryVersion`
- Xóa bất kỳ file nào không rõ nguồn gốc

### 🚫 Never Do
- `implementation` scope cho Mindustry/Arc
- Uppercase trong sprite filenames (case-sensitive atlas packer)
- Spaces hoặc `(b?)` markers trong filename
- Base sprite `{name}.png` khi đã có variants `{name}1.png` (cho Floor/Wall/Ore)
- Folder riêng cho shadow overlays (phải nằm trong folder parent block)
- File `.PNG` (extension uppercase)
- Thêm content không sprite (trừ khi có lý do chính đáng)

## Research References

- **Source of truth**: `Anuken/Mindustry` GitHub (core/src/mindustry/)
- **All registered types**: `core/src/mindustry/mod/ClassMap.java`
- **Mod API entry**: `core/src/mindustry/mod/Mod.java`
- **Official wiki**: https://mindustrygame.github.io/wiki/modding/
- **v8 migration**: https://mindustrygame.github.io/wiki/modding/8-migrationv8/
- **Javadoc**: https://mindustrygame.github.io/docs/
