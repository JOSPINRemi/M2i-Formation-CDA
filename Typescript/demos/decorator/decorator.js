var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
console.log("Les décorateurs");
function simpleDecoratorClass(target) {
    target.prototype.id = Math.random();
}
let UserWithDecorator = class UserWithDecorator {
    constructor(name) {
        this.name = name;
    }
};
UserWithDecorator = __decorate([
    simpleDecoratorClass
], UserWithDecorator);
const user = new UserWithDecorator("Toto");
console.log(user);
//@ts-ignore
console.log(user.id);
console.clear();
function demoDecoratorMethod(...args) {
    return function (target, propertyKey, descriptor) {
        console.log(target);
        console.log(propertyKey);
        console.log(descriptor);
        const originalMethod = descriptor.value;
        descriptor.value = (...args) => {
            const resultMethod = originalMethod.apply(target, args);
            return resultMethod + 2;
        };
    };
}
class Calculatrice {
    add(a, b) {
        return a + b;
    }
}
__decorate([
    demoDecoratorMethod()
], Calculatrice.prototype, "add", null);
const maCalculatrice = new Calculatrice();
console.log(maCalculatrice.add(1, 1));
