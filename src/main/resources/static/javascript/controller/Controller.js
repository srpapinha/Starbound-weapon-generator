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

    weaponExists() {
        return this.getNames(this.weapons).includes(document.getElementById("weapontype").value);
    }

    getNames(array) {
        if (array === undefined) return;
        if (typeof (array[0]) === "object") {
            return array.map(e => e.name);
        }
        if (typeof (array[0] === "string")) {
            return array;
        }
    }

    autocomplete(element, array, image) {
        var parent, child, filtered, array;
        this.closeList();
    
        parent = document.createElement("div");
        parent.setAttribute("class", "autocomplete-items");
        element.parentNode.appendChild(parent);

        array = this.getNames(array);
        filtered = array.filter(e => e.match(`^${element.value}.*`)).slice(0, 10).sort();
        filtered.forEach(e => {
            child = document.createElement("div");
            child.innerHTML += e;
            if (image != undefined) child.innerHTML += `<img src="${image}/${e}">`;
            child.innerHTML += `<input value="${e}" type="hidden">`;
            child.addEventListener("click", function (e) {
                element.value = this.getElementsByTagName("input")[0].value;
            });
            parent.appendChild(child);
        });
    }

    closeList() {
        var list = document.getElementsByClassName("autocomplete-items");
        for (let i = 0; i < list.length; i++) {
            list[i].parentNode.removeChild(list[i]);
        }
    }

    generate() {
        if (!this.weaponExists()) {
            alert("Choose a valid weapon");
            return;
        }
        var ability1 = new Ability(parseInt(damage.value), projectile1.value);
        var ability2 = new Ability(undefined, projectile2.value);
    
        var weapon = new Weapon(ability1, ability2);
    
        document.getElementById("result").value = `/spawnitem rare${document.getElementById("weapontype").value} 1 '${JSON.stringify(weapon)}'`;
    }

    copy() {
        navigator.clipboard.writeText(document.getElementById("result").value);
    }
}