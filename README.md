### Farm szimulátor
Van egy farm ahol malacokat és marhákat tartanak. Etetéskor nő az állatok mérete és amikor elérik a vágósúlyt akkor a mészáros levágja az állatokat. Készítsd el az alábbi leírás szerinti java code-ot!

#### Animal osztály
- Tartalmazza a következő field-et:
  - méret `int size`
- Az állatok mérete nem állítható a constructor-al, alapértelmezetten az állat létrejöttekor 0.
- A méret field-hez tartozik egy getter.
- Minden állatot meg lehet etetni a `void feed()` metódussal, ennek megvalósítása állat típusonként különböző.

#### Cattle osztály
- Amikor megetetik mérete 2-vel növekszik.

#### Pig osztály
- Amikor megetetik mérete 1-el növekszik.

#### Butcher osztály
- Tartalmaz egy `boolean canButcher(Animal animal)` metódust ami visszaadja, hogy a paraméterben megadott állat levágható-e. Egy állatot akkor lehet levágni ha mérete nagyobb 4 egységnél.

#### Farm osztály
- Egy állatokból álló listában tárolódnak a farmon található állatok. Ez a lista a konstruktorban megadható.
- `List<Animal> getAnimals()`: visszatér a farm állataival
- `void feedAnimals()`: A farmon lévő összes állat megetetése.
- `void butcher(Butcher butcher)` : Az összes levágható állat eltávolítása a farmon lévő állatokat tartalmazó listából.
- `boolean isEmpty()` : Igazat ad vissza, ha a farmon nincsenek állatok, egyébként hamisat ad.
- `List<String> getStatus()`: Az állatok státuszait tartalmazó listát ad vissza, a farmon lévő összes állatra vonatkozóan. A lista elemei a következő formátumot követik: "There is a <állat mérete> sized <állat típusa (pig/cattle)> in the farm."

## Pontozás

Egy feladatra 0 pontot ér, ha:

- nem fordul le
- lefordul, de egy teszteset sem fut le sikeresen.
- ha a forráskód olvashatatlan, nem felel meg a konvencióknak, nem követi a clean code alapelveket.

0 pont adandó továbbá, ha:

- kielégíti a teszteseteket, de a szöveges követelményeknek nem felel meg

Pontokat a további működési funkciók megfelelősségének arányában kell adni a vizsgafeladatra:

- 5 pont: az adott projekt lefordul, néhány teszteset sikeresen lefut, és ezek funkcionálisan is helyesek. Azonban több
  teszteset nem fut le, és a kód is olvashatatlan.
- 10 pont: a projekt lefordul, a tesztesetek legtöbbje lefut, ezek funkcionálisan is helyesek, és a clean code elvek
  nagyrészt betartásra kerültek.
- 20 pont: ha a projekt lefordul, a tesztesetek lefutnak, funkcionálisan helyesek, és csak apróbb funkcionális vagy
  clean code hibák szerepelnek a megoldásban.

Gyakorlati pontozás a project feladatokhoz:

- Alap pontszám egy feladatra(max 20): lefutó egység tesztek száma / összes egység tesztek száma * 20, feltéve, hogy a
  megoldás a szövegben megfogalmazott feladatot valósítja meg
- Clean kód, programozási elvek, bevett gyakorlat, kód formázás megsértéséért - pontlevonás jár. Szintén pontlevonás
  jár, ha valaki a feladatot nem a leghatékonyabb módszerrel oldja meg - amennyiben ez értelmezhető.