const weapontype = document.getElementById("weapontype");
const description = document.getElementById("description");
const damage = document.getElementById("damage");
const firetime = document.getElementById("firetime");
const rarity = document.getElementById("rarity");
const level = document.getElementById("level");
const element = document.getElementById("element");
const primaryAbility = document.getElementById("ability1");
const altAbility = document.getElementById("ability2");
const result = document.getElementById("result");

function getWeapons() {
    const request = new XMLHttpRequest();
    request.open("GET", `http://localhost:8080/weapons`, false);
    request.send();

    return JSON.parse(request.responseText);
}

function getAbilities(weapon) {
    const request = new XMLHttpRequest();
    request.open("GET", `http://localhost:8080/abilities/${weapon}`, false);
    request.send();
    return JSON.parse(request.responseText);
}

function getElements() {
    const request = new XMLHttpRequest();
    request.open("GET", `http://localhost:8080/elements`, false);
    request.send();
    return JSON.parse(request.responseText);
}

function setResult(element) {
    document.getElementById("weapons").value = element.innerText;
}

function autocomplete(element, callback) {
    var a, b, filtered, array, obj;
    element.addEventListener("input", function(e) {
        closeList();
        array = callback();
        
        a = document.createElement("div");
        a.setAttribute("class", "autocomplete-items");
        this.parentNode.appendChild(a);
        filtered = array.filter(e => e.match(`^${this.value}.*`));
        console.log(array);
        filtered.forEach(e => {
            b = document.createElement("div");
            b.innerHTML += e;
            b.innerHTML += `<input value="${e}" type="hidden">`;
            b.addEventListener("click", function(e) {
                element.value = this.getElementsByTagName("input")[0].value;
            });
            a.appendChild(b);
        });

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
        var type = getWeapons().find(e => weapontype.value);
        var weapon = new Weapon("Custom weapon", description.value, rarity.value, level.value, element.value, primaryAbility.value, altAbility.value, undefined);
        
        result.value = `/spawnitem rare${weapontype.value} 1 '${JSON.stringify(weapon)}'`;
    })
}

autocomplete(weapontype, () => {
    return getWeapons().map(e => e.name);
});

autocomplete(element, () => {
    return getElements().map(e => e.name);;
});

autocomplete(rarity, () => {
    return ["common", "uncommon", "rare", "legendary", "essential"];
});

autocomplete(primaryAbility, () => {
    return getAbilities(weapontype.value).map(e => e.name);;
});

autocomplete(altAbility, () => {
    return getAbilities(weapontype.value).map(e => e.name);;
});

generate();