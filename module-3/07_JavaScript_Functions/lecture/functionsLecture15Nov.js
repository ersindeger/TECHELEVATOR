
console.log(sum(2,3));

//named function
function sum(x,y) {

    return x+y;
}

console.log(sum(3,3));

// let addMe = function add (x,y) {
//     return x+y;
// }

// console.log(addMe(2,17));

let add = function (x,y) {
    return x+y;
}

console.log(add(4,20));

function multiply (x,y) {
    return x*y;
}
// Step 1: Turn it into a functional expression

let multi =  (a,b) => {
    return a*b;
}

function onClick(func, num1, num2) {
    console.log(func(num1, num2));
}

onClick(multiply, 10, 9);
onClick(sum, 2, 33);
onClick(multi, 10, 10);

onClick((a,b)=>{return a+b}, 11,31);
// (a,b)=>{return a+b} is the FUNC that is being passed on to onClick


function doSomething(func) {
    console.log(func);
}

doSomething( (a,b) => {return a*b} );

doSomething ( (a) => {return a} );
// these two functions above are anonymous functions!

let numbers = [1, 2, 3, 4];

numbers.forEach( (number) => {
    console.log(`This number is ${2*number}`);
});

/* HW exercise line 24 answer below:
function useParameterToFilterArray(filterFunction) {
    return unfilteredArray.filter(filterFunction);
}
*/

