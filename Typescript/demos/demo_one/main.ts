console.log("Base Typescript");

// Inference (typescript le fait pour nous)

let test;
test = true;
test = "true";
test = 42;

let monPrenom = "Christophe"; // type string
let monAge = 35; // type number
let isPresent = true; // type boolean

// Je peux réasigner des valeurs uniquement du même type
monPrenom = "true";
// monPrenom = 45; // Type 'number' isn't assignable to type 'string'
monAge = 45;
isPresent = false;
// isPresent = "true"; // Type 'string' isn't assignable to type 'boolean'

// Assignation (on donne nous même le type)

// Pour spécifier le type d'une variable, la syntaxe est la suivante
let firstName: string;
firstName = "Christophe";
// firstName = 45; // Type 'number' isn't assignable to type 'string'
// let age: number = "toto"; // erreur
let age: number = 45; // force le bon type
let present: boolean = true;

// Via le typescript on a une auto-completion et une intellisence plus poussée
console.log("Nombre de lettre dans " + firstName + " " + firstName.length);

// Connaître le type d'une variable avec typeof
console.log("Type de la variable firstname : " + typeof firstName);
console.log("Type de la variable age : " + typeof age);
console.log("Type de la variable present : " + typeof present);

let ageString: string = age.toString();
let presentString: string = present.toString();

console.log(ageString + " " + typeof ageString);
console.log(presentString + " " + typeof presentString);

let message: string = `
Bonjour ${firstName}
Vous avez ${age} ans.
Vous êtes ${present ? "présent" : "absent"}`;

console.log(message);

/**
 * Pour la création de fonction en TS, la différence est l'ajout du typage pour les paramètres
 * De la sortie on sécurise les utilisations futures de notre fonction en vérouillant des types incorrects
 */
function addition(a: number, b: number): number {
  return a + b;
}

function multiply(a: number, b: number): number {
  return a * b;
}

function logMessage(message: string): void {
  console.log(message);
}

let result: number = addition(1, 2);
logMessage(`résultat de 1 + 2 = ${result}`);

// let resultB = multiply("A", "B"); // ne marche pas

/**
 * Array
 * Pour définir un taleau de number, il faut utiliser le typee suivi des crochets
 */
let numbers: number[] = [1, 2, 3, 4];
// ou
let numbers2: Array<number> = [1, 2, 3, 4];

// numbers.push("toto"); // erreur
numbers.push(5);
console.log(numbers);
console.log(numbers2);

/**
 * Dans un tableau array de type any on peut mettre ce que l'on veut
 */

let tab: any[];

// On peut déclarer un tableau qui contient plusieurs types alors tous ces types peuvent être présent dans le tableau
