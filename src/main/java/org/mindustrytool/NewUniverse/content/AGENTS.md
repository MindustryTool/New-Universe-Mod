# content/ — Game content definitions

## OVERVIEW

Five Java classes that register all mod content: items, blocks, units, planets, and the tech tree. Each class is a static holder with a `load()` entry point.

## STRUCTURE

| File | Pattern | Lines | Content |
|------|---------|-------|---------|
| `NewUniverseItems.java` | Static init | 61 | 5 items: cryoCrystal, frozenIron, volcanicSulfur, cryoAlloy, glaciusRubble |
| `NewUniverseBlocks.java` | Static init | 102 | 15 blocks: 8 floors, 4 walls, 3 ores |
| `NewUniverseUnitTypes.java` | Static init | 201 | 18 units: 5 air, 5 mech, 5 naval, 3 special (spearhead, altiar, cetus) + Seq groupings |
| `NewUniversePlanets.java` | Static init | 53 | 2 planets (borealisSun, glacius) + 1 SectorPreset |
| `NewUniverseTechTree.java` | Static init | 68 | Tech tree wiring via nodeRoot/nodeProduce |

## WHERE TO LOOK

- **Adding an item**: `NewUniverseItems.java` — static field, double-brace init, set hardness/cost/flammability/explosiveness/radioactivity/color
- **Adding a block**: `NewUniverseBlocks.java` — declare field, instantiate in `load()`. Floor→wall linking is automatic via naming convention (`"glacius-ice"` → `"glacius-ice-wall"`)
- **Adding a unit**: `NewUniverseUnitTypes.java` — static field in tier section, add to appropriate `Seq<UnitType>` grouping field
- **Adding a planet**: `NewUniversePlanets.java` — static field, double-brace init in `load()`
- **Wiring content into progression**: `NewUniverseTechTree.java` — nest nodes under the appropriate parent in `load()`

## CONVENTIONS

- **Name prefix**: All Glacius content uses `glacius-` kebab-case. Items and ores drop the prefix (`cryo-crystal`, `ore-cryo-crystal`).
- **Unit tiers**: Suffix `-{tier}` for tiers 1-5 (`glacius-air-1`). Special units get a unique name (`spearhead`).
- **Seq groupings**: UnitTypes must be added to `glacius{Type}Units` + `glaciusAllUnits` Seq fields.
- **Registration**: See root AGENTS.md `Content Registration — Two Patterns` for details. All content uses static init (Pattern A).

## ANTI-PATTERNS

- **Don't omit the Seq grouping** when adding a unit. Units not in `glaciusAllUnits` won't appear in unit tests or config UI.
- **Don't create floors without matching walls**. Floor.init() auto-links `"X"` → `"X-wall"`. Missing walls crash on planet load.
