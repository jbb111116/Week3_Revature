/***
 * Template Literals are an ES6 feature of JS.
 * They are used for formatting strings, and are often used in place of situations
 * where you might be tempted to concatonate complicated strings or otherwise utilize
 * complicated string literals.
 * 
 * Template Literals make it much easier to create complex strings.
 */

 const person = {
     firstName: 'Abby',
     lastName: 'Adams',
     age: 22
 };

 // We want to print out, "My name is Abby Adams and I'm 22 years old.";
 const str = 'My name is ' + person.firstName + ' ' + person.lastName + ' and I\'m '
               +  person.age + ' years old.';
console.log(str);

// Template literals allow for simple variable injection w/out breaking the string
// You break lines by just pressing 'Enter' in a template literal unlike in normal
// strings.
const template = ``// <-- those are not single quotes, they are backticks
template = `My name is ${person.firstName} ${person.lastName} and I'm ${person.age} years old.`;
console.log(template);