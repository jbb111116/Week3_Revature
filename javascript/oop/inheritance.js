/**
 * Inheritance in JS
 * 
 * Inheritance can't work like Java. There are no classes. Java features
 * classical inheritance. JS does not have classes, so it cannot use classical 
 * inheritance. JS, instead, utilizes prototypal inheritance. Prototypal
 * is the principle of objects inheriting from other objects.
 * 
 * Objects have a prototype reference to the parent object, generally with the
 * __PROTO__filed. When we try to access any member that is not defined on the current 
 * object, it attempts to recursively find in it the __PROTO__ chain.
 * 
 * The __PROTO__ field is exposed to us, so we can easily see it and even modify it.
 * The oldschool way of extending an object would be to use object.create().
 * 
 * 
 * There are multiple way to create Objects in JS:
 * - Basic object
 * - Constructor function
 * - Extending basic object
 * - ES6 'classes'
 */



 // Basic object
 const Person = {
     firstName = '',
     lastName = '',
     printName: function(){
         console.log(this.firstName + ' ' + this.lastName);
     },
     delayPrint: function(){
        //  window.setTimeout(this.printName,1000);
        window.setTimeout(() => console.log(this.firstName + ' ' + this.lastName),1000);
     }
 }

 // Constructor function
 const Dog = function(name, speak){
     this.name = name;
     this.speak = speak;
 }

 // Extending basic object
 const abby = Object.create(Person);

 // ES6 'classes'
 // Supports for extends, super, etc.
 class Chicken {
     feathers;
     eggs;
     speak(){
         console.log('Bawk');
     }
     constructor(feathers,eggs){
         this.feathers = feathers;
         this.eggs = eggs;
     }
 }