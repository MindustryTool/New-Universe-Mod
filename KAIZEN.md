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
  flattenPaths: true,           // Bỏ qua cấu trúc thư mục, chỉ dùng filename
  combineSubdirectories: true,  // Gộp tất cả subdirectory vào 1 atlas
  stripWhitespaceCenter: true   // Tự động crop whitespace
}
```

**Hệ quả**: Đường dẫn file chỉ quan trọng cho atlas page routing, KHÔNG ảnh hưởng đến 
region name. `mjolnir.png` ở bất kỳ đâu trong `sprites/` đều cho kết quả giống nhau.

### Atlas Page Routing

Đường dẫn quyết định sprite vào page nào (quan trọng cho environment tiles):

| Path contains | Atlas Page |
|---|---|
| `sprites/blocks/environment` | `environment` |
| `sprites/rubble` | `rubble` |
| `sprites/ui` | `ui` |
| Everything else | `main` |

**Khuyến nghị**: Floor/wall sprites nên để ở `sprites/blocks/environment/` để được 
pack đúng page.

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

- [ ] Item sprites: `sprites/items/{name}.png` (32×32, RGBA)
- [ ] Ore sprites: `sprites/blocks/environment/ore-{name}N.png` (3 variants)
- [ ] Floor sprites: `sprites/blocks/environment/{name}N.png` (N = 1..variants)
- [ ] Wall sprites: `sprites/blocks/environment/{name}.png`
- [ ] Turret base: `{name}-base.png` (tránh fallback generic)
- [ ] Unit sprites: `sprites/units/{name}/{name}.png`
- [ ] Weapon sprites: `sprites/units/{parent}/{weapon}.png`

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
