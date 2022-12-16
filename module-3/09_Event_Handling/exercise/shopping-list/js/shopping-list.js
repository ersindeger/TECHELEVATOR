let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');

  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;

    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

document.addEventListener('DOMContentLoaded', () => {

  setPageTitle();
  displayGroceries();

  const groceries = document.querySelectorAll('li');

  groceries.forEach((name) => {

    //when you click on a name (grocery item), MARK it completed
    name.addEventListener('click', () => {
      if (!name.classList.contains('completed')) {
        name.classList.add('completed');
        name.querySelector('i').classList.add('completed');
      }
    });

    //when you double-click on a name (grocery item), REMOVE it from completed
    name.addEventListener('dblclick', () => {
      if (name.classList.contains('completed')) {
        name.classList.remove('completed');
        name.querySelector('i').classList.remove('completed');
      }
    });

  });

  // mark all tasks as completed
  const completeAll = document.createAttribute('toggleAll');

  completeAll.addEventListener('click', () => {
    if (allItemsIncomplete) {

      groceries.forEach((name) => {
        name.classList.add('completed');
        name.querySelector('i').classList.add('completed');
      });

      allItemsIncomplete = false;
      completeAll.innerText = "Mark All Incomplete";
    }
    else {
      groceries.forEach((name) => {
        name.classList.remove('completed');
        name.querySelector('i').classList.remove('completed');
      });

      allItemsIncomplete = true;
      completeAll.innerText = "Mark All Complete";
    }


  });

});





