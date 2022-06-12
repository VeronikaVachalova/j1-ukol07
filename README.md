# Úkol 7 – Výběr oblíbené barvy
Naprogramujte aplikaci, ve které uživatel zadá svou přezdívku a vybere si oblíbenou barvu.

## Zadání
Vytvořte javabeanu `PreferenceBean`, ve kterém bude uložena přezdívka (`String`) a oblíbená barva. Pro seznam barev si vytvořte nový enum,
pojmenujte jej třeba `Barva`. Protože beanu použijeme jako cz.czechitas.ukol7.model pro Swing, musí settery *odpalovat* události při změně
properties. Ideální je, když taková beany implementuje rozhraní `ObservableBean`, pro implementaci potřebných metod se hodí
třída `ExtendedPropertyChangeSupport`.

Dále vytvořte cz.czechitas.ukol7.formbuilder.cz.czechitas.ukol7.controller `PreferenceController`, který v sobě bude mít cz.czechitas.ukol7.model (reprezentovaný třídou `PresentationModel`), cz.czechitas.ukol7.model v sobě bude mít
instanci `PreferenceBean`. Dále v sobě bude mít `Action`, která bude sloužit pro uložení preferencí. Text akce bude
„Uložit“, při provedení akce se do konzole vypíše přezdívka uživatele a jím vybraná barva. Akce bude dostupná jen tehdy,
když bude zadaná přezdívka a vybraná barva.

Nakonec vytvořte cz.czechitas.ukol7.view `HlavniOkno` – formulář (odděděný z `JFrame`). Oknu nastavte titulek, použijte layout manager
`MigLayout` a nastavte dvousloupcový layout. Do formuláře vložte na jednom řádku label „Přezdívka“ a `textField` propojený
na property `prezdivka`. Dále vložte na řádky pod sebe radiobuttony pro jednotlivé barvy. Radiobuttony vždy roztáhněte
přes celý řádek (přes oba sloupce layoutu). Jednotlivé radiouttony vložíte ručně (nebude se používat cyklus), pro
každou barvu bdue jeden radiobutton a bude přímo u něj uveden český název barvy.

Na poslední řádek formuláře přidáte tlačítko, které propojíte na akci pro uložení v controlleru.

Nebojte se opisovat ze cvičení z lekce – vše až na `enum` a radiobuttony je v kódu z lekce a stačí to jen vhodně
přizpůsobit. A radiobuttony jsou vlastně docela podobné checkboxům, akorát nejsou řízené hodnotami `true`/`false`, ale
hodnotou z enumu.

## Může se hodit
* Omezení pro sloupce layoutu může být například `[right, 100]rel[50:75:250,grow,fill]`.
* `FormBuilder` má metodu `radioButton(label, property, choice)`, která vyrábí radiobutton. První dvě hodnoty jsou stejné, jako u checkboxu – text radiobuttonu a property, na kterou se má napojit. Třetí hodnota je volba (z enumu), při které je konkrétní radiobutton vybraný. Více radiobuttonů bude napojených na stejnou property a vybraný je ten, jehož parametr `choice` se shoduje s hodnotou uloženou v property. 
* Enum pro roční období by mohl vypadat třeba takto: 
```java
public enum RocniObdobi {
    Jaro,
    Leto,
    Podzim,
    Zima,
    ;
}
```

# Bonus

Radiobuttony nemusíte do formuláře vkládat ručně. Můžete využít toho, že každý `enum` má metodu `values()`, která vrací
pole všech hodnot v enumu (seřazených stejně, jako jsou ve zdrojovém kódu). Můžete tedy volat např.`Barva.values()`. Pole
se dá procházet pomocí cyklu `for` – stačí za `values()` ještě dopsat `.for` a IntelliJ Idea sama nabídne vytvoření cyklu.

Každý enum má také metodu `toString()`, která vrací text shodný s názvem položky enumu. Ten můžete použít pro label.
Lepší by ale bylo mít ve formuláři české texty. I to enum umožňuje. Každá položka enumu se totiž může chovat jako konstruktor.
Třeba pro enum ročních období si můžu vytvořit property `text`, kterou naplním v konstruktoru: 

```java
public enum RocniObdobi {
    Jaro("jaro"),
    Leto("léto"),
    Podzim("podzim"),
    Zima("zima"),
    ;
    
    private final String text;

    RocniObdobi(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
