/***
 * Truthy/Falsy values in JS, is the idea that every value can be evaluated 
 * for truthiness. This means any value of any type can be utilized in an IF statement,
 * a logical argument, etc.
 * 
 * Most values are considered truthy, and a small set are considered falsy.
 * 
 * Falsy values include: 0, NaN, false, undefined, null, ''
 * 
 * So when a field is assigned a boolean expression involving truthy/falsy values,
 * the value that makes the difference is the value that is assigned to the variable.
 * 
 * Short-circuit logic in JS helps get rid of if-else statements in the process
 * of assigning values or objects to a variable.
 * 
 * Boolean expressions in JS don't necessarily evaluate to a true/false value,
 * but instead evalutate to the values in the expression that made the difference in the 
 * resulting logical result. The logic of this follows short circuit logic closely.
 * 
 * ex)
 * x = 0 || 1;
 * x -> 1
 * 
 * x = 'cat' && 'dog';
 * x -> 'dog'
 * 
 * x = 'hello' || 15 ;
 * x -> 'hello'
 * 
 */