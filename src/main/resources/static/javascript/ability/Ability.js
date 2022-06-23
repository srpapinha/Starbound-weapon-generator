class Ability {
    fireTime;
    baseDps;
    projectileType;

    constructor(fireTime, baseDps, projectileType) {
        this.fireTime = valid(fireTime);
        this.baseDps = valid(baseDps);
        this.projectileType = valid(projectileType);
    }
}