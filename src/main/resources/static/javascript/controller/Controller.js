import { Weapon } from "/javascript/model/Weapon.js";
import { Ability } from "/javascript/model/Ability.js";

export class Controller {
    weapons;
    elements;
    rarities;
    abilities;
    projectiles;

    constructor() {
        this.weapons = this.sendRequest("/weapons");
        this.elements = this.sendRequest("/elements");
        this.rarities = this.sendRequest("/rarities");
        this.projectiles = this.sendRequest("/projectiles");

        this.abilities = new Map();
        this.weapons.forEach(e => this.abilities.set(e.name, this.sendRequest(`/abilities/${e.name}`)));
    }

    sendRequest(url) {
        const request = new XMLHttpRequest();
        request.open("GET", url, false);
        request.send();
        if(request.status === 200) return JSON.parse(request.responseText);
        return undefined;
    }

    getNamesFromObjects(array) {
        if(array === undefined) return;
        if(typeof array[0] === "string") return array;
        if(typeof array[0] === "object") return array.map(e => e.name);
    }

    weaponExists() {
        return this.getNamesFromObjects(this.weapons).includes(document.getElementById("weapontype").value);
    }

    autocomplete(element, array, image) {
        var parent, child, controllerObject = this;
        this.closeList();
    
        parent = document.createElement("div");
        parent.setAttribute("class", "autocomplete-items");
        element.parentNode.appendChild(parent);

        array = this.getNamesFromObjects(array);
        array = array.filter(e => e.match(`^${element.value}.*`)).slice(0, 10);
        array.forEach(e => {
            child = document.createElement("div");
            child.innerHTML += e;
            if (image != undefined) child.innerHTML += `<img src="${image}/${e}">`;
            child.innerHTML += `<input value="${e}" type="hidden">`;
            child.addEventListener("click", function(e) {
                element.value = this.getElementsByTagName("input")[0].value;
                controllerObject.enableValidFields();
            });
            parent.appendChild(child);
        });
    }

    enableValidFields() {
        var weapon, ability1, ability2, projectile1, projectile2;
        weapon = this.weapons.find(e => document.getElementById("weapontype").value === e.name);

        ability1 = document.getElementById("ability1");
        ability2 = document.getElementById("ability2");
        projectile1 = document.getElementById("projectile1");
        projectile2 = document.getElementById("projectile2");

        ability1.disabled = true;
        ability2.disabled = true;
        projectile1.disabled = true;
        projectile2.disabled = true;

        if(weapon === undefined) return;

        switch(weapon.weaponType) {
            case "melee":
                ability2.disabled = false;
                break;
            case "ranged":
                ability2.disabled = false;
                projectile1.disabled = false;
                projectile2.disabled = false;
                break;

            case "magic":
                ability1.disabled = false;
                if(weapon.twoHanded)  ability2.disabled = false;
                break;
        }
    }

    closeList() {
        var list = document.getElementsByClassName("autocomplete-items");
        for (let i = 0; i < list.length; i++) {
            list[i].parentNode.removeChild(list[i]);
        }
    }

    generateCommand() {
        if (!this.weaponExists()) {
            alert("Choose a valid weapon");
            return;
        }
        var ability1 = new Ability(parseInt(damage.value), projectile1.value);
        var ability2 = new Ability(undefined, projectile2.value);
    
        var weapon = new Weapon(ability1, ability2);
    
        document.getElementById("result").value = `/spawnitem rare${document.getElementById("weapontype").value} 1 '${JSON.stringify(weapon)}'`;
    }

    copyToClipboard() {
        navigator.clipboard.writeText(document.getElementById("result").value);
    }
}