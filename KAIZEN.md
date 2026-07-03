# KAIZEN — Mindustry v8 Modding Knowledge Base

> Tổng hợp research sâu về Mindustry v8 modding API, sprite pipeline, tech tree,
> và các pitfalls thường gặp. Dùng làm tài liệu tra cứu khi phát triển mod New Universe.

---

## 1. Content Name → Sprite Resolution Pipeline

### Mod Prefix

Khi bạn tạo content từ 1 mod, Mindustry tự động prefix tên content với mod name.

```
Item("duras")         → content.name = "new-universe-duras"
UnitType("herja")     → content.name = "new-universe-herja"
Block("ice")          → content.name = "new-universe-ice"
OreBlock("ore-duras") → content.name = "new-universe-ore-duras"
```

**Source**: `ContentLoader.transformName()`:
```java
public String transformName(String name){
    return currentMod == null ? name : currentMod.name + "-" + name;
}
```

### Sprite → Atlas Entry

Sprite files trong thư mục `sprites/` cũng được prefix với mod name khi pack vào atlas.

```
sprites/items/duras.png        → atlas entry "new-universe-duras"
sprites/units/herja/herja.png  → atlas entry "new-universe-herja"
sprites/blocks/turrets/mjolnir/mjolnir.png → "new-universe-mjolnir"
sprites/ores/duras/duras-ore1.png → "new-universe-duras-ore1"
```

**Source**: `Mods.packSprites()` — file trong `sprites/` (prefix=true) được thêm `mod.name + "-"` 
vào trước base filename, trừ khi filename đã có pattern `{category}-{modname}-{content}`.

**Kết luận**: Content name và atlas entry phải MATCH. Nếu content tên `new-universe-duras` 
thì cần file `duras.png` ở đâu đó trong `sprites/`.

### Case Sensitivity ⚠️

Atlas packer **phân biệt hoa/thường** (case-sensitive). File `Cophalast.png` → atlas entry
`new-universe-Cophalast`, nhưng content lookup dùng `new-universe-cophalast` → không match.

**Luôn dùng lowercase + kebab-case** cho tên file sprite:
- ✅ `duras.png`, `faras-alloy.png`, `tempered-glass.png`
- ❌ `Duras.png`, `Faras alloy.png`, `Tempered glass.png`
- ❌ `.PNG` extension → đổi thành `.png`

### @Load Annotation

Annotation `@Load` tự động sinh code `Core.atlas.find()` với content name.

```java
@Load("@-shadow")     → Core.atlas.find("new-universe-{block}-shadow")
@Load("@-team")       → Core.atlas.find("new-universe-{block}-team")
@Load("@-base")       → Core.atlas.find("new-universe-{block}-base")
```

**Source**: `LoadRegionProcessor.parse()`:
- `@` → `content.name` (đã bao gồm mod prefix)
- `@size` → `block.size`
- `#1`, `#` → `INDEX0` (array index 0)
- `#2` → `INDEX1` (array index 1)

### Icon Fallback Chain

`UnlockableContent.loadIcon()` thử các pattern sau cho `fullIcon`:

| Priority | Pattern | Example (item "duras") |
|----------|---------|----------------------|
| 1 | `fullOverride` | (nếu set) |
| 2 | `{type}-{name}-full` | `item-new-universe-duras-full` |
| 3 | `{name}-full` | `new-universe-duras-full` |
| **4** | **`{name}`** | **`new-universe-duras`** ← cần file `duras.png` |
| 5 | `{type}-{name}` | `item-new-universe-duras` |
| 6 | `{name}1` | `new-universe-duras1` |

`uiIcon` = `{type}-{name}-ui` (fallback về `fullIcon`).

**Nếu không tìm thấy**: `Core.atlas.find()` trả về error texture (hồng/đen checkerboard).
`found()` trả về `false`. **Không có auto-generation từ color.**

---

## 2. Bundle / Localization I18N

### Bundle Key Format

Bundle keys phải dùng **full content name (đã bao gồm mod prefix)**:

```
item.new-universe-{item-name}.name = Display Name
item.new-universe-{item-name}.description = Mô tả
```

