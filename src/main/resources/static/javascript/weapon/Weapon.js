class Weapon {
    shortdescription;
    description;
    rarity;
    level;
    elementalType;
    primaryAbility;
    altAbilityType;
    altAbility;
    
    constructor(shortdescription, description, rarity, level, elementalType, primaryAbility, altAbilityType, altAbility) {
        this.shortdescription = valid(shortdescription); 
        this.description = valid(shortdescription);
        this.rarity = valid(rarity);
        this.elementalType = valid(elementalType);
        this.primaryAbility = primaryAbility;
        this.level = valid(level);
        this.altAbilityType = valid(altAbilityType);
        this.altAbility = altAbility;
    }
}