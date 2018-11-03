/**
 * What does it mean that functions in JS are first-class citizens?
 * 
 * Functions in JS are treated like fields, w/ the ability to be assigned and
 * passed. They can be assigned. They can be reassigned.
 * They can be returned.
 * 
 * Callback Functions
 * 
 * We defined myFunction and we called setTimeout.
 * Did we call myFunction?
 *  We did not call it.
 * 
 * Was it called?
 *  Yes.It was.
 * 
 */

 const myFunction = function(){
     console.log('Done!');
 }
 // Passing myFunction as a callback function, which will be called
 // by the implmentation of setTimeout
 setTimeout(myFunction,1000); // This is a callback function

 /**
  * This is also a callback function!
  * Example of how a callback function might be utilized
  * @param f - A function to be called by otherFunction
  */
 const otherFunction = function(f){
     f();
 }