Không dùng key thiếu prefix (sẽ không được game nhận):
- ❌ `item.cophalast.name = Cophalast`
- ✅ `item.new-universe-cophalast.name = Cophalast`

### Các loại content bundle keys

```
item.{mod}-{name}.name          — Item
item.{mod}-{name}.description
block.{mod}-{name}.name         — Block (floor, wall, turret, crafter, ...)
block.{mod}-{name}.description
unit.{mod}-{name}.name          — Unit
unit.{mod}-{name}.description
planet.{mod}-{name}.name        — Planet
planet.{mod}-{name}.description
liquid.{mod}-{name}.name        — Liquid
liquid.{mod}-{name}.description
status.{mod}-{name}.name        — Status effect
status.{mod}-{name}.description
```

**Source**: Mindustry wiki modding guide, section "Bundles".

### Locale codes hỗ trợ

Mindustry hỗ trợ `vi` (Vietnamese). File đặt trong `resources/bundles/`:
- `bundle.properties` — default (English)
- `bundle_vi.properties` — Vietnamese

### Encoding

Properties files dùng UTF-8 (không cần Unicode escapes).

---

## 3. Sprite Format & Directory

### Yêu cầu kỹ thuật

| Content Type | Sprite Size | Định dạng |
|---|---|---|
| Items | **32×32** | PNG 32-bit RGBA |
| Blocks (1×1) | 32×32 | PNG 32-bit RGBA |
| Blocks (n×n) | n×32 × n×32 | PNG 32-bit RGBA |
| Floors | 32×32 | PNG 32-bit RGBA |
| Units | Tự do, thường 32× → 128× | PNG 32-bit RGBA |

**Tất cả**: PNG 32-bit RGBA (không 16-bit, không indexed). Sai format có thể gây crash 
"Pixmap decode error".

### Atlas Packer Config

Mindustry dùng `pack.json` với:

```json
{
  flattenPaths: true,
  combineSubdirectories: true
}
```

**`flattenPaths: true`**: Cấu trúc thư mục bị flatten — chỉ filename quyết định region name.
Ví dụ: `sprites/boarelis/enviroment/floor/ice-floor.png` → region name `ice-floor`.

**`combineSubdirectories: true`**: Tất cả thư mục con được gộp vào cùng 1 atlas page.

### Atlas Page Routing — CRITICAL

`Mods.getPage()` trong Mindustry source quyết định sprite vào page nào dựa trên **đường dẫn file**:

```java
private PageType getPage(Fi file){
    String path = file.path();
    return
        path.contains("sprites/blocks/environment") ? PageType.environment :
        path.contains("sprites/rubble") ? PageType.rubble :
        path.contains("sprites/ui") ? PageType.ui :
        PageType.main;
}
```

| Path contains → | Atlas Page |
|---|---|
| `sprites/blocks/environment` | `environment` |
| `sprites/rubble` | `rubble` |
| `sprites/ui` | `ui` |
| Everything else | `main` |

**Hệ quả với New Universe**: 
- File ở `sprites/boarelis/enviroment/floor/X.png` → path contains `sprites/boarelis/enviroment` → **không** match `sprites/blocks/environment` → vào page `main`
- File ở `sprites/blocks/environment/a/X.png` → path contains `sprites/blocks/environment` → vào page `environment` ✅
- **Environment tiles (Floor, Wall, OreBlock) yêu cầu page `environment` để render đúng. Nếu sai page → hiển thị lỗi hoặc không load.**

## 3b. Floor Variant Resolution

Floor trong Mindustry resolve sprite variants qua `Floor.load()`:

```java
if(variants > 0){
    variantRegions = new TextureRegion[variants];
    for(int i = 0; i < variants; i++){
        variantRegions[i] = Core.atlas.find(name + (i + 1));
    }
}else{
    variantRegions = new TextureRegion[1];
    variantRegions[0] = Core.atlas.find(name);
}
```

Với Floor tên `"ice-floor"` (content name `new-universe-ice-floor`), variants=3:
- Atlas regions cần: `new-universe-ice-floor1`, `2`, `3`
- File sprite cần: `ice-floor1.png`, `ice-floor2.png`, `ice-floor3.png`

