import { Controller } from "/javascript/controller/Controller.js";

var controller = new Controller();

document.getElementById("weapontype").addEventListener("input", function(e) {
    controller.autocomplete(this, controller.weapons);
});

document.getElementById("element").addEventListener("input", function(e) {
    controller.autocomplete(this, controller.elements, "/elements");
});

document.getElementById("rarity").addEventListener("input", function(e) {
    controller.autocomplete(this, controller.rarities, "/rarities");
});

document.getElementById("ability1").addEventListener("input", function(e) {
    var weapon = document.getElementById("weapontype").value;
    if(controller.weaponExists(weapon)) controller.autocomplete(this, controller.abilities.get(weapon));
});

document.getElementById("ability2").addEventListener("input", function(e) {
    var weapon = document.getElementById("weapontype").value;
    if(controller.weaponExists(weapon)) controller.autocomplete(this, controller.abilities.get(weapon));
});

document.getElementById("projectile1").addEventListener("input", function(e) {
    controller.autocomplete(this, controller.projectiles, "/projectiles");
});
document.getElementById("projectile2").addEventListener("input", function(e) {
    controller.autocomplete(this, controller.projectiles, "/projectiles");
});

document.addEventListener("click", controller.closeList);
document.getElementById("generate").addEventListener("click", function(e) {
    controller.generate();
});
document.getElementById("copy").addEventListener("click", controller.copy);