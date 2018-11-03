/**
 * Encapsulation - A Black Box
 * Hiding data
 * 
 * How is encapuslation implemented in Java?
 * 
 * Access modifiers and getters and setters.
 * 
 * Does JavaScript have access modifiers?
 * No access modifiers.
 * This can make encapsulation tricky.
 * 
 * Generally, over the years, encapsulation is implemented using 
 * closures. Closures are a language feature, which is defined as 
 * fields defined within a function accessible from an inner function
 * being available after the outer funtion has returned.
 * 
 * 
 */

 let outer = function(){
     let x = 10;
    //  let inner = function(){
    //      console.log(x);
    //  }
    //  inner();
    //  return inner();
    return {
        // get: () => x,
        get: function() {return x;},
        set:(y) => x = y
    };
 }


 class MyObject{
     _myPrivateField;

     get myPrivateField() {
         return this._myPrivateField;
     }
     get myPrivateField(f){
         this._myPrivateField = f;
     }
     constructor(field){
         this._myPrivateField = fields;
     }
 }
 