**File naming rules** (tất cả lowercase + kebab-case):
- Base: `{name}.png` → region `{mod}-{name}`
- Variants: `{name}{N}.png` → region `{mod}-{name}{N}` (N = 1, 2, 3...)
- ❌ `Ice-Floor1.png` → region `new-universe-Ice-Floor1` (uppercase → không match!)

## 3c. Mod Prefix trong Region Name

`Mods.packSprites()` quyết định region name:

```java
int hyphen = baseName.indexOf('-');
String fullName = ((prefix && !(hyphen != -1 && baseName.substring(hyphen + 1).startsWith(mod.name + "-")))
    ? mod.name + "-" : "") + baseName;
```

Logic:
1. Luôn thêm `mod.name + "-"` (="new-universe-") vào trước base filename
2. **NGOẠI LỆ**: Nếu filename đã có prefix `{category}-{modname}-` → không thêm nữa (tránh double prefix)

Ví dụ:
- `duras.png` → `new-universe-duras` ✅
- `new-universe-duras.png` → `new-universe-duras` ✅ (không double prefix)
- `Cophalast.png` → `new-universe-Cophalast` ❌ (sai case!)

## 3d. Sprite Directory Structure Chuẩn

```
sprites/
├── blocks/environment/borealis/   → PageType.environment
│   ├── floor/{name}/              (Floor blocks, per-block folder)
│   ├── wall/{name}/               (Wall blocks, per-block folder)
│   ├── ore/{name}/                (OreBlock, per-block folder)
│   └── props/{name}/              (Prop blocks, per-block folder)
├── boarelis/                      → PageType.main
│   ├── item/item/{name}.png       (Items)
│   ├── item/gas/{name}.png        (Liquids)
│   ├── unit/{line}/{name}-t{N}/   (Units, organized by line + tier)
│   ├── building/cores/{name}/     (Cores: base, team, thruster-1, thruster-2)
│   ├── building/turrets/{name}/   (Turrets: base, side-l/r, mid, blade, barrel, preview)
│   └── building/{category}/       (Other buildings: ducts, conduits, power, production)
├── sprites-override/              → Override vanilla (không prefix)
│   └── team-blue.png
└── pack.json
```

### Per-Block Folder Convention (env blocks)

Mỗi block content có folder riêng:
```
blocks/environment/borealis/floor/ice-floor/
  ice-floor1.png      # variant 1
  ice-floor2.png      # variant 2
  ice-floor3.png      # variant 3
  # KHÔNG có base sprite (ice-floor.png) — useless khi variants > 0

blocks/environment/borealis/wall/red-wall/
  red-wall1.png       # variant 1 1x1
  red-wall1-2x2.png   # variant 1 2x2
  red-wall2.png       # variant 2 1x1
  red-wall2-2x2.png   # variant 2 2x2
  red-wall3.png       # variant 3 1x1
  red-wall3-2x2.png   # variant 3 2x2

blocks/environment/borealis/props/red-crystal-cluster/
  red-crystal-cluster.png           # base (props cần base cho icon)
  red-crystal-cluster1.png          # variant 1
  red-crystal-cluster2.png          # variant 2
  red-crystal-cluster-shadow1.png   # shadow (cùng folder, KHÔNG tạo subfolder riêng)
```

### Core Sprite Requirements

CoreBlock dùng `@Load` annotation, cần:
- `{name}.png` — base block region
- `{name}-team.png` — team-colored overlay
- `{name}-thruster-1.png` — thruster frame animation 1
- `{name}-thruster-2.png` — thruster frame animation 2

### Variant Naming Rules

| Content Type | Pattern | Variants | Ví dụ |
|---|---|---|---|
| Floor | `{name}{N}.png` | N = 1..variants | `ice-floor1.png`, `ice-floor2.png` |
| Wall 1x1 | `{name}{N}.png` | N = 1..variants | `red-wall1.png`, `red-wall2.png` |
| Wall 2x2 | `{name}{N}-2x2.png` | N = 1..variants | `red-wall1-2x2.png` |
| OreBlock | `{name}{N}.png` | N = 1..variants | `ore-cophalast1.png` |
| Prop | `{name}{N}.png` | N = 1..variants | `boulder1.png`, `boulder2.png` |
| Prop shadow | `{name}-shadow{N}.png` | cùng folder | `red-crystal-cluster-shadow1.png` |

