/**
 * Polymorphism in JS
 * Polymorphism - many forms
 * 
 * Functions: 
 * - Overloading
 * - Overriding
 * 
 * Does JS support method overloading? If so, how?
 * Functions in JS don't care what you pass to them. WE cannot assign
 * two different functions to the same object w/ the same name.
 * 
 * sum(2,3);
 * sum(2)(3);
 * We keep the context of 'this' w/ the arrow function '=>'.
 * We can't have function overloading in the same sense as Java, however we can adapt
 * functions to handle varying amounts of arguments internally.
 * 
 * Does JS support method overriding? If so, how?
 * We can override. Overriding works like normal. Child Objects can define 
 * their own implementations for functions will use the child function, because it's nearer in the 
 * proto-chain.
 * 
 * 
 * 
 */

 let a;
 let b;
 function sum(a,b){
     if(b == undefined){
         return(z) => a + z;
     }
     return a+b;
 }



 sum(2)(3);
