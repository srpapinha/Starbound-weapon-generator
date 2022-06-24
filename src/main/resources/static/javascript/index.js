const weapontype = document.getElementById("weapontype");
const description = document.getElementById("description");
const damage = document.getElementById("damage");
const firetime = document.getElementById("firetime");
const rarity = document.getElementById("rarity");
const level = document.getElementById("level");
const element = document.getElementById("element");
const primaryAbility = document.getElementById("ability1");
const projectile1 = document.getElementById("projectile1");
const altAbility = document.getElementById("ability2");
const projectile2 = document.getElementById("projectile2");
const result = document.getElementById("result");

function sendRequest(url) {
    const request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    var obj = JSON.parse(request.responseText);
    return  Array.isArray(obj) ? obj : [];
}

function getWeapons() {
    return sendRequest("http://localhost:8080/weapons")
}

function getElements() {
    return sendRequest("http://localhost:8080/elements");
}

function getAbilities(weapon) {
    return sendRequest(`http://localhost:8080/abilities/${weapon}`);
}

function getProjectiles() {
    return sendRequest("http://localhost:8080/projectiles");
}

function autocomplete(element, callback, image) {
    var a, b, filtered, array, obj;
    element.addEventListener("input", function(e) {
        closeList();
        array = callback();
        
        a = document.createElement("div");
        a.setAttribute("class", "autocomplete-items");
        this.parentNode.appendChild(a);
        filtered = array.filter(e => e.match(`^${this.value}.*`)).slice(0, 10).sort();
        filtered.forEach(e => {
            b = document.createElement("div");
            b.innerHTML += e;
            if(image != undefined) b.innerHTML += `<img src="${image}/${e}">`;
            b.innerHTML += `<input value="${e}" type="hidden">`;
            b.addEventListener("click", function(e) {
                element.value = this.getElementsByTagName("input")[0].value;
            });
            a.appendChild(b);
        });
        a.setAttribute

    });
    document.addEventListener("click", function (e) {
        closeList();
    });
}

function closeList() {
    var list = document.getElementsByClassName("autocomplete-items");
    for (let i = 0; i < list.length; i++) {
        list[i].parentNode.removeChild(list[i]);
    }
}

function generate() {
    document.getElementById("generate").addEventListener("click", function(e) {
        if(weapontype.value === "") {
            alert("Choose the weapon");
            return;
        }
        var type = getWeapons().find(e => weapontype.value);
        if(type === undefined) {
            alert("Choose valid weapon");
            return;
        }
        var ability1 = new Ability(parseInt(firetime.value), parseInt(damage.value), projectile1.value);
        var ability2 = new Ability(undefined, parseInt(damage.value), projectile2.value);

        if(ability1.IsEmpty()) ability1 = undefined;
        if(ability2.IsEmpty()) ability2 = undefined;
        
        var weapon = new Weapon("Custom weapon", description.value, rarity.value, parseInt(level.value), element.value, primaryAbility.value, ability1, altAbility.value, ability2);
        
        result.value = `/spawnitem rare${weapontype.value} 1 '${JSON.stringify(weapon)}'`;
    })
}

function copy() {
    navigator.clipboard.writeText(document.getElementById("result").value);
}

function valid(variable) {
    if(variable === null) return undefined;
    if(typeof variable === "string" && variable.length === 0) {
        return undefined;
    }
    if(typeof variable === "number" && isNaN(variable)) {
        return undefined;
    }
    return variable;
}

autocomplete(weapontype, () => {
    return getWeapons().map(e => e.name);
});

autocomplete(element, () => {
    return getElements().map(e => e.name);
}, "elements");

autocomplete(rarity, () => {
    return ["common", "uncommon", "rare", "legendary", "essential"];
});

autocomplete(projectile1, () => {
    return getProjectiles().map(e => e.name);
}, "projectiles");

autocomplete(projectile2, () => {
    return getProjectiles().map(e => e.name);
}, "projectiles");


autocomplete(altAbility, () => {
    return getAbilities(weapontype.value).map(e => e.name);
});

autocomplete(primaryAbility, () => {
    return getAbilities(weapontype.value).map(e => e.name);
});

generate();