---

## 4. Tech Tree Chi Tiết

### node() vs nodeProduce()

```java
// node() — chỉ tạo node với auto-added Research objectives từ dependencies
node(block, () -> { ... });

// nodeProduce() — tạo node + thêm Produce(content) objective
nodeProduce(item, () -> { ... });
```

**Khác biệt duy nhất**: `nodeProduce` thêm 1 `Produce(content)` objective.
Về mặt chức năng, `Produce` và `Research` đều check `content.unlockedHost()` — 
giống hệt nhau. Khác biệt chỉ ở display text.

### Auto-added Research Objectives (QUAN TRỌNG)

Khi 1 block được add vào tech tree, constructor của `TechNode` tự động thêm 
`Research(item)` objectives cho mỗi item trong build cost của block.

```java
// Block.getDependencies()
for(ItemStack stack : requirements){
    cons.get(stack.item);
}

// TechNode constructor — tự động thêm objectives
content.getDependencies(d -> objectives.add(new Research(d)));
```

**Điều này có nghĩa**: Dù block ở root level (con của root), nó vẫn không research được 
cho đến khi các item trong build cost của nó đã được research.

### 3 Layers Gating Content

1. **Parent-child visibility**: Child node chỉ visible khi parent unlocked.
   ```java
   l.visible = !locked && l.parent.visible;
   ```

2. **Objectives gate selectability**: Node chỉ selectable khi tất cả objectives complete.
   ```java
   boolean selectable(TechNode node){
       return node.content.unlockedHost() || !node.objectives.contains(i -> !i.complete());
   }
   ```

3. **unlockedNowHost()**: Check cuối cùng trong game.
   ```java
   public boolean unlockedNowHost(){
       return !state.isCampaign() || unlockedHost();
   }
   ```

**Critical**: Trong non-campaign modes (custom game, sandbox), `unlockedNowHost()` trả về 
`true` cho ALL content — tech tree chỉ enforced trong campaign.

### Thứ tự research items trong vanilla Serpulo

Items và blocks là 2 subtree RIÊNG BIỆT dưới root — không phải items làm parent của blocks.
Dependency được xử lý qua auto-added Research objectives từ build cost, không phải qua 
tree hierarchy.

Mẫu phổ biến từ real mods:
```java
nodeRoot("erisa", planet, () -> {
    // Blocks first
    node(conveyor, () -> { ... });
    node(drill, () -> { ... });
    
    // Items at bottom as separate subtree
    nodeProduce(item1, () -> {
        nodeProduce(item2, () -> { ... });
    });
});
```

### nodeRoot() First Argument

Chỉ là display label cho tech tree selector (dùng cho bundle key `"techtree." + name`).
Không phải content name lookup.

### Starting Loadout

`planet.ruleSetter.loadout` xác định item trong core lúc bắt đầu game.
**Không liên quan** đến research system — bạn có thể có item trong core mà chưa research.

---

## 5. Block Sprite Conventions

### Floors

```java
new Floor("ice") {{ variants = 3; }}
```

Cần sprite:
- `ice1.png`, `ice2.png`, `ice3.png` (3 variants từ `variants`)
- Auto-loaded: `ice-edge.png` (auto-gen từ stencil nếu thiếu)
- Auto-loaded: `ice-edge-stencil.png` (fallback về `edge-stencil` chung)

### OreBlock

```java
new OreBlock("ore-duras", items.duras) {{ variants = 3; }}
```

Cần sprite:
- `ore-duras1.png`, `ore-duras2.png`, `ore-duras3.png` (3 ore variants)
- Fallback: `duras1.png`, `duras2.png`, `duras3.png` (item sprite variants)
- OreBlock auto-gen: thêm shadow effect dưới ore sprite

⚠️ **CẨN THẬN**: Tên sprite phải match content name. OreBlock tên `"ore-duras"` 
(content name `new-universe-ore-duras`) cần file `ore-duras1.png` (→ `new-universe-ore-duras1`).

### Turrets

Turret dùng `DrawTurret` drawer, cần:

