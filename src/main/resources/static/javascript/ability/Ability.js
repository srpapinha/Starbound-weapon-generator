class Ability {
    fireTime;
    baseDps;
    projectileType;

    constructor(fireTime, baseDps, projectileType) {
        this.fireTime = valid(fireTime);
        this.baseDps = valid(baseDps);
        this.projectileType = valid(projectileType);
    }

    IsEmpty() {
        if(this.fireTime === undefined && this.baseDps === undefined && this.projectileType === undefined) {
            return true;
        }
        return false;
    }
}