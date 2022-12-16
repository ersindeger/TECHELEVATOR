

// console.log(sum(2,3));

// //named function have a name and can be called by their name
function sum(x,y ) {
    return x + y;
}

// console.log(sum(3,3));
 console.log(sum(2, sum(3,sum(2,2))));

// let addMe = function add (x,y) {
//     return x + y;
// }

// let x =  function (x,y) {
//     return x + y;
// }


// console.log(x(2,2));


function  multiply (x,y) {
    return x * y;
}

//step 1 -> Turn it into a functional expression
let multi =  (a,b) => {
    return a * b;
}


// function onClick(func, num1, num2) {
//     console.log(func(num1, num2));
// }

// onClick(multiply, 2,2);
// onClick(sum, 3,4);

// function doSomething(func) {
//          console.log(func);
//      }

// doSomething((a,b) => {
//      return a*b
//      });
// doSomething((a) => {
//        return a;
//       });



onClick((a,b)=>{return a + b}, 2, 2 );



