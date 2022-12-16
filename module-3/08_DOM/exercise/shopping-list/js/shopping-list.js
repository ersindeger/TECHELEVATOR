
const groceryList = document.getElementById('groceries');

// add pageTitle

let pageTitle = 'My Shopping List';

// add groceries
let groceries = [{ id: 1, item: "tomatoes" }, { id: 2, item: "potatoes" }, { id: 3, item: "lettuce" },
{ id: 4, item: "apples" }, { id: 5, item: "bananas" }, { id: 6, item: "carrots" },
{ id: 7, item: "eggplant" }, { id: 8, item: "bread" }, { id: 9, item: "milk" },
{ id: 10, item: "butter" }];


/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {

      const heading = document.getElementById('title');
      heading.innerText = pageTitle;
      groceryList.appendChild(heading);
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {

      // const ul = document.getElementById('groceries');
      // groceryList.appendChild(ul);

      groceries.forEach(grocery => {

            const li = document.createElement('li');
            li.innerText = grocery.item;
            groceryList.appendChild(li);

      });

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
      const listOfGroceryItems = document.querySelectorAll('li');

      listOfGroceryItems.forEach(item => {
            item.setAttribute('class', 'completed');
      })

};


setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
      // When the DOM Content has loaded attach a click listener to the button
      const button = document.querySelector('.btn');
      button.addEventListener('click', markCompleted);
});
