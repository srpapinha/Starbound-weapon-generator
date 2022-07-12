export class Ability {
    baseDps;
    projectileType;

    constructor(baseDps, projectileType) {
        this.baseDps = this.valid(baseDps);
        this.projectileType = this.valid(projectileType);
    }

    isEmpty() {
        return this.baseDps === undefined && this.projectileType === undefined;
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