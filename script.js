// Select elements
const inputField = document.getElementById('userInput');
const addButton = document.getElementById('addButton');
const myList = document.getElementById('myList');

// Add event listener to button
addButton.addEventListener('click', () => {
    // Get the user input value
    const userInput = inputField.value;

    // Check if input is not empty
    if (userInput.trim() !== '') {
        // Create a new list item
        const listItem = document.createElement('li');
        listItem.textContent = userInput;

        // Append the list item to the unordered list
        myList.appendChild(listItem);

        // Clear the input field
        inputField.value = '';
    } else {
        alert('Please enter some text!');
    }
});
