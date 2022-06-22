class Ability {
    baseDps;
    fireTime;
    knockback;
    energyUsage;

    constructor(fireTime, baseDps, knockback, energyUsage) {
        this.fireTime = fireTime != "" ? fireTime : undefined;
        this.baseDps = baseDps != "" ? baseDps : undefined;
        this.knockback = knockback != "" ? knockback : undefined;
        this.energyUsage = energyUsage != "" ? energyUsage : undefined;
    }
}