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
        this.shortdescription = shortdescription != "" ? shortdescription : undefined;
        this.description = description != "" ? description : undefined;
        this.rarity = rarity != "" ? rarity : undefined;
        this.elementalType = elementalType != "" ? elementalType : undefined;
        this.primaryAbility = primaryAbility != "" ? primaryAbility : undefined;
        this.level = level != "" ? level : undefined;
        this.altAbilityType = altAbilityType != "" ? altAbilityType : undefined;
        this.altAbility = altAbility != "" ? altAbility : undefined;
    }
}