| File | Atlas Entry | Ghi chú |
|------|-------------|---------|
| `mjolnir.png` | `new-universe-mjolnir` | Main barrel/body (block.region) |
| `mjolnir-base.png` | `new-universe-mjolnir-base` | Base plate. Fallback: `new-universe-block-{size}` → `block-{size}` |
| `mjolnir-preview.png` | `new-universe-mjolnir-preview` | Icon trong build menu. Fallback: block.region |
| `mjolnir-outline.png` | `new-universe-mjolnir-outline` | Outline |
| `mjolnir-liquid.png` | `new-universe-mjolnir-liquid` | Liquid overlay |
| `mjolnir-top.png` | `new-universe-mjolnir-top` | Top overlay |
| `mjolnir-heat.png` | `new-universe-mjolnir-heat` | Heat glow |

**Không có `-base` → dùng generic base theo size**.

### GenericCrafter

Mặc định dùng `DrawDefault` — chỉ vẽ `block.region` (file `{name}.png`).

Multi-region crafters dùng `DrawRegion(suffix)`:

```java
// new DrawRegion("-top") → Core.atlas.find("new-universe-{block}-top")
```

Pattern cho animated: `DrawFrames` tìm `{name}-frame0`, `{name}-frame1`, ...

### Units

UnitType load sprite từ file `{name}.png`:
- `herja.png` → atlas `new-universe-herja`

Unit cũng dùng:
- `{name}-ui.png` — UI icon (unit card)
- `{name}-preview.png` — Preview trong block chooser
- `{name}-full.png` — Full icon
- `{name}-cell.png` — Cell texture (dùng cho shield/effect)
- `{name}-leg.png` — Leg texture (mechs)
- `{name}-base.png` — Base texture (mechs)

Các weapon regions resolve từ tên weapon: `{weapon-name}.png`.

---

## 6. Common Pitfalls & Checklist

### Sprite Checklist

- [ ] Item sprites: `sprites/{any}/{name}.png` (32×32, RGBA, lowercase)
- [ ] Ore sprites: `sprites/blocks/environment/{any}/{name}{N}.png` (N = 1..variants)
- [ ] Floor sprites: `sprites/blocks/environment/{any}/{name}{N}.png` (N = 1..variants)
- [ ] Wall sprites: `sprites/blocks/environment/{any}/{name}.png`
- [ ] Turret sprites: `sprites/{any}/turrets/{name}/{name}.png` (và `-base`, `-preview`, `-side-l`, `-side-r`, `-mid`, `-blade-l`, `-blade-r`, `-barrel-l`, `-barrel-r`)
- [ ] Unit sprites: `sprites/{any}/unit/{line}/{name}-t{N}/{name}.png`
- [ ] Weapon sprites: `sprites/{any}/unit/{line}/{name}-t{N}/{name}-weapon.png`

### Environment Sprite Checklist (New Universe)

- [ ] **Path**: Sprite nằm ở đường dẫn chứa `sprites/blogenvironment` — nếu không, environment tiles sẽ không render
- [ ] **Case**: Tất cả file lowercase — `ice-floor1.png` ✅, `Ice-Floor1.png` ❌
- [ ] **Variants**: File đúng pattern `{name}{N}.png` — `ice-floor1.png` ✅, `ice-floor-1.png` ❌
- [ ] **Wall size**: Wall 2×2 cần file `{name}-large.png` riêng, hoặc để Mindustry tự gen từ region

### Tech Tree Checklist

- [ ] Items dùng `nodeProduce()` (cần research trước khi dùng)
- [ ] Blocks có build cost item đã được add vào tech tree
- [ ] Auto-added Research objectives từ dependencies sẽ gate block research
- [ ] Planet có `ruleSetter` set loadout cho starting items

### Bundle / I18N Checklist

- [ ] Bundle key có mod prefix: `item.new-universe-{name}.name` (không thiếu prefix)
- [ ] File sprite lowercase kebab-case, `.png` (không `.PNG`)
- [ ] File sprite không có khoảng trắng trong tên

### Content Registration Checklist

- [ ] Feather DI: `@Singleton` + `@Inject` constructor + `Feather.instance().loadContent()`
- [ ] Load order: Items → Blocks → Units → Planets → TechTree
- [ ] Mod prefix trong mod.hjson (`name: "new-universe"`) match với tên thư mục sprite

