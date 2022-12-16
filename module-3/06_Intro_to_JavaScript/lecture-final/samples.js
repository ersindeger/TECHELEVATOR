let fellowName = 'Scott';
console.log(fellowName);


function add(a, b) {
    return a + b;
}

console.log(add(2,2));
console.log(add(3,4));


const students = ['Osman', 'Joel', 'Trae', 'Ian'];
console.log('Size of array is: ' + students.length);

const ian = students[3];
console.log(ian);

students.push('Greg');
console.log(students);

students.splice(1, 0, 'Michael');
console.log(students);

// const greg = students.pop();
// console.log('removed: ' + greg);
// console.log(students);

students.unshift(students.pop());
console.log(students);


for (let i = 0; i< students.length; i++) {
    console.log(students[i]);
}


console.log(students.reverse());

console.log(add);


const person = {
   firstName: 'Scott',
   isDork: true,
   address: {
       streetAddress: 'In a van down by the river',
       city: 'Columbus',
       zip: {
           zip: 43033,
           plus4: 2323
       }
   } 
}

console.log(person.firstName);
console.log(person.address.zip.zip + '-' + person.address.zip.plus4);
