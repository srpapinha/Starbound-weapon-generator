class Weapon {
    shortdescription;
    description;
    rarity;
    level;
    elementalType;
    primaryAbility;
    primaryAbilityType;
    altAbilityType;
    altAbility;
    
    constructor(shortdescription, description, rarity, level, elementalType, primaryAbilityType, primaryAbility, altAbilityType, altAbility) {
        this.shortdescription = valid(shortdescription); 
        this.description = valid(shortdescription);
        this.rarity = valid(rarity);
        this.elementalType = valid(elementalType);
        this.primaryAbilityType = valid(primaryAbilityType);
        this.primaryAbility = primaryAbility;
        this.level = valid(level);
        this.altAbilityType = valid(altAbilityType);
        this.altAbility = altAbility;
    }
}