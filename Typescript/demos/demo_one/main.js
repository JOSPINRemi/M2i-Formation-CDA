"use strict";
console.log("Base Typescript");
let test;
test = true;
test = "true";
test = 42;
let monPrenom = "Christophe";
let monAge = 35;
let isPresent = true;
monPrenom = "true";
monAge = 45;
isPresent = false;
let firstName;
firstName = "Christophe";
let age = 45;
let present = true;
console.log("Nombre de lettre dans " + firstName + " " + firstName.length);
console.log("Type de la variable firstname : " + typeof firstName);
console.log("Type de la variable age : " + typeof age);
console.log("Type de la variable present : " + typeof present);
let ageString = age.toString();
let presentString = present.toString();
console.log(ageString + " " + typeof ageString);
console.log(presentString + " " + typeof presentString);
let message = `
Bonjour ${firstName}
Vous avez ${age} ans.
Vous êtes ${present ? "présent" : "absent"}`;
console.log(message);
function addition(a, b) {
    return a + b;
}
function multiply(a, b) {
    return a * b;
}
function logMessage(message) {
    console.log(message);
}
let result = addition(1, 2);
logMessage(`résultat de 1 + 2 = ${result}`);
let numbers = [1, 2, 3, 4];
let numbers2 = [1, 2, 3, 4];
numbers.push(5);
console.log(numbers);
console.log(numbers2);
let tab;
