
document.addEventListener('DOMContentLoaded', () => {

document.querySelector('.btn').addEventListener('click', displayDate);
document.querySelector('.btn').addEventListener('click', displayName);
});


function displayDate() {
  document.getElementById('time').innerText = Date();

}

function displayName () {
  const name = document.createElement('h3');
  name.innerText = 'Ersin Deger';
  document.body.appendChild(name);
}