### 📌 New Universe — Trạng thái hiện tại (2026-07-03)

> ✅ = đã sửa, ❌ = còn tồn tại

#### Sprite Directory (✅ Đã sửa)

| Vấn đề | Trạng thái |
|--------|-----------|
| ~Sai tên thư mục `boarelis/enviroment/`~ | ✅ Chuyển sang `blocks/environment/borealis/{type}/{name}/` |
| ~Env tiles sai atlas page (vào `main`)~ | ✅ Đường dẫn chứa `blocks/environment` → page `environment` |
| ~Uppercase trong filename~ | ✅ Tất cả lowercase kebab-case |
| ~Base sprite useless~ | ✅ Xoá base `{name}.png` khi variants tồn tại (Floor/Wall/Ore) |
| ~Shadow overlay tạo folder riêng~ | ✅ Gộp vào folder parent block |
| Item sprite `item/item/` double folder | ⚠️ Harmless với flattenPaths, giữ nguyên |

#### Java Classes (✅ Đã thêm)

| Class | Trạng thái |
|-------|-----------|
| Floor blocks (7) | ✅ `BorealisEnvironmentBlocks.java` |
| Wall blocks (6) | ✅ `StaticWall` |
| OreBlock (5) | ✅ cophalast, duras, navitas, vastum, wall-pausis |
| Prop blocks | ✅ Giữ nguyên (7 props, shadows cùng folder) |
| Liquid barbavior | ✅ Thêm mới |
| Liquid horani | ✅ Thêm mới |

#### ErisaPlanetGenerator (✅ Đã cập nhật)

- Dùng custom blocks thay vì vanilla
- 4 temperature zones × 5 height levels
- Ore distribution mapping cho từng loại floor

#### Core Blocks (✅ Đã thêm sprites)

- `core-basis(-team, -thruster-1, -thruster-2)`
- `core-centrum(-team, -thruster-1, -thruster-2)`
- `core-preatorium(-team, -thruster-1, -thruster-2)`

---

## 7. Mindustry API Class Reference

### Content Types (ClassMap.java)

| Class | ContentType | Tạo bằng | Sprite pattern |
|-------|-------------|----------|---------------|
| `Item` | `item` | `new Item("name", color)` | `{name}.png` |
| `Liquid` | `liquid` | `new Liquid("name", color)` | `{name}.png` |
| `Block` | `block` | `new Floor("name")`, `new ItemTurret("name")`, etc. | `{name}.png` + regions |
| `UnitType` | `unit` | `new UnitType("name")` | `{name}.png` + parts |
| `Planet` | `planet` | `new Planet("name", parent, ...)` | (mesh render) |
| `StatusEffect` | `status` | `new StatusEffect("name")` | `{name}.png` |

### Key Registration Classes

```
mindustry.content.TechTree      — nodeRoot(), node(), nodeProduce()
mindustry.ctype.UnlockableContent  — unlock(), locked(), unlockedNowHost()
mindustry.ctype.ContentType     — Enum: item, block, unit, planet, etc.
mindustry.game.Objectives       — Research(content), Produce(content)
mindustry.world.Block           — region, @Load annotations, getDependencies()
mindustry.world.draw.DrawTurret — base, barrel, preview region resolution
mindustry.world.draw.DrawDefault — default drawer (block.region)
mindustry.world.draw.DrawRegion — region with suffix: block.name + suffix
mindustry.world.blocks.environment.Floor   — variant regions, edge auto-gen
mindustry.world.blocks.environment.OreBlock — ore shadow, item fallback
```

### Diagnostics Tools

```bash
# Kiểm tra lỗi compile
./gradlew clean shadowJar

# Kiểm tra atlas có gì
jar tf build/libs/new-universe-desktop.jar | findstr png

# Kiểm tra lỗi LSP
# Dùng lsp_diagnostics tool trong OpenCode
```

---

*Cập nhật: 2026-07-03. Nguồn: Mindustry core source (commit master), 
official wiki, real mods (MineDusty, Extra Utilities, Aeyama, Psammos).*
