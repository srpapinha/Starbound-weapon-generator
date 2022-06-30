import { Ability } from "/javascript/model/Ability.js";

export class Weapon {
    shortdescription;
    rarity;
    level;
    elementalType;
    primaryAbility;
    primaryAbilityType;
    altAbilityType;
    altAbility;
    
    constructor(primaryAbility, altAbility) {
        this.shortdescription = this.valid(document.getElementById("description").value);
        this.rarity = this.valid(document.getElementById("rarity").value);
        this.level = this.valid(parseInt(document.getElementById("level").value));
        this.elementalType = this.valid(document.getElementById("element").value);
        this.primaryAbilityType = this.valid(document.getElementById("ability1").value);
        this.altAbilityType = this.valid(document.getElementById("ability2").value);
        this.primaryAbility = primaryAbility.isEmpty() ? undefined : primaryAbility;
        this.altAbility = altAbility.isEmpty() ? undefined : altAbility;
    }

    valid(variable) {
        if (variable === null) return undefined;
        if (typeof variable === "string" && variable.length === 0) {
            return undefined;
        }
        if (typeof variable === "number" && isNaN(variable)) {
            return undefined;
        }
        return variable;
    }
}