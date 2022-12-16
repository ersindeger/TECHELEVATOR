const daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

// for (let i=0; i< daysOfWeek.length; i++) {
//     console.log(daysOfWeek[i]);
// }

//daysOfWeek.forEach(printDayOfWeek);

/**
 * Prints out a day of the week given x is a day of the week
 * @param {*} x  - day of week
 */
function printDayOfWeek(x) {
    console.log(x);
} 


//printDayOfWeek('LazyDay');


// daysOfWeek.forEach( (day) => {
//     console.log(day);
// });

// daysOfWeek.forEach( (day, index, daysOfWeek) => {
//     if (index == 0) {
//         console.log('Length of the array is: ' + daysOfWeek.length);
//     }
//     console.log(day + " was found at index: " + index + " and is the " + (index + 1) + " day of the week");
// }); 


// const newDaysOfWeek = daysOfWeek.map((day) => {
//     return day + " is a day of the week";
// });

// console.log(daysOfWeek);

// console.log(newDaysOfWeek);

 const numsArray = [2,4,3,4];
// console.log(numsArray);

// const doubleValueArray = numsArray.map( (num) => {
//     return num * 2; 
// });

// console.log(doubleValueArray);

const filteredArray = daysOfWeek.filter( (day) => {

    if (day.startsWith('T')) {
        return true;
    }
    return false;

});

console.log(filteredArray);

const evenNums = numsArray.filter( (num) => {
     if (num % 2 == 0) {
         return true;
     }
     return false;
} );

console.log(evenNums);


const homes = [
   {
       zipCode: '43024',
       price: 230000
   },
   {
    zipCode: '43025',
    price: 230
   },
   {
    zipCode: '43025',
    price: 2300
   }   
];

const filteredHomes = homes.filter( (home) => {

     if (home.zipCode === '43025') {
         return true;
     }
     return false;

});

console.log(filteredHomes);



//const numsArray = [2,4,3,4];
const sum = numsArray.reduce( (runningTotal, num) => {
       return runningTotal += num;
});

console.log(sum);

